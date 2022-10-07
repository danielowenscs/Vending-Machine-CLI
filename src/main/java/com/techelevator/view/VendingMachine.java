package com.techelevator.view;

import com.techelevator.view.Menu;

import java.awt.geom.Arc2D;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;


public class VendingMachine {
    private Menu menu = new Menu ();
    private Balance balance = new Balance();
    private LogData logData = new LogData();
    Scanner scanner = new Scanner(System.in);

    // get user input
    public String getUserInput () {
        String userInput = scanner.nextLine();
        userInput= inputHandler(userInput);
        return userInput;
    }

    // enters 1
    public void printMenu () {
        menu.printMenu();
    }

    // enters 2 make purchase

    // enters 1
    public void feedMoney (String userInput) {
        //00.00

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
        // select Item

        Item itemSelected = menu.getItem(userInput);
        if (itemSelected == null) {
            System.out.println("Not An Option");
            System.out.println();
            return;
        } else {
            // update balance
            balance.makePurchase(itemSelected.getPrice()); // item price
            // update purchase log
            logData.updateLogPurchase(itemSelected.getName(), itemSelected.getSlotIdentifier(), itemSelected.getPrice(), balance.getBalanceAsStr());
            // update menu inventory
            menu.updateMenuInventory(itemSelected);
            // need logic for if a purchase can't be made
            System.out.printf("%s | %s | %s | %s\n\n", itemSelected.getName(), itemSelected.getPrice().toString(), balance.getBalanceAsStr(), itemSelected.getPhrase());
        }
    }
    // enters 3
    public boolean finishTransaction () {
        printChange();
        logData.logChange(balance.getBalanceAsStr());
        return true;
    }

    public boolean programOver () {


        return true;
    }

    // format change
    public void printChange () {
        if(balance.getChange()==null){
            System.out.println("You Have No Change");
            return;
        }
        Map<String, Integer> changeAsMap = new HashMap<String, Integer>();
        changeAsMap=balance.getChange();
        System.out.println("Your Change Is:");
        for (Map.Entry<String, Integer> entry : changeAsMap.entrySet()) {
            if(entry.getValue()>1) {
                System.out.printf("%d %ss\n", entry.getValue(), entry.getKey());
            }
            else
            {
                System.out.printf("%d %s\n",entry.getValue(),entry.getKey());
            }
        }
    }


    private String inputHandler(String userInput){
        return userInput.toUpperCase();
    }

}
