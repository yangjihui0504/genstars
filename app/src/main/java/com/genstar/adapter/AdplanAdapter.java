package com.genstar.adapter;

import android.app.Activity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.genstar.R;

public class AdplanAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private Activity activity;
    public AdplanAdapter(Activity activity) {
        super(R.layout.adapter_adplan);
        this.activity = activity;
    }


    @Override
    protected void convert(BaseViewHolder helper, String item) {
        Glide.with(activity).load(item)
                .apply(new RequestOptions()
                        .placeholder(R.mipmap.success1)
                        .centerCrop()).into((ImageView) helper.getView(R.id.iv_adplan));
    }
}
