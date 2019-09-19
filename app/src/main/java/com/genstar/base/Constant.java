package com.genstar.base;

/**
 * 全局变量
 * Created by comersss on 16/12/23.
 */
public class Constant {
    public static String MD5_KEY = "QzFFMEUwMEM2RDYyNTY4NzdCQkVGQTU1RkQxREI3";
    public static String appid = "";
    public static String mch_id = "";
    public static String sub_mch_id = "";
    public static String authinfo = "";

    //获取authinfo
    public static final String WechatFaceAuth = "/GetWxpayfaceAuthinfo";

    //获取广告素材
    public static final String AdSource = "/GetAdSource";

    //微信刷脸订单接口
    public static final String WxFacePay = "/WxFacePay";

    //条码支付统一接口
    public static final String posPrePay = "/barcode";

    //支付成功页信息
    public static final String WxFacePaySuccess = "/WxFacePaySuccess";

    //商户微信参数接口
    public static final String GetWxParams = "/GetWxParams";

    //创建商户订单号接口
    public static final String CreateOrderNumber = "/CreateOrderNumber";

    //用户登录
    public static final String applogin = "/WxFacepayLogin";

    //取用户信息
    public static final String GetUserByOpenId = "/GetUserByOpenId";

    //优惠查询接口
    public static final String getcoupon = "/getcoupon";

    //会员卡余额支付
    public static final String MemberCardPay = "/MemberCardPay";

    //支付成功后广告计划接口
    public static final String getadplan = "/getadplan";

    //2.10.检测app版本接口
    public static final String CheckUpdate = "/FacePayAPPCheckUpdate";
}
