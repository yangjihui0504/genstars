package com.genstar.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.genstar.R;
import com.genstar.bean.SuccessBean;
import com.genstar.utils.Arith;

public class DiscountAdapter extends BaseQuickAdapter<SuccessBean.CouponListBean, BaseViewHolder> {
    public DiscountAdapter() {
        super(R.layout.adapter_discount);
    }

    @Override
    protected void convert(BaseViewHolder helper, SuccessBean.CouponListBean item) {
        String cardType = item.getCardType();
        String tv1 = "";
        if ("代金券".equals(cardType)) {
            int reduce_money = item.getReduce_money();
            try {
                double div = Arith.div(reduce_money, 100, 2);
                tv1 = "￥" + div;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        } else if ("礼品券".equals(cardType)) {
            tv1 = "礼品券";
        } else if ("折扣券".equals(cardType)) {
            int discount = item.getDiscount();
            try {
                double div = Arith.div(100 - discount, 10, 1);
                tv1 = "￥" + div;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        helper.setText(R.id.tv_1, tv1);
        helper.setText(R.id.tv_2, item.getCardType());
        helper.setText(R.id.tv_3, item.getTitle());
    }
}
