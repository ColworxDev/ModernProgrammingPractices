package lesson4Lab;

public class Salaried extends Employee {
	
	Double salary;

	public Salaried(int empId, Double sal) {
		// TODO Auto-generated constructor stub
		super(empId);
		this.salary = sal;
	}

	@Override
	public Double calcGrossPay(int month, int year) {
		// TODO Auto-generated method stub
		return salary;
	}

}
