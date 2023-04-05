package Testing;

public class Employee {
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
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

	private String name;
	private int salary;

	public Employee(String name, int sal) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.salary = sal; 
	}

}
