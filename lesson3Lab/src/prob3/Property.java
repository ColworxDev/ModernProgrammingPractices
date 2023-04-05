package prob3;

abstract public class Property {
	private Address address;
	
	public void setAddress(Address a) {
		address = a;
	}
	
	public Address getAddress() {
		return address;
	}
	
	abstract double computeRent();
	
	@Override
	public String toString(){ 
		return getClass().getSimpleName() + address ;
	}
	
}