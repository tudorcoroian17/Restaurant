package businessLogic;

import java.util.ArrayList;

public class CompositeProduct extends MenuItem{

	private static final long serialVersionUID = 1L;
	
	private ArrayList<MenuItem> product = new ArrayList<MenuItem>();
	
	public CompositeProduct(String name, ArrayList<MenuItem> product) {
		super();
		this.setName(name);
		this.setProduct(product);
		this.setPrice(computePrice());
	}
	
	@Override
	public double computePrice() {
		double price = 0;
		for(MenuItem it : this.product) {
			if(it.getClass().toString().contentEquals("class businessLogic.CompositeProduct")) {
				price += it.computePrice();
			} else if (it.getClass().toString().contentEquals("class businessLogic.BaseProduct")) {
				price += it.getPrice();
			}
		}
		return price;
	}
	
	public ArrayList<MenuItem> getProduct() {
		return product;
	}
	
	public void setProduct(ArrayList<MenuItem> product) {
		this.product = product;
	}

}
