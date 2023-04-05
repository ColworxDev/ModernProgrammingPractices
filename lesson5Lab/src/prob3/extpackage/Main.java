package prob3.extpackage;

import java.time.LocalDate;

import prob3.CustOrderFactory;
import prob3.Customer;
import prob3.Order;

public class Main {
	public static void main(String[] args) {
		
		//Customer cust2 = new Customer;
		
		Customer cust = CustOrderFactory.createCustomer("Bob");
		Order order = CustOrderFactory.newOrder(cust, LocalDate.now());
		order.addItem(CustOrderFactory.newItem("Shirt"));
		order.addItem(CustOrderFactory.newItem("Laptop"));

		order = CustOrderFactory.newOrder(cust, LocalDate.now());
		order.addItem(CustOrderFactory.newItem("Pants"));
		order.addItem(CustOrderFactory.newItem("Knife set"));

		System.out.println(cust.getOrders());
	}
}

		
