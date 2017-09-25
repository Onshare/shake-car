package com.android.shake.app.money;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.android.shake.R;
import com.jazz.libs.adapter.BaseAppAdapter;

import java.util.List;

/**
 * Created by NoName on 2017/9/25.
 */

public class MoneyAdapter extends BaseAppAdapter<Money> {

    public MoneyAdapter(@NonNull Context ctx, List<Money> moneyList) {
        super(ctx);
        setData(moneyList);
    }

    @Override
    public int getItemLayerId() {
        return R.layout.item_money;
    }

    @Override
    public void fillItemView(int position, Money d, View converView) {
        if(d != null){
            ((TextView)converView.findViewById(R.id.item_money_count)).setText(d.count);
            if(d.isHonebao()){
                converView.findViewById(R.id.item_money_container).setBackgroundResource(R.mipmap.money_hongbao);
                ((TextView)converView.findViewById(R.id.item_money_lei)).setText("红包收入(元)");
            }else {
                converView.findViewById(R.id.item_money_container).setBackgroundResource(R.mipmap.money_jifen);
                ((TextView)converView.findViewById(R.id.item_money_lei)).setText("积分兑换(元)");
            }
        }
    }
}
