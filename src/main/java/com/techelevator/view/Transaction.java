package com.techelevator.view;

import com.techelevator.Item;

public class Transaction {
    private int money;

    Transaction () {
        money = 0;
    }
    public void updateMoney (int amt) {
        money += amt;
    }
    public void updateLog(String extraPart) {

    }
    public void purchase(Item item) {
        // determine if purchase is possible if so ...
        updateMoney(0); // pass in negative price of item
        // update Menu () //
    }
}


//    Update money (updates money variable) {changes money variable}
//    updated Log("extra part") {gets date and time adds to extra part and souts log}
//    PURCAHSE (item) { determines if purchase is possible, if so update money, quantity, prepare log String, update inventory, call updateLog()}
//    createSalesReport() {iterates through map and writes each item and amount to the file}