package com.genstar.utils;

import android.app.Activity;

import java.util.Timer;
import java.util.TimerTask;

public class ACCloseTimerUtils {
    private static ACCloseTimerUtils acCloseTimerUtils;
    private static Timer mTimer;

    public static ACCloseTimerUtils getInstance() {
        if (acCloseTimerUtils == null) {
            acCloseTimerUtils = new ACCloseTimerUtils();
        }
        if (mTimer != null) {
            mTimer = new Timer();
        }
        return acCloseTimerUtils;
    }

    public static void startTimer(Activity activity) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        activity.finish();
                    }
                });
            }
        };
        mTimer.schedule(timerTask, 60000);

    }

    public static void stopTimer(Activity activity) {
        mTimer.cancel();
    }
}
