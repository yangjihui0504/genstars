package com.genstar.bean;

public class OrdernumBean {

    /**
     * status : SUCCESS
     * errcode : 0
     * errmsg : ok
     * ordernum : K1C054037CEAB56582
     */

    private String status;
    private int errcode;
    private String errmsg;
    private String ordernum;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }
}
