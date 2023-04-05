package prob2;

import java.util.ArrayList;
import java.util.List;

public class LandlordInfo {
	
	private List<Building> buildings;

	public LandlordInfo() {
		// TODO Auto-generated constructor stub
		buildings = new ArrayList<>();
	}
	
	public Double calcProfits() {
		Double profits = 0.0;
		for (Building b : buildings) {
			profits += b.getMonthlyProfit();
		}
		return profits;
	}
	
	public void addBuilding(Building b) {
		this.buildings.add(b);
	}
	
	

}
