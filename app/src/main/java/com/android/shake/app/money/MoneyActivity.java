package com.android.shake.app.money;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.android.shake.MainActivity;
import com.android.shake.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NoName on 2017/9/25.
 */

public class MoneyActivity extends MainActivity<MoneyPresenter> {

    private TextView moneyCount;
    private View moneyBack, moneyPay;
    private ListView moneyList;


    @Override
    public void onClick(View v) {
        int resId = v.getId();
        switch (resId){
            case R.id.money_back:
                finish();
                break;
            case R.id.money_pay:
                break;
        }
    }

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
        setContentView(R.layout.activity_money);
        moneyBack = findViewById(R.id.money_back);
        moneyCount = (TextView) findViewById(R.id.money_count);
        moneyPay = findViewById(R.id.money_pay);
        moneyList = (ListView) findViewById(R.id.money_list);
        addOnClick(moneyBack, moneyPay);
        this.moneyList.setAdapter(new MoneyAdapter(this, getData()));
    }

    private List<Money> getData(){
        List<Money> mList = new ArrayList<>();
        mList.add(new Money(Money.MONEY_HONGBAO, "52.41"));
        mList.add(new Money(Money.MONEY_JIFEN, "5.01"));
        return mList;
    }


}
