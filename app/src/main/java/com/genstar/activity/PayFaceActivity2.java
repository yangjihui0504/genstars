package com.genstar.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.genstar.R;
import com.genstar.base.BaseActivity;
import com.genstar.utils.CashierInputFilter;
import com.genstar.utils.CountTimer;
import com.genstar.utils.LogUtil;
import com.genstar.utils.PlayMusic;
import com.genstar.utils.SpeechUtil;
import com.genstar.utils.TimeUtils;

import java.math.BigDecimal;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PayFaceActivity2 extends BaseActivity {

    @BindView(R.id.et_money)
    EditText etMoney;
    @BindView(R.id.tv_7)
    TextView tv7;
    @BindView(R.id.tv_8)
    TextView tv8;
    @BindView(R.id.tv_9)
    TextView tv9;
    @BindView(R.id.tv_4)
    TextView tv4;
    @BindView(R.id.tv_5)
    TextView tv5;
    @BindView(R.id.tv_6)
    TextView tv6;
    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.tv_2)
    TextView tv2;
    @BindView(R.id.tv_3)
    TextView tv3;
    @BindView(R.id.tv_0)
    TextView tv0;
    @BindView(R.id.tv_spot)
    TextView tvSpot;
    @BindView(R.id.ll_delete)
    LinearLayout llDelete;
    @BindView(R.id.ll_sure)
    LinearLayout llSure;

    private static final double ANSWER_TEXT_MAX_LENGTH = 5;
    @BindView(R.id.iv_bg)
    ImageView ivBg;
    private CountTimer countTimer;
    private String trim;
    private TimeCount timeCount;
    private int totalTime = 20000;//总时间
    private int spaceTime = 1000;//间隔时间
    private boolean isTextChanged = false;
    private int memberid = 0;
    private String adSource;

    public static void open(Context context, Intent extras) {

        Intent intent = new Intent();
        intent.setClass(context, PayFaceActivity2.class);
        if (extras != null) {
            intent.putExtras(extras);
        }
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_face);
        ButterKnife.bind(this);

        initData();
        initListener();
    }

    private void initListener() {
        tv0.setOnClickListener(this::setListener);
        tv1.setOnClickListener(view -> setListener(view));
        tv2.setOnClickListener(view -> setListener(view));
        tv3.setOnClickListener(view -> setListener(view));
        tv4.setOnClickListener(view -> setListener(view));
        tv5.setOnClickListener(view -> setListener(view));
        tv6.setOnClickListener(view -> setListener(view));
        tv7.setOnClickListener(view -> setListener(view));
        tv8.setOnClickListener(view -> setListener(view));
        tv9.setOnClickListener(view -> setListener(view));
        llDelete.setOnClickListener(view -> setListener(view));
        tvSpot.setOnClickListener(view -> setListener(view));
        llSure.setOnClickListener(view -> setListener(view));

        etMoney.addTextChangedListener(new TextWatcher() {

            private String textChanged;
            private String beforeChangedText;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                LogUtil.d("textchange", "beforeTextChanged----" + etMoney.getText().toString());
                beforeChangedText = etMoney.getText().toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                LogUtil.d("textchange", "onTextChanged----" + etMoney.getText().toString());
                textChanged = etMoney.getText().toString();
                if (!beforeChangedText.equals(textChanged)) {
                    isTextChanged = true;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                LogUtil.d("textchange", "afterTextChanged----" + etMoney.getText().toString());
            }
        });
    }


    private void setListener(View view) {
        if (view == tv0) {
            addPwdText(0);
        } else if (view == tv1) {
            addPwdText(1);
        } else if (view == tv2) {
            addPwdText(2);
        } else if (view == tv3) {
            addPwdText(3);
        } else if (view == tv4) {
            addPwdText(4);
        } else if (view == tv5) {
            addPwdText(5);
        } else if (view == tv6) {
            addPwdText(6);
        } else if (view == tv7) {
            addPwdText(7);
        } else if (view == tv8) {
            addPwdText(8);
        } else if (view == tv9) {
            addPwdText(9);
        } else if (view == tvSpot) {
            addPwdText(-1);
        } else if (view == llDelete) {
            addPwdText(-2);
        } else if (view == llSure) {

            trim = etMoney.getText().toString().trim();
            if (trim == null || trim.isEmpty()) {
                SpeechUtil.openAudioFile(mSpeech, "输入金额有误");
                ToastUtils.showShort("请输入金额");
            } else {
                Double aDouble = Double.valueOf(trim);
                if (aDouble == 0) {
                    SpeechUtil.openAudioFile(mSpeech, "输入金额有误");
                    ToastUtils.showShort("请输入正确的金额");
                } else {
                    pay();
                }
            }

        }


    }


    private void pay() {
        SpeechUtil.openAudioFile(mSpeech, "请选择支付方式");
        Intent intent = new Intent();
        intent.putExtra("money", trim);
        ChoiseActivity.open(mActivity, intent);
        finish();

    }

    private void dayin(String money, String strType, String out_trade_no) {
        //打印小票
        String nowTime = TimeUtils.getNowTime();
        //todo 打印小票
//        DaYinUtils instance = DaYinUtils.getInstance(mActivity, new Handler(), MyApplication.shopName, out_trade_no, MyApplication.cashierName, strType, "非会员", money, 10, MyApplication.address, nowTime);
//        instance.dayin();
    }

    private void initData() {
        Intent intent = getIntent();
        adSource = intent.getStringExtra("adSource");
        InputFilter[] filters = {new CashierInputFilter()};
        etMoney.setFilters(filters);

        Glide.with(mActivity).load(adSource)
                .apply(new RequestOptions()
                        .placeholder(R.mipmap.icon_bg)
                        .centerCrop()
                ).into(ivBg);
    }


    private void startTimer() {
        if (null == timeCount) {
            timeCount = new TimeCount(totalTime, spaceTime);
        }
        timeCount.start();
    }

    private void stopTime() {
        if (timeCount != null) {
            timeCount.cancel();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        startTimer();
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopTime();
    }

    private void addPwdText(int num) {
        String answer = etMoney.getText().toString().trim();

        if (num >= 0 && !answer.contains(".") && answer.length() >= ANSWER_TEXT_MAX_LENGTH) {
            PlayMusic.playSoundForm(-3);
            return;
        }

        if (num >= 0) {

            if (answer != null && !answer.isEmpty()) {
                //当数字不等于空的时候
                if (String.valueOf(answer.charAt(0)).equals("0")) {
                    if (answer.length() == 1) {
                        PlayMusic.playSoundForm(-3);
                        return;
                    }
                    if (answer.length() >= 2 && !answer.subSequence(1, 2).equals(".")) {
                        //数字第一位是0，但第二位不是.的时候
                        PlayMusic.playSoundForm(-3);
                        return;
                    }
                }
                if (answer.contains(".")) {
                    if (answer.length() >= 4) {
                        int beginIndex = answer.length() - 3;
                        if (String.valueOf(answer.charAt(beginIndex)).equals(".")) {
                            PlayMusic.playSoundForm(-3);
                            return;
                        }
                    }
                }
                if (answer.length() == 3 && "0.0".equals(answer)) {
                    if (num == 0) {
                        PlayMusic.playSoundForm(-3);
                        return;
                    }
                }

            }
            //播放声音
            etMoney.setText(answer + num);
            etMoney.setSelection((answer + num).length());
            if (isTextChanged) {
                PlayMusic.playSoundForm(num);
                isTextChanged = false;
            }


        } else {

            if (num == -2) {
                if (TextUtils.isEmpty(answer)) {
                    return;
                }
                etMoney.setText(answer.substring(0, answer.length() - 1));
                etMoney.setSelection((answer.substring(0, answer.length() - 1)).length());
                if (isTextChanged) {
                    PlayMusic.playSoundForm(num);
                    isTextChanged = false;
                }
            } else if (num == -1) {
                if (TextUtils.isEmpty(answer)) {
                    PlayMusic.playSoundForm(-3);
                    return;
                }
                if (answer.contains(".")) {
                    PlayMusic.playSoundForm(-3);
                    return;
                }
                etMoney.setText(answer + ".");
                etMoney.setSelection((answer + ".").length());
                if (isTextChanged) {
                    PlayMusic.playSoundForm(num);
                    isTextChanged = false;
                }
            }

        }
    }

    class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {

        }

        @Override
        public void onFinish() {
            finish();
        }
    }

    @Override
    public void finish() {
        stopTime();
        super.finish();
    }


    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        String trim = etMoney.getText().toString().trim();
        switch (keyCode) {
            case 67:
                //退格
                if (isTextChanged) {
                    PlayMusic.playSoundForm(-2);
                    isTextChanged = false;
                }
                if (trim.isEmpty()) {
                    finish();
                }
                break;
            case 158:
                //.
                if (isTextChanged) {
                    PlayMusic.playSoundForm(-1);
                    isTextChanged = false;
                } else {
                    PlayMusic.playSoundForm(-3);
                }
                break;
            case 144:
                //0
                if (isTextChanged) {
                    PlayMusic.playSoundForm(0);
                    isTextChanged = false;
                } else {
                    PlayMusic.playSoundForm(-3);
                }
                break;
            case 145:
                if (isTextChanged) {
                    PlayMusic.playSoundForm(1);
                    isTextChanged = false;
                } else {
                    PlayMusic.playSoundForm(-3);
                }
                break;
            case 146:
                if (isTextChanged) {
                    PlayMusic.playSoundForm(2);
                    isTextChanged = false;
                } else {
                    PlayMusic.playSoundForm(-3);
                }
                break;
            case 147:
                if (isTextChanged) {
                    PlayMusic.playSoundForm(3);
                    isTextChanged = false;
                } else {
                    PlayMusic.playSoundForm(-3);
                }
                break;
            case 148:
                if (isTextChanged) {
                    PlayMusic.playSoundForm(4);
                    isTextChanged = false;
                } else {
                    PlayMusic.playSoundForm(-3);
                }
                break;
            case 149:
                if (isTextChanged) {
                    PlayMusic.playSoundForm(5);
                    isTextChanged = false;
                } else {
                    PlayMusic.playSoundForm(-3);
                }
                break;
            case 150:
                if (isTextChanged) {
                    PlayMusic.playSoundForm(6);
                    isTextChanged = false;
                } else {
                    PlayMusic.playSoundForm(-3);
                }
                break;
            case 151:
                if (isTextChanged) {
                    PlayMusic.playSoundForm(7);
                    isTextChanged = false;
                } else {
                    PlayMusic.playSoundForm(-3);
                }
                break;
            case 152:
                if (isTextChanged) {
                    PlayMusic.playSoundForm(8);
                    isTextChanged = false;
                } else {
                    PlayMusic.playSoundForm(-3);
                }
                break;
            case 153:
                if (isTextChanged) {
                    PlayMusic.playSoundForm(9);
                    isTextChanged = false;
                } else {
                    PlayMusic.playSoundForm(-3);
                }
                break;
        }


        return super.onKeyUp(keyCode, event);
    }

}
