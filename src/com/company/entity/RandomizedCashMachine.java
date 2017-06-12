package com.company.entity;

import java.util.Random;

/**
 * Created by Violetta on 12-06-2017.
 */
public class RandomizedCashMachine implements CashMachine {
    RandomizedCashier randCash=new RandomizedCashier();
    boolean crashing;
    Random rand = new Random();
    @Override
    public int countMoney() {
        return rand.nextInt(20) + randCash.callAmount();
    }
    @Override
    public int printACheck() {
        return rand.nextInt(10) + randCash.giveChangeAndReceipt();
    }
    public boolean isCrashing() {
        crashing = (new Random()).nextBoolean();
        return crashing;
    }
    @Override
    public int crashAndRepair() {
       if (crashing)
           return rand.nextInt(100);
       else
           return 0;
    }

    public int beepGoods() {
        return rand.nextInt(30) + randCash.beepTheGoods();
    }

}
