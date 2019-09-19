package com.genstar.utils;

import android.content.Context;

import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.tsy.sdk.myokhttp.MyOkHttp;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CookieJar;
import okhttp3.OkHttpClient;

/**
 * 应用名称: BaiLeMeng
 * 包 名 称: com.bailemeng.app.common.http
 * 描    述:
 * 创 建 人: shenjinghao
 * 创建时间: 2017/11/7
 */
public class OkHttpUtils {
    private static MyOkHttp mMyOkHttp;
    public static MyOkHttp init(Context context){
        //持久化存储cookie
        ClearableCookieJar cookieJar =
                new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context));
        //自定义OkHttp
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .cookieJar(cookieJar)       //设置开启cookie
                .cache(new Cache(new File(context.getExternalCacheDir(), "okhttpcache"), 10 * 1024 * 1024))
                .retryOnConnectionFailure(true)
//                .addInterceptor(logging)            //设置开启log
                .build();
        mMyOkHttp = new MyOkHttp(okHttpClient);
        return mMyOkHttp;
    }

    public static MyOkHttp getInstance(Context context) {
        return init(context);
    }

    public static void setCookie(Context context, ClearableCookieJar cookieJar) {
        //自定义OkHttp
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .cookieJar(cookieJar)       //设置开启cookie
                .cache(new Cache(new File(context.getExternalCacheDir(), "okhttpcache"), 10 * 1024 * 1024))
//                .addInterceptor(logging)            //设置开启log
                .build();
        mMyOkHttp = new MyOkHttp(okHttpClient);
    }

    public static void setCookie(Context context, CookieJar cookieJar) {
        //自定义OkHttp
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                .cookieJar(cookieJar)       //设置开启cookie
                .cache(new Cache(new File(context.getExternalCacheDir(), "okhttpcache"), 10 * 1024 * 1024))
//                .addInterceptor(logging)            //设置开启log
                .build();
        mMyOkHttp = new MyOkHttp(okHttpClient);
    }
}
