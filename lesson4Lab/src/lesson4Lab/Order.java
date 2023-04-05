package lesson4Lab;

import java.time.LocalDate;

public class Order {
	
	private int orderNo;
	private LocalDate orderDate;
	private int orderAmount;

	public Order(int orderNo, LocalDate orderDate, int orderAmount) {
		// TODO Auto-generated constructor stub
		this.orderNo = orderNo;
		this.orderDate = orderDate;
		this.orderAmount = orderAmount;
	}
	
	public LocalDate getOrderDate() {
		return orderDate;
	}
	
	public int getOrderAmount() {
		return orderAmount;
	}
	
	public int getOrderNo() {
		return orderNo;
	}
	
	

}
