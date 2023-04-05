import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		
		A a = new A("Tim");
		A a2 = new A("Tim");
		B b = new B();
		
		
//		System.out.println(a.equals(a2));
		
//		System.out.println(
//				Optional.of("23a")
//				.flatMap(x -> Optional.of(Integer.valueOf(x)))
//				
//				.map(x -> x - x).orElse(999));
		
		//System.out.println(Optional.of("23").map(x -> "").orElseGet(() -> "none"));
		//System.out.println(Optional.of(23).flatMap(x -> Optional.ofNullable(null)).orElseGet(() -> "none"));
		
		 Optional.of(23).flatMap(x -> Optional.ofNullable(46)).ifPresent(System.out::println);
	}
	
	static class A {
		
		public String name = "";
		
		public A (String name) {
			this.name = name;
		}
		
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			A obj1 = (A)obj;
			return this.name.equals(obj1.name);
		}
		
		
		
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return 2;
		}
	}
	
	static class B {
		
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return 2;
		}
	}
	
	public class EmployeeInfo {
        public void sort(List<Employee> emps, Employee e) {
             Collections.sort(emps, (e1, e2) -> {
                  e.setSalary(10000.00);
                  return e1.name.compareToIgnoreCase(e2.name);
             }); }
	}
	
	static class Employee {
		String name;
		Double salary;
		
		public Employee(String n, Double sal) {
			this.name = n;
			this.salary = sal;
		}
		
		public void setSalary(Double sal) {
			
		}
	}
	
	public interface Predicate{
        boolean apply(Number n);
        String toString();
}
   public interface SubPredicate extends Predicate {
        boolean apply(Integer n);
}

   

}
