package com.genstar.bean;

import java.util.List;

public class LoginBean {


    /**
     * appid : wx6329468685b67b0b
     * mch_id : 1545746591
     * sub_mch_id : 1549238351
     * shoplogo : //mp.yiyepay.cn/jkpaymp/CvUploads/2/upload/images/201908/D56F182CAAF49193A4E720C4B330A92F.png
     * id : 1
     * name : 收银
     * phone : 15000000000
     * mid : 2
     * sid : 1
     * ismanager : true
     * jobnum : 42012001
     * MerchantName : null
     * ShopName : 一叶知付
     * issuper : true
     * ShopList : [{"Id":1,"MerchantId":2,"ShopName":"一叶知付","ShopSubName":null,"ProvinceId":12,"CityId":122,"CountyId":1301,"Creator":2,"CreateTime":"/Date(1568098881000)/","Status":15,"Contact":"单金杰","Phone":"17816754005","Telephone":null,"Address":"四季青街道越秀维多利中心A座10楼","OpeningTime":"/Date(1568077200000)/","ClosingTime":"/Date(1568109600000)/","Remark":null,"csmShopId":"0","WxId":1,"Images":"//mp.yiyepay.cn/jkpaymp/CvUploads/2/upload/images/201908/D56F182CAAF49193A4E720C4B330A92F.png,//mp.q11.shop/jkpaymp/CvUploads/700/upload/images/201903/C0E4B19A32D9C16E31D3DC51617E9D65.png,//mp.q11.shop/jkpaymp/CvUploads/700/upload/images/201903/C0E4B19A32D9C16E31D3DC51617E9D65.png,//mp.q11.shop/jkpaymp/CvUploads/700/upload/images/201903/C0E4B19A32D9C16E31D3DC51617E9D65.png","class_id":20,"trading_area_id":0,"local_image":"//mp.yiyepay.cn/jkpaymp/CvUploads/2/upload/images/201908/D56F182CAAF49193A4E720C4B330A92F.png","label":"一叶知付","is_recommend":1,"logo":"//mp.yiyepay.cn/jkpaymp/CvUploads/2/upload/images/201908/D56F182CAAF49193A4E720C4B330A92F.png","strategy":null,"discount_info":"本周中秋优惠"}]
     * status : SUCCESS
     * errmsg :
     */

    private String appid;
    private String mch_id;
    private String sub_mch_id;
    private String shoplogo;
    private int id;
    private String name;
    private String phone;
    private int mid;
    private int sid;
    private boolean ismanager;
    private String jobnum;
    private String MerchantName;
    private String ShopName;
    private boolean issuper;
    private String status;
    private String errmsg;
    private List<ShopListBean> ShopList;

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

    public String getShoplogo() {
        return shoplogo;
    }

    public void setShoplogo(String shoplogo) {
        this.shoplogo = shoplogo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public boolean isIsmanager() {
        return ismanager;
    }

    public void setIsmanager(boolean ismanager) {
        this.ismanager = ismanager;
    }

    public String getJobnum() {
        return jobnum;
    }

    public void setJobnum(String jobnum) {
        this.jobnum = jobnum;
    }

    public String getMerchantName() {
        return MerchantName;
    }

    public void setMerchantName(String MerchantName) {
        this.MerchantName = MerchantName;
    }

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String ShopName) {
        this.ShopName = ShopName;
    }

    public boolean isIssuper() {
        return issuper;
    }

    public void setIssuper(boolean issuper) {
        this.issuper = issuper;
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

    public List<ShopListBean> getShopList() {
        return ShopList;
    }

    public void setShopList(List<ShopListBean> ShopList) {
        this.ShopList = ShopList;
    }

    public static class ShopListBean {
        /**
         * Id : 1
         * MerchantId : 2
         * ShopName : 一叶知付
         * ShopSubName : null
         * ProvinceId : 12
         * CityId : 122
         * CountyId : 1301
         * Creator : 2
         * CreateTime : /Date(1568098881000)/
         * Status : 15
         * Contact : 单金杰
         * Phone : 17816754005
         * Telephone : null
         * Address : 四季青街道越秀维多利中心A座10楼
         * OpeningTime : /Date(1568077200000)/
         * ClosingTime : /Date(1568109600000)/
         * Remark : null
         * csmShopId : 0
         * WxId : 1
         * Images : //mp.yiyepay.cn/jkpaymp/CvUploads/2/upload/images/201908/D56F182CAAF49193A4E720C4B330A92F.png,//mp.q11.shop/jkpaymp/CvUploads/700/upload/images/201903/C0E4B19A32D9C16E31D3DC51617E9D65.png,//mp.q11.shop/jkpaymp/CvUploads/700/upload/images/201903/C0E4B19A32D9C16E31D3DC51617E9D65.png,//mp.q11.shop/jkpaymp/CvUploads/700/upload/images/201903/C0E4B19A32D9C16E31D3DC51617E9D65.png
         * class_id : 20
         * trading_area_id : 0
         * local_image : //mp.yiyepay.cn/jkpaymp/CvUploads/2/upload/images/201908/D56F182CAAF49193A4E720C4B330A92F.png
         * label : 一叶知付
         * is_recommend : 1
         * logo : //mp.yiyepay.cn/jkpaymp/CvUploads/2/upload/images/201908/D56F182CAAF49193A4E720C4B330A92F.png
         * strategy : null
         * discount_info : 本周中秋优惠
         */

        private int Id;
        private int MerchantId;
        private String ShopName;
        private Object ShopSubName;
        private int ProvinceId;
        private int CityId;
        private int CountyId;
        private int Creator;
        private String CreateTime;
        private int Status;
        private String Contact;
        private String Phone;
        private Object Telephone;
        private String Address;
        private String OpeningTime;
        private String ClosingTime;
        private Object Remark;
        private String csmShopId;
        private int WxId;
        private String Images;
        private int class_id;
        private int trading_area_id;
        private String local_image;
        private String label;
        private int is_recommend;
        private String logo;
        private Object strategy;
        private String discount_info;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public int getMerchantId() {
            return MerchantId;
        }

        public void setMerchantId(int MerchantId) {
            this.MerchantId = MerchantId;
        }

        public String getShopName() {
            return ShopName;
        }

        public void setShopName(String ShopName) {
            this.ShopName = ShopName;
        }

        public Object getShopSubName() {
            return ShopSubName;
        }

        public void setShopSubName(Object ShopSubName) {
            this.ShopSubName = ShopSubName;
        }

        public int getProvinceId() {
            return ProvinceId;
        }

        public void setProvinceId(int ProvinceId) {
            this.ProvinceId = ProvinceId;
        }

        public int getCityId() {
            return CityId;
        }

        public void setCityId(int CityId) {
            this.CityId = CityId;
        }

        public int getCountyId() {
            return CountyId;
        }

        public void setCountyId(int CountyId) {
            this.CountyId = CountyId;
        }

        public int getCreator() {
            return Creator;
        }

        public void setCreator(int Creator) {
            this.Creator = Creator;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public String getContact() {
            return Contact;
        }

        public void setContact(String Contact) {
            this.Contact = Contact;
        }

        public String getPhone() {
            return Phone;
        }

        public void setPhone(String Phone) {
            this.Phone = Phone;
        }

        public Object getTelephone() {
            return Telephone;
        }

        public void setTelephone(Object Telephone) {
            this.Telephone = Telephone;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String Address) {
            this.Address = Address;
        }

        public String getOpeningTime() {
            return OpeningTime;
        }

        public void setOpeningTime(String OpeningTime) {
            this.OpeningTime = OpeningTime;
        }

        public String getClosingTime() {
            return ClosingTime;
        }

        public void setClosingTime(String ClosingTime) {
            this.ClosingTime = ClosingTime;
        }

        public Object getRemark() {
            return Remark;
        }

        public void setRemark(Object Remark) {
            this.Remark = Remark;
        }

        public String getCsmShopId() {
            return csmShopId;
        }

        public void setCsmShopId(String csmShopId) {
            this.csmShopId = csmShopId;
        }

        public int getWxId() {
            return WxId;
        }

        public void setWxId(int WxId) {
            this.WxId = WxId;
        }

        public String getImages() {
            return Images;
        }

        public void setImages(String Images) {
            this.Images = Images;
        }

        public int getClass_id() {
            return class_id;
        }

        public void setClass_id(int class_id) {
            this.class_id = class_id;
        }

        public int getTrading_area_id() {
            return trading_area_id;
        }

        public void setTrading_area_id(int trading_area_id) {
            this.trading_area_id = trading_area_id;
        }

        public String getLocal_image() {
            return local_image;
        }

        public void setLocal_image(String local_image) {
            this.local_image = local_image;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public int getIs_recommend() {
            return is_recommend;
        }

        public void setIs_recommend(int is_recommend) {
            this.is_recommend = is_recommend;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public Object getStrategy() {
            return strategy;
        }

        public void setStrategy(Object strategy) {
            this.strategy = strategy;
        }

        public String getDiscount_info() {
            return discount_info;
        }

        public void setDiscount_info(String discount_info) {
            this.discount_info = discount_info;
        }
    }
}
