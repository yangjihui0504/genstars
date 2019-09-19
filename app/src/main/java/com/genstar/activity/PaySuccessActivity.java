package com.genstar.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.genstar.R;
import com.genstar.adapter.AdplanAdapter;
import com.genstar.adapter.DiscountAdapter;
import com.genstar.adapter.MLinerLayout;
import com.genstar.base.BaseActivity;
import com.genstar.bean.AdplanBean;
import com.genstar.bean.LoginBean;
import com.genstar.bean.SuccessBean;
import com.genstar.utils.TimeUtils;
import com.genstar.utils.http.ActionHelper;
import com.genstar.utils.http.PropertiesUtils;
import com.genstar.utils.http.TextCallback;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PaySuccessActivity extends BaseActivity {

    @BindView(R.id.iv_shop_icon)
    ImageView ivShopIcon;
    @BindView(R.id.rv_discount)
    RecyclerView rvDiscount;
    @BindView(R.id.tv_actual_charge)
    TextView tvActualCharge;
    @BindView(R.id.tv_discount)
    TextView tvDiscount;
    @BindView(R.id.tv_paymode)
    TextView tvPaymode;
    @BindView(R.id.tv_shop_name)
    TextView tvShopName;
    @BindView(R.id.rv_adplan)
    RecyclerView rvAdplan;
    private String orderNum;
    private DiscountAdapter discountAdapter;
    private SuccessBean successBean;
    private AdplanAdapter adplanAdapter;
    private List<String> strsToList1;

    public static void open(Context context, Intent extras) {
        Intent intent = new Intent();
        intent.setClass(context, PaySuccessActivity.class);
        if (extras != null) {
            intent.putExtras(extras);
        }
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        ButterKnife.bind(this);
        initData();
        initListener();
    }

    private void initListener() {

    }

    private void initData() {
        Intent intent = getIntent();
        orderNum = intent.getStringExtra("OrderNum");
        ActionHelper.WxFacePaySuccess(mActivity, orderNum, new TextCallback(mActivity) {

            @Override
            public void onSuccessed(String json) throws JSONException {
                successBean = new Gson().fromJson(json, SuccessBean.class);
                setData();
            }

            @Override
            public void onErrored(String errmsg) {

            }
        });

        String nowTime = TimeUtils.getNowTime();
        ActionHelper.getadplan(mActivity, nowTime, new TextCallback(mActivity) {

            @Override
            public void onSuccessed(String json) throws JSONException {
                AdplanBean adplanBean = new Gson().fromJson(json, AdplanBean.class);
                String apAdContent = adplanBean.getList().getApAdContent();
                String[] split = apAdContent.split(",");
                strsToList1 = Arrays.asList(split);
                setRecyclerView2();
                setListData2();
            }

            @Override
            public void onErrored(String errmsg) {

            }
        });

    }

    private void setData() {
        setTitle();
        setRecyclerView();
        setListData();
    }

    private void setTitle() {
        SuccessBean.OrderBean order = successBean.getOrder();
        int parentPaymodeId = order.getParentPaymodeId();
        if (parentPaymodeId == 1) {
            //1代表支付宝  2代表微信
            tvPaymode.setText("支付宝支付");
        } else {
            tvPaymode.setText("微信支付");
        }

        tvActualCharge.setText("￥" + order.getActualCharge());
        tvDiscount.setText("￥" + order.getDiscount());

        //通过截取动态获取请求头是http还是https
        String url = PropertiesUtils.getProjectConfig().getProperty("api.host");
        String substring = url.substring(0, url.indexOf(":") + 1);

        //商店信息在登陆时就保存在sp中
        String ShopList = spInsance.getString("ShopList", "");
        Gson gson = new Gson();
        Type listType = new TypeToken<List<LoginBean.ShopListBean>>() {
        }.getType();
        List<LoginBean.ShopListBean> shopListBeanList = gson.fromJson(ShopList, listType);
        if (shopListBeanList.size() > 0) {
            LoginBean.ShopListBean shopListBean = shopListBeanList.get(0);
            String images = shopListBean.getImages();
            Glide.with(mActivity).load(substring + images)
                    .apply(new RequestOptions()
                            .placeholder(R.mipmap.icon_bg)
                            .centerCrop()
                    ).into(ivShopIcon);
            tvShopName.setText(shopListBean.getShopName());
        }

    }

    private void setRecyclerView() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mActivity);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvDiscount.setLayoutManager(linearLayoutManager);
        discountAdapter = new DiscountAdapter();
        rvDiscount.setAdapter(discountAdapter);
    }

    private void setRecyclerView2() {
        MLinerLayout linearLayoutManager = new MLinerLayout(mActivity);
        linearLayoutManager.setCanScroll(false);
        rvAdplan.setLayoutManager(linearLayoutManager);
        adplanAdapter = new AdplanAdapter(mActivity);
        rvAdplan.setAdapter(adplanAdapter);
    }

    private void setListData() {
        discountAdapter.replaceData(successBean.getCouponList());
    }

    private void setListData2() {
        adplanAdapter.replaceData(strsToList1);
    }
}
