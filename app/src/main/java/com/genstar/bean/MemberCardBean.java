package com.genstar.bean;

public class MemberCardBean {

    /**
     * Result : true
     * Errmsg : 会员卡支付成功
     * OrderNum : K1C0540C1E978435C2
     * Token : null
     * AppId : null
     * TimeStamp : null
     * NonceStr : null
     * Package : null
     * SignType : null
     * PaySign : null
     */

    private boolean Result;
    private String Errmsg;
    private String OrderNum;
    private Object Token;
    private Object AppId;
    private Object TimeStamp;
    private Object NonceStr;
    private Object Package;
    private Object SignType;
    private Object PaySign;

    public boolean isResult() {
        return Result;
    }

    public void setResult(boolean Result) {
        this.Result = Result;
    }

    public String getErrmsg() {
        return Errmsg;
    }

    public void setErrmsg(String Errmsg) {
        this.Errmsg = Errmsg;
    }

    public String getOrderNum() {
        return OrderNum;
    }

    public void setOrderNum(String OrderNum) {
        this.OrderNum = OrderNum;
    }

    public Object getToken() {
        return Token;
    }

    public void setToken(Object Token) {
        this.Token = Token;
    }

    public Object getAppId() {
        return AppId;
    }

    public void setAppId(Object AppId) {
        this.AppId = AppId;
    }

    public Object getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(Object TimeStamp) {
        this.TimeStamp = TimeStamp;
    }

    public Object getNonceStr() {
        return NonceStr;
    }

    public void setNonceStr(Object NonceStr) {
        this.NonceStr = NonceStr;
    }

    public Object getPackage() {
        return Package;
    }

    public void setPackage(Object Package) {
        this.Package = Package;
    }

    public Object getSignType() {
        return SignType;
    }

    public void setSignType(Object SignType) {
        this.SignType = SignType;
    }

    public Object getPaySign() {
        return PaySign;
    }

    public void setPaySign(Object PaySign) {
        this.PaySign = PaySign;
    }
}
