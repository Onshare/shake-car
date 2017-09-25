package com.android.shake.app.record;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.android.shake.MainActivity;
import com.android.shake.R;

/**
 * Created by NoName on 2017/9/26.
 */

public class RecordActivity extends MainActivity<RecordPresenter> {

    private View back;
    private View mRecordWw, mRecordCar;
    private ListView listView;
    private RecordAdapter adapter =null;

    @Override
    public void onClick(View v) {
        int resId = v.getId();
        switch (resId){
            case R.id.record_back:
                finish();
                break;
            case R.id.record_ww:
                setTitlePoint(false);
                break;
            case R.id.record_car:
                setTitlePoint(true);
                break;
        }
    }

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
        setContentView(R.layout.activity_record);
        back = findViewById(R.id.record_back);
        mRecordWw = findViewById(R.id.record_ww);
        mRecordCar = findViewById(R.id.record_car);
        listView = (ListView) findViewById(R.id.record_list);
        listView.setAdapter(adapter = new RecordAdapter(this));
        addOnClick(back, mRecordWw, mRecordCar);
        setTitlePoint(false);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void setTitlePoint(boolean isCar) {
        mRecordWw.setSelected(!isCar);
        mRecordCar.setSelected(isCar);
        adapter.setData(isCar ? getPresent().getCarRecord() : getPresent().getWwRecord());
    }
}
