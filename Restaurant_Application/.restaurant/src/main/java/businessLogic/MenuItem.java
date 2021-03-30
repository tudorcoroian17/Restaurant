package businessLogic;

import java.io.Serializable;

public abstract class MenuItem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private double price;
	
	public abstract double computePrice();
	
	public MenuItem() {
		this.name = new String();
		this.price = 0;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
