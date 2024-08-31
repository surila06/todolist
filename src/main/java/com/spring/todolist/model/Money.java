package com.spring.todolist.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Money {

    private String currency;
    private int value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money money)) return false;

        return getCurrency().equals(money.getCurrency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCurrency());
//        int result = 17;
//        if (currency != null) {
//            result = 31 * result + currency.hashCode();
//        }
//        if (value != 0) {
//            result = 31 * result + value.hashCode();
//        }
//
//        return result;

    }
}
