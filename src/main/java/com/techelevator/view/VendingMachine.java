package com.techelevator.view;

import com.techelevator.view.Menu;

import java.math.BigDecimal;
import java.util.Scanner;


public class VendingMachine {
    private Menu menu = new Menu ();
    private Balance balance = new Balance();
    private LogData logData = new LogData();
    Scanner scanner = new Scanner(System.in);

    // get user input
    public String getUserInput () {
        String userInput = scanner.nextLine();
        return userInput;
    }

    // enters 1
    public void printMenu () {
        menu.printMenu();
    }

    // enters 2 make purchase

    // enters 1
    public void feedMoney (String userInput) {
        //update balance
        balance.addToBalance(new BigDecimal(userInput));
        // update log
        logData.updateLogFeed(new BigDecimal(userInput), balance.getBalanceAsStr());
    }

    // enters 2

    // display balance
    public void displayBalance () {
        System.out.printf("Current Money Provided: $%s\n\n", balance.getBalanceAsStr());
    }
    public void makePurchase(String userInput) {
        System.out.println();
        // select Item
        Item itemSelected = menu.getItem(userInput);
        // update balance
        balance.makePurchase(itemSelected.getPrice()); // item price
        // update purchase log
        logData.updateLogPurchase(itemSelected.getName(), itemSelected.getSlotIdentifier(), itemSelected.getPrice(), balance.getBalanceAsStr());
        // update menu inventory
        menu.updateMenuInventory(itemSelected);
        // need logic for if a purchase can't be made
        System.out.printf("%s | %s | %s | %s\n\n", itemSelected.getName(), itemSelected.getPrice().toString(), balance.getBalanceAsStr(), itemSelected.getPhrase());
    }

    // enters 3
    public boolean finishTransaction () {
        System.out.println(formatChange());
        return true;
    }

    public boolean programOver () {
        return true;
    }

    // format change
    public String formatChange () {
        return null;
    }

}
