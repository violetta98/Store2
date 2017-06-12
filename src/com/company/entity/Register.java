package com.company.entity;

import java.util.LinkedList;
import java.util.Queue;

public class Register implements Runnable {
    private final Cashier cashier;
    private RandomizedCashMachine rcm = new RandomizedCashMachine();
    private final Queue<Customer> queue = new LinkedList<>();
    public Register(Cashier cashier) {
        this.cashier=cashier;
    }
    public void newCustomer(Customer customer) {
        queue.add(customer);
    }
    public void run() {
        int numberOfCustomers=0;
        int totalTime=0;
        Customer customer;
        int CashMachineCrash=0;
        while((customer=queue.poll())!=null) { // ctrl + q
            totalTime+=customer.putGoodsOnTheLine();
            if (rcm.isCrashing()) {
                totalTime += rcm.crashAndRepair();
                CashMachineCrash++;
            }
            totalTime+=rcm.beepGoods();
            totalTime+=rcm.countMoney();
            totalTime+=customer.payForGoods();
            totalTime+=rcm.printACheck();
            numberOfCustomers++;
        }
        System.out.println("There was "+ numberOfCustomers + " customers and it took "+totalTime);
        System.out.println("Cash Machine was broke "+ CashMachineCrash + " times");
    }
}