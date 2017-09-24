package com.android.shake.app.setting;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.shake.MainActivity;
import com.android.shake.R;
import com.jazz.libs.viewUtil.CenterToast;

/**
 * Created by NoName on 2017/9/25.
 */

public class SettingActivity extends MainActivity<SettingPresenter> {

    private View mSettingBack, mSettingSuggestion, mSettingLianxi, mSettingCache, mSettingAgree, mSettingAbout, mSettingLogout;

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
        setContentView(R.layout.activity_setting);
        mSettingBack = findViewById(R.id.setting_back);
        mSettingSuggestion = findViewById(R.id.setting_suggestion);
        mSettingLianxi = findViewById(R.id.setting_lianxi);
        mSettingCache = findViewById(R.id.setting_cache);
        mSettingAgree = findViewById(R.id.setting_agreement);
        mSettingAbout = findViewById(R.id.setting_about);
        mSettingLogout = findViewById(R.id.setting_logout);
        addOnClick(mSettingBack, mSettingSuggestion, mSettingLianxi, mSettingCache, mSettingAgree, mSettingAbout, mSettingLogout);
    }

    @Override
    public void onClick(View v) {
        int resId = v.getId();
        switch (resId){
            case R.id.setting_back:
                this.finish();
                break;
            case R.id.setting_suggestion:
                break;
            case R.id.setting_lianxi:
                break;
            case R.id.setting_cache:
                CenterToast.makeText(this, "清楚完成", Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting_agreement:
                break;
            case R.id.setting_about:
                break;
            case R.id.setting_logout:
                break;
        }
    }
}
