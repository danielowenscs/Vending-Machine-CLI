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

    public void addToBalance(BigDecimal amt) {
        // check if input is good
        balance = balance.add(amt);
    }

    //this function checks if a purchase can be made, if so it then subtracts from the money
    public void makePurchase(BigDecimal price) {
            balance = balance.subtract(price);
    }

    // this function gets the change
    public Map<String,Integer> getChange() {
        // if balance is zero no change needs to be given so we can exit the function
        if (getBalance().compareTo(BigDecimal.ZERO) < 1)  {
            return null;
        }

        Map<String, Integer> change = new HashMap<String, Integer>();
        String currCoin = "";
        int balanceLeft = balance.multiply(new BigDecimal("100")).intValue();
        while (balanceLeft != 0) {
            if (balanceLeft / 25 > 0) {
                currCoin = "Quarter";
                balanceLeft -=25;

            } else if (balanceLeft / 10 > 0) {
                currCoin = "Dime";
                balanceLeft -= 10;
            } else if (balanceLeft / 5 > 0) {
                currCoin = "Nickel";
                balanceLeft -= 5;
            } else {
                currCoin = "Pennie";
                balanceLeft -= 1;
            }

            if (change.containsKey(currCoin)) {
                change.replace(currCoin, change.get(currCoin)+1);
            }
            else {
                change.put(currCoin, 1);
            }
        }
        return change;
    }

}
