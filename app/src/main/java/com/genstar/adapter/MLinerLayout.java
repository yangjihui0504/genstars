package com.genstar.adapter;

import android.content.Context;
import android.util.AttributeSet;

import androidx.recyclerview.widget.LinearLayoutManager;

public class MLinerLayout extends LinearLayoutManager {
    private boolean canScroll = true;
    public MLinerLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public MLinerLayout(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public MLinerLayout(Context context) {
        super(context);
    }

    /**
     * 垂直方向
     * @return
     */
    @Override
    public boolean canScrollVertically() {
        return canScroll && super.canScrollVertically();
    }

    /**
     * 水平方向
     * @return
     */
    @Override
    public boolean canScrollHorizontally() {
        return super.canScrollHorizontally();
    }

    /**
     * 设置是否可以滑动
     * @param canScroll
     */
    public void setCanScroll(boolean canScroll) {
        this.canScroll = canScroll;
    }

}
