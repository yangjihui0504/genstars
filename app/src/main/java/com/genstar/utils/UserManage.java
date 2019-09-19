package com.genstar.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

public class UserManage {
    private static UserManage instance;

    private UserManage() {
    }

    public static UserManage getInstance() {
        if (instance == null) {
            instance = new UserManage();
        }
        return instance;
    }


    /**
     * 保存所有
     */
    public void saveUserInfo(Context context, String token , String username ,String password) {
        SharedPreferences sp = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);//Context.MODE_PRIVATE表示SharePrefences的数据只有自己应用程序能访问。
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("Authorization", token);
        editor.putString("username", username);
        editor.putString("password", password);
        editor.commit();
    }


    /**
     * 保存自动登录的用户信息
     */
    public void saveToken(Context context, String token ) {
        SharedPreferences sp = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);//Context.MODE_PRIVATE表示SharePrefences的数据只有自己应用程序能访问。
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("Authorization", token);
        editor.commit();
    }

    /**
     * 保存自动登录的用户信息
     */
    public void deleteUser(Context context, String token , String username ,String password) {
        SharedPreferences sp = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);//Context.MODE_PRIVATE表示SharePrefences的数据只有自己应用程序能访问。
        SharedPreferences.Editor editor = sp.edit();
        editor.remove("username");
        editor.remove("password");
        editor.commit();
    }
    /**
     * 删除token
     */
    public void deleteToken(Context context) {
        SharedPreferences sp = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        sp.edit().remove("Authorization").commit();
    }
    /**
     * 删除sp所有数据
     */
    public void deleteSp(Context context) {
        SharedPreferences sp = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        sp.edit().clear().commit();
    }


    /**
     * 获取token
     */
    public String getAuthorization(Context context) {
        SharedPreferences sp = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        return sp.getString("Authorization", "");
    }


    /**
     * 判断sp中是否有token
     */
    public boolean hasToken(Context context) {
        String authorization = getAuthorization(context);
        if (authorization != null && !TextUtils.isEmpty(authorization)) {
            //有数据
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取保存的username
     */
    public String getUsername(Context context) {
        SharedPreferences sp = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        return sp.getString("username", "");
    }

    /**
     * 获取保存的psd
     */
    public String getPassword(Context context) {
        SharedPreferences sp = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        return sp.getString("password", "");
    }



}


