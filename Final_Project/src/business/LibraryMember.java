package business;

import java.io.Serializable;
import java.time.LocalDate;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;


final public class LibraryMember extends Person implements Serializable {
	private String memberId;
	private CheckoutRecord checkoutRecord;
	
	public LibraryMember(String memberId, String fname, String lname, String tel,Address add) {
		super(fname,lname, tel, add);
		this.memberId = memberId;		
	}
	
	
	public String getMemberId() {
		return memberId;
	}

	public void checkout(BookCopy copy, LocalDate todaysDate, int maxLength) {
		copy.isAvailable(false);
		CheckoutRecordEntity entity = new CheckoutRecordEntity(todaysDate, todaysDate.plusDays(maxLength),copy);
		if (checkoutRecord == null) {
			checkoutRecord = new CheckoutRecord(entity);
		} else {
			checkoutRecord.addEntity(entity);
		}
	}
	
	
	public void addCheckoutRecord(CheckoutRecord checkoutRecord) {
 		this.checkoutRecord = checkoutRecord;
 	}

 	public CheckoutRecord getCheckoutRecord() {
 		return checkoutRecord;
 	}
	
	@Override
	public String toString() {
		return "Member Info: " + "ID: " + memberId + ", name: " + getFirstName() + " " + getLastName() + 
				", " + getTelephone() + " " + getAddress();
	}

	private static final long serialVersionUID = -2226197306790714013L;
}
