package prob3;


public class Trailer extends Property {
	private static final double RENT = 500;
	
	public Trailer(Address address) {
		this.setAddress(address);
	}
	
	public double computeRent(){
		return RENT;
	}
	
}