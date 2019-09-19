package com.genstar.bean;

public class SuccessCouponBean {

    /**
     * errcode : 0
     * errmsg : ok
     * total : 0
     * coupon_id : 0
     * coupon_type :
     * coupon_least_money : 0
     * coupon_money : 0
     * coupon_discount : 0
     * dixian : false
     * dixian_price1 : 0
     * dixian_price2 : 0
     * fanjifen : false
     * fanjifen_price : 0
     * fanjifen_max : 0
     * lingquyouhui : true
     */

    private String errcode;
    private String errmsg;
    private int total;
    private int coupon_id;
    private String coupon_type;
    private double coupon_least_money;
    private double coupon_money;
    private String coupon_discount;
    private boolean dixian;
    private double dixian_price1;
    private double dixian_price2;
    private boolean fanjifen;
    private double fanjifen_price;
    private double fanjifen_max;
    private boolean lingquyouhui;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(int coupon_id) {
        this.coupon_id = coupon_id;
    }

    public String getCoupon_type() {
        return coupon_type;
    }

    public void setCoupon_type(String coupon_type) {
        this.coupon_type = coupon_type;
    }

    public double getCoupon_least_money() {
        return coupon_least_money;
    }

    public void setCoupon_least_money(double coupon_least_money) {
        this.coupon_least_money = coupon_least_money;
    }

    public double getCoupon_money() {
        return coupon_money;
    }

    public void setCoupon_money(double coupon_money) {
        this.coupon_money = coupon_money;
    }

    public String getCoupon_discount() {
        return coupon_discount;
    }

    public void setCoupon_discount(String coupon_discount) {
        this.coupon_discount = coupon_discount;
    }

    public boolean isDixian() {
        return dixian;
    }

    public void setDixian(boolean dixian) {
        this.dixian = dixian;
    }

    public double getDixian_price1() {
        return dixian_price1;
    }

    public void setDixian_price1(double dixian_price1) {
        this.dixian_price1 = dixian_price1;
    }

    public double getDixian_price2() {
        return dixian_price2;
    }

    public void setDixian_price2(double dixian_price2) {
        this.dixian_price2 = dixian_price2;
    }

    public boolean isFanjifen() {
        return fanjifen;
    }

    public void setFanjifen(boolean fanjifen) {
        this.fanjifen = fanjifen;
    }

    public double getFanjifen_price() {
        return fanjifen_price;
    }

    public void setFanjifen_price(double fanjifen_price) {
        this.fanjifen_price = fanjifen_price;
    }

    public double getFanjifen_max() {
        return fanjifen_max;
    }

    public void setFanjifen_max(double fanjifen_max) {
        this.fanjifen_max = fanjifen_max;
    }

    public boolean isLingquyouhui() {
        return lingquyouhui;
    }

    public void setLingquyouhui(boolean lingquyouhui) {
        this.lingquyouhui = lingquyouhui;
    }
}
