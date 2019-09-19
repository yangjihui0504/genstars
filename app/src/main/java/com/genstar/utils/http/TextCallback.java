package com.genstar.utils.http;

import android.app.Activity;

import com.genstar.utils.NetworkUtil;
import com.tsy.sdk.myokhttp.response.JsonResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 通用对象解析
 * <pre>使用Gson进行解析</pre>
 *
 * @author 续写经典
 * @date 2015/12/18
 */
public abstract class TextCallback extends JsonResponseHandler {
    protected static final String SUCCESS_CODE = "0";
    protected static final String SUCCESS_STATUS = "SUCCESS";
    protected static final String HTTP_ERROR_MSG = "网络异常,稍后请重试";
    protected static final String DEFAULT_ERROR_MSG = "服务器数据返回异常";
    protected static final String DATA_PRASE_ERROR_MSG = "数据解析异常";
    protected static final String DATA_PRASE_ERROR_MSG_TimeOUT = "网络请求超时";
    protected static final String KEY_STATUS = "status";
    protected static final String KEY_ERRCODE = "errcode";
    protected static final String KEY_ERRMSG = "errmsg";

    private Activity activity;

    public TextCallback(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void onSuccess(int statusCode, JSONObject response) {
        try {
            String json = String.valueOf(response);
            if (json == null || json.equals("null") || json.length() == 0) {
                onErrored(DEFAULT_ERROR_MSG);
                return;
            }
            boolean hasErrorCode = response.has(KEY_ERRCODE);
            if (hasErrorCode){
                final String Errocode = new JSONObject(json).getString(KEY_ERRCODE);
                if (Errocode.equals(SUCCESS_CODE)) {
                    onSuccessed(json);
                } else {
                    final String errmsg = new JSONObject(json).getString(KEY_ERRMSG);
                    onErrored(errmsg);
                }
            }else{
                final String Status = new JSONObject(json).getString(KEY_STATUS);
                if (Status.equals(SUCCESS_STATUS)) {
                    onSuccessed(json);
                } else {
                    final String errmsg = new JSONObject(json).getString(KEY_ERRMSG);
                    onErrored(errmsg);
                }
            }

        } catch (Exception e) {
            onErrored(DATA_PRASE_ERROR_MSG);
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(int statusCode, String error_msg) {
        if (NetworkUtil.getAPNType(activity) == 0) {
            onErrored(HTTP_ERROR_MSG);
        } else {
            onErrored(DATA_PRASE_ERROR_MSG_TimeOUT);
        }
    }

    //成功
    public abstract void onSuccessed(String json) throws JSONException;

    //失败
    public abstract void onErrored(String errmsg);
}
