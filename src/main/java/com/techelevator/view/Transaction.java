package com.techelevator.view;

import com.techelevator.Item;
import com.techelevator.Log;

public class Transaction {
    private int money;
    private Menu menu;
    private Log 
    public Transaction (Menu menu) {
        money = 0;
        this.menu=menu;
    }
    public void updateMoney (int amt) {
        money += amt;


    }
    public void updateLog(String extraPart) {
        System.out.println("updated string");
    }
    public void purchase(Item item) {
        // determine if purchase is possible if so ...
        updateMoney(-item.getPrice()); // pass in negative price of item
        menu.updateMenu(item);
    }



}


//    Update money (updates money variable) {changes money variable}
//    updated Log("extra part") {gets date and time adds to extra part and souts log}
//    PURCAHSE (item) { determines if purchase is possible, if so update money, quantity, prepare log String, update inventory, call updateLog()}
//    createSalesReport() {iterates through map and writes each item and amount to the file}