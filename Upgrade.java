package edu.tridenttech.cpt187.ondo.computersales;

public class Upgrade {
	private String name;
	private String description;
	private double price;

	public Upgrade(String name, String description, double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public Upgrade(Upgrade upgr) {
		this.name = upgr.name;
		this.description = upgr.description;
		this.price = upgr.price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
}