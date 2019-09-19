package com.genstar.utils.http;

import java.util.Properties;

/**
 * Created by test1234 on 2017/6/12.
 */
public class BaseActionHelper {
    //默认接口地址
    private static final String DEF_API_HOST = "https://mp.yiyepay.cn/jkpay/api/posservice";
    //默认接口前缀
//    private static final String API_FIX = "/api/json";

    //默认接口地址
    private static String API_HOST = null;


    static {
        Properties properties = PropertiesUtils.getProjectConfig();
        if (properties != null) {
            API_HOST = properties.getProperty("api.host");
        }
    }

    public static String getUrl() {
        String host;
        if (API_HOST != null && !API_HOST.isEmpty()) {
            host = API_HOST;
        } else {
            host = DEF_API_HOST;
        }
        return host;
    }
}