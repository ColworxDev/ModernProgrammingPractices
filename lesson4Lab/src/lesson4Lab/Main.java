package lesson4Lab;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> emps = new ArrayList<>();
		
		emps.add(new Salaried(1, 50.0));
		emps.add(new Hourly(2, 5.0, 40.0));
		
		Employee cmp = new Commissioned(3, 1.5, 50.0);
		
		LocalDate prev = LocalDate.now().minusMonths(1);
		((Commissioned)cmp).addOrder(new Order(1, prev, 50));
		((Commissioned)cmp).addOrder(new Order(2, prev, 40));
		emps.add(cmp);
		
		
		int month = LocalDate.now().getMonthValue();
		int year = LocalDate.now().getYear();
		for (Employee employee : emps) {
			Paycheck paycheck = employee.calcCompensation(month, year);
			System.out.println(paycheck + "\nNetPay= " + paycheck.getNetPay());
			System.out.println("\n\n");
		}
	}

}
