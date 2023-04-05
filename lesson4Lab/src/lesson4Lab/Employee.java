package lesson4Lab;

public abstract class Employee {
	
	private int empID;

	public Employee(int employeeId) {
		// TODO Auto-generated constructor stub
		this.empID = employeeId;
	}
	
	public void print() {
		System.out.println("Employeeid = " + empID);
	}
	
	public Paycheck calcCompensation(int month, int year) {
		Double grossPay = calcGrossPay(month, year);
		Paycheck pc = new Paycheck(grossPay, Deduct.FICA.getVal(), Deduct.State.getVal(), Deduct.Local.getVal(), Deduct.Medicare.getVal(), Deduct.SocialSecurity.getVal());
		return pc;
	}
	
	abstract public Double calcGrossPay(int month, int year);

}
