package com.genstar.bean;

public class PayDetailBean {

    /**
     * paymode : weixinpay
     * orderno :
     * totalfee : 0
     * discount : 0
     * status : FAIL
     * errmsg : 商户未签名
     */

    private String paymode;
    private String orderno;
    private int totalfee;
    private int discount;
    private String status;
    private String errmsg;

    public String getPaymode() {
        return paymode;
    }

    public void setPaymode(String paymode) {
        this.paymode = paymode;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public int getTotalfee() {
        return totalfee;
    }

    public void setTotalfee(int totalfee) {
        this.totalfee = totalfee;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
