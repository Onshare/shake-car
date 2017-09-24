package com.android.shake;

import android.view.View;

import com.jazz.libs.controller.BaseActivity;
import com.jazz.libs.controller.BasePresent;

public abstract class MainActivity<P extends BasePresent>  extends BaseActivity<P> implements View.OnClickListener{

    protected void addOnClick(View... view) {
        if (view != null) {
            for (View v : view) {
                if (v != null) {
                    v.setOnClickListener(this);
                }
            }
        }
    }


}
