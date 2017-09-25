package com.android.shake.app.exchange;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.shake.MainActivity;
import com.android.shake.R;

/**
 * Created by NoName on 2017/9/26.
 */

public class ExchangeActivity extends MainActivity<ExchangePresenter> {

    private View back;
    private TextView jifen;
    private EditText jifenEdit;
    private View jifenSubmit;
    private EditText youhuiEdit;
    private View youhuiSubmit;

    @Override
    public void onClick(View v) {
        int resId = v.getId();
        switch (resId){
            case R.id.exchange_back:
                finish();
                break;
            case R.id.exchange_jifen_submit:
                onExchangeJifen();
                break;
            case R.id.exchange_youhui_submit:
                onExchangeYouhui();
                break;
        }
    }

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
        setContentView(R.layout.activity_exchange);
        back = findViewById(R.id.exchange_back);
        jifen = (TextView)findViewById(R.id.exchange_jifen_title);
        jifenEdit = (EditText) findViewById(R.id.exchange_jifen_edit);
        jifenSubmit = findViewById(R.id.exchange_jifen_submit);
        youhuiEdit = (EditText)findViewById(R.id.exchange_youhui_edit);
        youhuiSubmit = findViewById(R.id.exchange_youhui_submit);
        addOnClick(back, jifenSubmit, youhuiSubmit);
    }

    protected void onExchangeJifen(){
        String jifen = jifenEdit.getText().toString().trim();
    }

    protected void onExchangeYouhui(){
        String youhui = youhuiEdit.getText().toString().trim();
    }
}
