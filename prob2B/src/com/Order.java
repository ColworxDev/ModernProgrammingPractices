package com;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private int orderNum; 
	private List<OrderLine> orderLines;

	public Order(int num, String orderTitle, int cost) {
		this.orderNum = num;
		orderLines = new ArrayList<>();
		addOrderLine(orderTitle, cost);
		
	}
	
	public void addOrderLine(String title, int cost){
		orderLines.add(new OrderLine(title, cost, this));
	}
	
	public String toString() {
		String str = "";
		for (OrderLine orderLine : orderLines) {
			str += orderLine.toString() + " \n";
		}
		return "orderNum = " + orderNum + "\norderlines are below \n" + str;
	}

}
