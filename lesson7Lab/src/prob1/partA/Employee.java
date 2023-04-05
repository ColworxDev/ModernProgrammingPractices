package prob1.partA;

public class Employee {
	private String name;
	private int salary;
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override 
	public String toString() {
		return "(" + name + ", " + salary + ")";
	}
	
	
	/*
	 * Answer 1 is Method parameter must have Object Paramter type and add override annotation
	 */
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj == null) return false;
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee e = (Employee) obj;
		return e.name.equals(name) && e.salary == salary;
		
	}
	
//	public boolean equals(Employee e) {
//		return e.name.equals(name) && e.salary == salary;
//	}
//	public boolean equals(Object ob) {
//		Employee e = (Employee)ob;
//		return e.name.equals(name) && e.salary == salary;
//	}
}
