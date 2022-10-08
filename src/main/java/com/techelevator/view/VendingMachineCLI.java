package com.techelevator.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// balance cannot be higher than $100
public class VendingMachineCLI {
    private static VendingMachine vendingMachine = new VendingMachine();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isTransactionComplete = false;
        boolean isProgramOver = false;
        String userInput;
        while (!isProgramOver) {

            System.out.println("(1) Display Vending Machine Items");
            System.out.println("(2) Purchase");
            System.out.println("(3) Exit");
            System.out.println();
            System.out.print("Your Choice: ");
            userInput = getUserInput();
            System.out.println();
            if (userInput.equals("1")) {
                printMenu();
                System.out.println();
            } else if (userInput.equals("2")) {
                while (!isTransactionComplete) {
                    printBalance();
                    System.out.println();
                    System.out.println("(1) Feed Money");
                    System.out.println("(2) Select Product");
                    System.out.println("(3) Finish Transaction");
                    System.out.println();
                    System.out.print("Your Choice: ");
                    userInput = getUserInput();
                    System.out.println();
                    if (userInput.equals("1")) {
                        System.out.print("Enter The Amount Of Money To Add (format 0.00): $");
                        userInput = getUserInput();
                        System.out.println();
                        handelFeedInput(userInput);
                    } else if (userInput.equals("2")) {
                        printMenu();
                        System.out.println();
                        System.out.print("Enter The Slot Identifier Of The Product You Wish To Purchase: ");
                        userInput = getUserInput();
                        System.out.println();
                        handelPurchase(userInput);

                        System.out.println();
                    } else if (userInput.equals("3")) {
                        printChange();
                        System.out.println();
                        isTransactionComplete = true;
                    } else {
                        System.out.println(getErrorMessage());
                        System.out.println();
                    }
                }
                isTransactionComplete = false;
            } else if (userInput.equals("3")) {
                vendingMachine.endProgram();
                isProgramOver = true;
            } else {
                System.out.println(getErrorMessage());
                System.out.println();
            }
        }
    }

    // get user input
    private static String getUserInput() {
        String userInput = scanner.nextLine();
        return userInput;
    }

    private static void handelFeedInput(String userInput) {
        if (!vendingMachine.isValidFeed(userInput)) {
            System.out.println("Invalid Input, Balance Can Be At Most $100.00 And A Feed Must Be At Least $0.01, Please Try Again!");
            System.out.println();
        } else {
            vendingMachine.feedMoney(userInput);
        }
    }

    private static void handelPurchase(String userInput) {
        if (!vendingMachine.isSlotIdentifierValid(userInput)){
            System.out.println("ERROR: Slot Identifier Not Valid");
        }
        else if(!vendingMachine.isStockValid(userInput)){
            System.out.println("ERROR: Not in Stock");
        }
        else if(!vendingMachine.isValidFunds(userInput)){
            System.out.println("ERROR: Invalid Funds");
        }
        else {
            Item itemSelected = vendingMachine.makePurchase(userInput);
            printReceipt(itemSelected);
        }
    }

    private static String getErrorMessage() {
        return "The Option You Selected Is Not Available, Please Try Again!";
    }

    private static void printMenu() {
        Menu menu = vendingMachine.getMenu();
        ArrayList<Item> menuItems = new ArrayList<Item>();
        System.out.println("+--------------------------------------------+");
        System.out.println("|                    MENU                    |");
        System.out.println("+----+--------------------+-------+----------+");
        System.out.println("| ID | Name               | Price | Stock    |");
        System.out.println("+----+--------------------+-------+----------+");
        for (Item entry : menu.getMenu()) {
            if (entry.getAmount() < 1) {
                System.out.printf("| %s | %-18s | $%2.2f | SOLD OUT |%n", entry.getSlotIdentifier(), entry.getName(), entry.getPrice());
            } else {
                System.out.printf("| %s | %-18s | $%2.2f | %d        |%n", entry.getSlotIdentifier(), entry.getName(), entry.getPrice(), entry.getAmount());
            }
        }
        System.out.println("+----+--------------------+-------+----------+");
    }

    private static void printBalance() {
        System.out.printf("Current Money Provided: $%.2f %n", vendingMachine.getBalance());
    }

    private static void printReceipt(Item itemSelected) {
        System.out.println("+-------------------------------------------+");
        System.out.println("|              Purchase Receipt             |");
        System.out.println("+----+--------------------+-------+---------+");
        System.out.println("| ID | Name               | Price | Balance |");
        System.out.println("+----+--------------------+-------+---------+");
        System.out.printf("| %s | %-18s | %2.2f  | %-7.2f |%n", itemSelected.getSlotIdentifier(), itemSelected.getName(), itemSelected.getPrice(), vendingMachine.getBalance());
        System.out.println("+----+--------------------+-------+---------+");
        System.out.println(itemSelected.getPhrase());


    }

    // format change
    public static void printChange() {
        Map<String, Integer> changeAsMap = new HashMap<String, Integer>();
        changeAsMap = vendingMachine.getChange();
        if (changeAsMap == null) {
            printBalance();
            return;
        }
        printBalance();
        System.out.println("+-------------------+");
        System.out.println("|    Your Change    |");
        System.out.println("+-------------------+");
        for (Map.Entry<String, Integer> entry : changeAsMap.entrySet()) {
            System.out.printf("| %-6s | %-8s |%n", entry.getValue(), entry.getKey());
        }
        System.out.println("+--------+----------+");
        vendingMachine.finishTransaction();
        printBalance();
    }
}

