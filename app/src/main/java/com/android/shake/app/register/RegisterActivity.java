package com.android.shake.app.register;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.shake.MainActivity;
import com.android.shake.R;

/**
 * Created by NoName on 2017/9/25.
 */

public class RegisterActivity extends MainActivity<RegisterPresenter> {

    private Spinner selecter;
    private EditText phone, invalidate;
    private View send, submit, qq, wechat;

    @Override
    public void onClick(View v) {
        int resId = v.getId();
        switch (resId){
            case R.id.register_send:
                break;
            case R.id.register_submit:
                break;
            case R.id.register_qq:
                break;
            case R.id.register_wechat:
                break;
        }
    }

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
        setContentView(R.layout.activity_register);
        selecter = (Spinner) findViewById(R.id.register_selector);
        phone = (EditText) findViewById(R.id.register_phone);
        invalidate = (EditText) findViewById(R.id.register_invalidate);

        send = findViewById(R.id.register_send);
        submit = findViewById(R.id.register_submit);
        qq = findViewById(R.id.register_qq);
        wechat = findViewById(R.id.register_wechat);

        addOnClick(send, submit, qq, wechat);
    }
}
