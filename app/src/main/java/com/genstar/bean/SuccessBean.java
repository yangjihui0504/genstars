package com.genstar.bean;

import java.util.List;

public class SuccessBean {

    /**
     * status : SUCCESS
     * errcode : 0
     * errmsg : ok
     * order : {"Id":32,"OrderNum":"K1C05407E486A45AD2","MerchantId":2,"TradeTime":"/Date(1568027225000)/","Amount":0.01,"UndiscountAmount":0,"Discount":0,"ActualCharge":0.01,"FlowNum":"4200000393201909090375053840","Status":1,"StatusDesc":"OK","PaymodeId":13,"ParentPaymodeId":2,"CashierId":1,"CustomerId":"okRNwuMhLOOYvtR9nLwpmq-hX6QA","CustomerName":"","AgentId":1,"TermimalId":0,"TerminalSN":"","TerminalCateId":null,"ShopId":1,"Remark":"刷卡支付-微信支付","ApiVersion":null,"CreateTime":"/Date(1568027225000)/","UpdateTime":"/Date(1568027227000)/","SourceOrderNum":null,"OrdersType":1,"IsNeedManualCancel":0,"OrdersSource":5,"WxId":0}
     * weixin : {"WxId":1,"UnionWxId":0,"MerchantId":2,"type":0,"Status":13,"MicroName":"一叶知付","ServiceStartTime":"/Date(1564588800000)/","ServiceEndTime":"/Date(4720262400000)/","MicroCode":"","AppId":"wx6329468685b67b0b","AppSecret":"9fc68d010af0a16717f045d887c1a71d","AppEncodingAESKey":"","AppAccessToken":"25_lJernfhbi9MzwSTK2kqeziXpnNDkdju3pkavA4t3xfzjaM2PULlpYKJOpd_zeWYUqt30dr9gbriLgWPt64GH7c5zRwk_BBmg2yZhYeUXfe6Su4vruIxt82WC1WsW72z_E0wI5sr6a-CsOofnDGKiAHDYBF","AppRefreshToken":"refreshtoken@@@vRz-et2Rmy5BvTsh_12V252Eif-0XmKS4m7ML9uESVw","WxAdvancedAPI":1,"GetLastDate":"/Date(1568022484000)/","MicroPicture":"http://wx.qlogo.cn/mmopen/G1vK91Xdmvy5Xh3f9NldBsB0Sda2ncWWZoEdibGCQs4tljZpqKwmHLHAqTXBbPbYsQSUg4tX5cZJw1vvCJeOF7gdIaTibDgNTn/0","OriginalID":"gh_00a24f3391d6","MpName":"","MpPassword":"","MicroQrCode":"/UpLoad/WZZ_Load/images/201908/8a407437c292e49af47c4a8961bdd0d1.PNG","Jsapi_ticket":"","GetJsapiTime":"/Date(-62135596800000)/","CertificationExpiredTime":"/Date(-62135596800000)/","Card_api_ticket":"E0o2-at6NcC2OsJiQTlwlCwzzB1knsxRIdyMN46m6FtafD2np4xxn1er5DngTrBK3Adg_XePFmTzlaeg_2H17w","Card_api_ticket_get_time":"/Date(1568026536000)/","HasGprsPrint":0,"GprsPrintParams":"","GprsPintNum":1}
     * CouponList : [{"Id":11333,"CardId":"pkRNwuBT5EcnItujvMGX0pg6lpwE","Wxid":1,"MerchantId":2,"CardType":"折扣券","CardStatus":"CARD_STATUS_VERIFY_OK","CardNumber":111,"Discount":1,"Reduce_money":0,"Least_money_to_use":0,"Max_increase_bonus":0,"Title":"满100给您打9.9折","Brand_name":"一叶知付","Logo":"http://mmbiz.qpic.cn/mmbiz_jpg/6jaF7RLfXicsh4XhXHpkxpOBibpXsroJcrKgwoYKdiaEibBBw7tJZaKQCCr4EZcXERZSmuTs8gj5SObUTmXqJ58u5Q/0?wx_fmt=jpeg","Total_quantity":111,"Date_type":"DATE_TYPE_FIX_TERM","BeginTime":"/Date(0)/","EndTime":"/Date(0)/","Fixed_term":30,"Fixed_begin_term":0,"CardJson":"{\"timestamp\":\"1568027229\",\"nonce_str\":\"4198049918267376\",\"signature\":\"54e567517f701d495e747a4c618d6369790abd5d\",\"outer_str\":\"4198049918267376\"}","CreateTime":"/Date(1568026093000)/","QrcodeUrl":null,"QrCodeExprieTime":"/Date(-62135596800000)/","Tuijian":0,"ShopIds":null,"ActivateUserForm":null},{"Id":11332,"CardId":"pkRNwuGPqYFA4sH953aKpclm2Rf4","Wxid":1,"MerchantId":2,"CardType":"礼品券","CardStatus":"CARD_STATUS_VERIFY_OK","CardNumber":11,"Discount":0,"Reduce_money":0,"Least_money_to_use":0,"Max_increase_bonus":0,"Title":"兑换礼物","Brand_name":"一叶知付","Logo":"http://mmbiz.qpic.cn/mmbiz_jpg/6jaF7RLfXicsh4XhXHpkxpOBibpXsroJcrKgwoYKdiaEibBBw7tJZaKQCCr4EZcXERZSmuTs8gj5SObUTmXqJ58u5Q/0?wx_fmt=jpeg","Total_quantity":11,"Date_type":"DATE_TYPE_FIX_TERM","BeginTime":"/Date(0)/","EndTime":"/Date(0)/","Fixed_term":30,"Fixed_begin_term":0,"CardJson":"{\"timestamp\":\"1568027229\",\"nonce_str\":\"4198049918267376\",\"signature\":\"a861f78753b448ff0d7555ca9696cdee6df95ec3\",\"outer_str\":\"4198049918267376\"}","CreateTime":"/Date(1568021342000)/","QrcodeUrl":null,"QrCodeExprieTime":"/Date(-62135596800000)/","Tuijian":0,"ShopIds":null,"ActivateUserForm":null},{"Id":11331,"CardId":"pkRNwuGo_yNz6DJFgwDD0sKmpr4o","Wxid":1,"MerchantId":2,"CardType":"折扣券","CardStatus":"CARD_STATUS_VERIFY_OK","CardNumber":11,"Discount":1,"Reduce_money":0,"Least_money_to_use":0,"Max_increase_bonus":0,"Title":"满100打9.9折","Brand_name":"一叶知付","Logo":"http://mmbiz.qpic.cn/mmbiz_jpg/6jaF7RLfXicsh4XhXHpkxpOBibpXsroJcrKgwoYKdiaEibBBw7tJZaKQCCr4EZcXERZSmuTs8gj5SObUTmXqJ58u5Q/0?wx_fmt=jpeg","Total_quantity":11,"Date_type":"DATE_TYPE_FIX_TERM","BeginTime":"/Date(0)/","EndTime":"/Date(0)/","Fixed_term":30,"Fixed_begin_term":0,"CardJson":"{\"timestamp\":\"1568027229\",\"nonce_str\":\"4198049918267376\",\"signature\":\"bc74b6ed8eadad28fa5b447dffa43640bb8d3e18\",\"outer_str\":\"4198049918267376\"}","CreateTime":"/Date(1568020406000)/","QrcodeUrl":null,"QrCodeExprieTime":"/Date(-62135596800000)/","Tuijian":0,"ShopIds":null,"ActivateUserForm":null},{"Id":3,"CardId":"pkRNwuHq8ISJrc_f9gMPs6XSATGY","Wxid":1,"MerchantId":2,"CardType":"代金券","CardStatus":"CARD_STATUS_VERIFY_OK","CardNumber":989,"Discount":0,"Reduce_money":9999,"Least_money_to_use":10000,"Max_increase_bonus":0,"Title":"满100减99.99代金券","Brand_name":"一叶知付","Logo":"http://mmbiz.qpic.cn/mmbiz_jpg/6jaF7RLfXicsh4XhXHpkxpOBibpXsroJcrKgwoYKdiaEibBBw7tJZaKQCCr4EZcXERZSmuTs8gj5SObUTmXqJ58u5Q/0?wx_fmt=jpeg","Total_quantity":999,"Date_type":"DATE_TYPE_FIX_TERM","BeginTime":"/Date(0)/","EndTime":"/Date(1576800000000)/","Fixed_term":30,"Fixed_begin_term":0,"CardJson":"{\"timestamp\":\"1568027229\",\"nonce_str\":\"4198049918267376\",\"signature\":\"5e980c73b232f1329a48adb8b189a3757e4ffcdf\",\"outer_str\":\"4198049918267376\"}","CreateTime":"/Date(1565751533000)/","QrcodeUrl":"//mp.yiyepay.cn/jkpaymp/CvUploads/2/1/images/qrcode/pkRNwuHq8ISJrc_f9gMPs6XSATGY_满100减99.99代金券.jpg","QrCodeExprieTime":"/Date(1597287544000)/","Tuijian":0,"ShopIds":"1","ActivateUserForm":null}]
     * MemberCard : {"Id":11320,"CardId":"p_gKd5pmECz-Mws2DQH9vodZYeJI","Wxid":1,"MerchantId":698,"CardType":"MEMBER_CARD","CardStatus":"CARD_STATUS_VERIFY_OK","CardNumber":100,"Discount":0,"Reduce_money":0,"Least_money_to_use":0,"Max_increase_bonus":0,"Title":"普卡","Brand_name":"杭州启博科技","Logo":"http://mmbiz.qpic.cn/mmbiz_png/iafb73yRWQzSXg3luFjvQwZhE4MwqfzGTWDQqKz5qCicNsYHMt1BMBE6cKoN23DPwgqhviaRXO5jFS6XrzX9wno2g/0?wx_fmt=png","Total_quantity":100,"Date_type":"DATE_TYPE_FIX_TIME_RANGE","BeginTime":"/Date(1560441600000)/","EndTime":"/Date(1592150399000)/","Fixed_term":0,"Fixed_begin_term":0,"CardJson":"{\"card\":{\"card_type\":\"MEMBER_CARD\",\"general_coupon\":null,\"groupon\":null,\"gift\":null,\"cash\":null,\"discount\":null,\"member_card\":{\"supply_bonus\":true,\"supply_balance\":false,\"bonus_cleared\":null,\"bonus_rules\":null,\"balance_rules\":null,\"prerogative\":\"100积分可兑换精美牙签一根\",\"bind_old_card_url\":null,\"activate_url\":null,\"background_pic_url\":\"http://mmbiz.qpic.cn/mmbiz_png/iafb73yRWQzSXg3luFjvQwZhE4MwqfzGTm6HgyZIFxsFgyYibVuCx9piaSM2oRyo44RyicHNvB4BsBib9WIvt4Dhr6g/0?wx_fmt=png\",\"wx_activate\":true,\"auto_activate\":false,\"custom_field1\":null,\"custom_field2\":null,\"custom_field3\":null,\"custom_cell1\":null,\"bonus_rule\":{\"cost_money_unit\":10000,\"increase_bonus\":1,\"max_increase_bonus\":0,\"init_increase_bonus\":100,\"cost_bonus_unit\":100,\"reduce_money\":100,\"least_money_to_use_bonus\":10000,\"max_reduce_bonus\":100},\"discount\":2,\"base_info\":{\"id\":\"p_gKd5pmECz-Mws2DQH9vodZYeJI\",\"status\":\"CARD_STATUS_VERIFY_OK\",\"sub_merchant_info\":null,\"logo_url\":\"http://mmbiz.qpic.cn/mmbiz_png/iafb73yRWQzSXg3luFjvQwZhE4MwqfzGTWDQqKz5qCicNsYHMt1BMBE6cKoN23DPwgqhviaRXO5jFS6XrzX9wno2g/0?wx_fmt=png\",\"code_type\":2,\"brand_name\":\"杭州启博科技\",\"title\":\"普卡\",\"sub_title\":null,\"color\":\"#63b359\",\"notice\":\"刷我滴卡\",\"service_phone\":\"0577－－56001524\",\"source\":null,\"description\":\"次卡优惠太大，请谨慎使用！\",\"use_limit\":0,\"get_limit\":1,\"use_custom_code\":false,\"bind_openid\":false,\"can_share\":true,\"can_give_friend\":false,\"location_id_list\":[],\"date_info\":{\"type\":\"DATE_TYPE_FIX_TIME_RANGE\",\"begin_timestamp\":1560441600,\"end_timestamp\":1592150399,\"fixed_term\":0,\"fixed_begin_term\":0},\"sku\":{\"quantity\":100,\"total_quantity\":100},\"url_name_type\":0,\"custom_url\":null,\"custom_url_name\":\"点这里\",\"custom_url_sub_title\":\"看这里\",\"promotion_url_name\":\"就是这里\",\"promotion_url\":null,\"promotion_url_sub_title\":\"快点这里\",\"modify_msg_operation\":null,\"use_all_locations\":true,\"need_push_on_view\":false,\"pay_info\":{\"swipe_card\":{\"is_swipe_card\":true}}}},\"scenic_ticket\":null,\"movie_ticket\":null,\"boarding_pass\":null,\"lucky_money\":null,\"meeting_ticket\":null},\"errcode\":0,\"ErrorCodeValue\":0,\"errmsg\":\"ok\",\"P2PData\":null}","CreateTime":"/Date(1560476033000)/","QrcodeUrl":null,"QrCodeExprieTime":"/Date(-62135596800000)/","Tuijian":0,"ShopIds":null,"ActivateUserForm":null}
     */

    private String status;
    private int errcode;
    private String errmsg;
    private OrderBean order;
    private WeixinBean weixin;
    private MemberCardBean MemberCard;
    private List<CouponListBean> CouponList;

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

    public OrderBean getOrder() {
        return order;
    }

    public void setOrder(OrderBean order) {
        this.order = order;
    }

    public WeixinBean getWeixin() {
        return weixin;
    }

    public void setWeixin(WeixinBean weixin) {
        this.weixin = weixin;
    }

    public MemberCardBean getMemberCard() {
        return MemberCard;
    }

    public void setMemberCard(MemberCardBean MemberCard) {
        this.MemberCard = MemberCard;
    }

    public List<CouponListBean> getCouponList() {
        return CouponList;
    }

    public void setCouponList(List<CouponListBean> CouponList) {
        this.CouponList = CouponList;
    }

    public static class OrderBean {
        /**
         * Id : 32
         * OrderNum : K1C05407E486A45AD2
         * MerchantId : 2
         * TradeTime : /Date(1568027225000)/
         * Amount : 0.01
         * UndiscountAmount : 0
         * Discount : 0
         * ActualCharge : 0.01
         * FlowNum : 4200000393201909090375053840
         * Status : 1
         * StatusDesc : OK
         * PaymodeId : 13
         * ParentPaymodeId : 2
         * CashierId : 1
         * CustomerId : okRNwuMhLOOYvtR9nLwpmq-hX6QA
         * CustomerName :
         * AgentId : 1
         * TermimalId : 0
         * TerminalSN :
         * TerminalCateId : null
         * ShopId : 1
         * Remark : 刷卡支付-微信支付
         * ApiVersion : null
         * CreateTime : /Date(1568027225000)/
         * UpdateTime : /Date(1568027227000)/
         * SourceOrderNum : null
         * OrdersType : 1
         * IsNeedManualCancel : 0
         * OrdersSource : 5
         * WxId : 0
         */

        private int Id;
        private String OrderNum;
        private int MerchantId;
        private String TradeTime;
        private double Amount;
        private double UndiscountAmount;
        private int Discount;
        private double ActualCharge;
        private String FlowNum;
        private int Status;
        private String StatusDesc;
        private int PaymodeId;
        private int ParentPaymodeId;
        private int CashierId;
        private String CustomerId;
        private String CustomerName;
        private int AgentId;
        private int TermimalId;
        private String TerminalSN;
        private Object TerminalCateId;
        private int ShopId;
        private String Remark;
        private Object ApiVersion;
        private String CreateTime;
        private String UpdateTime;
        private Object SourceOrderNum;
        private int OrdersType;
        private int IsNeedManualCancel;
        private int OrdersSource;
        private int WxId;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getOrderNum() {
            return OrderNum;
        }

        public void setOrderNum(String OrderNum) {
            this.OrderNum = OrderNum;
        }

        public int getMerchantId() {
            return MerchantId;
        }

        public void setMerchantId(int MerchantId) {
            this.MerchantId = MerchantId;
        }

        public String getTradeTime() {
            return TradeTime;
        }

        public void setTradeTime(String TradeTime) {
            this.TradeTime = TradeTime;
        }

        public double getAmount() {
            return Amount;
        }

        public void setAmount(double Amount) {
            this.Amount = Amount;
        }

        public double getUndiscountAmount() {
            return UndiscountAmount;
        }

        public void setUndiscountAmount(double UndiscountAmount) {
            this.UndiscountAmount = UndiscountAmount;
        }

        public int getDiscount() {
            return Discount;
        }

        public void setDiscount(int Discount) {
            this.Discount = Discount;
        }

        public double getActualCharge() {
            return ActualCharge;
        }

        public void setActualCharge(double ActualCharge) {
            this.ActualCharge = ActualCharge;
        }

        public String getFlowNum() {
            return FlowNum;
        }

        public void setFlowNum(String FlowNum) {
            this.FlowNum = FlowNum;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public String getStatusDesc() {
            return StatusDesc;
        }

        public void setStatusDesc(String StatusDesc) {
            this.StatusDesc = StatusDesc;
        }

        public int getPaymodeId() {
            return PaymodeId;
        }

        public void setPaymodeId(int PaymodeId) {
            this.PaymodeId = PaymodeId;
        }

        public int getParentPaymodeId() {
            return ParentPaymodeId;
        }

        public void setParentPaymodeId(int ParentPaymodeId) {
            this.ParentPaymodeId = ParentPaymodeId;
        }

        public int getCashierId() {
            return CashierId;
        }

        public void setCashierId(int CashierId) {
            this.CashierId = CashierId;
        }

        public String getCustomerId() {
            return CustomerId;
        }

        public void setCustomerId(String CustomerId) {
            this.CustomerId = CustomerId;
        }

        public String getCustomerName() {
            return CustomerName;
        }

        public void setCustomerName(String CustomerName) {
            this.CustomerName = CustomerName;
        }

        public int getAgentId() {
            return AgentId;
        }

        public void setAgentId(int AgentId) {
            this.AgentId = AgentId;
        }

        public int getTermimalId() {
            return TermimalId;
        }

        public void setTermimalId(int TermimalId) {
            this.TermimalId = TermimalId;
        }

        public String getTerminalSN() {
            return TerminalSN;
        }

        public void setTerminalSN(String TerminalSN) {
            this.TerminalSN = TerminalSN;
        }

        public Object getTerminalCateId() {
            return TerminalCateId;
        }

        public void setTerminalCateId(Object TerminalCateId) {
            this.TerminalCateId = TerminalCateId;
        }

        public int getShopId() {
            return ShopId;
        }

        public void setShopId(int ShopId) {
            this.ShopId = ShopId;
        }

        public String getRemark() {
            return Remark;
        }

        public void setRemark(String Remark) {
            this.Remark = Remark;
        }

        public Object getApiVersion() {
            return ApiVersion;
        }

        public void setApiVersion(Object ApiVersion) {
            this.ApiVersion = ApiVersion;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public String getUpdateTime() {
            return UpdateTime;
        }

        public void setUpdateTime(String UpdateTime) {
            this.UpdateTime = UpdateTime;
        }

        public Object getSourceOrderNum() {
            return SourceOrderNum;
        }

        public void setSourceOrderNum(Object SourceOrderNum) {
            this.SourceOrderNum = SourceOrderNum;
        }

        public int getOrdersType() {
            return OrdersType;
        }

        public void setOrdersType(int OrdersType) {
            this.OrdersType = OrdersType;
        }

        public int getIsNeedManualCancel() {
            return IsNeedManualCancel;
        }

        public void setIsNeedManualCancel(int IsNeedManualCancel) {
            this.IsNeedManualCancel = IsNeedManualCancel;
        }

        public int getOrdersSource() {
            return OrdersSource;
        }

        public void setOrdersSource(int OrdersSource) {
            this.OrdersSource = OrdersSource;
        }

        public int getWxId() {
            return WxId;
        }

        public void setWxId(int WxId) {
            this.WxId = WxId;
        }
    }

    public static class WeixinBean {
        /**
         * WxId : 1
         * UnionWxId : 0
         * MerchantId : 2
         * type : 0
         * Status : 13
         * MicroName : 一叶知付
         * ServiceStartTime : /Date(1564588800000)/
         * ServiceEndTime : /Date(4720262400000)/
         * MicroCode :
         * AppId : wx6329468685b67b0b
         * AppSecret : 9fc68d010af0a16717f045d887c1a71d
         * AppEncodingAESKey :
         * AppAccessToken : 25_lJernfhbi9MzwSTK2kqeziXpnNDkdju3pkavA4t3xfzjaM2PULlpYKJOpd_zeWYUqt30dr9gbriLgWPt64GH7c5zRwk_BBmg2yZhYeUXfe6Su4vruIxt82WC1WsW72z_E0wI5sr6a-CsOofnDGKiAHDYBF
         * AppRefreshToken : refreshtoken@@@vRz-et2Rmy5BvTsh_12V252Eif-0XmKS4m7ML9uESVw
         * WxAdvancedAPI : 1
         * GetLastDate : /Date(1568022484000)/
         * MicroPicture : http://wx.qlogo.cn/mmopen/G1vK91Xdmvy5Xh3f9NldBsB0Sda2ncWWZoEdibGCQs4tljZpqKwmHLHAqTXBbPbYsQSUg4tX5cZJw1vvCJeOF7gdIaTibDgNTn/0
         * OriginalID : gh_00a24f3391d6
         * MpName :
         * MpPassword :
         * MicroQrCode : /UpLoad/WZZ_Load/images/201908/8a407437c292e49af47c4a8961bdd0d1.PNG
         * Jsapi_ticket :
         * GetJsapiTime : /Date(-62135596800000)/
         * CertificationExpiredTime : /Date(-62135596800000)/
         * Card_api_ticket : E0o2-at6NcC2OsJiQTlwlCwzzB1knsxRIdyMN46m6FtafD2np4xxn1er5DngTrBK3Adg_XePFmTzlaeg_2H17w
         * Card_api_ticket_get_time : /Date(1568026536000)/
         * HasGprsPrint : 0
         * GprsPrintParams :
         * GprsPintNum : 1
         */

        private int WxId;
        private int UnionWxId;
        private int MerchantId;
        private int type;
        private int Status;
        private String MicroName;
        private String ServiceStartTime;
        private String ServiceEndTime;
        private String MicroCode;
        private String AppId;
        private String AppSecret;
        private String AppEncodingAESKey;
        private String AppAccessToken;
        private String AppRefreshToken;
        private int WxAdvancedAPI;
        private String GetLastDate;
        private String MicroPicture;
        private String OriginalID;
        private String MpName;
        private String MpPassword;
        private String MicroQrCode;
        private String Jsapi_ticket;
        private String GetJsapiTime;
        private String CertificationExpiredTime;
        private String Card_api_ticket;
        private String Card_api_ticket_get_time;
        private int HasGprsPrint;
        private String GprsPrintParams;
        private int GprsPintNum;

        public int getWxId() {
            return WxId;
        }

        public void setWxId(int WxId) {
            this.WxId = WxId;
        }

        public int getUnionWxId() {
            return UnionWxId;
        }

        public void setUnionWxId(int UnionWxId) {
            this.UnionWxId = UnionWxId;
        }

        public int getMerchantId() {
            return MerchantId;
        }

        public void setMerchantId(int MerchantId) {
            this.MerchantId = MerchantId;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public String getMicroName() {
            return MicroName;
        }

        public void setMicroName(String MicroName) {
            this.MicroName = MicroName;
        }

        public String getServiceStartTime() {
            return ServiceStartTime;
        }

        public void setServiceStartTime(String ServiceStartTime) {
            this.ServiceStartTime = ServiceStartTime;
        }

        public String getServiceEndTime() {
            return ServiceEndTime;
        }

        public void setServiceEndTime(String ServiceEndTime) {
            this.ServiceEndTime = ServiceEndTime;
        }

        public String getMicroCode() {
            return MicroCode;
        }

        public void setMicroCode(String MicroCode) {
            this.MicroCode = MicroCode;
        }

        public String getAppId() {
            return AppId;
        }

        public void setAppId(String AppId) {
            this.AppId = AppId;
        }

        public String getAppSecret() {
            return AppSecret;
        }

        public void setAppSecret(String AppSecret) {
            this.AppSecret = AppSecret;
        }

        public String getAppEncodingAESKey() {
            return AppEncodingAESKey;
        }

        public void setAppEncodingAESKey(String AppEncodingAESKey) {
            this.AppEncodingAESKey = AppEncodingAESKey;
        }

        public String getAppAccessToken() {
            return AppAccessToken;
        }

        public void setAppAccessToken(String AppAccessToken) {
            this.AppAccessToken = AppAccessToken;
        }

        public String getAppRefreshToken() {
            return AppRefreshToken;
        }

        public void setAppRefreshToken(String AppRefreshToken) {
            this.AppRefreshToken = AppRefreshToken;
        }

        public int getWxAdvancedAPI() {
            return WxAdvancedAPI;
        }

        public void setWxAdvancedAPI(int WxAdvancedAPI) {
            this.WxAdvancedAPI = WxAdvancedAPI;
        }

        public String getGetLastDate() {
            return GetLastDate;
        }

        public void setGetLastDate(String GetLastDate) {
            this.GetLastDate = GetLastDate;
        }

        public String getMicroPicture() {
            return MicroPicture;
        }

        public void setMicroPicture(String MicroPicture) {
            this.MicroPicture = MicroPicture;
        }

        public String getOriginalID() {
            return OriginalID;
        }

        public void setOriginalID(String OriginalID) {
            this.OriginalID = OriginalID;
        }

        public String getMpName() {
            return MpName;
        }

        public void setMpName(String MpName) {
            this.MpName = MpName;
        }

        public String getMpPassword() {
            return MpPassword;
        }

        public void setMpPassword(String MpPassword) {
            this.MpPassword = MpPassword;
        }

        public String getMicroQrCode() {
            return MicroQrCode;
        }

        public void setMicroQrCode(String MicroQrCode) {
            this.MicroQrCode = MicroQrCode;
        }

        public String getJsapi_ticket() {
            return Jsapi_ticket;
        }

        public void setJsapi_ticket(String Jsapi_ticket) {
            this.Jsapi_ticket = Jsapi_ticket;
        }

        public String getGetJsapiTime() {
            return GetJsapiTime;
        }

        public void setGetJsapiTime(String GetJsapiTime) {
            this.GetJsapiTime = GetJsapiTime;
        }

        public String getCertificationExpiredTime() {
            return CertificationExpiredTime;
        }

        public void setCertificationExpiredTime(String CertificationExpiredTime) {
            this.CertificationExpiredTime = CertificationExpiredTime;
        }

        public String getCard_api_ticket() {
            return Card_api_ticket;
        }

        public void setCard_api_ticket(String Card_api_ticket) {
            this.Card_api_ticket = Card_api_ticket;
        }

        public String getCard_api_ticket_get_time() {
            return Card_api_ticket_get_time;
        }

        public void setCard_api_ticket_get_time(String Card_api_ticket_get_time) {
            this.Card_api_ticket_get_time = Card_api_ticket_get_time;
        }

        public int getHasGprsPrint() {
            return HasGprsPrint;
        }

        public void setHasGprsPrint(int HasGprsPrint) {
            this.HasGprsPrint = HasGprsPrint;
        }

        public String getGprsPrintParams() {
            return GprsPrintParams;
        }

        public void setGprsPrintParams(String GprsPrintParams) {
            this.GprsPrintParams = GprsPrintParams;
        }

        public int getGprsPintNum() {
            return GprsPintNum;
        }

        public void setGprsPintNum(int GprsPintNum) {
            this.GprsPintNum = GprsPintNum;
        }
    }

    public static class MemberCardBean {
        /**
         * Id : 11320
         * CardId : p_gKd5pmECz-Mws2DQH9vodZYeJI
         * Wxid : 1
         * MerchantId : 698
         * CardType : MEMBER_CARD
         * CardStatus : CARD_STATUS_VERIFY_OK
         * CardNumber : 100
         * Discount : 0
         * Reduce_money : 0
         * Least_money_to_use : 0
         * Max_increase_bonus : 0
         * Title : 普卡
         * Brand_name : 杭州启博科技
         * Logo : http://mmbiz.qpic.cn/mmbiz_png/iafb73yRWQzSXg3luFjvQwZhE4MwqfzGTWDQqKz5qCicNsYHMt1BMBE6cKoN23DPwgqhviaRXO5jFS6XrzX9wno2g/0?wx_fmt=png
         * Total_quantity : 100
         * Date_type : DATE_TYPE_FIX_TIME_RANGE
         * BeginTime : /Date(1560441600000)/
         * EndTime : /Date(1592150399000)/
         * Fixed_term : 0
         * Fixed_begin_term : 0
         * CardJson : {"card":{"card_type":"MEMBER_CARD","general_coupon":null,"groupon":null,"gift":null,"cash":null,"discount":null,"member_card":{"supply_bonus":true,"supply_balance":false,"bonus_cleared":null,"bonus_rules":null,"balance_rules":null,"prerogative":"100积分可兑换精美牙签一根","bind_old_card_url":null,"activate_url":null,"background_pic_url":"http://mmbiz.qpic.cn/mmbiz_png/iafb73yRWQzSXg3luFjvQwZhE4MwqfzGTm6HgyZIFxsFgyYibVuCx9piaSM2oRyo44RyicHNvB4BsBib9WIvt4Dhr6g/0?wx_fmt=png","wx_activate":true,"auto_activate":false,"custom_field1":null,"custom_field2":null,"custom_field3":null,"custom_cell1":null,"bonus_rule":{"cost_money_unit":10000,"increase_bonus":1,"max_increase_bonus":0,"init_increase_bonus":100,"cost_bonus_unit":100,"reduce_money":100,"least_money_to_use_bonus":10000,"max_reduce_bonus":100},"discount":2,"base_info":{"id":"p_gKd5pmECz-Mws2DQH9vodZYeJI","status":"CARD_STATUS_VERIFY_OK","sub_merchant_info":null,"logo_url":"http://mmbiz.qpic.cn/mmbiz_png/iafb73yRWQzSXg3luFjvQwZhE4MwqfzGTWDQqKz5qCicNsYHMt1BMBE6cKoN23DPwgqhviaRXO5jFS6XrzX9wno2g/0?wx_fmt=png","code_type":2,"brand_name":"杭州启博科技","title":"普卡","sub_title":null,"color":"#63b359","notice":"刷我滴卡","service_phone":"0577－－56001524","source":null,"description":"次卡优惠太大，请谨慎使用！","use_limit":0,"get_limit":1,"use_custom_code":false,"bind_openid":false,"can_share":true,"can_give_friend":false,"location_id_list":[],"date_info":{"type":"DATE_TYPE_FIX_TIME_RANGE","begin_timestamp":1560441600,"end_timestamp":1592150399,"fixed_term":0,"fixed_begin_term":0},"sku":{"quantity":100,"total_quantity":100},"url_name_type":0,"custom_url":null,"custom_url_name":"点这里","custom_url_sub_title":"看这里","promotion_url_name":"就是这里","promotion_url":null,"promotion_url_sub_title":"快点这里","modify_msg_operation":null,"use_all_locations":true,"need_push_on_view":false,"pay_info":{"swipe_card":{"is_swipe_card":true}}}},"scenic_ticket":null,"movie_ticket":null,"boarding_pass":null,"lucky_money":null,"meeting_ticket":null},"errcode":0,"ErrorCodeValue":0,"errmsg":"ok","P2PData":null}
         * CreateTime : /Date(1560476033000)/
         * QrcodeUrl : null
         * QrCodeExprieTime : /Date(-62135596800000)/
         * Tuijian : 0
         * ShopIds : null
         * ActivateUserForm : null
         */

        private int Id;
        private String CardId;
        private int Wxid;
        private int MerchantId;
        private String CardType;
        private String CardStatus;
        private int CardNumber;
        private int Discount;
        private int Reduce_money;
        private int Least_money_to_use;
        private int Max_increase_bonus;
        private String Title;
        private String Brand_name;
        private String Logo;
        private int Total_quantity;
        private String Date_type;
        private String BeginTime;
        private String EndTime;
        private int Fixed_term;
        private int Fixed_begin_term;
        private String CardJson;
        private String CreateTime;
        private Object QrcodeUrl;
        private String QrCodeExprieTime;
        private int Tuijian;
        private Object ShopIds;
        private Object ActivateUserForm;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getCardId() {
            return CardId;
        }

        public void setCardId(String CardId) {
            this.CardId = CardId;
        }

        public int getWxid() {
            return Wxid;
        }

        public void setWxid(int Wxid) {
            this.Wxid = Wxid;
        }

        public int getMerchantId() {
            return MerchantId;
        }

        public void setMerchantId(int MerchantId) {
            this.MerchantId = MerchantId;
        }

        public String getCardType() {
            return CardType;
        }

        public void setCardType(String CardType) {
            this.CardType = CardType;
        }

        public String getCardStatus() {
            return CardStatus;
        }

        public void setCardStatus(String CardStatus) {
            this.CardStatus = CardStatus;
        }

        public int getCardNumber() {
            return CardNumber;
        }

        public void setCardNumber(int CardNumber) {
            this.CardNumber = CardNumber;
        }

        public int getDiscount() {
            return Discount;
        }

        public void setDiscount(int Discount) {
            this.Discount = Discount;
        }

        public int getReduce_money() {
            return Reduce_money;
        }

        public void setReduce_money(int Reduce_money) {
            this.Reduce_money = Reduce_money;
        }

        public int getLeast_money_to_use() {
            return Least_money_to_use;
        }

        public void setLeast_money_to_use(int Least_money_to_use) {
            this.Least_money_to_use = Least_money_to_use;
        }

        public int getMax_increase_bonus() {
            return Max_increase_bonus;
        }

        public void setMax_increase_bonus(int Max_increase_bonus) {
            this.Max_increase_bonus = Max_increase_bonus;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public String getBrand_name() {
            return Brand_name;
        }

        public void setBrand_name(String Brand_name) {
            this.Brand_name = Brand_name;
        }

        public String getLogo() {
            return Logo;
        }

        public void setLogo(String Logo) {
            this.Logo = Logo;
        }

        public int getTotal_quantity() {
            return Total_quantity;
        }

        public void setTotal_quantity(int Total_quantity) {
            this.Total_quantity = Total_quantity;
        }

        public String getDate_type() {
            return Date_type;
        }

        public void setDate_type(String Date_type) {
            this.Date_type = Date_type;
        }

        public String getBeginTime() {
            return BeginTime;
        }

        public void setBeginTime(String BeginTime) {
            this.BeginTime = BeginTime;
        }

        public String getEndTime() {
            return EndTime;
        }

        public void setEndTime(String EndTime) {
            this.EndTime = EndTime;
        }

        public int getFixed_term() {
            return Fixed_term;
        }

        public void setFixed_term(int Fixed_term) {
            this.Fixed_term = Fixed_term;
        }

        public int getFixed_begin_term() {
            return Fixed_begin_term;
        }

        public void setFixed_begin_term(int Fixed_begin_term) {
            this.Fixed_begin_term = Fixed_begin_term;
        }

        public String getCardJson() {
            return CardJson;
        }

        public void setCardJson(String CardJson) {
            this.CardJson = CardJson;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public Object getQrcodeUrl() {
            return QrcodeUrl;
        }

        public void setQrcodeUrl(Object QrcodeUrl) {
            this.QrcodeUrl = QrcodeUrl;
        }

        public String getQrCodeExprieTime() {
            return QrCodeExprieTime;
        }

        public void setQrCodeExprieTime(String QrCodeExprieTime) {
            this.QrCodeExprieTime = QrCodeExprieTime;
        }

        public int getTuijian() {
            return Tuijian;
        }

        public void setTuijian(int Tuijian) {
            this.Tuijian = Tuijian;
        }

        public Object getShopIds() {
            return ShopIds;
        }

        public void setShopIds(Object ShopIds) {
            this.ShopIds = ShopIds;
        }

        public Object getActivateUserForm() {
            return ActivateUserForm;
        }

        public void setActivateUserForm(Object ActivateUserForm) {
            this.ActivateUserForm = ActivateUserForm;
        }
    }

    public static class CouponListBean {
        /**
         * Id : 11333
         * CardId : pkRNwuBT5EcnItujvMGX0pg6lpwE
         * Wxid : 1
         * MerchantId : 2
         * CardType : 折扣券
         * CardStatus : CARD_STATUS_VERIFY_OK
         * CardNumber : 111
         * Discount : 1
         * Reduce_money : 0
         * Least_money_to_use : 0
         * Max_increase_bonus : 0
         * Title : 满100给您打9.9折
         * Brand_name : 一叶知付
         * Logo : http://mmbiz.qpic.cn/mmbiz_jpg/6jaF7RLfXicsh4XhXHpkxpOBibpXsroJcrKgwoYKdiaEibBBw7tJZaKQCCr4EZcXERZSmuTs8gj5SObUTmXqJ58u5Q/0?wx_fmt=jpeg
         * Total_quantity : 111
         * Date_type : DATE_TYPE_FIX_TERM
         * BeginTime : /Date(0)/
         * EndTime : /Date(0)/
         * Fixed_term : 30
         * Fixed_begin_term : 0
         * CardJson : {"timestamp":"1568027229","nonce_str":"4198049918267376","signature":"54e567517f701d495e747a4c618d6369790abd5d","outer_str":"4198049918267376"}
         * CreateTime : /Date(1568026093000)/
         * QrcodeUrl : null
         * QrCodeExprieTime : /Date(-62135596800000)/
         * Tuijian : 0
         * ShopIds : null
         * ActivateUserForm : null
         */

        private int Id;
        private String CardId;
        private int Wxid;
        private int MerchantId;
        private String CardType;
        private String CardStatus;
        private int CardNumber;
        private int Discount;
        private int Reduce_money;
        private int Least_money_to_use;
        private int Max_increase_bonus;
        private String Title;
        private String Brand_name;
        private String Logo;
        private int Total_quantity;
        private String Date_type;
        private String BeginTime;
        private String EndTime;
        private int Fixed_term;
        private int Fixed_begin_term;
        private String CardJson;
        private String CreateTime;
        private Object QrcodeUrl;
        private String QrCodeExprieTime;
        private int Tuijian;
        private Object ShopIds;
        private Object ActivateUserForm;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getCardId() {
            return CardId;
        }

        public void setCardId(String CardId) {
            this.CardId = CardId;
        }

        public int getWxid() {
            return Wxid;
        }

        public void setWxid(int Wxid) {
            this.Wxid = Wxid;
        }

        public int getMerchantId() {
            return MerchantId;
        }

        public void setMerchantId(int MerchantId) {
            this.MerchantId = MerchantId;
        }

        public String getCardType() {
            return CardType;
        }

        public void setCardType(String CardType) {
            this.CardType = CardType;
        }

        public String getCardStatus() {
            return CardStatus;
        }

        public void setCardStatus(String CardStatus) {
            this.CardStatus = CardStatus;
        }

        public int getCardNumber() {
            return CardNumber;
        }

        public void setCardNumber(int CardNumber) {
            this.CardNumber = CardNumber;
        }

        public int getDiscount() {
            return Discount;
        }

        public void setDiscount(int Discount) {
            this.Discount = Discount;
        }

        public int getReduce_money() {
            return Reduce_money;
        }

        public void setReduce_money(int Reduce_money) {
            this.Reduce_money = Reduce_money;
        }

        public int getLeast_money_to_use() {
            return Least_money_to_use;
        }

        public void setLeast_money_to_use(int Least_money_to_use) {
            this.Least_money_to_use = Least_money_to_use;
        }

        public int getMax_increase_bonus() {
            return Max_increase_bonus;
        }

        public void setMax_increase_bonus(int Max_increase_bonus) {
            this.Max_increase_bonus = Max_increase_bonus;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public String getBrand_name() {
            return Brand_name;
        }

        public void setBrand_name(String Brand_name) {
            this.Brand_name = Brand_name;
        }

        public String getLogo() {
            return Logo;
        }

        public void setLogo(String Logo) {
            this.Logo = Logo;
        }

        public int getTotal_quantity() {
            return Total_quantity;
        }

        public void setTotal_quantity(int Total_quantity) {
            this.Total_quantity = Total_quantity;
        }

        public String getDate_type() {
            return Date_type;
        }

        public void setDate_type(String Date_type) {
            this.Date_type = Date_type;
        }

        public String getBeginTime() {
            return BeginTime;
        }

        public void setBeginTime(String BeginTime) {
            this.BeginTime = BeginTime;
        }

        public String getEndTime() {
            return EndTime;
        }

        public void setEndTime(String EndTime) {
            this.EndTime = EndTime;
        }

        public int getFixed_term() {
            return Fixed_term;
        }

        public void setFixed_term(int Fixed_term) {
            this.Fixed_term = Fixed_term;
        }

        public int getFixed_begin_term() {
            return Fixed_begin_term;
        }

        public void setFixed_begin_term(int Fixed_begin_term) {
            this.Fixed_begin_term = Fixed_begin_term;
        }

        public String getCardJson() {
            return CardJson;
        }

        public void setCardJson(String CardJson) {
            this.CardJson = CardJson;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }

        public Object getQrcodeUrl() {
            return QrcodeUrl;
        }

        public void setQrcodeUrl(Object QrcodeUrl) {
            this.QrcodeUrl = QrcodeUrl;
        }

        public String getQrCodeExprieTime() {
            return QrCodeExprieTime;
        }

        public void setQrCodeExprieTime(String QrCodeExprieTime) {
            this.QrCodeExprieTime = QrCodeExprieTime;
        }

        public int getTuijian() {
            return Tuijian;
        }

        public void setTuijian(int Tuijian) {
            this.Tuijian = Tuijian;
        }

        public Object getShopIds() {
            return ShopIds;
        }

        public void setShopIds(Object ShopIds) {
            this.ShopIds = ShopIds;
        }

        public Object getActivateUserForm() {
            return ActivateUserForm;
        }

        public void setActivateUserForm(Object ActivateUserForm) {
            this.ActivateUserForm = ActivateUserForm;
        }
    }
}
