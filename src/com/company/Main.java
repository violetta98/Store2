package com.company;

import com.company.entity.RandomizedCashier;
import com.company.entity.RandomizedCustomer;
import com.company.entity.Register;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Register register = new Register(new RandomizedCashier());
        Random random = new Random();
        for (int i=0; i<random.nextInt(100); i++)
            register.newCustomer(new RandomizedCustomer());
        register.run();
    }
}