package com.android.shake.app.money;

/**
 * Created by NoName on 2017/9/25.
 */

public class Money {

    public static final String MONEY_JIFEN = "JIFEN_MONEY";
    public static final String MONEY_HONGBAO = "HONGBAO_MONEY";

    public String itemType;
    public String count;

    public Money(){}

    public Money(String itemType, String count){
        this.itemType = itemType;
        this.count = count;
    }

    public boolean isHonebao(){
        return MONEY_HONGBAO.equals(itemType);
    }
}
