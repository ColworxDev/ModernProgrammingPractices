package lesson4Lab;

public class Paycheck {
	
	private Double grossPay;
	private Double fica;
	private Double state;
	private Double local;
	private Double medicare;
	private Double socialSecurity;

	public Paycheck(Double grosspay, Double fica, Double state, Double local, Double medicare, Double socialSecurity) {
		// TODO Auto-generated constructor stub
		this.grossPay = grosspay;
		this.fica = fica;
		this.state = state;
		this.local = local;
		this.medicare = medicare;
		this.socialSecurity = socialSecurity;
	}
	
	public String print() {
		return toString();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "grossPay = " + grossPay + "\n" +
				"fica = " + fica + "\n" + 
				"state = " + state + "\n" +
				"local = " + local + "\n" +
				"medicare = " + medicare + "\n" +
				"socialSecurity = " + socialSecurity;
	}
	
	public Double getNetPay() {
		return grossPay - grossPay * fica 
						- grossPay * state
						- grossPay * local
						- grossPay * medicare
						- grossPay * socialSecurity;
	}

}
