package com.techelevator.view;

import com.techelevator.view.Menu;

import java.awt.geom.Arc2D;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;


public class VendingMachine {
    private Menu menu = new Menu();
    private Balance balance = new Balance();

    public Menu getMenu () {
        return menu;
    }
    public BigDecimal getBalance() {
        return balance.getBalance();
    }
    public boolean isValidFeed (String userInput) {
        if (userInput.matches("^[0-9]*(\\.[0-9]{0,2})?$")) {
            if (Float.parseFloat(userInput) > 0) {
                if (getBalance().add(new BigDecimal(userInput)).compareTo(new BigDecimal("100")) < 1) {
                    return true;
                }
            }
        }
        return false;
    }


    public void feedMoney(String userInput) {

        //update balance
        balance.addToBalance(new BigDecimal(userInput));
        // update log
        addToLog(String.format("%s FEED MONEY: $%s $%s", getDateTime(), userInput.toString(), balance.getBalance()));
    }

    public Item makePurchase(String userInput) {
            Item itemSelected = menu.getItem(userInput);
            // update balance
            balance.makePurchase(itemSelected.getPrice()); // item price
            // update log
            addToLog(String.format("%s %s %s $%.2f $%s", getDateTime(), itemSelected.getName(), itemSelected.getSlotIdentifier(), itemSelected.getPrice(), balance.getBalance()));
            // update menu inventory
            menu.updateMenuInventory(itemSelected);
            return itemSelected;
    }

    public void finishTransaction() {
        //printChange();
        addToLog(String.format("%s GIVE CHANGE: $%S $0.00", getDateTime(), balance.getBalance()));
        // set balance to 0
        balance.setBalance(BigDecimal.ZERO);
    }
    public void endProgram() {
        createSalesReport();
    }

    // this method accepts a string to log and logs it
    private static void addToLog(String stringToLog) {
        final String fileName = "Log.txt";
        File file = new File(fileName);
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            writer.println(stringToLog);
        } catch (IOException e) {
            System.err.println("Error appending entry. Msg: " + e.getMessage());
        }
    }

     //this method creates a sales report file
    private void createSalesReport() {
        final String fileName = "salesreport.txt";
        File file = new File(fileName);
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            for (Item entry : menu.getMenu()) {
                writer.println(String.format("%s|%d", entry.getName(), 5 - entry.getAmount()));
            }
        } catch (IOException e) {
            System.err.println("Error appending entry. Msg: " + e.getMessage());
        }
    }

    public Map<String,Integer> getChange() {
        // if balance is zero no change needs to be given so we can exit the function
        if (getBalance().compareTo(BigDecimal.ZERO) < 1)  {
            return null;
        }
        // create an empty map to store the data for change
        Map<String, Integer> changeAsMap = new HashMap<String, Integer>();

        // curr coin will be a pointer to determine what coin to add to the map after each pass
        String currCoin = "";

        // this int will represent the balance as an int amt in pennies
        int balanceLeft = balance.getBalance().multiply(new BigDecimal("100")).intValue();

        // iterate through unit balance reaches 0
        while (balanceLeft != 0) {
            // assign the coin based on the division
            if (balanceLeft / 25 > 0) {
                currCoin = "Quarters";
                balanceLeft -=25;

            } else if (balanceLeft / 10 > 0) {
                currCoin = "Dimes";
                balanceLeft -= 10;
            } else if (balanceLeft / 5 > 0) {
                currCoin = "Nickels";
                balanceLeft -= 5;
            } else {
                currCoin = "Pennies";
                balanceLeft -= 1;
            }
            // check if coin is in map, if so add it
            if (changeAsMap.containsKey(currCoin)) {
                changeAsMap.replace(currCoin, changeAsMap.get(currCoin)+1);
            }
            // if not then add it and assign its value to 1
            else {
                changeAsMap.put(currCoin, 1);
            }
        }
        return changeAsMap;
    }

    // this is a helper method that returns the date and time
    private String getDateTime() {
        return new SimpleDateFormat("dd/MM/YYYY hh:mm:ss a").format(new Date());
    }
}
