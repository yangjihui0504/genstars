package com.genstar.utils;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SignUtils {
    public static String sign(HashMap<String, String> args , String key_) {
        String sign = "";
        StringBuilder sb = new StringBuilder();
        Collection<String> keySet = args.keySet();
        List<String> keyList = new ArrayList<String>(keySet);
        Collections.sort(keyList);

        for (String key : keyList) {
            String value = args.get(key);
            if (!TextUtils.isEmpty(value)) {
                sb.append(key).append("=").append(value).append("&");
            }
        }
        sb.append("key=").append(key_);
        String tmp = sb.toString();
        sign = MD5Utils.md5(tmp).toUpperCase();
        return sign;
    }
}
