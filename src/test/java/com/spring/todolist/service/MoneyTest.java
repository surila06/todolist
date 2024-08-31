package com.spring.todolist.service;

import com.spring.todolist.model.Money;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.util.HashSet;
import java.util.Set;

public class MoneyTest {

    @Test
    public void test() {

        Money money1 = new Money("USD",99);
        Money money2 = new Money("USD",49);
        Money money3 = new Money("INR",99);

        System.out.println(money1.equals(money2));

        Set<Money> moneySet = new HashSet<>();
        moneySet.add(money1);
        moneySet.add(money2);
        moneySet.add(money3);
        System.out.println("moneySet"+moneySet);

//        true
//        moneySet[Money(currency=USD, value=99), Money(currency=INR, value=99)]


    }
}
