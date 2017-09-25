package com.android.shake.app.record;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.android.shake.R;
import com.jazz.libs.adapter.BaseAppAdapter;

/**
 * Created by NoName on 2017/9/26.
 */

public class RecordAdapter extends BaseAppAdapter<Record> {

    public RecordAdapter(@NonNull Context ctx) {
        super(ctx);
    }

    @Override
    public int getItemLayerId() {
        return R.layout.item_record;
    }

    @Override
    public void fillItemView(int position, Record d, View converView) {
        ((TextView)converView.findViewById(R.id.item_record_addr)).setText(d.addr);
        ((TextView)converView.findViewById(R.id.item_record_coin)).setText(d.coin);
        ((TextView)converView.findViewById(R.id.item_record_time)).setText(d.time);
    }
}
