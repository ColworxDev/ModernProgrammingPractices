package prob2;


import java.util.ArrayList;
import java.util.List;

public class Building {
	
	private String name;
	private Double maintainanceCost;
	private List<Apartment> appartments;
	
	public Building(){
		this.name = "";
		this.appartments = new ArrayList<>();
		this.maintainanceCost = 0.0;
	}

	public Building(Double cost, Double rentalFee) {
		// TODO Auto-generated constructor stub
		name = "Building";
		maintainanceCost = cost;
		appartments = new ArrayList<>();
		addApartment(new Apartment());
	}
	
	public void addApartment(Apartment a) {
		appartments.add(a);
	}
	
	public String getName() {
		return name;
	}
	
	public List<Apartment> getApartmentList() {
		return appartments;
	}

	public void setApartmentList(List<Apartment> apartmentList) {
		this.appartments = apartmentList;
	}
	
	public Double getMaintainceCost() {
		return maintainanceCost;
	}
	
	public void setMaintenanceCost(Double maintenanceCost) {
		this.maintainanceCost = maintenanceCost;
	}
	
	public Double getMonthlyProfit(){
		Double profit = 0.0;
		for(int i=0;i<appartments.size();i++){
			Apartment apt = appartments.get(i);
			profit += apt.getRentalFee();
		}
		profit -= maintainanceCost;
		return profit;
	}
	
	@Override
	public String toString(){
		return this.name +" monthly profit is "+ getMonthlyProfit();
	}

}
