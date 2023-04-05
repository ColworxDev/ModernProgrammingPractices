package dataaccess;

import java.io.Serializable;

public enum Auth implements Serializable {
	LIBRARIAN, ADMIN, BOTH;
	public String getDisplayTitle() {
		switch (this) {
		case ADMIN: 
			return "(Admin)";
		case LIBRARIAN: 
			return "(Librarian)";
		default:
			return "(Both)";
		}
	}
}
