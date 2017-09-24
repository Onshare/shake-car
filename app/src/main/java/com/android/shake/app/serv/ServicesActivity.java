package com.android.shake.app.serv;

import android.os.Bundle;
import android.view.View;

import com.android.shake.MainActivity;
import com.android.shake.R;

/**
 * Created by NoName on 2017/9/25.
 */

public class ServicesActivity extends MainActivity<ServicesPresenter> {

    private View mServBack, mServRule, mServFault, mServRemind, mServLianxi;

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
        setContentView(R.layout.activity_service);
        mServBack = findViewById(R.id.serv_back);
        mServRule = findViewById(R.id.serv_rule);
        mServFault = findViewById(R.id.serv_fault);
        mServRemind = findViewById(R.id.serv_remind);
        mServLianxi = findViewById(R.id.serv_lianxi);
        addOnClick(mServBack, mServRule, mServFault, mServRemind, mServLianxi);
    }

    @Override
    public void onClick(View v) {
        int resId = v.getId();
        switch (resId){
            case R.id.serv_back:
                this.finish();
                break;
            case R.id.serv_rule:
                break;
            case R.id.serv_fault:
                break;
            case R.id.serv_remind:
                break;
            case R.id.serv_lianxi:
                break;
        }
    }
}
