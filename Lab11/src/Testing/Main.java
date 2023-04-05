package Testing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

	public int add(int x, int y) {
		return x + y;
	}
	
	public static void main(String[] args) {
		List<Employee> employee = Arrays.asList(
				new Employee("Jim", 5000),
				new Employee("Tim", 5500),
				new Employee("Kim", 6000),
				new Employee("Lim", 8000)
				);
		
		
		
		employee.stream()
		.sorted(
				CompareEmp.comp
//				Comparator.comparing(Employee::getName)
//				.thenComparing(Employee::getSalary, Comparator.reverseOrder())
				)
		.forEach(System.out::println);
		
		Employee e1 = new Employee("Tim", 5000);
		Employee e2 = new Employee("Lim", 5000);
		
		assert(CompareEmp.CompareTwoEmployee(e1, e2) > 0);
		
		
		
				
	}
}
