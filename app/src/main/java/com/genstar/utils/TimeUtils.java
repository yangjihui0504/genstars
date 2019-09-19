package com.genstar.utils;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getNowTime() {
        long time = System.currentTimeMillis();
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = new Date(time);
        String nowTime = format.format(d1);
        return nowTime;
    }

    /**
     * 获取当前时间然后转换成时间戳
     *
     * @return
     * @throws ParseException
     */
    public static String dateToStamp() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = simpleDateFormat.parse(getNowTime());
            long ts = date.getTime();
            return String.valueOf(ts);
        } catch (Exception ex) {
            return "";
        }
    }

}
