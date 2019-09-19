package com.genstar.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.viewpager.widget.ViewPager;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.genstar.R;
import com.genstar.base.BaseActivity;
import com.genstar.bean.AdSourceBean;
import com.genstar.utils.PlayMusic;
import com.genstar.utils.TimeUtils;
import com.genstar.utils.WXUtils;
import com.genstar.utils.http.ActionHelper;
import com.genstar.utils.http.TextCallback;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements  ViewPager.OnPageChangeListener {


    @BindView(R.id.btn_settlement)
    Button btnSettlement;
    @BindView(R.id.banner_view)
    Banner bannerView;

    private ArrayList<String> imagePath = new ArrayList<>();
    private String adSource;
    private int position;

    public static void open(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initSound();
        WXUtils.initWX(mActivity);
        initData();
        initListener();
    }

    /**
     * 初始化自写小键盘声音
     */
    private void initSound() {
        PlayMusic.initSound(mActivity); //设置数字的声音
    }

    private void initData() {
        bannerStyle();
        setData();
    }

    private void setData() {
        String nowTime = TimeUtils.getNowTime();
        ActionHelper.GetAdSource(mActivity, nowTime, new TextCallback(mActivity) {
            @Override
            public void onSuccessed(String json) throws JSONException {
                AdSourceBean adSourceBean = new Gson().fromJson(json, AdSourceBean.class);
                setBanner(adSourceBean);
            }

            @Override
            public void onErrored(String errmsg) {
                ToastUtils.showShort(errmsg);
            }
        });
    }

    private void setBanner(AdSourceBean adSourceBean) {
        List<AdSourceBean.ListBean> list = adSourceBean.getList();

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                imagePath.add(list.get(i).getAdSource());
            }
        }
        //设置图片网址或地址的集合
        bannerView.setImages(imagePath);
        bannerView.setOnPageChangeListener(this);
        //必须最后调用的方法，启动轮播图。
        bannerView.start();
    }

    private void initListener() {
        btnSettlement.setOnClickListener(this::setListener);
    }

    private void setListener(View view) {
        if (view == btnSettlement) {
            Intent intent = new Intent();

            if (imagePath.size() > 0 && imagePath.size() >= position) {
                adSource = imagePath.get(position-1);
            }

            intent.putExtra("adSource", adSource);
            PayFaceActivity2.open(mActivity, intent);
        }
    }

    private void bannerStyle() {
        //设置内置样式，共有六种可以点入方法内逐一体验使用。
        bannerView.setBannerStyle(BannerConfig.NOT_INDICATOR);
        //设置图片加载器，图片加载器在下方
        bannerView.setImageLoader(new MyImageLoader());

        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
        bannerView.setBannerAnimation(Transformer.Default);
        //设置轮播间隔时间
        bannerView.setDelayTime(3000);


    }



    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        this.position = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * 图片加载类
     */
    private class MyImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }

    }

}
