package com.genstar.bean;

public class AdplanBean {

    /**
     * status : SUCCESS
     * errcode : 0
     * errmsg : ok
     * list : {"id":1,"apTitle":"成功页底部","apStartTime":"/Date(1567267200000)/","apEndTime":"/Date(1598889600000)/","apStatus":1,"apPV":0,"apAdContent":"https://mp.yiyepay.cn/jkpaymp//upfiles/images/success1.png,https://mp.yiyepay.cn/jkpaymp//upfiles/images/success2.png,https://mp.yiyepay.cn/jkpaymp//upfiles/images/success3.png"}
     */

    private String status;
    private int errcode;
    private String errmsg;
    private ListBean list;

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

    public ListBean getList() {
        return list;
    }

    public void setList(ListBean list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * id : 1
         * apTitle : 成功页底部
         * apStartTime : /Date(1567267200000)/
         * apEndTime : /Date(1598889600000)/
         * apStatus : 1
         * apPV : 0
         * apAdContent : https://mp.yiyepay.cn/jkpaymp//upfiles/images/success1.png,https://mp.yiyepay.cn/jkpaymp//upfiles/images/success2.png,https://mp.yiyepay.cn/jkpaymp//upfiles/images/success3.png
         */

        private int id;
        private String apTitle;
        private String apStartTime;
        private String apEndTime;
        private int apStatus;
        private int apPV;
        private String apAdContent;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getApTitle() {
            return apTitle;
        }

        public void setApTitle(String apTitle) {
            this.apTitle = apTitle;
        }

        public String getApStartTime() {
            return apStartTime;
        }

        public void setApStartTime(String apStartTime) {
            this.apStartTime = apStartTime;
        }

        public String getApEndTime() {
            return apEndTime;
        }

        public void setApEndTime(String apEndTime) {
            this.apEndTime = apEndTime;
        }

        public int getApStatus() {
            return apStatus;
        }

        public void setApStatus(int apStatus) {
            this.apStatus = apStatus;
        }

        public int getApPV() {
            return apPV;
        }

        public void setApPV(int apPV) {
            this.apPV = apPV;
        }

        public String getApAdContent() {
            return apAdContent;
        }

        public void setApAdContent(String apAdContent) {
            this.apAdContent = apAdContent;
        }
    }
}
