package com.genstar.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.RelativeLayout;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.genstar.R;
import com.genstar.base.BaseActivity;
import com.genstar.bean.FaceMenberBean;
import com.genstar.bean.OrdernumBean;
import com.genstar.dialog.TopDialog;
import com.genstar.listener.BaseResultLitener;
import com.genstar.utils.SpeechUtil;
import com.genstar.utils.UniqueIdUtils;
import com.genstar.utils.http.ActionHelper;
import com.genstar.utils.http.TextCallback;
import com.google.gson.Gson;

import org.json.JSONException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChoiseActivity extends BaseActivity {

    @BindView(R.id.ll_member)
    RelativeLayout llMember;
    @BindView(R.id.ll_face)
    RelativeLayout llFace;
    @BindView(R.id.ll_sweep)
    RelativeLayout llSweep;
    private ArrayList<Integer> imagePath = new ArrayList<>();
    private String money;
    HashMap<String, String> hashMap = new HashMap<>();
    private TopDialog topDialog;


    public static void open(Context context, Intent extras) {
        Intent intent = new Intent();
        intent.setClass(context, ChoiseActivity.class);
        if (extras != null) {
            intent.putExtras(extras);
        }
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choise);
        ButterKnife.bind(this);
        initData();
        initListener();
    }

    private void initData() {
        Intent intent = getIntent();
        money = intent.getStringExtra("money");
    }


    private void initListener() {
        llFace.setOnClickListener(this::setListener);
        llMember.setOnClickListener(this::setListener);
        llSweep.setOnClickListener(this::setListener);
    }

    private void setListener(View view) {
        if (view == llFace) {
            pay();
        } else if (view == llMember) {
            scanpay();
        } else if (view == llSweep) {
            showTopDialog();
        }
    }

    private void pay() {
        BigDecimal minMoney = new BigDecimal(money);
        String smoney = minMoney.multiply(new BigDecimal("100")).setScale(0, BigDecimal.ROUND_HALF_UP).toString();
        //获取订单号
        ActionHelper.CreateOrderNumber(mActivity, spInsance.getInt("mid") + "", new TextCallback(mActivity) {
            @Override
            public void onSuccessed(String json) throws JSONException {
                OrdernumBean ordernumBean = new Gson().fromJson(json, OrdernumBean.class);
                //开启刷脸
                ActionHelper.ScanPayTypes(mActivity, ordernumBean.getOrdernum(), smoney, new BaseResultLitener() {
                    @Override
                    public void sucess(String serverRetData, String openid) {
                        SpeechUtil.openAudioFile(mSpeech, "支付成功,支付" + money+"元");
                        finish();
                    }

                    @Override
                    public void fail(String errMsg) {
                        SpeechUtil.openAudioFile(mSpeech, "支付失败" + errMsg);
                    }
                });
            }

            @Override
            public void onErrored(String errmsg) {
                SpeechUtil.openAudioFile(mSpeech, "支付失败" + errmsg);
            }
        });
    }

    private void scanpay() {
        ActionHelper.ScanPayTypeFace(new BaseResultLitener() {
            @Override
            public void sucess(String serverRetData, String openid) {
                FaceMenberBean faceMenberBean = new Gson().fromJson(serverRetData, FaceMenberBean.class);
                String nickname = faceMenberBean.getNickname();
                Intent intent = new Intent();
                intent.putExtra("openid", openid);
                intent.putExtra("nickname", nickname);
                intent.putExtra("money", money);
                PayActivity.open(mActivity, intent);
                finish();
            }

            @Override
            public void fail(String errMsg) {

            }
        });
    }

    private void showTopDialog() {
        topDialog = new TopDialog(mActivity, money);
        topDialog.setOnOkClickListener(new TopDialog.OnOkClickListener() {
            @Override
            public void onsucess(String didanhao) {
                showSuccess(didanhao);
            }

            @Override
            public void onfaile() {
                ToastUtils.showShort("支付失败，请重新支付");
            }
        });
        if (!topDialog.isShowing()) {
            topDialog.show();
        }
    }

    private void showSuccess(String didanhao) {
        Intent intent = new Intent();
        intent.putExtra("OrderNum", didanhao);
        PaySuccessActivity.open(mActivity, intent);
        finish();
    }

}
