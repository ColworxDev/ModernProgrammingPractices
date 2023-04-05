package com;

public class OrderLine {
	
	private double cost;
	private String title;
	private Order order;
	
	//package level visibility
	OrderLine(String title, double cost, Order order) {
		this.title = title;
		this.cost = cost;
		this.order = order;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public String toString() {
		return "title = " + title + ", cost = " + cost;
	}

}
