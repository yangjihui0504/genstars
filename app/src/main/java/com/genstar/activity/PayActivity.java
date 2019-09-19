package com.genstar.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.SPUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.genstar.R;
import com.genstar.base.BaseActivity;
import com.genstar.base.Constant;
import com.genstar.bean.MemberCardBean;
import com.genstar.bean.OrdernumBean;
import com.genstar.bean.SuccessCouponBean;
import com.genstar.bean.SuccessMemberBean;
import com.genstar.listener.BaseResultLitener;
import com.genstar.utils.SignUtils;
import com.genstar.utils.SpeechUtil;
import com.genstar.utils.TimeUtils;
import com.genstar.utils.WXUtils;
import com.genstar.utils.http.ActionHelper;
import com.genstar.utils.http.PropertiesUtils;
import com.genstar.utils.http.TextCallback;
import com.google.gson.Gson;

import org.json.JSONException;

import java.math.BigDecimal;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PayActivity extends BaseActivity {
    @BindView(R.id.iv_shop_icon)
    ImageView ivShopIcon;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_shop_name)
    TextView tvShopName;
    @BindView(R.id.tv_shop_address)
    TextView tvShopAddress;
    @BindView(R.id.btn_settlement)
    Button btnSettlement;
    @BindView(R.id.tv_amount)
    TextView tvAmount;
    @BindView(R.id.tv_balance)
    TextView tvBalance;
    @BindView(R.id.tv_discount_left)
    TextView tvDiscountLeft;
    @BindView(R.id.tv_discount)
    TextView tvDiscount;
    @BindView(R.id.tv_actual_charge)
    TextView tvActualCharge;
    @BindView(R.id.rv_discount)
    RelativeLayout rvDiscount;
    @BindView(R.id.tv_fanjifen)
    TextView tvFanjifen;
    @BindView(R.id.rl_fanjifen)
    RelativeLayout rlFanjifen;
    //输入金额
    private String money;
    private String openid;
    private String nickname;
    private String tvActualChargeMoney;
    //积分对应抵现金额
    private double tvDisCountMoney = 0;
    private int coupon_id;
    private boolean ishaveCoupon;
    private boolean isFanjifen;
    private boolean ishaveDixian;
    private double fanjifenMoney;
    private SuccessMemberBean.UserBean user;
    private int dixianPoint;

    public static void open(Context context, Intent extras) {
        Intent intent = new Intent();
        intent.setClass(context, PayActivity.class);
        if (extras != null) {
            intent.putExtras(extras);
        }
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        ButterKnife.bind(this);
        initData();
        initListener();
    }

    private void initData() {
        Intent intent = getIntent();
        money = intent.getStringExtra("money");
        openid = intent.getStringExtra("openid");
        nickname = intent.getStringExtra("nickname");
        setTitle();

        setData();

        stopWX();
    }

    private void stopWX() {
        WXUtils.stopWX();
    }

    private void setData() {
        ActionHelper.GetUserByOpenId(mActivity, openid, nickname, new TextCallback(mActivity) {
            @Override
            public void onSuccessed(String json) throws JSONException {
                SuccessMemberBean successMemberBean = new Gson().fromJson(json, SuccessMemberBean.class);
                user = successMemberBean.getUser();
                double cardBalance = user.getCardBalance();
                tvBalance.setText("余额￥" + cardBalance);
                ActionHelper.getcoupon(mActivity, money, 0 + "", openid, new TextCallback(mActivity) {
                    @Override
                    public void onSuccessed(String json) throws JSONException {
                        setText(cardBalance ,json);
                    }

                    @Override
                    public void onErrored(String errmsg) {

                    }
                });
            }

            @Override
            public void onErrored(String errmsg) {

            }
        });


    }

    private void setText(double cardBalance ,String json) {
        SuccessCouponBean successCouponBean = new Gson().fromJson(json, SuccessCouponBean.class);
        //卡券id
        coupon_id = successCouponBean.getCoupon_id();
        if (successCouponBean.getTotal() == 0) {
            ishaveCoupon = false;
            rvDiscount.setVisibility(View.GONE);
            tvActualChargeMoney = money;
        } else {
            ishaveCoupon = true;
            rvDiscount.setVisibility(View.VISIBLE);
            String couponType = successCouponBean.getCoupon_type();
            double iMoney = Double.parseDouble(money);
            if (!TextUtils.isEmpty(couponType) && !successCouponBean.isDixian()) {
                //是卡券优惠
                if ("DISCOUNT".equals(couponType)) {
                    // 打折券
                    couponType = "打折券";
                } else if ("CASH".equals(couponType)) {
                    //代金券
                    couponType = "代金券";
                }

                tvDiscount.setText("-￥" + successCouponBean.getCoupon_money());
                double coupon_least_money = successCouponBean.getCoupon_least_money();
                if (iMoney > coupon_least_money) {
                    tvDisCountMoney = successCouponBean.getCoupon_money();
                } else {
                    tvDisCountMoney = 0;
                }

            } else if (successCouponBean.isDixian()) {
                ishaveDixian = true;
                //积分抵现
                couponType = "积分抵现";
                if (user != null) {
                    dixianPoint = user.getUserPoint();
                    double v = dixianPoint * successCouponBean.getDixian_price1();
                    //保留两位小数 ， 因为不需要四舍五入， 这里减去0.005
                    String dixianMoney = String.format("%.2f", v - 0.005);

                    double DoubleDixianMoney = Double.parseDouble(dixianMoney);
                    if (DoubleDixianMoney < successCouponBean.getDixian_price2()) {
                        tvDisCountMoney = DoubleDixianMoney;
                    } else {
                        tvDisCountMoney = successCouponBean.getDixian_price2();
                        dixianPoint = (int) (tvDisCountMoney / successCouponBean.getDixian_price1());
                    }
                }
            } else {
                //啥都不是
                rvDiscount.setVisibility(View.GONE);
            }
            tvDiscountLeft.setText(couponType);

            if (tvDisCountMoney > 0) {
                tvDiscount.setText("-￥" + tvDisCountMoney);
                tvActualChargeMoney = (iMoney - tvDisCountMoney) + "";

            } else {
                tvDiscount.setText("-￥0.00");
                tvActualChargeMoney = money;
            }


        }
        tvActualCharge.setText(tvActualChargeMoney);

        //是否返积分
        if (successCouponBean.isFanjifen()) {
            isFanjifen = true;
            rlFanjifen.setVisibility(View.VISIBLE);
            double fanjifenPrice = successCouponBean.getFanjifen_price();
            double fanjifenMax = successCouponBean.getFanjifen_max();
            //取整数 ，不四舍五入
            double floor = Math.floor(fanjifenPrice);
            fanjifenMoney = 0;
            if (fanjifenMax > floor) {
                fanjifenMoney = floor;
            } else {
                fanjifenMoney = fanjifenMax;
            }
            tvFanjifen.setText(fanjifenMoney + "");

        } else {
            isFanjifen = false;
            rlFanjifen.setVisibility(View.GONE);
        }

        setButtonText(cardBalance , tvActualChargeMoney);
    }

    private void setButtonText(double cardBalance, String tvActualChargeMoney) {
        Double dTvActualChargeMoney = Double.parseDouble(tvActualChargeMoney);
        if (cardBalance>=dTvActualChargeMoney){
            btnSettlement.setText("确认支付");
        }else{
            btnSettlement.setText("余额不足去刷脸支付");
        }
    }

    private void setTitle() {
        //通过截取动态获取请求头是http还是https
        String url = PropertiesUtils.getProjectConfig().getProperty("api.host");
        String substring = url.substring(0, url.indexOf(":") + 1);
        //商店信息在登陆时就保存在sp中
        String shoplogo = spInsance.getString("shoplogo", "");
        String ShopName = spInsance.getString("ShopName", "");
        Glide.with(mActivity).load(substring + shoplogo)
                .apply(new RequestOptions()
                        .placeholder(R.mipmap.icon_bg)
                        .centerCrop()
                ).into(ivShopIcon);
        tvShopName.setText(ShopName);
        tvShopAddress.setText(ShopName);
        tvAmount.setText("￥" + money);

    }

    private void initListener() {
        ivBack.setOnClickListener(this::setListener);
        btnSettlement.setOnClickListener(this::setListener);
    }

    private void setListener(View view) {
        if (view == ivBack) {
            finish();
        } else if (view == btnSettlement) {
            if (btnSettlement.getText().equals("确认支付")){
                gotoPay();
            }else {
                pay();
            }

        }
    }

    private void pay() {
        BigDecimal minMoney = new BigDecimal(money);
        String smoney = minMoney.multiply(new BigDecimal("100")).setScale(0, BigDecimal.ROUND_HALF_UP).toString();
        //获取订单号
        ActionHelper.CreateOrderNumber(mActivity, spInsance.getInt("mid") + "", new TextCallback(mActivity) {
            @Override
            public void onSuccessed(String json) throws JSONException {
                OrdernumBean ordernumBean = new Gson().fromJson(json, OrdernumBean.class);
                //开启刷脸
                ActionHelper.ScanPayTypes(mActivity, ordernumBean.getOrdernum(), smoney, new BaseResultLitener() {
                    @Override
                    public void sucess(String serverRetData, String openid) {
                        SpeechUtil.openAudioFile(mSpeech, "支付成功,支付" + money+"元");
                        finish();
                    }

                    @Override
                    public void fail(String errMsg) {
                        SpeechUtil.openAudioFile(mSpeech, "支付失败" + errMsg);
                    }
                });
            }

            @Override
            public void onErrored(String errmsg) {
                SpeechUtil.openAudioFile(mSpeech, "支付失败" + errmsg);
            }
        });
    }

    private void gotoPay() {
        SPUtils spInsance = SPUtils.getInstance();
        int mid = spInsance.getInt("mid");
        int sid = spInsance.getInt("sid");
        String time = TimeUtils.dateToStamp();
        String paymode = "membercardpay";
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.clear();
        hashMap.put("merchid", mid + "");
        hashMap.put("paymode", paymode);
        hashMap.put("timestamp", time);
        hashMap.put("shopid", sid + "");
        String sign = SignUtils.sign(hashMap, Constant.MD5_KEY);
        //是否有卡券优惠
        String couponid = "";
        if (ishaveCoupon) {
            couponid = coupon_id + "";
        }

        //是否用积分抵扣
        String point = "";
        String pointMoney = "";
        if (ishaveDixian) {
            point = dixianPoint + "";
            pointMoney = tvDisCountMoney + "";
        }

        String DiscoutMoney = "";
        if (tvDisCountMoney > 0) {
            DiscoutMoney = tvDisCountMoney + "";
        }

        String getPoint = "";
        if (isFanjifen) {
            getPoint = fanjifenMoney + "";
        }

        ActionHelper.MemberCardPay(mActivity, money, openid, mid + "", sid + "", sign, paymode, time,
                tvDisCountMoney + "", tvActualChargeMoney, couponid, point, pointMoney, DiscoutMoney, getPoint, new TextCallback(mActivity) {
                    @Override
                    public void onSuccessed(String json) throws JSONException {
                        MemberCardBean memberCardBean = new Gson().fromJson(json, MemberCardBean.class);
                        String orderNum = memberCardBean.getOrderNum();

                        showSuccess(orderNum);
                    }

                    @Override
                    public void onErrored(String errmsg) {

                    }
                });
    }

    private void showSuccess(String didanhao) {
        Intent intent = new Intent();
        intent.putExtra("OrderNum", didanhao);
        PaySuccessActivity.open(mActivity, intent);
        finish();
    }
}
