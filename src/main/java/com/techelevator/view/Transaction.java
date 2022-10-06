package com.techelevator.view;

import com.techelevator.Item;
import com.techelevator.Log;

public class Transaction {
    private int money;
    private Menu menu;
    private Log log;

    public Transaction (Menu menu, Log log) {
        this.log = log;
        money = 0;
        this.menu=menu;
    }
    public void updateFeed (int amt) {
        log.updateLogFeed(money, amt);
        money += amt;


    }
    public void updateLog(String extraPart) {
        System.out.println("updated string");
    }
    public void purchase(Item item) {
        // determine if purchase is possible if so ...
        money -= item.getPrice(); // pass in negative price of item
        menu.updateMenu(item);
        log.updateLogPurchase(item, money);
//        getChange()
    }
    private void getChange(){
        
    }



}


//    Update money (updates money variable) {changes money variable}
//    updated Log("extra part") {gets date and time adds to extra part and souts log}
//    PURCAHSE (item) { determines if purchase is possible, if so update money, quantity, prepare log String, update inventory, call updateLog()}
//    createSalesReport() {iterates through map and writes each item and amount to the file}