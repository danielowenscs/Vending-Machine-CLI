package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.Balance;

import java.math.BigDecimal;


public class VendingMachineCLI {
	private static Menu menu;
	public static void main(String[] args) {
		Menu menu = new Menu();
		LogData log = new LogData(menu);
		String userInput;
		//prints menu
		//menu.printMenu();
		Balance balance = new Balance();
		//menu.printMenu();
		// Make Feed
		// steps are ...
		// 1. get user Input
		userInput = "5.00";
		balance.addToBalance(new BigDecimal(userInput));
		balance.addToBalance(new BigDecimal(userInput));
		System.out.println(balance.getBalance());
		// 2. update log
		log.updateLogFeed(new BigDecimal(userInput), balance.getBalance());

		// Make Purchase
		// steps are ...
		// 1. Ask user to enter slot identifier
		userInput = "A4";
		// 2. select Item
		Item itemSelected = menu.getItem(userInput);
		// 3. update balance
		balance.addToBalance(itemSelected.getPrice()); // item price
		// 4. update purchase log
		log.updateLogPurchase(itemSelected.getName(), itemSelected.getPrice(), balance.getBalance());
		// 5. update menu inventory
		menu.updateMenuInventory(itemSelected);
		//menu.printMenu();
		log.updateLogPurchase(itemSelected.getName(), itemSelected.getPrice(), balance.getBalance());





		//this is responsible for making a feed and updating the log
//		int feedAmt = 27;
//		transaction.makeFeed(feedAmt);
//		log.updateLogFeed(transaction.getMoney(), feedAmt);
//
//		// this gets the change
//		transaction.getChange();
	}

}




















//package com.techelevator;
//
//import com.techelevator.view.Menu;
//
//public class VendingMachineCLI {
//
//	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
//	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
//	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
//
//	private Menu menu;
//
//	public static void main(String[] args) {
//		Menu menu = new Menu(System.in, System.out);
//		VendingMachineCLI cli = new VendingMachineCLI(menu);
//		cli.run();
//	}
//
//	public VendingMachineCLI(Menu menu) {
//		this.menu = menu;
//	}
//
//	public void run() {
//
//		/*
//		  ===== you nay use/modify the existing Menu class or write your own ======
//		while (true) {
//			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
//
//			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
//				// display vending machine items
//			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
//				// do purchase
//			}
//		}
//		 */
//	}
//
//}
