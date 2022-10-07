package com.techelevator.view;

import com.techelevator.view.Item;
import com.techelevator.view.LogData;
import com.techelevator.view.Menu;
import com.techelevator.view.Balance;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

public class VendingMachineCLI {
    private static Menu menu = new Menu();
    private static Balance balance = new Balance();
    private static LogData logData = new LogData();

    public static void main(String[] args) throws FileNotFoundException {
        Menu menu = new Menu();
        boolean exitProgram = false;
        boolean isTransactionComplete = false;
        Scanner scanner = new Scanner(System.in);

        while (!exitProgram) {

            System.out.println("(1) Display Vending Machine Items");
            System.out.println("(2) Purchase");
            System.out.println("(3) Exit");
            System.out.println();
            System.out.print("Your Choice: ");
            String userInput = scanner.nextLine();
            System.out.println();

            if (userInput.equals("1")) {
                menu.printMenu();
                System.out.println();
            }
            if (userInput.equals("2")) {
                while (!isTransactionComplete) {

                    System.out.printf("Current Money Provided: $%s\n", balance.getBalanceAsStr());
                    System.out.println();
                    System.out.println("(1) Feed Money");
                    System.out.println("(2) Select Product");
                    System.out.println("(3) Finish Transaction");
                    System.out.println();
                    System.out.print("Your Choice: ");
                    userInput = scanner.nextLine();
                    System.out.println();


                    if (userInput.equals("1")) {
                        System.out.print("Enter The Amount Of Money To Add Format (0.00): ");
                        userInput = scanner.nextLine();
                        System.out.println();
                        feedMoney(userInput);
                    }
                    if (userInput.equals("2")) {
                        System.out.print("Enter The Slot Identifier Of The Product You Wish To Purchase: ");
                        userInput = scanner.nextLine();
                        makePurchase(userInput);
                    }
                    if (userInput.equals("3")) {
                        menu.createSalesReport();
                        userInput = "0";
                        isTransactionComplete = true;
                    }
                }
            }
            if (userInput.equals("3")) {
                exitProgram = true;
            }
        }
        logData.getChange(balance.getBalanceAsStr());
        logData.salesReport();
    }

    private static void feedMoney(String userInput) {
        //update balance
        balance.addToBalance(new BigDecimal(userInput));
        // update log
        logData.updateLogFeed(new BigDecimal(userInput), balance.getBalanceAsStr());
    }

    private static void makePurchase(String userInput) {
        // select Item
        Item itemSelected = menu.getItem(userInput);
        // update balance
        balance.makePurchase(itemSelected.getPrice()); // item price
        // update purchase log
        logData.updateLogPurchase(itemSelected.getName(), itemSelected.getSlotIdentifier(), itemSelected.getPrice(), balance.getBalanceAsStr());
        // update menu inventory
        menu.updateMenuInventory(itemSelected);
        // need logic for if a purchase can't be made
    }
}

