package businessLogic;

public class BaseProduct extends MenuItem{

	private static final long serialVersionUID = 1L;

	public BaseProduct(String name, double price) {
		super();
		this.setName(name);
		this.setPrice(price);
	}
	
	@Override
	public double computePrice() {
		return this.getPrice();
	}

	
}
