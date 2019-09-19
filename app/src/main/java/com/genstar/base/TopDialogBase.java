package com.genstar.base;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.genstar.R;

public abstract class TopDialogBase extends Dialog {
    public TopDialogBase(Context context) {
        super(context);
        init();
    }

    protected void init(){
        Window win = this.getWindow();
        win.requestFeature(Window.FEATURE_NO_TITLE);
        onCreate();
        win.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = win.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.windowAnimations = R.style.TopInAndOutStyle;
        lp.gravity = Gravity.TOP;
        win.setAttributes(lp);
        win.setBackgroundDrawableResource(android.R.color.transparent);
    }
    protected abstract void onCreate();
}
