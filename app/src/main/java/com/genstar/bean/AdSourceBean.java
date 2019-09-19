package com.genstar.bean;

import java.util.List;

public class AdSourceBean {

    /**
     * status : SUCCESS
     * errcode : 0
     * errmsg : ok
     * list : [{"id":3,"adTitle":"背景3","adSource":"https://mp.yiyepay.cn/jkpaymp//upfiles/images/bg3.png","adType":0,"adHit":0,"adPV":0,"adMid":0,"adStatus":1,"adEndTime":"/Date(7889155200000)/"},{"id":2,"adTitle":"背景2","adSource":"https://mp.yiyepay.cn/jkpaymp//upfiles/images/bg2.png","adType":0,"adHit":0,"adPV":0,"adMid":0,"adStatus":1,"adEndTime":"/Date(7889155200000)/"},{"id":1,"adTitle":"背景1","adSource":"https://mp.yiyepay.cn/jkpaymp//upfiles/images/bg1.png","adType":0,"adHit":0,"adPV":0,"adMid":0,"adStatus":1,"adEndTime":"/Date(7889155200000)/"}]
     */

    private String status;
    private int errcode;
    private String errmsg;
    private List<ListBean> list;

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

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * id : 3
         * adTitle : 背景3
         * adSource : https://mp.yiyepay.cn/jkpaymp//upfiles/images/bg3.png
         * adType : 0
         * adHit : 0
         * adPV : 0
         * adMid : 0
         * adStatus : 1
         * adEndTime : /Date(7889155200000)/
         */

        private int id;
        private String adTitle;
        private String adSource;
        private int adType;
        private int adHit;
        private int adPV;
        private int adMid;
        private int adStatus;
        private String adEndTime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAdTitle() {
            return adTitle;
        }

        public void setAdTitle(String adTitle) {
            this.adTitle = adTitle;
        }

        public String getAdSource() {
            return adSource;
        }

        public void setAdSource(String adSource) {
            this.adSource = adSource;
        }

        public int getAdType() {
            return adType;
        }

        public void setAdType(int adType) {
            this.adType = adType;
        }

        public int getAdHit() {
            return adHit;
        }

        public void setAdHit(int adHit) {
            this.adHit = adHit;
        }

        public int getAdPV() {
            return adPV;
        }

        public void setAdPV(int adPV) {
            this.adPV = adPV;
        }

        public int getAdMid() {
            return adMid;
        }

        public void setAdMid(int adMid) {
            this.adMid = adMid;
        }

        public int getAdStatus() {
            return adStatus;
        }

        public void setAdStatus(int adStatus) {
            this.adStatus = adStatus;
        }

        public String getAdEndTime() {
            return adEndTime;
        }

        public void setAdEndTime(String adEndTime) {
            this.adEndTime = adEndTime;
        }
    }
}
