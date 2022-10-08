package com.techelevator.view;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Balance {
    private BigDecimal balance;

    public Balance() {
        balance = new BigDecimal("0.00");
    }

    public BigDecimal getBalance() {
        return balance;
    }
    public String getBalanceAsStr() {
        return balance.toString();
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void addToBalance(BigDecimal amt) {
        // check if input is good
        balance = balance.add(amt);
    }

    //this function checks if a purchase can be made, if so it then subtracts from the money
    public void makePurchase(BigDecimal price) {
            balance = balance.subtract(price);
    }

    // this function gets the change

}
