package prob3;

import java.util.ArrayList;
import java.util.List;

public class Admin {
	public static double computeTotalRent(Property[] properties) {
		double totalRent = 0;
		for (Property o : properties) {
			totalRent += o.computeRent();
//			below code not needed anymore
//			if (o instanceof House) {
//				House h = (House) o;
//				totalRent += h.computeRent();
//			}
//			else if (o instanceof Condo) {
//				Condo h = (Condo) o;
//				totalRent += h.computeRent();
//			}
//			else if (o instanceof Trailer) {
//				Trailer h = (Trailer) o;
//				totalRent += h.computeRent();
//			}	
		}
		return totalRent;
	}
	
	public static void listAllProperties(String inSpecifiedCity, Property[] props) {
		for (Property property : props) {
			if (property.getAddress().getCity() == inSpecifiedCity) {
				System.out.println(property);
			}
		}
	}
}
