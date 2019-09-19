package com.genstar.dialog;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.genstar.R;
import com.genstar.base.Constant;
import com.genstar.base.TopDialogBase;
import com.genstar.bean.QrCodePayResult;
import com.genstar.utils.SignUtils;
import com.genstar.utils.TimeUtils;
import com.genstar.utils.UniqueIdUtils;
import com.genstar.utils.http.PropertiesUtils;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.math.BigDecimal;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopDialog extends TopDialogBase {
    @BindView(R.id.iv_close)
    ImageView ivClose;
    @BindView(R.id.et_scan)
    EditText etScan;
    private String money;
    private Context context;
    private CountDownTimer timer;
    private Handler handler = new Handler();

    public TopDialog(Context context, String money) {
        super(context);
        this.context = context;
        this.money = money;
    }

    public interface OnOkClickListener {
        void onsucess(String data);

        void onfaile();
    }

    private OnOkClickListener onOkClickListener;

    public void setOnOkClickListener(OnOkClickListener onOkClickListener) {
        this.onOkClickListener = onOkClickListener;
    }

    @Override
    protected void onCreate() {
        setContentView(R.layout.dialog_top);
        ButterKnife.bind(this);
        initData();
        initListener();
    }


    private void initData() {

        etScan.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent event) {
                if ((event != null && KeyEvent.KEYCODE_ENTER == event.getKeyCode() && KeyEvent.ACTION_DOWN == event.getAction())) {
                    etScan.setEnabled(false);
                    handler.post(delayRun);
                    return true;
                }else if (i == EditorInfo.IME_ACTION_GO){
                    etScan.setEnabled(false);
                    handler.post(delayRun);
                    return true;
                }
                return false;
            }
        });
    }

    private void initListener() {
        ivClose.setOnClickListener(view -> listener(view));
    }

    private void listener(View view) {
        if (view == ivClose) {
            dismiss();
        }
    }


    /**
     * 延迟线程，看是否还有下一个字符输入
     */
    private Runnable delayRun = new Runnable() {

        @Override
        public void run() {
            if (onOkClickListener != null) {
                String replace = etScan.getText().toString().replace(" ", "").replace("\n", "");
                pay(replace);
            }
        }
    };


    private void pay(String result) {
        BigDecimal minMoney = new BigDecimal(money);
        money = minMoney.multiply(new BigDecimal("100")).setScale(0, BigDecimal.ROUND_HALF_UP).toString();

        SPUtils spInsance = SPUtils.getInstance();
        String deviceSN = UniqueIdUtils.getDeviceSN();
        int mid = spInsance.getInt("mid");
        String time = TimeUtils.dateToStamp();
        int id = spInsance.getInt("id");
        String pwd = spInsance.getString("pwd");

        HashMap<String, String> localHashMap = new HashMap<>();
        if (id > 0) {
            localHashMap.put("terminalsn", "");
        } else {
            localHashMap.put("terminalsn", deviceSN);
        }
        localHashMap.put("paymode", "weixinpay");
        localHashMap.put("merchid", mid + "");
        localHashMap.put("authcode", result);
        localHashMap.put("totalfee", money);
        localHashMap.put("discount", 0 + "");
        localHashMap.put("timestamp", time);
        localHashMap.put("cashierid", id + "");
        localHashMap.put("source", 5 + "");
        String sign = SignUtils.sign(localHashMap, pwd);
        localHashMap.put("sign", sign);
        OkGo.<String>post(PropertiesUtils.getProjectConfig().getProperty("api.host") + Constant.posPrePay)
                .upJson(new Gson().toJson(localHashMap))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String body = response.body();
                        QrCodePayResult resultGetOrder = new Gson().fromJson(body, QrCodePayResult.class);
                        if ("SUCCESS".equals(resultGetOrder.getStatus())) {
                            if (onOkClickListener != null)
                                dissmissdialog();
                            onOkClickListener.onsucess(resultGetOrder.getOrderno());
                        } else {
                            dissmissdialog();
                            ToastUtils.showShort("支付失败，请重试");
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        String body = response.body();
                        super.onError(response);
                        dissmissdialog();
                        ToastUtils.showShort("支付失败，请重试");
                    }
                });

    }

    public void dissmissdialog() {
//        frameLayout.setVisibility(View.GONE);
        if (isShowing())
            dismiss();
        if (!ObjectUtils.isEmpty(timer)) {
            timer.cancel();
            timer = null;
        }
    }

}
