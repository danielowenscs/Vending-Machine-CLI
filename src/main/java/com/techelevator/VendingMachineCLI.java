package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.Transaction;

public class VendingMachineCLI {
	public static void main(String[] args) {
		Menu menu = new Menu();
		Log log = new Log(menu);
		menu.printMenu();
		Transaction transaction = new Transaction(menu, log);
		transaction.updateFeed(27);
		transaction.getChange();
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
