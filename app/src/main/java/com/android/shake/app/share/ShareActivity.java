package com.android.shake.app.share;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.android.shake.MainActivity;
import com.android.shake.R;

/**
 * Created by NoName on 2017/9/26.
 */

public class ShareActivity extends MainActivity<SharePresenter> {

    private View back;
    private View bk;
    private TextView ma;
    private View wechat, gr, qq, sina;

    @Override
    public void onClick(View v) {
        int resId = v.getId();
        switch (resId){
            case R.id.share_back:
                finish();
                break;
            case R.id.share_wechat:
                break;
            case R.id.share_gr:
                break;
            case R.id.share_qq:
                break;
            case R.id.share_sina:
                break;
            default:
        }
    }

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
        setContentView(R.layout.activity_share);
        back = findViewById(R.id.share_back);
        bk = findViewById(R.id.share_sign);
        ma = (TextView) findViewById(R.id.share_ma);
        wechat = findViewById(R.id.share_wechat);
        gr = findViewById(R.id.share_gr);
        qq = findViewById(R.id.share_qq);
        sina = findViewById(R.id.share_sina);
        addOnClick(back, wechat, gr, qq, sina);
        initsign();
    }

    void initsign(){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.mipmap.share_bk, options);
        bk.setLayoutParams(new FrameLayout.LayoutParams(getResources().getDisplayMetrics().widthPixels
                , (options.outHeight / options.outWidth) * getResources().getDisplayMetrics().widthPixels));
    }

    protected void setMa(String txt){
        ma.setText("您的邀请码是:"+txt);
    }
}
