package prob2;

public class Apartment {
	
	private String name;
	private Double rentalFee;

	public Apartment() {
		// TODO Auto-generated constructor stub
		name = "Appartment";
		rentalFee = 0.0;
	}
	
	public Apartment(Double fee) {
		// TODO Auto-generated constructor stub
		this.name = "Apartment";
		this.rentalFee = fee;
	}
	
	
	public Double getRentalFee() {
		return rentalFee;
	}
	
	public void setRentalFee(Double fee) {
		this.rentalFee = fee;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		this.name = n;
	}
}
