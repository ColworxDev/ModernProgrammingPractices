package business;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckoutRecordEntity implements Serializable {
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private BookCopy bookCopy;
	
	public CheckoutRecordEntity(LocalDate checkoutDate, LocalDate dueDate, BookCopy bookCopy) {
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
		this.bookCopy = bookCopy;
	}
	
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public BookCopy getBookCopy() {
		return bookCopy;
	}

	public void setBookCopy(BookCopy bookCopy) {
		this.bookCopy = bookCopy;
	}

}
