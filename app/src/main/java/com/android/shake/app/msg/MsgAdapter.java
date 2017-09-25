package com.android.shake.app.msg;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.android.shake.R;
import com.jazz.libs.adapter.BaseAppAdapter;

/**
 * Created by NoName on 2017/9/25.
 */

public class MsgAdapter extends BaseAppAdapter<Msg> {

    public MsgAdapter(@NonNull Context ctx) {
        super(ctx);
    }

    @Override
    public int getItemLayerId() {
        return R.layout.item_msg;
    }

    @Override
    public void fillItemView(int position, Msg d, View converView) {
        ((TextView)converView.findViewById(R.id.item_msg_title)).setText(d.title);
        ((TextView)converView.findViewById(R.id.item_msg_content)).setText(d.content);
    }
}
