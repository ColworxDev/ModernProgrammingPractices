package lesson8.labs.prob6;
import java.util.Comparator;
import java.util.function.*;

public class Examples {
	
	
	//type: Class::instanceMethod
	//Example 1 : (String x) -> x.toUpperCase()
	Function<String, String> upper1 = (String x) -> x.toUpperCase();

	Function<String, String> upper2 = String::toUpperCase;

	//type:  Class::instanceMethod
	//1: A (Employee e) -> e.getName()
	Function<Employee, String> eToString1 = e -> e.getName();
	Function<Employee, String> eToString2 = Employee::getName;

	//type: Class::instanceMethod
	//1: B (Employee e,String s) -> e.setName(s)
	BiConsumer<Employee, String> setName1 = (e, s) -> e.setName(s);
	BiConsumer<Employee, String> setName2 = Employee::setName;

	//type: Class::instanceMethod
	//1: C  (String s1,String s2) -> s1.compareTo(s2)
	Comparator<String> strComp1 = (s1, s2) -> s1.compareTo(s2);
	Comparator<String> strComp2 = String::compareTo;

	//type: Class::staticMethod
	//1: D (Integer x,Integer y) -> Math.pow(x,y)
	BiFunction<Integer, Integer, Double> min1 = (x, y) -> Math.pow(x,y);
	BiFunction<Integer, Integer, Double> min2 = Math::pow;

	//type: Class::instanceMethod
	//1: E  (Apple a) -> a.getWeight()
	Function<Apple, Double> appleWeight1 = (Apple a) -> a.getWeight();
	Function<Apple, Double> appleWeight2 = Apple::getWeight;

	//type: Class::staticMethod
	//1: F (String x) -> Integer.parseInt(x);
	Function<String, Integer> parser1 = x -> Integer.parseInt(x);
	Function<String, Integer> parser2 = Integer::parseInt;

	//type: obj::instanceMethod
	//1: G EmployeeNameComparator comp = new EmployeeNameComparator();
	//(Employee e1, Employee e2) -> comp.compare(e1,e2)
	EmployeeNameComparator comp = new EmployeeNameComparator();
	Comparator<Employee> empComp1 = (e1, e2) -> comp.compare(e1,e2);
	Comparator<Employee> empComp2 = comp::compare;
	
	
	public void evaluator() {
		System.out.println(upper2.apply("hello"));

		Employee testEmp = new Employee("John", 100000);
		Apple testApple = new Apple(4.5);
		System.out.println(upper2.apply("hello"));
		System.out.println(eToString2.apply(testEmp));


		setName2.accept(testEmp,"Ralph");
		System.out.println(testEmp.getName());

		System.out.println(strComp2.compare("a", "b"));
		System.out.println(min2.apply(2,10));
		System.out.println(appleWeight2.apply(testApple));

		System.out.println(parser2.apply("15"));

		System.out.println(empComp2.compare(testEmp, new Employee("John", 100000)));

		
	}
	
	public static void main(String[] args) {
		Examples e = new Examples();
		e.evaluator();
		
	}

	@FunctionalInterface
	public interface NoArgNoReturn {
		void act();
	}

	static class Apple {
		Apple(double weight) {
			this.weight = weight;
		}
		private double weight;
		public double getWeight() {
			return weight;
		}
	}
	
}
