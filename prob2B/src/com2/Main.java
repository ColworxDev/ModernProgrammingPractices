package com2;

import com.Order;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		
		Order o1 = new Order(0, "first order", 200);
		o1.addOrderLine("second order", 300);
		System.out.println(o1);
		
		System.out.println("This is second order");
		Order o2 = new Order(0, "second order", 400);
		o2.addOrderLine("third order", 500);
		System.out.println(o2);
		
		
		//Cannot call OrderLine from outside its package
		//new new OrderLine(title, cost, this);
		
	}

}
