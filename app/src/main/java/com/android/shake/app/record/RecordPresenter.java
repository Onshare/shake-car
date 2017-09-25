package com.android.shake.app.record;

import com.jazz.libs.controller.BasePresent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NoName on 2017/9/26.
 */

public class RecordPresenter extends BasePresent<RecordActivity> {

    private final List<Record> mWwRecord = new ArrayList<>();
    private final List<Record> mCarRecord = new ArrayList<>();

    public List<Record> getWwRecord() {
        mWwRecord.clear();
        mWwRecord.add(new Record());
        mWwRecord.add(new Record());
        mWwRecord.add(new Record());
        mWwRecord.add(new Record());
        mWwRecord.add(new Record());
        return mWwRecord;
    }


    public List<Record> getCarRecord() {
        mCarRecord.clear();
        mCarRecord.add(new Record());
        mCarRecord.add(new Record());
        mCarRecord.add(new Record());
        mCarRecord.add(new Record());
        mCarRecord.add(new Record());
        mCarRecord.add(new Record());
        mCarRecord.add(new Record());
        mCarRecord.add(new Record());
        return mCarRecord;
    }
}
