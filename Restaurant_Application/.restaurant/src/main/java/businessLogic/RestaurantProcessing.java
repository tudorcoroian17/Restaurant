package businessLogic;

import java.util.ArrayList;

import data.WriteFile;

public interface RestaurantProcessing {

	//methods accessible only for administrator
	/**
	 * @pre name != null
	 * @pre price > 0
	 * @post BaseProduct bp != null
	 * @param name
	 * @param price
	 * @return BaseProduct
	 */
	public BaseProduct createMenuItem(String name, double price);
	/**
	 * @pre name != null
	 * @pre ingredients != null
	 * @post CompositeProduct cp != null
	 * @param name
	 * @param ingredients
	 * @return CompositeProduct
	 */
	public CompositeProduct createMenuItem(String name, ArrayList<MenuItem> ingredients);
	/**
	 * @pre product != null
	 * @param product
	 */
	public void addItemToMenu(BaseProduct product);
	/**
	 * @pre product != null
	 * @param product
	 */
	public void addItemToMenu(CompositeProduct product);
	/**
	 * @pre product != null
	 * @param product
	 */
	public void addItemToMenu(MenuItem product);
	/**
	 * @pre itemToAdd != null
	 * @pre product != null
	 * @param itemToAdd
	 * @param product
	 */
	public void addItemToCompositeProduct(String itemToAdd, BaseProduct product);
	/**
	 * @pre itemToAdd != null
	 * @pre product != null
	 * @param itemToAdd
	 * @param product
	 */
	public void addItemToCompositeProduct(String itemToAdd, CompositeProduct product);
	/**
	 * @pre itemToAdd != null
	 * @pre product != null
	 * @param itemToAddTo
	 * @param product
	 */
	public void addItemToCompositeProduct(CompositeProduct itemToAddTo, CompositeProduct product);
	/**
	 * @pre itemToAdd != null
	 * @pre product != null
	 * @param itemToAddTo
	 * @param product
	 */
	public void addItemToCompositeProduct(CompositeProduct itemToAddTo, BaseProduct product);
	/**
	 * @pre product != null
	 * @param product
	 */
	public void deleteMenuItem(CompositeProduct product);
	/**
	 * @pre product != null
	 * @param product
	 */
	public void deleteMenuItem(BaseProduct product);
	/**
	 * @pre name != null
	 * @param name
	 */
	public void deleteMenuItem(String name);
	/**
	 * @pre product != null
	 * @pre ingredients != null
	 * @pre newPrice > 0
	 * @param product
	 * @param ingredients
	 * @param newPrice
	 */
	public void editMenuItem(CompositeProduct product, ArrayList<MenuItem> ingredients, double newPrice);
	/**
	 * @pre product != null
	 * @pre newPrice > 0
	 * @param product
	 * @param newPrice
	 */
	public void editMenuItem(BaseProduct product, double newPrice);
	/**
	 * @pre name != null
	 * @pre ingredients != null
	 * @pre newPrice > 0
	 * @param name
	 * @param ingredients
	 * @param newPrice
	 */
	public void editMenuItem(String name, ArrayList<MenuItem> ingredients,double newPrice);
	/**
	 * @pre name != null
	 * @pre newPrice > 0
	 * @param name
	 * @param newPrice
	 */
	public void editMenuItem(String name, double newPrice);
	
	//methods accessible only for waiter
	/**
	 * @pre id >= 0
	 * @pre day >= 1 && day <= 31
	 * @pre month >= 1 && month <= 12
	 * @pre year >= 1990 && year <= 2020
	 * @pre table > 0
	 * @pre products != null
	 * @post Order o != null
	 * @param id
	 * @param day
	 * @param month
	 * @param year
	 * @param table
	 * @param products
	 * @return Order
	 */
	public Order createOrder(int id, int day, int month, int year, int table, ArrayList<MenuItem> products);
	/**
	 * @pre product != null
	 * @post price > 0
	 * @param product
	 * @return double
	 */
	public double computePrice(CompositeProduct product);
	/**
	 * @pre product != null
	 * @post price > 0
	 * @param product
	 * @return double
	 */
	public double computePrice(BaseProduct product);
	/**
	 * @pre order != null
	 * @pre price > 0
	 * @pre writer != null
	 * @param order
	 * @param price
	 * @param writer
	 */
	public void generateBill(Order order, int price, WriteFile writer);
	/**
	 * @pre order != null
	 * @pre products != null
	 * @param order
	 * @param products
	 */
	public void addOrder(Order order, ArrayList<MenuItem> products);
	
}
