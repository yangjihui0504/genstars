package com.genstar.bean;

public class SuccessMemberBean {

    /**
     * status : SUCCESS
     * errcode : 0
     * errmsg : ok
     * user : {"UserId":46,"WxId":1,"MerchantId":2,"Status":3,"OpenID":"okRNwuMhLOOYvtR9nLwpmq-hX6QA","UnionID":"o6Z0oxJKPBQfhSxpeEAtrVJXNp_g","Source":0,"CreateTime":"/Date(1568165513000)/","SubscribeTime":"/Date(1568165513000)/","CancelTime":"/Date(-62135596800000)/","MemberTime":"/Date(1568173623000)/","LastTime":"/Date(1568173667000)/","UserGroup":"0","UserPoint":0,"CardBalance":10000,"NickName":".Y.","RealName":"杨继辉","Sex":1,"Phone":"17839233546","HeadImg":"http://thirdwx.qlogo.cn/mmopen/ajNVdqHZLLCH7qCXGx3dTbMAsaAYW3jnvVGkyhmsRfdunqichkVujRqbhbSFZoBk5DEibe4UMaKzzs1YpsHkecKtxJNMZ9zzn9EZ6kF6hglia8/0","Birthday":"/Date(767980800000)/","Country":"中国","Province":"河南","City":"商丘","Area":null,"CardNumber":"640382259820","CardLeveL":1,"Memo":"","IDCard":"","wxAdminId":0,"wxGps":"","ParentUserId":0,"Email":null,"Address":null,"OrderNum":0,"OrderFee":0,"OrderTime":"/Date(-62135596800000)/","OrderDiscount":0,"Tags":null,"Industry":null,"Salary":null,"Education":null,"CardGivingMoney":0}
     */

    private String status;
    private int errcode;
    private String errmsg;
    private UserBean user;

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

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * UserId : 46
         * WxId : 1
         * MerchantId : 2
         * Status : 3
         * OpenID : okRNwuMhLOOYvtR9nLwpmq-hX6QA
         * UnionID : o6Z0oxJKPBQfhSxpeEAtrVJXNp_g
         * Source : 0
         * CreateTime : /Date(1568165513000)/
         * SubscribeTime : /Date(1568165513000)/
         * CancelTime : /Date(-62135596800000)/
         * MemberTime : /Date(1568173623000)/
         * LastTime : /Date(1568173667000)/
         * UserGroup : 0
         * UserPoint : 0
         * CardBalance : 10000
         * NickName : .Y.
         * RealName : 杨继辉
         * Sex : 1
         * Phone : 17839233546
         * HeadImg : http://thirdwx.qlogo.cn/mmopen/ajNVdqHZLLCH7qCXGx3dTbMAsaAYW3jnvVGkyhmsRfdunqichkVujRqbhbSFZoBk5DEibe4UMaKzzs1YpsHkecKtxJNMZ9zzn9EZ6kF6hglia8/0
         * Birthday : /Date(767980800000)/
         * Country : 中国
         * Province : 河南
         * City : 商丘
         * Area : null
         * CardNumber : 640382259820
         * CardLeveL : 1
         * Memo :
         * IDCard :
         * wxAdminId : 0
         * wxGps :
         * ParentUserId : 0
         * Email : null
         * Address : null
         * OrderNum : 0
         * OrderFee : 0
         * OrderTime : /Date(-62135596800000)/
         * OrderDiscount : 0
         * Tags : null
         * Industry : null
         * Salary : null
         * Education : null
         * CardGivingMoney : 0
         */

        private int UserId;
        private int WxId;
        private int MerchantId;
        private int Status;
        private String OpenID;
        private String UnionID;
        private int Source;
        private String CreateTime;
        private String SubscribeTime;
        private String CancelTime;
        private String MemberTime;
        private String LastTime;
        private String UserGroup;
        private int UserPoint;
        private double CardBalance;
        private String NickName;
        private String RealName;
        private int Sex;
        private String Phone;
        private String HeadImg;
        private String Birthday;
        private String Country;
        private String Province;
        private String City;
        private Object Area;
        private String CardNumber;
        private int CardLeveL;
        private String Memo;
        private String IDCard;
        private int wxAdminId;
        private String wxGps;
        private int ParentUserId;
        private Object Email;
        private Object Address;
        private int OrderNum;
        private double OrderFee;
        private String OrderTime;
        private double OrderDiscount;
        private Object Tags;
        private Object Industry;
        private Object Salary;
        private Object Education;
        private int CardGivingMoney;

        public int getUserId() {
            return UserId;
        }

        public void setUserId(int UserId) {
            this.UserId = UserId;
        }

        public int getWxId() {
            return WxId;
        }

        public void setWxId(int WxId) {
            this.WxId = WxId;
        }

        public int getMerchantId() {
            return MerchantId;
        }

        public void setMerchantId(int MerchantId) {
            this.MerchantId = MerchantId;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public String getOpenID() {
            return OpenID;
        }

        public void setOpenID(String OpenID) {
            this.OpenID = OpenID;
        }

        public String getUnionID() {
            return UnionID;
        }

        public void setUnionID(String UnionID) {
            this.UnionID = UnionID;
        }

        public int getSource() {
            return Source;
        }

        public void setSource(int Source) {
            this.Source = Source;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public String getSubscribeTime() {
            return SubscribeTime;
        }

        public void setSubscribeTime(String SubscribeTime) {
            this.SubscribeTime = SubscribeTime;
        }

        public String getCancelTime() {
            return CancelTime;
        }

        public void setCancelTime(String CancelTime) {
            this.CancelTime = CancelTime;
        }

        public String getMemberTime() {
            return MemberTime;
        }

        public void setMemberTime(String MemberTime) {
            this.MemberTime = MemberTime;
        }

        public String getLastTime() {
            return LastTime;
        }

        public void setLastTime(String LastTime) {
            this.LastTime = LastTime;
        }

        public String getUserGroup() {
            return UserGroup;
        }

        public void setUserGroup(String UserGroup) {
            this.UserGroup = UserGroup;
        }

        public int getUserPoint() {
            return UserPoint;
        }

        public void setUserPoint(int UserPoint) {
            this.UserPoint = UserPoint;
        }

        public double getCardBalance() {
            return CardBalance;
        }

        public void setCardBalance(double CardBalance) {
            this.CardBalance = CardBalance;
        }

        public String getNickName() {
            return NickName;
        }

        public void setNickName(String NickName) {
            this.NickName = NickName;
        }

        public String getRealName() {
            return RealName;
        }

        public void setRealName(String RealName) {
            this.RealName = RealName;
        }

        public int getSex() {
            return Sex;
        }

        public void setSex(int Sex) {
            this.Sex = Sex;
        }

        public String getPhone() {
            return Phone;
        }

        public void setPhone(String Phone) {
            this.Phone = Phone;
        }

        public String getHeadImg() {
            return HeadImg;
        }

        public void setHeadImg(String HeadImg) {
            this.HeadImg = HeadImg;
        }

        public String getBirthday() {
            return Birthday;
        }

        public void setBirthday(String Birthday) {
            this.Birthday = Birthday;
        }

        public String getCountry() {
            return Country;
        }

        public void setCountry(String Country) {
            this.Country = Country;
        }

        public String getProvince() {
            return Province;
        }

        public void setProvince(String Province) {
            this.Province = Province;
        }

        public String getCity() {
            return City;
        }

        public void setCity(String City) {
            this.City = City;
        }

        public Object getArea() {
            return Area;
        }

        public void setArea(Object Area) {
            this.Area = Area;
        }

        public String getCardNumber() {
            return CardNumber;
        }

        public void setCardNumber(String CardNumber) {
            this.CardNumber = CardNumber;
        }

        public int getCardLeveL() {
            return CardLeveL;
        }

        public void setCardLeveL(int CardLeveL) {
            this.CardLeveL = CardLeveL;
        }

        public String getMemo() {
            return Memo;
        }

        public void setMemo(String Memo) {
            this.Memo = Memo;
        }

        public String getIDCard() {
            return IDCard;
        }

        public void setIDCard(String IDCard) {
            this.IDCard = IDCard;
        }

        public int getWxAdminId() {
            return wxAdminId;
        }

        public void setWxAdminId(int wxAdminId) {
            this.wxAdminId = wxAdminId;
        }

        public String getWxGps() {
            return wxGps;
        }

        public void setWxGps(String wxGps) {
            this.wxGps = wxGps;
        }

        public int getParentUserId() {
            return ParentUserId;
        }

        public void setParentUserId(int ParentUserId) {
            this.ParentUserId = ParentUserId;
        }

        public Object getEmail() {
            return Email;
        }

        public void setEmail(Object Email) {
            this.Email = Email;
        }

        public Object getAddress() {
            return Address;
        }

        public void setAddress(Object Address) {
            this.Address = Address;
        }

        public int getOrderNum() {
            return OrderNum;
        }

        public void setOrderNum(int OrderNum) {
            this.OrderNum = OrderNum;
        }

        public double getOrderFee() {
            return OrderFee;
        }

        public void setOrderFee(double OrderFee) {
            this.OrderFee = OrderFee;
        }

        public String getOrderTime() {
            return OrderTime;
        }

        public void setOrderTime(String OrderTime) {
            this.OrderTime = OrderTime;
        }

        public double getOrderDiscount() {
            return OrderDiscount;
        }

        public void setOrderDiscount(double OrderDiscount) {
            this.OrderDiscount = OrderDiscount;
        }

        public Object getTags() {
            return Tags;
        }

        public void setTags(Object Tags) {
            this.Tags = Tags;
        }

        public Object getIndustry() {
            return Industry;
        }

        public void setIndustry(Object Industry) {
            this.Industry = Industry;
        }

        public Object getSalary() {
            return Salary;
        }

        public void setSalary(Object Salary) {
            this.Salary = Salary;
        }

        public Object getEducation() {
            return Education;
        }

        public void setEducation(Object Education) {
            this.Education = Education;
        }

        public int getCardGivingMoney() {
            return CardGivingMoney;
        }

        public void setCardGivingMoney(int CardGivingMoney) {
            this.CardGivingMoney = CardGivingMoney;
        }
    }
}
