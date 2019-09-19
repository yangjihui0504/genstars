package com.genstar.bean;

public class WXParamsBean {

    /**
     * status : SUCCESS
     * errcode : 0
     * errmsg : ok
     * appid : wx6329468685b67b0b
     * mch_id : 1545746591
     * sub_mch_id : 1549238351
     */

    private String status;
    private int errcode;
    private String errmsg;
    private String appid;
    private String mch_id;
    private String sub_mch_id;

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

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public void setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
    }
}
