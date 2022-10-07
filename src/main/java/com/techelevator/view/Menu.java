package com.techelevator.view;

import java.io.*;
import java.util.*;


public class Menu {
    private static List<Item> menu = new ArrayList<Item>();

    public Menu() {
        setMenu();
    }

    public static void printMenu() {
        for (Item entry : menu) {
            if (entry.getAmount() < 1) {
                System.out.printf("%s | SOLD OUT", entry.getSlotIdentifier());
            }
            else {
                System.out.printf("%s | %s | %s | %d\n", entry.getSlotIdentifier(), entry.getName(), entry.getPrice().toString(), entry.getAmount());
            }
        }
    }

    public void updateMenuInventory(Item item) {
       item.setAmount(item.getAmount()-1);
    }

    public Item getItem(String slotIdentifierToFind) {
        for (Item entry : menu) {
            if (entry.getSlotIdentifier().equals(slotIdentifierToFind)) {
                return entry;
            }
        }
        // code should not reach here
        return null;
    }

    public void createSalesReport() {
        for (Item entry : menu) {
            System.out.printf("%s|%d\n", entry.getName(), 5 - entry.getAmount());
        }
        System.out.println();
    }

    private static void setMenu() {
        try {
            File dataFile = new File ("C:\\Users\\Student\\workspace\\module-1-capstone-team-0\\vendingmachine.csv");
            Scanner myReader = new Scanner(dataFile);
            while (myReader.hasNextLine()) {
                String[] splittedData =myReader.nextLine().split("\\|");
                menu.add(new Item(splittedData[0], splittedData[1], splittedData[2], splittedData[3]));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("The file does not exist.");
        }
    }
}
