package prob2;


/** 
 * Main class is for testing your code; you can uncomment
 * the code here once you have implemented classes. 
 * 
 * However, the way
 * data has been populated into the LandlordInfo and Building
 * objects violates the design indicated in the UML diagram for
 * this problem. Refactor the code in the main method so that
 * data is loaded in a correct manner; you can verify that you
 * have done this successfully by moving the Main class into a
 * different package.
 *
 */
public class Main {

	public static void main(String[] args) {
		
		Apartment[] apts0 = {
				new Apartment(600.0),
				new Apartment(700.0)};
		Apartment[] apts1 = {
				new Apartment(500.0), 
				new Apartment(450.0)
		};
		Apartment[] apts2 = {
				new Apartment(1100.0),
				new Apartment(650.0)};
//		
		Apartment[] apts3 = {
				new Apartment(6750.0), 
				new Apartment(945.0)
		};
		Building[] bldgs = {
				new Building(150.0, 400.0),
				new Building(175.0, 900.0),
				new Building(150.0, 300.0),
				new Building(175.0, 775.0)
		};
		
		for(Apartment a : apts0) {
			bldgs[0].addApartment(a);
		}
		for(Apartment a : apts1) {
			bldgs[1].addApartment(a);
		}
		for(Apartment a : apts2) {
			bldgs[2].addApartment(a);
		}
		for(Apartment a : apts3) {
			bldgs[3].addApartment(a);
		}
//		
		LandlordInfo landlord = new LandlordInfo();
		for(Building b: bldgs) {
			landlord.addBuilding(b);
		}
		System.out.println(landlord.calcProfits());

	}
}


