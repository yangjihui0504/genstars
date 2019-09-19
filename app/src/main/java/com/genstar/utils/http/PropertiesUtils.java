package com.genstar.utils.http;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertiesUtils {
    @SuppressWarnings("RegExpRedundantEscape")
    private static final Pattern PATTERN = Pattern.compile("\\$\\{([^\\}]+)\\}");
    private final static String SPLIT = "/";
    private final static String PATH = SPLIT + "assets";
    private static Map<String, Properties> properties = new HashMap<>();

    /**
     * 读取配置
     *
     * @param name 文件名
     */
    private static void readProperties(String name) {
        try {
            InputStream in = getResourceAsStream(name);
            Properties read = new Properties();
            read.load(in);
            properties.put(name, read);
        } catch (IOException | NullPointerException e) {
            Log.d("读取配置文件", e.getMessage());
        }
    }

    /**
     * 获取配置
     *
     * @param name 文件名
     */
    private static Properties getProperties(String name) {
        Properties properties = PropertiesUtils.properties.get(name);
        if (properties == null) readProperties(name);
        return PropertiesUtils.properties.get(name);
    }

    public static Properties getProjectConfig() {
        return getProperties("project-config.properties");
    }

    public static Properties getSdkConfig() {
        return getProperties("sdk_config.properties");
    }

    public static InputStream getResourceAsStream(String name) {
        return PropertiesUtils.class.getResourceAsStream(PATH + SPLIT + name);
    }

    public static String loopGet(Properties props, String key) {
        String property = props.getProperty(key);
        if (property != null && !property.isEmpty())
            return loop(props, props.getProperty(key));
        return null;
    }

    private static String loop(Properties props, String key) {
        //定义matcher匹配其中的路径变量
        Matcher matcher = PATTERN.matcher(key);
        StringBuffer buffer = new StringBuffer();
        boolean flag = false;
        while (matcher.find()) {
            String matcherKey = matcher.group(1);//依次替换匹配到的路径变量
            String matcherValue = props.getProperty(matcherKey);
            if (matcherValue != null) {
                //quoteReplacement方法对字符串中特殊字符进行转化
                matcher.appendReplacement(buffer, Matcher.quoteReplacement(matcherValue));
                flag = true;
            }
        }
        matcher.appendTail(buffer);
        //flag为false时说明已经匹配不到路径变量，则不需要再递归查找
        return flag ? loop(props, buffer.toString()) : key;
    }

    public static String appName(){
        return getProjectConfig().getProperty("app.name");
    }
}
