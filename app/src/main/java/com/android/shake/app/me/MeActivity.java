package com.android.shake.app.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.shake.MainActivity;
import com.android.shake.R;
import com.android.shake.app.exchange.ExchangeActivity;
import com.android.shake.app.money.MoneyActivity;
import com.android.shake.app.msg.MsgActivity;
import com.android.shake.app.record.RecordActivity;
import com.android.shake.app.register.RegisterActivity;
import com.android.shake.app.setting.SettingActivity;
import com.android.shake.app.share.ShareActivity;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by NoName on 2017/9/24.
 */

public class MeActivity extends MainActivity<MePresenter>{

    private View mBack,mSetting;
    private SimpleDraweeView avatar;
    private TextView alias, point, online;
    private View record, money, friend, exchange, message;

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
        setContentView(R.layout.activity_me);
        mBack = findViewById(R.id.me_back);
        mSetting = findViewById(R.id.me_setting);
        avatar = (SimpleDraweeView) findViewById(R.id.me_avatar);

        alias = (TextView) findViewById(R.id.me_alias);
        point = (TextView) findViewById(R.id.me_point);
        online = (TextView) findViewById(R.id.me_online);

        record = findViewById(R.id.me_record);
        money = findViewById(R.id.me_money);
        friend = findViewById(R.id.me_friend);
        exchange = findViewById(R.id.me_exchange);
        message = findViewById(R.id.me_message);

        addOnClick(mBack, mSetting, avatar, record, money, friend, exchange, message);
    }

    @Override
    public void onClick(View v) {
        int resId = v.getId();
        switch (resId){
            case R.id.me_back:
                this.finish();
                break;
            case R.id.me_setting:
                startActivity(new Intent(this, SettingActivity.class));
                break;
            case R.id.me_avatar:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.me_record:
                startActivity(new Intent(this, RecordActivity.class));
                break;
            case R.id.me_money:
                startActivity(new Intent(this, MoneyActivity.class));
                break;
            case R.id.me_friend:
                startActivity(new Intent(this, ShareActivity.class));
                break;
            case R.id.me_exchange:
                startActivity(new Intent(this, ExchangeActivity.class));
                break;
            case R.id.me_message:
                startActivity(new Intent(this, MsgActivity.class));
                break;
            default:
        }
    }
}
