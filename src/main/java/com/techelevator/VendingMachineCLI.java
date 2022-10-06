package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.Balance;
import com.techelevator.LogData;
import java.math.BigDecimal;
import java.util.Scanner;


public class VendingMachineCLI {
	private static Balance balance = new Balance();

	private static Menu menu;
	private static LogData log;
	public static void main(String[] args) {
		Menu menu = new Menu();
		boolean isPurchaseComplete=false;
		boolean isTransactionComplete=false;
		Scanner scanner = new Scanner(System.in);


		while(!isPurchaseComplete) {
			System.out.println("(1) Display Vending Machine Items");
			System.out.println("(2) Purchase");
			System.out.println("(3) Exit");
			String userInput = scanner.nextLine();
			if (userInput.equals("1")) {
				menu.printMenu();
			}








			if (userInput.equals("2")) {
				System.out.println("(1) Feed Money");
				System.out.println("(2) Select Product");
				System.out.println("(3) Finish Transaction");
				userInput = scanner.nextLine();
				while (!isTransactionComplete) {
					if (userInput.equals("1")) {
						//feed money
						System.out.println("Enter Money: ");
						userInput = scanner.nextLine();
						feedMoney(userInput);
					}
					if (userInput.equals("2")) {
						//select product
						System.out.println("Enter product ID: ");
						userInput = scanner.nextLine();
						makePurchase(userInput);

					}
					if (userInput.equals("3")) {
						isTransactionComplete=true;
					}
				}


			}



			if (userInput.equals("3")) {
				isPurchaseComplete = true;
			}
		}

//		LogData log = new LogData(menu);
//
//		//prints menu
//		//
//		Balance balance = new Balance();
//		//menu.printMenu();
//		// Make Feed
//		// steps are ...
//		// 1. get user Input
//
//
//		userInput = "5.00";
//		balance.addToBalance(new BigDecimal(userInput));
//		balance.addToBalance(new BigDecimal(userInput));
//		System.out.println(balance.getBalance());
//		// 2. update log
//		log.updateLogFeed(new BigDecimal(userInput), balance.getBalance());
//
//		// Make Purchase
//		// steps are ...
//		// 1. Ask user to enter slot identifier
//		userInput = "A4";
//		// 2. select Item
//		Item itemSelected = menu.getItem(userInput);
//		// 3. update balance
//		balance.addToBalance(itemSelected.getPrice()); // item price
//		// 4. update purchase log
//		log.updateLogPurchase(itemSelected.getName(), itemSelected.getPrice(), balance.getBalance());
//		// 5. update menu inventory
//		menu.updateMenuInventory(itemSelected);
//		//menu.printMenu();
//		log.updateLogPurchase(itemSelected.getName(), itemSelected.getPrice(), balance.getBalance());





		//this is responsible for making a feed and updating the log
//		int feedAmt = 27;
//		transaction.makeFeed(feedAmt);
//		log.updateLogFeed(transaction.getMoney(), feedAmt);
//
//		// this gets the change
//		transaction.getChange();
	}



	private static void makePurchase(String userInput){
		// steps are ...
		// 2. select Item
		Item itemSelected = menu.getItem(userInput);
		// 3. update balance
		balance.makePurchase(itemSelected.getPrice()); // item price
		// 4. update purchase log
		log.updateLogPurchase(itemSelected.getName(), itemSelected.getPrice(), balance.getBalance());
		// 5. update menu inventory
		menu.updateMenuInventory(itemSelected);
		//menu.printMenu();
		// log needed for if purchace cant be made

}


	private static void feedMoney(String userInput){
		balance.addToBalance(new BigDecimal(userInput));
		log.updateLogFeed(new BigDecimal(userInput), balance.getBalance());

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
