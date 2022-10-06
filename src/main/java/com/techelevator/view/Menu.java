package com.techelevator.view;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Menu {
    private static Map<Item, Integer> menu = new HashMap<Item, Integer>();

    public Menu() {
        String path = "C:/Users/Student/workspace/module-1-capstone-team-0/vendingmachine.csv";
        File dataFile = getInputFileFromUser(path);
        try (Scanner dataInput = new Scanner(dataFile)) {
            while (dataInput.hasNextLine()) {
                String lineOfText = dataInput.nextLine();
                addMenuItem(lineOfText);
            }
        } catch (FileNotFoundException e) {
            System.err.println("The file does not exist.");
        }
    }

    public static void printMenu() {
        for (Map.Entry<Item, Integer> entry : menu.entrySet()) {
            if (entry.getValue() < 1) {
                System.out.println(entry.getKey().getSlotIdentifier() + " | SOLD OUT");
            } else {
                System.out.println(entry.getKey().getSlotIdentifier() + " | " + entry.getKey().getName() + "|" + entry.getValue());
            }
        }
    }

    private static void addMenuItem(String line) {
        String[] splited = line.split("\\|");
        // need to accoount for data erors and convert string to int
        menu.put(new Item(splited[0], splited[1], splited[2], splited[3]), 5);
    }

    public void updateMenuInventory(Item item) {
        int amount = menu.get(item);
        if (!(amount < 1)) {
            menu.replace(item, amount -= 1);
        }
    }

    public Item getItem(String slotIdentifier) {
        for (Map.Entry<Item, Integer> entry : menu.entrySet()) {
            Item key = entry.getKey();
            if (key.getSlotIdentifier().equals(slotIdentifier)) {
                return key;
            }
        }
        // should not reach here need to add check
        return null;
    }

    public void createSalesReport() {
        for (Map.Entry<Item, Integer> entry : menu.entrySet()) {
            Item key = entry.getKey();
            System.out.printf("%s|%d\n", key.getName(), 5 - entry.getValue());
        }
        System.out.println();
    }

    private static File getInputFileFromUser(String path) {
        File inputFile = new File(path);
        if (inputFile.exists() == false) { // checks for the existence of a file
            System.out.println(path + " does not exist");
            System.exit(1); // Ends the program
        } else if (inputFile.isFile() == false) {
            System.out.println(path + " is not a file");
            System.exit(1); // Ends the program
        }
        return inputFile;
    }

}
