package edu.tridenttech.cpt187.ondo.computersales;

public class Computer {
	private String name;
	private String model;
	private String description;
	private double price;

	public Computer(String name, String model, String description, double price) {
		this.name = name;
		this.model = model;
		this.description = description;
		this.price = price;
	}
	
	public Computer(Computer comp) {
		this.name = comp.name;
		this.model = comp.model;
		this.description = comp.description;
		this.price = comp.price;
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

	public String getModel() {
		return model;
	}

	public String getDescription() {
		return description;
	}
}
