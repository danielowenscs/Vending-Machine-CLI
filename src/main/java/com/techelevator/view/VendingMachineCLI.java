package com.techelevator.view;

import com.techelevator.view.Item;
import com.techelevator.view.LogData;
import com.techelevator.view.Menu;
import com.techelevator.view.Balance;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachineCLI {
    private static VendingMachine vendingMachine = new VendingMachine();
    public static void main(String[] args) {
        boolean isTransactionComplete = false;
        boolean isProgramOver = false;
        String userInput;


        while (!isProgramOver) {

            System.out.println("(1) Display Vending Machine Items");
            System.out.println("(2) Purchase");
            System.out.println("(3) Exit\n");
            System.out.print("Your Choice: ");
            userInput = vendingMachine.getUserInput();
            System.out.println();
            try {
                if (userInput.equals("1")) {
                    printMenu();
                    System.out.println();
                } else if (userInput.equals("2")) {
                    while (!isTransactionComplete) {
                        vendingMachine.displayBalance();
                        System.out.println("(1) Feed Money");
                        System.out.println("(2) Select Product");
                        System.out.println("(3) Finish Transaction");
                        System.out.println();
                        displayBalance();
                        System.out.println();
                        System.out.print("Your Choice: ");
                        userInput = vendingMachine.getUserInput();
                        System.out.println();


                        if (userInput.equals("1")) {
                            try {

                                System.out.print("Enter The Amount Of Money To Add (format 0.00): ");
                                userInput = vendingMachine.getUserInput();
                                System.out.println();
                                vendingMachine.feedMoney(userInput);
                            } catch (Exception e){
                                System.out.println("ERROR: Please Enter Correct Format");
                            }

                        }
                        else if (userInput.equals("2")) {
                                printMenu();
                                System.out.println();
                                System.out.print("Enter The Slot Identifier Of The Product You Wish To Purchase: ");
                                userInput = vendingMachine.getUserInput();
                                System.out.println();
                                Item itemSelected = vendingMachine.makePurchase(userInput);
                                System.out.printf("%s | %s | %5.2f | %s%n", itemSelected.getName(), itemSelected.getPrice().toString(), vendingMachine.getBalance(), itemSelected.getPhrase());
                                System.out.println();

                        } else if (userInput.equals("3")) {
                            vendingMachine.finishTransaction();
                            System.out.println();
                            isTransactionComplete = true;
                        } else {
                            System.out.println("Invalid Input Please Pick (1) (2) (3)");
                        }
                    }
                    isTransactionComplete = false;
                }
                else if (userInput.equals("3")) {
                    isProgramOver = true;
                } else {
                }
            }
            catch (Exception e){
                System.out.println("NOT VALID INPUT");
            }
        }


    }


    private static void printMenu () {
        Menu menu = vendingMachine.getMenu();
        ArrayList <Item> menuItems = new ArrayList<Item>();
        for (Item entry : menu.getMenu()) {
            if (entry.getAmount() < 1) {
                System.out.printf("%s | SOLD OUT\n", entry.getSlotIdentifier());
            }
            else {
                System.out.printf("%s | %s | %s | %d\n", entry.getSlotIdentifier(), entry.getName(), entry.getPrice().toString(), entry.getAmount());
            }
        }
    }

    private static void displayBalance() {
        System.out.printf("Current Money Provided: $%5.2f %n", vendingMachine.getBalance());
    }





}

//    private static Menu menu = new Menu();
//    private static Balance balance = new Balance();
//    private static LogData logData = new LogData();
//
//    public static void main(String[] args) throws FileNotFoundException {
//
//        boolean exitProgram = false;
//        boolean isTransactionComplete = false;
//        Scanner scanner = new Scanner(System.in);
//
//        while (!exitProgram) {
//
//            System.out.println("(1) Display Vending Machine Items");
//            System.out.println("(2) Purchase");
//            System.out.println("(3) Exit\n");
//            System.out.print("Your Choice: ");
//            String userInput = scanner.nextLine();
//            System.out.println();
//
//            if (userInput.equals("1")) {
//                menu.printMenu();
//                System.out.println();
//            }
//            if (userInput.equals("2")) {
//                while (!isTransactionComplete) {
//
//                    System.out.printf("Current Money Provided: $%s\n\n", balance.getBalanceAsStr());
//                    System.out.println("(1) Feed Money");
//                    System.out.println("(2) Select Product");
//                    System.out.println("(3) Finish Transaction\n");
//                    System.out.print("Your Choice: ");
//                    userInput = scanner.nextLine();
//                    System.out.println();
//
//                    if (userInput.equals("1")) {
//                        System.out.print("Enter The Amount Of Money To Add (format 0.00): ");
//                        userInput = scanner.nextLine();
//                        System.out.println();
//                        feedMoney(userInput);
//                    }
//                    if (userInput.equals("2")) {
//                        menu.printMenu();
//                        System.out.println();
//                        System.out.print("Enter The Slot Identifier Of The Product You Wish To Purchase: ");
//                        userInput = scanner.nextLine();
//                        makePurchase(userInput);
//                    }
//                    if (userInput.equals("3")) {
//                        logData.getChange(balance.getBalanceAsStr());
//                        System.out.println(balance.getChange());
//                        userInput = "0";
//                        isTransactionComplete = true;
//                    }
//                }
//            }
//            if (userInput.equals("3")) {
//                // creates transaction report file
//                logData.transactionReport();
//
//                // creates sales report file
//                menu.createSalesReport();
//
//                exitProgram = true;
//            }
//        }
//    }
//
//    private static void feedMoney(String userInput) {
//        //update balance
//        balance.addToBalance(new BigDecimal(userInput));
//        // update log
//        logData.updateLogFeed(new BigDecimal(userInput), balance.getBalanceAsStr());
//    }
//
//    private static void makePurchase(String userInput) {
//        // select Item
//        Item itemSelected = menu.getItem(userInput);
//        // update balance
//        balance.makePurchase(itemSelected.getPrice()); // item price
//        // update purchase log
//        logData.updateLogPurchase(itemSelected.getName(), itemSelected.getSlotIdentifier(), itemSelected.getPrice(), balance.getBalanceAsStr());
//        // update menu inventory
//        menu.updateMenuInventory(itemSelected);
//        // need logic for if a purchase can't be made
//        System.out.printf("%s | %s | %s | %s\n\n", itemSelected.getName(), itemSelected.getPrice().toString(), balance.getBalanceAsStr(), itemSelected.getPhrase());
//    }
//}

