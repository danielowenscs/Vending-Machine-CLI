package com.techelevator.view;

import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;


public class Menu {
    private static List<Item> menu = new ArrayList<Item>();

    public Menu() {
        setMenu();
    }

    // this updates the menu inventory by subtracting 1 from the inventory
    public void updateMenuInventory(Item item) {
       item.setAmount(item.getAmount()-1);
    }

    // returns the instance of item in the menu that corresponds to the item
    // if it cannot find the item it returns null
    public Item getItem(String slotIdentifierToFind) {
        for (Item entry : menu) {
            if (entry.getSlotIdentifier().equals(slotIdentifierToFind)) {
                return entry;
            }
        }
        return null;
    }

    // returns menu as a list
    public List<Item> getMenu() {
        return menu;
    }

    // this method reads data from the vendingmachine.csv file and then adds it to a list
    private static void setMenu() {
        try {
            final File dataFile = new File ("vendingmachine.csv");
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
