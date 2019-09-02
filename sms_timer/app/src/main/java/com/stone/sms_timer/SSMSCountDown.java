package com.stone.sms_timer;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

/**
 * 短信发送倒计时提示
 */
public class SSMSCountDown extends CountDownTimer {
    private TextView mTextView;

    public SSMSCountDown(TextView tv, long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        this.mTextView = tv;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        mTextView.setClickable(false); //设置不可点击
        String s = String.valueOf(millisUntilFinished / 1000);
        mTextView.setText(s + "秒后可再次发送"); //设置倒计时时间
        SpannableString spannableString = new SpannableString(mTextView.getText().toString()); //获取按钮上的文字
        ForegroundColorSpan span = new ForegroundColorSpan(Color.RED);
        //将倒计时的时间设置为红色,TextView有效，Button无效
        spannableString.setSpan(span, 0, s.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        mTextView.setText(spannableString);
    }

    @Override
    public void onFinish() {
        mTextView.setText("重新获取验证码");
        mTextView.setClickable(true);//重新获得点击
    }

}
