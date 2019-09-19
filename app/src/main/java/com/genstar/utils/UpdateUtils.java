package com.genstar.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.allenliu.versionchecklib.v2.AllenVersionChecker;
import com.allenliu.versionchecklib.v2.builder.UIData;
import com.allenliu.versionchecklib.v2.callback.RequestVersionListener;
import com.genstar.base.Constant;
import com.genstar.utils.http.PropertiesUtils;

import org.json.JSONException;
import org.json.JSONObject;

public class UpdateUtils {
    private final String tag = "updateUtils";
    private Activity activity;

    private boolean checkFinish = false;

    public UpdateUtils(Activity activity) {
        this.activity = activity;
    }

    private void checkUpdate(String requestUrl, Context context) {
        AllenVersionChecker
                .getInstance()
                .requestVersion()
                .setRequestUrl(requestUrl)
                .request(new RequestVersionListener() {
                    @Override
                    public UIData onRequestVersionSuccess(String response) {
                        //get the data response from server,parse,get the `downloadUlr` and some other ui date
                        try {
                            JSONObject versionInfo = new JSONObject(response);
//            {
//                url: "download url",
//                versionCode: 3,
//                updateMessage: "Android 7.0"
//            }
                            String url = versionInfo.getString("url");
                            int versionCode = versionInfo.getInt("versionCode");
                            String updateMessage = versionInfo.getString("updateMessage");

                            int currentVersion = getCurrentVersionCode(context);
                            if (currentVersion < versionCode) {
                                stopSelf();
                                //return null if you dont want to update application
                                UIData uiData = UIData.create()
                                        .setTitle("发现新版本")
                                        .setContent(updateMessage)
                                        .setDownloadUrl(url);
                                return uiData;
                            } else {
                                onCheckUpdateOver();
                                return null;
                            }
                        } catch (JSONException e) {
                            Log.e(tag, "version info parse error!!", e);
                        } catch (Throwable e) {
                            Log.e(tag, "check version failed:", e);
                        }
                        return null;
                    }

                    @Override
                    public void onRequestVersionFailure(String message) {
                        onCheckUpdateOver();
                    }
                })
                .setForceRedownload(true)
                .setForceUpdateListener(() -> {
//                    foceUpdate();
                })
                .executeMission(context);
    }

    private void onCheckUpdateOver() {
        checkFinish = true;
    }

    private void stopSelf() {
        activity.finish();
    }

    private static int getCurrentVersionCode(Context context) {
        try {
            // ---get the package info---
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            return pi.versionCode;
        } catch (Exception e) {
            Log.e("VersionInfo", "Exception", e);
        }
        return -1;
    }

    /***
     *返回false 表示不需要更新
     */
    public void foceUpdate(String terminalsn) {
        String requestUrl = PropertiesUtils.getProjectConfig().getProperty("api.host") + Constant.CheckUpdate + "?terminalsn=" + terminalsn;
        checkUpdate(requestUrl, activity);

        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
            if (checkFinish) break;
        }

    }

}
