package edu.tridenttech.cpt187.ondo.computersales;

import java.util.ArrayList;

public class Catalog {
	private static final String[] TEST_MODEL_NAMES = {"Jaguar", "Snow Leopard", "Sabertooth" };
	private static final double[] TEST_MODEL_PRICES = {419.99, 518.99, 599.99 };
	private static final String[] TEST_MODEL_NUMBERS = {"17-010", "15-012", "13-017" };
	private static final String[] TEST_MODEL_DESCRIPTIONS = {
			"P17 laptop with microtron technology.",
			"L15 laptop with blacksmith screen.",
			"S13 laptop with altraX motherboard."
	};
			
	private static final String[] TEST_UPGRADE_NAMES = {"HD upgrade", "MEM upgrade", "Total Upgrade", "None" };
	private static final double[] TEST_UPGRADE_PRICES = {99.99, 49.99, 599.99, 0.00 };
	private static final String[] TEST_UPGRADE_DESCRIPTIONS = {
			"Add two Terabyte hard drive",
			"Add sixteen gigabyte memory card.",
			"Above upgrades plus Zenon-7 graphics card.",
			"no-upgrade added"
	};
			
	private ArrayList<Computer> baseModelList = new ArrayList<Computer>();
	private ArrayList<Upgrade> upgradeList = new ArrayList<Upgrade>();
	
	public Catalog() {
		loadModels();
		loadUpgrades();
	}

	private void loadModels() {
		for (int i=0; i < TEST_MODEL_NAMES.length; i++) {
			String name = TEST_MODEL_NAMES[i];
			String description = TEST_MODEL_DESCRIPTIONS[i];
			String modelId = TEST_MODEL_NUMBERS[i];
			double price = TEST_MODEL_PRICES[i];
			baseModelList.add(new Computer(name, modelId, description, price));
		}
	}

	private void loadUpgrades() {
		for (int i=0; i < TEST_UPGRADE_NAMES.length; i++) {
			String name = TEST_UPGRADE_NAMES[i];
			String description = TEST_UPGRADE_DESCRIPTIONS[i];
			double price = TEST_UPGRADE_PRICES[i];
			upgradeList.add(new Upgrade(name, description, price));
		}
	}
	
	public ArrayList<Computer> getBaseModelList() {
		ArrayList<Computer> copyBaseModelList = new ArrayList<Computer>(baseModelList);
		return copyBaseModelList;
	}
	
	public ArrayList<Upgrade> getUpgradeList() {
		ArrayList<Upgrade> copyUpgradeList = new ArrayList<Upgrade>(upgradeList);
		return copyUpgradeList;
	}
}