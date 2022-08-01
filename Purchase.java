package edu.tridenttech.cpt187.ondo.computersales;

public class Purchase {
	private Computer mod;
	private Upgrade upg;
	
	public Purchase(Computer model, Upgrade upgrade) {
		    mod = new Computer(model);
		    upg = new Upgrade(upgrade);
		}
	
	public String getModelName() {
		return mod.getName();
	}
	
	public double getModelPrice() {
		return mod.getPrice();
	}
	
	public String getUpgradeName() {
		return upg.getName();
	}
	
	public double getUpgradePrice() {
		return upg.getPrice();
	}
	
	public double getTotalPrice() {
		return mod.getPrice() + upg.getPrice();
	}
}
