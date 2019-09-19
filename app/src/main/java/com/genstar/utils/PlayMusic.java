package com.genstar.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.SoundPool;

import com.genstar.R;


public class PlayMusic {
    public static SoundPool soundPool;
    public static int soundID0, soundID1, soundID2, soundID3, soundID4, soundID5, soundID6, soundID7, soundID8, soundID9, soundID_Dian, soundID_Back, soundFail;
    public static int soundIDALL;

    @SuppressLint("NewApi")
    public static void initSound(Context context) {
        if (soundPool == null) {
            soundPool = new SoundPool.Builder().build();
        }
        soundID0 = soundPool.load(context, R.raw.num0, 1);
        soundID1 = soundPool.load(context, R.raw.num1, 1);
        soundID2 = soundPool.load(context, R.raw.num2, 1);
        soundID3 = soundPool.load(context, R.raw.num3, 1);
        soundID4 = soundPool.load(context, R.raw.num4, 1);
        soundID5 = soundPool.load(context, R.raw.num5, 1);
        soundID6 = soundPool.load(context, R.raw.num6, 1);
        soundID7 = soundPool.load(context, R.raw.num7, 1);
        soundID8 = soundPool.load(context, R.raw.num8, 1);
        soundID9 = soundPool.load(context, R.raw.num9, 1);
        soundID9 = soundPool.load(context, R.raw.num9, 1);
        soundID_Dian = soundPool.load(context, R.raw.dian, 1);
        soundID_Back = soundPool.load(context, R.raw.back, 1);
        soundFail = soundPool.load(context, R.raw.fail, 1);

    }

    public static void playSoundForm(int num) {
        if (num == 0) {
            soundIDALL = soundID0;
        } else if (num == 1) {
            soundIDALL = soundID1;
        } else if (num == 2) {
            soundIDALL = soundID2;
        } else if (num == 3) {
            soundIDALL = soundID3;
        } else if (num == 4) {
            soundIDALL = soundID4;
        } else if (num == 5) {
            soundIDALL = soundID5;
        } else if (num == 6) {
            soundIDALL = soundID6;
        } else if (num == 7) {
            soundIDALL = soundID7;
        } else if (num == 8) {
            soundIDALL = soundID8;
        } else if (num == 9) {
            soundIDALL = soundID9;
        } else if (num == -1) {
            soundIDALL = soundID_Dian;
        } else if (num == -2) {
            soundIDALL = soundID_Back;
        } else if (num == -3) {
            soundIDALL = soundFail;
        }
        if (soundPool != null)
            soundPool.play(
                    soundIDALL,
                    0.5f,      //左耳道音量【0~1】
                    0.5f,      //右耳道音量【0~1】
                    0,         //播放优先级【0表示最低优先级】
                    0,         //循环模式【0表示循环一次，-1表示一直循环，其他表示数字+1表示当前数字对应的循环次数】
                    1          //播放速度【1是正常，范围从0~2】
            );
    }

}
