package com.company.entity;

public class RandomizedCustomer extends RandomizedHuman implements Customer {

    @Override
    public int putGoodsOnTheLine() {
        return randomAction();
    }

    @Override
    public int payForGoods() {
        return randomAction();
    }
}