package com.android.shake.app.msg;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.android.shake.MainActivity;
import com.android.shake.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NoName on 2017/9/25.
 */

public class MsgActivity extends MainActivity<MsgPresenter> {

    private View back;
    private ListView listView;
    private MsgAdapter adapter;

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.msg_back){
            finish();
        }
    }

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
        setContentView(R.layout.activity_message);
        back = findViewById(R.id.msg_back);
        listView = (ListView) findViewById(R.id.msg_list);
        addOnClick(back);
        adapter = new MsgAdapter(this);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Msg> msgList = new ArrayList<>();
        msgList.add(new Msg());
        msgList.add(new Msg());
        msgList.add(new Msg());
        msgList.add(new Msg());
        msgList.add(new Msg());
        msgList.add(new Msg());
        msgList.add(new Msg());
        setData(msgList);
    }

    protected void setData(List<Msg> msgList){
        adapter.setData(msgList);
    }
}
