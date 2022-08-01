package edu.tridenttech.cpt187.ondo.computersales;

import java.util.ArrayList;
import java.util.Scanner;

public class ComputerStore {
	
	public static final String OPTION_NEW_SALE = "New sale";
	public static final String OPTION_MOD_BASE_PRICE = "Modify base price";
	public static final String OPTION_MOD_UPGRADE_PRICE = "Modify upgrade price";
	public static final String OPTION_LIST_SALES = "List sales for the day";
	public static final String OPTION_QUIT = "Quit";

	public static void main(String[] args) {
		Catalog catalog = new Catalog();
		Scanner keyboard = new Scanner(System.in);
		ArrayList<Computer> baseModelList = catalog.getBaseModelList();
		ArrayList<Upgrade> upgradeList = catalog.getUpgradeList();
		ArrayList<Purchase> dailySales = new ArrayList<>();
		char baseModelSelection = 0;
		char upgradeSelection = 0;
		char mainSelection = ' ';
		
		mainSelection = getMainSelection(keyboard);
		while (mainSelection != 'Q') {
			switch (mainSelection) {
			
			case 'A':
				baseModelSelection = getValidatedComputerSelection(keyboard, baseModelList);
				upgradeSelection = getValidatedUpgradeSelection(keyboard, upgradeList);
				int baseSelect = baseModelSelection - 65;
				int upgradeSelect = upgradeSelection - 65;
				Computer comp = new Computer(baseModelList.get(baseSelect));
				Upgrade upgr = new Upgrade(upgradeList.get(upgradeSelect));
				Purchase purchase = new Purchase(comp, upgr);
				displaySaleHeader();
                displaySale(purchase);
				dailySales.add(purchase);
				break;
				
			case 'B'://modify base model price
				baseModelSelection = getComputerPriceModSelect(keyboard, baseModelList);
				int selModel = baseModelSelection - 65;
				System.out.println("What is the new price?");
				double newPrice = keyboard.nextDouble();
				baseModelList.get(selModel).setPrice(newPrice);		
				break;
			
			case 'C'://modify upgrade price
			    upgradeSelection = getUpgradePriceModSelect(keyboard, upgradeList);
			    int selUpgrade = baseModelSelection - 65;
				System.out.println("What is the new price?");
				double newUpgradePrice = keyboard.nextDouble();
				upgradeList.get(selUpgrade).setPrice(newUpgradePrice);
				break;
			
			case 'D':
			    displaySaleHeader();
				displayDailySales(dailySales);
			
			} //end switch
			mainSelection = getMainSelection(keyboard);
		} //end !Q
		displayDailySales(dailySales);
	} //end main method
	
	private static void displayMainMenu(){
		System.out.println();
		System.out.println("Main Menu");
		System.out.println("==========");
		System.out.printf("%-4s %-12s \n", "A)", OPTION_NEW_SALE);
		System.out.printf("%-4s %-12s \n", "B)", OPTION_MOD_BASE_PRICE);
		System.out.printf("%-4s %-12s \n", "C)", OPTION_MOD_UPGRADE_PRICE);
		System.out.printf("%-4s %-12s \n", "D)", OPTION_LIST_SALES);
		System.out.printf("%-4s %-8s \n", "Q)", OPTION_QUIT);
		System.out.print("Your selection: ");
		System.out.println();
	}
	
	private static char getMainSelection(Scanner keyboard) {
		char selection = 'A';
		displayMainMenu();
		selection = keyboard.next().toUpperCase().charAt(0);
		return selection;
	}	
		
	private static char getValidatedComputerSelection(Scanner keyboard, ArrayList<Computer> modelList) {
		char selection = 0;
        selection = displayComputerMenu(keyboard, modelList);
        while (!validateComputerSelection(selection, modelList)) {
        	System.out.println("Invalid selection. Please re-enter your selection.");
			selection = displayComputerMenu(keyboard, modelList);
        }
		return selection;
	}

	private static char displayComputerMenu(Scanner input, ArrayList<Computer> modelList) {
		char selection = 0;
		char selChar = 'A';
		System.out.println("Which model of computer would you like?\nSelect from the following menu:");
		for(Computer comp : modelList) {
			System.out.printf("%c) %-15s%-45s%8.2f%n", selChar, comp.getName(), comp.getDescription(), comp.getPrice());
			selChar++;
		}
		System.out.println("Q) Quit");
		selection = input.next().charAt(0);
		return Character.toUpperCase(selection);
	}
	
	private static boolean validateComputerSelection(char selection, ArrayList<Computer> modelList) {
		boolean isValid = true; // assumption is false
		int testNdx = selection - 'A';
		// menu is A,B,C... for each item in the list
		if (testNdx < 0 || testNdx > modelList.size()) {
			isValid = false;
		}
		return isValid;
	}
	
	private static char getValidatedUpgradeSelection(Scanner input, ArrayList<Upgrade> upgradeList) {
		char selection = 0;
        selection = displayUpgradeMenu(input, upgradeList);
        while (!validateUpgradeSelection(selection, upgradeList)) {
        	System.out.println("Invalid selection. Please re-enter your selection.");
			selection = displayUpgradeMenu(input, upgradeList);
        }
		return selection;
	}

	private static char displayUpgradeMenu(Scanner input, ArrayList<Upgrade> upgradeList) {
		char selection = 0;
		char selChar = 'A';
		System.out.println("Which upgrade would you like?\n" + 
						   "Select from the following menu:");
		for(Upgrade upgr : upgradeList) {
			System.out.printf("%c) %-15s%-45s%8.2f%n", selChar,
					upgr.getName(), upgr.getDescription(), upgr.getPrice());
			selChar++;
		}
		selection = input.next().charAt(0);
		return Character.toUpperCase(selection);
	}

	private static boolean validateUpgradeSelection(char selection, ArrayList<Upgrade> upgradeList) {
		boolean isValid = true; // assumption is false
		int testNdx = selection - 'A';
		// menu is A,B,C... for each item in the list
		if (testNdx < 0 || testNdx > upgradeList.size()) {
			isValid = false;
		}
		return isValid;
	}
	
	private static char getComputerPriceModSelect(Scanner input, ArrayList<Computer> modelList) {
		char selection = 0;
		char selChar = 'A';
		System.out.println("Which computer price would you like to change?");
		System.out.println("Select from the following menu:");
		for(Computer comp : modelList) {
			System.out.printf("%c) %-15s%8.2f%n", selChar, comp.getName(), comp.getPrice());
			selChar++;
		}
		selection = input.next().charAt(0);
		return Character.toUpperCase(selection);
	}
	
	private static char getUpgradePriceModSelect(Scanner input, ArrayList<Upgrade> upgradeList) {
    	char selection = 0;
    	char selChar = 'A';
	    System.out.println("Which upgrade price would you like to change?");
    	System.out.println("Select from the following menu:");
    	for(Upgrade upg : upgradeList) {
	    	System.out.printf("%c) %-15s%8.2f%n", selChar, upg.getName(), upg.getPrice());
		    selChar++;
    	}
	    selection = input.next().charAt(0);
		return Character.toUpperCase(selection);
	}
	
	private static void displaySale(Purchase purchase){
	    System.out.printf("%-15s %-15s %10.2f %15.2f %10.2f%n", purchase.getModelName(),
	                 purchase.getUpgradeName(), purchase.getModelPrice(),
	                purchase.getUpgradePrice(),	purchase.getTotalPrice());
	}

	private static void displayDailySales(ArrayList<Purchase> dailySales) {
		for (Purchase purchase : dailySales) {
            displaySale(purchase);
		}
	}
	
	private static void displaySaleHeader(){
	    System.out.printf("%-15s %-15s %10s %15s %10s%n", "Computer",
	                "Upgrade", "Base Price", "Upgrade Price", "Total");	    
	}
}