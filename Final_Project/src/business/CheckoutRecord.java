package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord implements Serializable {
	private List<CheckoutRecordEntity> checkoutRecordEntities = new ArrayList<CheckoutRecordEntity>();

	public CheckoutRecord(CheckoutRecordEntity checkoutRecordEntity) {
		addEntity(checkoutRecordEntity);
	}
	
	public List<CheckoutRecordEntity> getCheckoutRecordEntities() {
		return checkoutRecordEntities;
	}

	public void addEntity(CheckoutRecordEntity checkoutRecordEntity) {
		checkoutRecordEntities.add(checkoutRecordEntity);
	}
	

}
