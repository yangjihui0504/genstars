package com.genstar.utils;

import android.app.Activity;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;

import com.blankj.utilcode.util.EncodeUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.genstar.base.Constant;
import com.genstar.bean.AuthinfoBean;
import com.genstar.utils.http.ActionHelper;
import com.genstar.utils.http.TextCallback;
import com.google.gson.Gson;
import com.tencent.wxpayface.IWxPayfaceCallback;
import com.tencent.wxpayface.WxPayFace;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class WXUtils {
    private static HashMap<Object, Object> localHashMap;
    private static SPUtils spInsance;

    /**
     * 初始化微信刷脸sdk
     */
    public static void initWX(Activity activity) {
        spInsance = SPUtils.getInstance();
        try {
            WxPayFace.getInstance().initWxpayface(activity, new IWxPayfaceCallback() {
                public void response(Map paramMap) throws RemoteException {
                    Log.i("test", "response | initWxpayface " + paramMap);
                    getAuthInfo(activity);
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.i("test", ex + "");
        }
    }


    private static void getAuthInfo(Activity activity) {
        WxPayFace.getInstance().getWxpayfaceRawdata(new IWxPayfaceCallback() {
            public void response(Map paramMap) throws RemoteException {
                Log.i("test", "paramMap = " + paramMap);

                try {
                    String rawdata = paramMap.get("rawdata").toString();
                    String sid = spInsance.getInt("sid") + "";
                    String deviceSN = UniqueIdUtils.getDeviceSN();
                    HashMap<String, String> hashMap = new HashMap<>();
                    String rawdata1 = EncodeUtils.urlEncode(rawdata);
                    hashMap.put("rawdata", rawdata);
                    hashMap.put("store_id", sid);
                    hashMap.put("device_id", deviceSN);
                    String sign = SignUtils.sign(hashMap , Constant.MD5_KEY);

                    ActionHelper.GetWxpayfaceAuthinfo(activity, rawdata1, sid, deviceSN, sign, new TextCallback(activity) {
                        @Override
                        public void onSuccessed(String json) throws JSONException {
                            AuthinfoBean authinfoBean = new Gson().fromJson(json, AuthinfoBean.class);
                            Constant.authinfo = authinfoBean.getAuthinfo();

                            //开启一个子线程，定时刷新
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    Looper.prepare();
                                    try {
                                        Thread.sleep(24 * 60 * 60 * 1000);
                                        getAuthInfo(activity);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    Looper.loop();
                                }
                            }).start();
                        }

                        @Override
                        public void onErrored(String errmsg) {
                            ToastUtils.showShort("初始化失败,请退出重进");
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

//                localHashMap = new HashMap<>();
//                localHashMap.put("rawdata", paramMap.get("rawdata").toString());
//                localHashMap.put("store_id", spInsance.getString("sid"));
//                localHashMap.put("device_id", UniqueIdUtils.getDeviceSN());
//                localHashMap.put("appid", Constant.appid);
//                localHashMap.put("mch_id", Constant.mch_id);
//                Log.i("test", "map = " + localHashMap);
//                String sLocalHashMap = new Gson().toJson(localHashMap);
//                OkGo.<String>post(PropertiesUtils.getProjectConfig().getProperty("api.host") + Constant.WechatFaceAuth)
//                        .upJson(sLocalHashMap)
//                        .execute(new StringCallback() {
//                            @Override
//                            public void onSuccess(Response<String> response) {
//                                try {
//                                    String body = response.body();
//                                    Log.i("test", "getAuthInfo :" + body);
//                                    ArgGetAuthInfo result = new Gson().fromJson(body, ArgGetAuthInfo.class);
//                                    if (result.isSuccess()) {
//                                        Constant.authInfo.setAuthinfo(result.getData().getAuthinfo());
//                                        Constant.authInfo.setExpire_time(System.currentTimeMillis());
//                                        //开启一个子线程，定时刷新
//                                        new Thread(new Runnable() {
//                                            @Override
//                                            public void run() {
//                                                Looper.prepare();
//                                                try {
////                                                    int millis = Integer.parseInt(result.getData().getExpires_in());
////                                                    Log.i("test", millis + "");
//                                                    Thread.sleep(24 * 60 * 60 * 1000);
//                                                    getAuthInfo();
//                                                } catch (InterruptedException e) {
//                                                    e.printStackTrace();
//                                                }
//                                                Looper.loop();
//                                            }
//                                        }).start();
//                                    } else {
//                                        ToastUtils.showShort(" Msg = " + result.getMessage());
//                                    }
//
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//
//                                    ToastUtils.showShort("初始化失败,请退出重进");
//
//                                }
//                            }
//
//                            @Override
//                            public void onError(Response<String> response) {
//                                super.onError(response);
//                                ToastUtils.showShort("初始化失败,请退出重进");
//                            }
//                        });


    }

    public static void stopWX() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                    HashMap<String, String> map = new HashMap<String, String>();
//                    map.put("authinfo", Constant.authInfo.getAuthinfo()); // 调用凭证，必填
                    WxPayFace.getInstance().stopWxpayface(map, new IWxPayfaceCallback() {
                        @Override
                        public void response(Map info) throws RemoteException {
                            if (info == null) {
                                new RuntimeException("调用返回为空").printStackTrace();
                                return;
                            }
                            String code = (String) info.get("return_code"); // 错误码
                            String msg = (String) info.get("return_msg"); // 错误码描述
                            if (code == null || !code.equals("SUCCESS")) {
                                new RuntimeException("调用返回非成功信息,return_msg:" + msg + "   ").printStackTrace();
                                return;
                            }
                /*
                在这里处理您自己的业务逻辑
                 */
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }
        }).start();

    }
}
