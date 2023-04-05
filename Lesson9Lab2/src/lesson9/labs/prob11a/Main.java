package lesson9.labs.prob11a;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Main {

	public static void main(String[] args) {
		List<Employee> emps = Arrays.asList(new Employee("Joe", "Davis", 120000),
				          new Employee("John", "Sims", 110000),
				          new Employee("Joe", "Stevens", 200000),
		                  new Employee("Andrew", "Reardon", 80000),
		                  new Employee("Joe", "Cummings", 760000),
		                  new Employee("Steven", "Walters", 135000),
		                  new Employee("Thomas", "Blake", 111000),
		                  new Employee("Alice", "Richards", 101000),
		                  new Employee("Donald", "Trump", 100000));

		//Part a
//		In the final line of the main method, write a stream pipeline (using filters and maps)
//		which prints, in sorted order (comma-separated, on a single line), the full names (first name + “ “ + last
//		name) of all Employees in the list whose salary is greater than $100,000 and
//		whose last name begins with any of the letters in the alphabet past the letter ‘M’
//		(so, any letters in the range ‘N’– ‘Z’). For the main method provided in your lab folder,
//		expected output is:
//		Alice Richards, Joe Stevens, John Sims, Steven Walters

		//Predicate<String> strFilter = Pattern.compile("[N-Z]").asPredicate();
		String output1 = emps.stream()
				.filter( a -> a.getSalary() > 100000 )
				.filter(a -> a.lastName.matches("[n-zN-Z]*"))
						.map(a -> Employee.fullName(a))
						.sorted()
								.collect(Collectors.joining(", "));
		System.out.println(output1);










	}
	
	
	

}
