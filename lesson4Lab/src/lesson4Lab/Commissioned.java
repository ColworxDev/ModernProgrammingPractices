package lesson4Lab;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Commissioned extends Employee {
	
	private Double commission;
	private Double baseSalary;
	private List<Order> orderList;

	public Commissioned(int empId, Double comm, Double baseSalary) {
		// TODO Auto-generated constructor stub
		super(empId);
		this.commission = comm;
		this.baseSalary = baseSalary;
		this.orderList = new ArrayList<>();
	}
	
	public void addOrder(Order order) {
		orderList.add(order);
	}

	@Override
	public Double calcGrossPay(int month, int year) {
		// TODO Auto-generated method stub
		
		Double total = 0.0;
		for (Order order : orderList) {
			if (isPreviousMonth(order.getOrderDate(), month, year)) {
				total += order.getOrderAmount();
			}
		}
		return baseSalary + (total * commission);
	}
	
	private Boolean isPreviousMonth(LocalDate orderDate, int month, int year) {
		return (orderDate.getMonthValue() == month - 1) && orderDate.getYear() == year;
	}

}
