package lesson4Lab;

public enum Deduct {
	
	FICA(.23), State(.05), Local(.01), Medicare(.03), 
	   SocialSecurity(.075);
	
	private double val;
	private Deduct(double val) {
		this.val = val;
	}
	public double getVal() {
		return val;
	}
}
