package com.techelevator.view;

import java.math.BigDecimal;

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

    public void addToBalance(BigDecimal amt) {
        // check if input is good
        balance = balance.add(amt);
    }

    //this function checks if a purchase can be made, if so it then subtracts from the money
    public void makePurchase(BigDecimal price) {
        if (balance.compareTo(price) > 0) {
            balance = balance.subtract(price);
        } else {
            System.out.println("purchase cannot be made");
        }
    }

    // this function gets the change
    public void getChange() {
        int balanceLeft = balance.multiply(new BigDecimal("100")).intValue();
        while (balanceLeft != 0) {
            if (balanceLeft / 25 > 0) {
                System.out.println("Quarter");
                balanceLeft -= 25;
            } else if (balanceLeft / 10 > 0) {
                System.out.println("Dime");
                balanceLeft -= 10;
            } else if (balanceLeft / 5 > 0) {
                System.out.println("Nickle");
                balanceLeft -= 5;
            } else {
                System.out.println("Pennies");
                balanceLeft -= 1;
            }
        }
    }
}
