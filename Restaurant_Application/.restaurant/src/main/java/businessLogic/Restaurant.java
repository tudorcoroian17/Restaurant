package businessLogic;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import data.WriteFile;

@SuppressWarnings("serial")
public class Restaurant extends Observable implements RestaurantProcessing, Serializable{

	private ArrayList<MenuItem> menu;
	public Map<Order, ArrayList<MenuItem>> orders;
	public ArrayList<Order> orderList;
	public Integer id = 0;
	
	public Restaurant() {
		menu = new ArrayList<MenuItem>();
		orders = new HashMap<Order, ArrayList<MenuItem>>();
		orderList = new ArrayList<Order>();
	}
	
	public BaseProduct createMenuItem(String name, double price) {
		assert name != null;
		assert price > 0;
		if (!name.matches("[a-zA-Z ]+")) return null;
		if (price <= 0) return null;
		BaseProduct product = new BaseProduct(name, price);
		return product;
	}

	public CompositeProduct createMenuItem(String name, ArrayList<MenuItem> ingredients) {
		assert name != null;
		assert ingredients != null;
		if (!name.matches("[a-zA-Z ]+")) return null;
		if (ingredients.isEmpty()) return null;
		CompositeProduct product = new CompositeProduct(name, ingredients);
		return product;
	}

	public void addItemToMenu(BaseProduct product) {
		assert product != null;
		menu.add(product);
	}

	public void addItemToMenu(CompositeProduct product) {
		assert product != null;
		menu.add(product);
	}
	
	public void addItemToMenu(MenuItem product) {
		assert product != null;
		menu.add(product);
	}

	public void addItemToCompositeProduct(String itemToAddTo, BaseProduct product) {
		assert itemToAddTo != null;
		assert product != null;
		for(MenuItem it : menu) {
			if(it.getName().contentEquals(itemToAddTo)) {
				((CompositeProduct)it).getProduct().add(product);
			}
		}
	}

	public void addItemToCompositeProduct(String itemToAddTo, CompositeProduct product) {
		assert itemToAddTo != null;
		assert product != null;
		for(MenuItem it : menu) {
			if(it.getName().contentEquals(itemToAddTo)) {
				((CompositeProduct)it).getProduct().add(product);
			}
		}
	}
	
	public void addItemToCompositeProduct(CompositeProduct itemToAddTo, CompositeProduct product) {
		assert itemToAddTo != null;
		assert product != null;
		itemToAddTo.getProduct().add(product);
	}
	
	public void addItemToCompositeProduct(CompositeProduct itemToAddTo, BaseProduct product) {
		assert itemToAddTo != null;
		assert product != null;
		itemToAddTo.getProduct().add(product);
	}

	public void deleteMenuItem(CompositeProduct product) {
		assert product != null;
		for(MenuItem it : menu) {
			if (!it.getName().contentEquals(product.getName())) return;
		}
		menu.remove(product);
		product.setName("");
		product.setPrice(0);
		product.setProduct(null);
		product = null;
	}

	public void deleteMenuItem(BaseProduct product) {
		assert product != null;
		for(MenuItem it : menu) {
			if (!it.getName().contentEquals(product.getName())) return;
		}
		menu.remove(product);
		product.setName("");
		product.setPrice(0);
		product = null;
	}

	public void deleteMenuItem(String name) {
		assert name != null;
		MenuItem product = null;
		for(MenuItem it : menu) {
			if (it.getName().contentEquals(name)) {
				product = it;
			}
		}
		if (product == null) return;
		menu.remove(product);
	}

	public void editMenuItem(CompositeProduct product, ArrayList<MenuItem> ingredients, double newPrice) {
		assert product != null;
		assert ingredients != null;
		assert newPrice > 0;
		for(MenuItem it : menu) {
			if (it.getName().contentEquals(product.getName())) {
				if (ingredients != null) ((CompositeProduct) it).getProduct().addAll(ingredients);
				if (newPrice != 0) it.setPrice(newPrice);
			}
		}
	}

	public void editMenuItem(BaseProduct product, double newPrice) {
		assert product != null;
		assert newPrice > 0;
		for(MenuItem it : menu) {
			if (it.getName().contentEquals(product.getName())) {
				if (newPrice != 0) it.setPrice(newPrice);
			}
		}
	}

	public void editMenuItem(String name, ArrayList<MenuItem> ingredients, double newPrice) {
		assert name != null;
		assert ingredients != null;
		assert newPrice > 0;
		for(MenuItem it : menu) {
			if (it.getName().contentEquals(name)) {
				if (ingredients != null) ((CompositeProduct) it).getProduct().addAll(ingredients);
				if (newPrice != 0) it.setPrice(newPrice);
			}
		}
	}

	public void editMenuItem(String name, double newPrice) {
		assert name != null;
		assert newPrice > 0;
		for(MenuItem it : menu) {
			if (it.getName().contentEquals(name)) {
				if (newPrice != 0) it.setPrice(newPrice);
			}
		}
	}

	public Order createOrder(int id, int day, int month, int year, int table, ArrayList<MenuItem> products) {
		assert id >= 0;
		assert day >= 1 && day <= 31;
		assert month >= 1 && month <= 12;
		assert year >= 1990 && year <= 2020;
		assert table > 0;
		assert products != null;
		if(day < 1 && day > 31) return null;
		if(month < 1 && month > 12) return null;
		if(year < 1990 && year > 2020) return null;
		DateT date = new DateT(day, month, year);
		Order order = new Order(id, date, table);
		return order;
	}

	public double computePrice(CompositeProduct product) {
		assert product != null;
		return product.computePrice();
	}

	public double computePrice(BaseProduct product) {
		assert product != null;
		return product.computePrice();
	}
	
	public double computePrice(Order order) {
		assert order != null;
		double price = 0;
		for(MenuItem it : this.orders.get(order)) {
			price = price + it.getPrice();
		}
		return price;
	}

	public void generateBill(Order order, int price, WriteFile writer) {
		assert order != null;
		assert price > 0;
		assert writer != null;
		String[] stringBuilder = new String[4];
		stringBuilder[0] = "Order number: " + order.getOrderID().toString();
		stringBuilder[1] = "Order date: " + Integer.toString(order.getOrderDate().getDay())
				   + "." + Integer.toString(order.getOrderDate().getMonth())
				   + "." + Integer.toString(order.getOrderDate().getYear());
		stringBuilder[2] = "Table: " + Integer.toString(order.getTable());
		stringBuilder[3] = "Price: " + Integer.toString(price);
		
		writer.setDataWritten(stringBuilder);
		try {
			writer.write();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<MenuItem> getMenu() {
		return menu;
	}

	public void setMenu(ArrayList<MenuItem> menu) {
		this.menu = menu;
	}

	public void addOrder(Order order, ArrayList<MenuItem> products) {
		assert order != null;
		assert products != null;
		this.orderList.add(order);
		orders.put(order, products);
		setChanged();
		notifyObservers();
	}

	

}
