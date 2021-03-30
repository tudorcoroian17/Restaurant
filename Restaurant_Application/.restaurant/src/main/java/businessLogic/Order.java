package businessLogic;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Order implements Serializable{

	private Integer orderID;
	private DateT orderDate;
	private int table;
	
	public Order(int id, DateT date, int table) {
		this.orderID = id;
		this.orderDate = date;
		this.table = table;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == null) return false;
		if (this.getClass() != object.getClass()) return false;
		
		Order order = (Order) object;
		if(this.orderID != order.getOrderID()) return false;
		if(this.orderDate != order.getOrderDate()) return false;
		if(this.table != order.getTable()) return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int hash = 31;
		hash += hash*3 + 7*table + 41*orderID + 11*orderDate.getDay(); 
		return hash;
	}
	
	public Integer getOrderID() {
		return orderID;
	}
	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}
	public DateT getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(DateT orderDate) {
		this.orderDate = orderDate;
	}
	public int getTable() {
		return table;
	}
	public void setTable(int table) {
		this.table = table;
	}
	
}
