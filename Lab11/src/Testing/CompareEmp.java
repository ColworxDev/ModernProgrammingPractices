package Testing;

import java.util.Comparator;

public class CompareEmp {
	
	static Comparator<Employee> comp = Comparator.comparing(Employee::getName)
			.thenComparing(Employee::getSalary, Comparator.reverseOrder());

	static int CompareTwoEmployee(Employee e1, Employee e2) {
		return comp.compare(e1, e2);
	}

}
