package com.techelevator.view;

import com.techelevator.view.Menu;

import java.awt.geom.Arc2D;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;


public class VendingMachine {
    private Menu menu = new Menu();
    private Balance balance = new Balance();
    private LogData logData = new LogData();
    Scanner scanner = new Scanner(System.in);

    // get user input
    public String getUserInput() {
        String userInput = scanner.nextLine();
        userInput = inputHandler(userInput);
        return userInput;
    }
    public Menu getMenu () {
        return menu;
    }




    // enters 2 make purchase

    // enters 1
    public void feedMoney(String userInput) {

        //update balance
        balance.addToBalance(new BigDecimal(userInput));
        // update log
        logData.updateLogFeed(new BigDecimal(userInput), balance.getBalanceAsStr());
        // return balance
        balance.getBalance();

//        // checks if valid
//        if (userInput.matches("^[0-9]*(\\.[0-9]{0,2})?$")) {
//            //update balance
//            balance.addToBalance(new BigDecimal(userInput));
//            // update log
//            logData.updateLogFeed(new BigDecimal(userInput), balance.getBalanceAsStr());
//            return"";
//        } else {
//            return badInputMessage();
//        }
    }

    // enters 2

    // display balance
    public void displayBalance() {
        //System.out.printf("Current Money Provided: $%s\n\n", balance.getBalanceAsStr());
    }


    public Item makePurchase(String userInput) {

        try {
            // if user input was bad form
            // select input, if in valid it's set to null
            // if it's null you simply return the bad input message
            Item itemSelected = menu.getItem(userInput);
            // update balance

            balance.makePurchase(itemSelected.getPrice()); // item price
            // update purchase log
            logData.updateLogPurchase(itemSelected.getName(), itemSelected.getSlotIdentifier(), itemSelected.getPrice(), balance.getBalanceAsStr());
            // update menu inventory
            menu.updateMenuInventory(itemSelected);
            // return receipt
            // System.out.printf("%20s | %s | %5.2f | %s%n", itemSelected.getName(), itemSelected.getPrice().toString(), balance.getBalance(), itemSelected.getPhrase());
            //return String.format("%s | %s | %5.2f | %s\n\n", itemSelected.getName(), itemSelected.getPrice().toString(), balance.getBalance(), itemSelected.getPhrase());
            return itemSelected;
        }
        catch (Exception e) {
            System.out.println("Purchase Cannot Be Made");
        }
    }

    public BigDecimal getBalance() {
        return balance.getBalance();
    }

    // enters 3
    public boolean finishTransaction() {
        printChange();
        logData.logChange(balance.getBalanceAsStr());
        return true;
    }

    private String badInputMessage() {
        return "The Input You Entered was in Valid, Please Try Again";
    }


    // format change
    public void printChange() {
        if (balance.getChange() == null) {
            System.out.println("You Have No Change");
            return;
        }
        Map<String, Integer> changeAsMap = new HashMap<String, Integer>();
        changeAsMap = balance.getChange();
        System.out.println("Your Change Is:");
        for (Map.Entry<String, Integer> entry : changeAsMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.printf("%d %ss\n", entry.getValue(), entry.getKey());
            } else {
                System.out.printf("%d %s\n", entry.getValue(), entry.getKey());
            }
        }
    }

    private String inputHandler(String userInput) {
        return userInput.toUpperCase();
    }

}
