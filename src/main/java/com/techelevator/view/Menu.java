package  com.techelevator.view;

import com.techelevator.Item;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Menu {
	private static Map<Item, Integer> menu = new HashMap<Item, Integer>();

	public Menu () {
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


	public static void printMenu () {
		for (Map.Entry<Item,Integer> entry : menu.entrySet()) {
			if (entry.getValue() < 1) {
				System.out.println(entry.getKey().getSlotIdentifier() + " | SOLD OUT");
			}
			else {
				System.out.println(entry.getKey().getSlotIdentifier() + " | " + entry.getKey().getName() + "|" + entry.getValue());
			}
		}
	}

	private static void addMenuItem (String line) {
		String[] splited = line.split("\\|");
		// need to accoount for data erors and convert string to int
		menu.put(new Item (splited[0], splited[1], splited[2], splited[3]), 5);
	}

	public void updateMenuInventory (Item item) {
		int amount = menu.get(item);
		if (!(amount < 1)) {
			menu.replace(item, amount-=1);
		};
	}
	public Item getItem (String slotIdentifier) {
		for (Map.Entry<Item,Integer> entry : menu.entrySet()) {
			Item key = entry.getKey();
			if (key.getSlotIdentifier().equals(slotIdentifier)) {
				return key;
			}
		}
		// should not reach here need to add check
		return null;
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








//package com.techelevator.view;
//
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.io.PrintWriter;
//import java.util.Scanner;
//
//public class Menu {
//
//	private PrintWriter out;
//	private Scanner in;
//
//	public Menu(InputStream input, OutputStream output) {
//		this.out = new PrintWriter(output);
//		this.in = new Scanner(input);
//	}
//
//	public Object getChoiceFromOptions(Object[] options) {
//		Object choice = null;
//		while (choice == null) {
//			displayMenuOptions(options);
//			choice = getChoiceFromUserInput(options);
//		}
//		return choice;
//	}
//
//	private Object getChoiceFromUserInput(Object[] options) {
//		Object choice = null;
//		String userInput = in.nextLine();
//		try {
//			int selectedOption = Integer.valueOf(userInput);
//			if (selectedOption > 0 && selectedOption <= options.length) {
//				choice = options[selectedOption - 1];
//			}
//		} catch (NumberFormatException e) {
//			// eat the exception, an error message will be displayed below since choice will be null
//		}
//		if (choice == null) {
//			out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
//		}
//		return choice;
//	}
//
//	private void displayMenuOptions(Object[] options) {
//		out.println();
//		for (int i = 0; i < options.length; i++) {
//			int optionNum = i + 1;
//			out.println(optionNum + ") " + options[i]);
//		}
//		out.print(System.lineSeparator() + "Please choose an option >>> ");
//		out.flush();
//	}
}
