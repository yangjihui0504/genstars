package com.genstar.utils.http;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.genstar.base.Constant;
import com.genstar.bean.PayDetailBean;
import com.genstar.listener.BaseResultLitener;
import com.genstar.utils.OkHttpUtils;
import com.genstar.utils.SignUtils;
import com.genstar.utils.SpeechUtil;
import com.genstar.utils.TimeUtils;
import com.genstar.utils.UniqueIdUtils;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.tencent.wxpayface.IWxPayfaceCallback;
import com.tencent.wxpayface.WxPayFace;
import com.tsy.sdk.myokhttp.response.IResponseHandler;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static com.genstar.base.BaseActivity.mSpeech;

public class ActionHelper extends BaseActionHelper {


    public static void login(Activity activity, String phone, String pwd, String timestamp, String sign, IResponseHandler responseHandler) {
        Map<String, String> params = new HashMap<>();
        params.put("phone", phone);
        params.put("pwd", pwd);
        params.put("timestamp", timestamp);
        params.put("sign", sign);

        OkHttpUtils.getInstance(activity)
                .post()
                .url(getUrl() + Constant.applogin)
                .tag(activity)
                .params(params)
                .enqueue(responseHandler);
    }


    public static void GetWxpayfaceAuthinfo(Activity activity, String rawdata, String store_id, String device_id, String sign, IResponseHandler responseHandler) {
        Map<String, String> params = new HashMap<>();
        params.put("rawdata", rawdata);
        params.put("store_id", store_id);
        params.put("device_id", device_id);
        params.put("sign", sign);

        OkHttpUtils.getInstance(activity)
                .post()
                .url(getUrl() + Constant.WechatFaceAuth)
                .tag(activity)
                .params(params)
                .enqueue(responseHandler);
    }

    /**
     * 获取广告信息
     *
     * @param activity
     * @param EndTime
     * @param responseHandler
     */
    public static void GetAdSource(Activity activity, String EndTime, IResponseHandler responseHandler) {
        Map<String, String> params = new HashMap<>();
        params.put("EndTime", EndTime);
        OkHttpUtils.getInstance(activity)
                .post()
                .url(getUrl() + Constant.AdSource)
                .tag(activity)
                .params(params)
                .enqueue(responseHandler);
    }

    public static void ScanPayTypeFace(final BaseResultLitener baseResultLitener) {
        if (TextUtils.isEmpty(Constant.authinfo) || TextUtils.isEmpty(Constant.appid) || TextUtils.isEmpty(Constant.mch_id) || TextUtils.isEmpty(Constant.sub_mch_id)) {
            ToastUtils.showShort("请先获取rawdata");
            return;
        }
        HashMap<Object, Object> localHashMap = new HashMap();
        localHashMap.put("face_authtype", "FACEID-ONCE");
        localHashMap.put("appid", Constant.appid);
        localHashMap.put("mch_id", Constant.mch_id);
        localHashMap.put("authinfo", Constant.authinfo);
        localHashMap.put("sub_mch_id", Constant.sub_mch_id);
//        localHashMap.put("store_id", SPUtils.getInstance().getInt("sid")); // 门店编号，必填

        WxPayFace.getInstance().getWxpayfaceUserInfo(localHashMap, new IWxPayfaceCallback() {
            public void response(final Map paramMap) throws RemoteException {
                Log.i("test", "response | getWxpayfaceUserInfo " + paramMap);
                final String code = paramMap.get("return_code").toString();
                if (TextUtils.equals(code, "SUCCESS")) {
                    String openid = paramMap.get("openid").toString().trim();
                    String sub_openid = paramMap.get("sub_openid").toString().trim();
                    String nickname = paramMap.get("nickname").toString().trim();
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("openid", openid);
                    jsonObject.put("nickname", nickname);
                    String jsonString = jsonObject.toJSONString();

                    baseResultLitener.sucess(jsonString, openid);

                } else if (TextUtils.equals(code, "USER_CANCEL")) {
                    baseResultLitener.fail("用户取消");
                } else if (TextUtils.equals(code, "SCAN_PAYMENT")) {
                    baseResultLitener.fail("返回");
                }

            }
        });

    }

    //微信扫脸支付
    public static void ScanPayTypes(Activity activity, final String outTratNum, final String money, final BaseResultLitener baseResultLitener) {
        HashMap<Object, Object> localHashMap = new HashMap();
        String appid = Constant.appid;
        String mch_id = Constant.mch_id;
        String sub_mch_id = Constant.sub_mch_id;
        localHashMap.put("face_authtype", "FACEPAY");
        localHashMap.put("appid", appid);
        localHashMap.put("mch_id", mch_id);
        localHashMap.put("out_trade_no", outTratNum);
        localHashMap.put("total_fee", money);
        localHashMap.put("ask_face_permit", "1");
        localHashMap.put("ask_ret_page", "1");
        localHashMap.put("sub_mch_id", sub_mch_id);

        if (TextUtils.isEmpty(Constant.authinfo)) {
            ToastUtils.showShort("请先获取rawdata");
            return;
        }
        localHashMap.put("authinfo", Constant.authinfo);
        WxPayFace.getInstance().getWxpayfaceCode(localHashMap, new IWxPayfaceCallback() {
            public void response(final Map paramMap) throws RemoteException {
                Log.i("test", "response | getWxpayfaceCode " + paramMap);
                final String code = paramMap.get("return_code").toString();
                if (TextUtils.equals(code, "SUCCESS")) {
                    String openid = paramMap.get("openid").toString().trim();
                    String face_code = paramMap.get("face_code").toString().trim();
                    //直接消费
                    pay(activity, money, outTratNum, openid, face_code, baseResultLitener);
//                    baseResultLitener.sucess(code , "");

                } else if (TextUtils.equals(code, "USER_CANCEL")) {
                    baseResultLitener.fail("用户取消");
                } else if (TextUtils.equals(code, "SCAN_PAYMENT")) {
                    baseResultLitener.fail("扫码支付");
                }

            }
        });

    }

    private static void pay(Activity activity, String money, String outTratNum, String openid, String face_code, BaseResultLitener baseResultLitener) {
        SPUtils spInsance = SPUtils.getInstance();
        String deviceSN = UniqueIdUtils.getDeviceSN();
        int mid = spInsance.getInt("mid");
        String time = TimeUtils.dateToStamp();
        int id = spInsance.getInt("id");
        String pwd = spInsance.getString("pwd");

        HashMap<String, String> params = new HashMap<>();
        params.put("terminalsn", deviceSN);
        params.put("merchid", mid + "");
        params.put("ordernum", outTratNum);
        params.put("face_code", face_code);
        params.put("openid", openid);
        params.put("totalfee", money);
        params.put("discount", 0 + "");
        params.put("timestamp", time);
        params.put("cashierid", id + "");
        params.put("source", 5 + "");
        params.put("paymode", "weixinpay");
        String sign = SignUtils.sign(params, pwd);
        params.put("sign", sign);


        OkGo.<String>post(getUrl() + Constant.WxFacePay).upJson(new Gson().toJson(params))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {

                        Log.i("test", "response.body() = " + response.body());
                        String body = response.body();
                        PayDetailBean payDetailBean = new Gson().fromJson(body, PayDetailBean.class);
                        if (!"SUCCESS".equals(payDetailBean.getStatus())) {
                            ToastUtils.showShort(payDetailBean.getErrmsg());
                            baseResultLitener.fail(payDetailBean.getErrmsg());
                            return;
                        } else {

                            WxPayFace.getInstance().updateWxpayfacePayResult(params, new IWxPayfaceCallback() {
                                public void response(Map paramMap) throws RemoteException {
                                    baseResultLitener.sucess(payDetailBean.getOrderno(), openid);
                                }
                            });
                        }
//

                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        baseResultLitener.fail("网络异常：" + response.body());
                    }
                });
    }


    public static void getWXParams(Activity activity, String mid, IResponseHandler responseHandler) {
        Map<String, String> params = new HashMap<>();
        params.put("mid", mid);

        OkHttpUtils.getInstance(activity)
                .post()
                .url(getUrl() + Constant.GetWxParams)
                .tag(activity)
                .params(params)
                .enqueue(responseHandler);
    }

    public static void CreateOrderNumber(Activity activity, String mid, IResponseHandler responseHandler) {
        Map<String, String> params = new HashMap<>();
        params.put("mid", mid);

        OkHttpUtils.getInstance(activity)
                .post()
                .url(getUrl() + Constant.CreateOrderNumber)
                .tag(activity)
                .params(params)
                .enqueue(responseHandler);
    }

    public static void WxFacePaySuccess(Activity activity, String OrderNum, IResponseHandler responseHandler) {
        Map<String, String> params = new HashMap<>();
        params.put("OrderNum", OrderNum);


        OkHttpUtils.getInstance(activity)
                .post()
                .url(getUrl() + Constant.WxFacePaySuccess)
                .tag(activity)
                .params(params)
                .enqueue(responseHandler);
    }

    public static void GetUserByOpenId(Activity activity, String Openid, String Nickname, IResponseHandler responseHandler) {
        Map<String, String> params = new HashMap<>();
        params.put("Openid", Openid);
        params.put("Nickname", Nickname);


        OkHttpUtils.getInstance(activity)
                .post()
                .url(getUrl() + Constant.GetUserByOpenId)
                .tag(activity)
                .params(params)
                .enqueue(responseHandler);
    }

    public static void getcoupon(Activity activity, String money, String payway, String openid, IResponseHandler responseHandler) {
        Map<String, String> params = new HashMap<>();
        params.put("money", money);
        params.put("payway", payway);
        params.put("openid", openid);


        OkHttpUtils.getInstance(activity)
                .post()
                .url(getUrl() + Constant.getcoupon)
                .tag(activity)
                .params(params)
                .enqueue(responseHandler);
    }

    public static void MemberCardPay(Activity activity, String amount, String Openid, String merchid, String shopid,String sign, String paymode, String timestamp
            , String Discount, String ActualCharge, String CouponId, String Point, String PointMoney
            , String DiscoutMoney, String GetPoint, IResponseHandler responseHandler) {
        Map<String, String> params = new HashMap<>();
        params.put("Openid", Openid);
        params.put("amount", amount);
        params.put("merchid", merchid);
        params.put("shopid", shopid);
        params.put("paymode", paymode);
        params.put("timestamp", timestamp);

        params.put("sign", sign);
        params.put("Discount", Discount);
        params.put("ActualCharge", ActualCharge);
        if (!TextUtils.isEmpty(CouponId)) {
            params.put("CouponId", CouponId);
        }
        if (!TextUtils.isEmpty(Point)) {
            params.put("Point", Point);
        }
        if (!TextUtils.isEmpty(PointMoney)) {
            params.put("PointMoney", PointMoney);
        }
        if (!TextUtils.isEmpty(DiscoutMoney)) {
            params.put("DiscoutMoney", DiscoutMoney);
        }
        if (!TextUtils.isEmpty(GetPoint)) {
            params.put("GetPoint", GetPoint);
        }

        OkHttpUtils.getInstance(activity)
                .post()
                .url(getUrl() + Constant.MemberCardPay)
                .tag(activity)
                .params(params)
                .enqueue(responseHandler);
    }


    public static void getadplan(Activity activity, String Endtime, IResponseHandler responseHandler) {
        Map<String, String> params = new HashMap<>();
        params.put("Endtime", Endtime);


        OkHttpUtils.getInstance(activity)
                .post()
                .url(getUrl() + Constant.getadplan)
                .tag(activity)
                .params(params)
                .enqueue(responseHandler);
    }
}
