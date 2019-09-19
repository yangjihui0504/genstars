package com.genstar.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.blankj.utilcode.util.ToastUtils;
import com.genstar.R;
import com.genstar.base.BaseActivity;
import com.genstar.base.Constant;
import com.genstar.bean.LoginBean;
import com.genstar.bean.WXParamsBean;
import com.genstar.utils.DataUtil;
import com.genstar.utils.MD5Utils;
import com.genstar.utils.SignUtils;
import com.genstar.utils.TimeUtils;
import com.genstar.utils.UniqueIdUtils;
import com.genstar.utils.UpdateUtils;
import com.genstar.utils.http.ActionHelper;
import com.genstar.utils.http.TextCallback;
import com.google.gson.Gson;

import org.json.JSONException;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LoginActivity extends BaseActivity {

    @BindView(R.id.rl_no_wang)
    RelativeLayout rlNoWang;
    @BindView(R.id.iv_quit)
    ImageView ivQuit;
    @BindView(R.id.et_user)
    EditText etUser;
    @BindView(R.id.ll_user)
    LinearLayout llUser;
    @BindView(R.id.et_psd)
    EditText etPsd;
    @BindView(R.id.iv_eyes)
    ImageView ivEyes;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.rv_youwang)
    RelativeLayout rvYouwang;
    @BindView(R.id.ll_all)
    RelativeLayout llAll;
    HashMap<String, String> hashMap = new HashMap<>();

    public static void open(Context context) {

        Intent intent = new Intent();
        intent.setClass(context, LoginActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_twopanes);
        ButterKnife.bind(this);
        initData();
        initListener();
    }

    private void initData() {

        //自动更新
        new Thread(new Runnable() {
            @Override
            public void run() {
                UpdateUtils updateUtils = new UpdateUtils(mActivity);
                String deviceSN = UniqueIdUtils.getDeviceSN();
                updateUtils.foceUpdate(deviceSN);
            }
        }).start();

    }

    private void initListener() {
        btnLogin.setOnClickListener(this::setListener);
    }

    private void setListener(View view) {
        if (view == btnLogin) {
            String sUser = etUser.getText().toString().trim();
            String sPWD = etPsd.getText().toString().trim();
            if (DataUtil.isEmpty(sUser)&&DataUtil.isEmpty(sPWD)){
                ToastUtils.showShort("账号密码不能为空");
                return;
            }
            if (hashMap != null) {
                String time = TimeUtils.dateToStamp();
                hashMap.clear();
                hashMap.put("phone",sUser );
                hashMap.put("pwd", getMD5(sPWD));
                hashMap.put("timestamp", time);
                String sign = SignUtils.sign(hashMap, Constant.MD5_KEY);
                btnLogin.setClickable(false);
                ActionHelper.login(mActivity, etUser.getText().toString().trim(), getMD5(etPsd.getText().toString().trim()),
                        time, sign, new TextCallback(mActivity) {
                            @Override
                            public void onSuccessed(String data) throws JSONException {
                                btnLogin.setClickable(true);
                                LoginBean loginBean = new Gson().fromJson(data, LoginBean.class);

                                spInsance.put("id", loginBean.getId());
                                spInsance.put("pwd", getMD5(etPsd.getText().toString().trim()));
                                spInsance.put("name", loginBean.getName());
                                spInsance.put("phone", loginBean.getPhone());
                                spInsance.put("mid", loginBean.getMid());
                                spInsance.put("sid", loginBean.getSid());
                                spInsance.put("jobnum", loginBean.getJobnum());
                                spInsance.put("MerchantName", loginBean.getMerchantName());
                                spInsance.put("ShopName", loginBean.getShopName());
                                spInsance.put("shoplogo", loginBean.getShoplogo());
                                //存储boolean值
                                spInsance.put("ismanager", loginBean.isIsmanager());
                                spInsance.put("issuper", loginBean.isIssuper());
                                //存储list集合
                                String shopList = new Gson().toJson(loginBean.getShopList());
                                spInsance.put("ShopList", shopList);

                                ActionHelper.getWXParams(mActivity, loginBean.getMid() + "", new TextCallback(mActivity) {
                                    @Override
                                    public void onSuccessed(String json) throws JSONException {
                                        WXParamsBean wxParamsBean = new Gson().fromJson(json, WXParamsBean.class);
                                        Constant.appid = wxParamsBean.getAppid();
                                        Constant.mch_id = wxParamsBean.getMch_id();
                                        Constant.sub_mch_id = wxParamsBean.getSub_mch_id();
                                        MainActivity.open(mActivity);
                                        finish();
                                    }

                                    @Override
                                    public void onErrored(String errmsg) {

                                    }
                                });
                            }

                            @Override
                            public void onErrored(String message) {
                                btnLogin.setClickable(true);
                                ToastUtils.showShort(message);
                            }
                        });
            }


        }
    }

    /**
     * 两次md5加密
     *
     * @param pwd
     * @return
     */
    private String getMD5(String pwd) {
        return MD5Utils.md5(MD5Utils.md5(pwd).toLowerCase()).toLowerCase();
    }


}
