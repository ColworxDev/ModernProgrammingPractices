package lesson4Lab;

public class Hourly extends Employee {
	
	private Double hourlyWage;
	private Double hoursPerWeek;

	public Hourly(int empId, Double hourly, Double hpWeek) {
		// TODO Auto-generated constructor stub
		super(empId);
		this.hourlyWage = hourly;
		this.hoursPerWeek = hpWeek;
	}

	@Override
	public Double calcGrossPay(int month, int year) {
		// TODO Auto-generated method stub
		//4 weeks per month
		return (hourlyWage * hoursPerWeek) * 4;
	}

}
