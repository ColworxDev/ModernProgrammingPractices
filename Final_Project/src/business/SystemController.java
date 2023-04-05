package business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dataaccess.Auth;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.User;

public class SystemController implements ControllerInterface {
	public static Auth currentAuth = null;
	
	public Auth getCurrentAuth() {
		return currentAuth;
	}
	
	public void login(String id, String password) throws LoginException {
		DataAccess da = new DataAccessFacade();
		HashMap<String, User> map = da.readUserMap();
		if(!map.containsKey(id)) {
			throw new LoginException("ID " + id + " not found");
		}
		String passwordFound = map.get(id).getPassword();
		if(!passwordFound.equals(password)) {
			throw new LoginException("Password incorrect");
		}
		currentAuth = map.get(id).getAuthorization();
		
	}
	@Override
	public List<LibraryMember> getAllMembers() {
		DataAccess da = new DataAccessFacade();
		List<LibraryMember> retval = new ArrayList<>();
		
		retval.addAll(da.readMemberMap().values());
		return retval;
	}
	
	
	@Override
	public List<String> allBookIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readBooksMap().keySet());
		return retval;
	}
	
	public List<Book> getAllBooks() {
		DataAccess da = new DataAccessFacade();
		List<Book> retval = new ArrayList<>();
		//retval.addAll(da.readBooksMap().keySet());
		retval.addAll(da.readBooksMap().values());
		return retval;
	}
	
	public void addNewBook(Book book) throws LoginException {
		if (allBookIds().contains(book.getIsbn())) {
			throw new LoginException("book isbn already exists in system");
		}
		DataAccess da = new DataAccessFacade();
		da.saveNewBook(book);
	}

	

  
	public void addBookCopy(String bookId) throws LoginException {
		if(bookId == null || bookId.length() == 0) {
			throw new LoginException("please enter a book ID !!");
		}
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		HashMap<String, Book> registeredBooks = da.readBooksMap();
		retval.addAll(registeredBooks.keySet());
		if(retval.contains(bookId) ) {
			registeredBooks.get(bookId).addCopy();
		} else {
			throw new LoginException("Book ID not found !!");
		}
		List<Book> registeredBooksList = new ArrayList<>();
		registeredBooksList.addAll(registeredBooks.values());
		DataAccessFacade.loadBookMap(registeredBooksList);
	}
	
  	
  	public void saveMemberList(List<LibraryMember> members) throws LoginException {
  		DataAccessFacade.loadMemberMap(members);
  	}
  	
  	public void saveBookList(List<Book> books) throws LoginException {
  		DataAccessFacade.loadBookMap(books);
  	}

	public HashMap<String, LibraryMember> allMembers() {
		DataAccess da = new DataAccessFacade();
		return da.readMemberMap();
	}
	
	public HashMap<String,Book> allBooks() {
		DataAccess da = new DataAccessFacade();
		return da.readBooksMap();
	}
	
	public void checkout(String memberId, String isbn) throws LoginException {
		LibraryMember member = null;
		HashMap<String, LibraryMember> memberMap = allMembers();
		for (String memberID : memberMap.keySet()) {
			if (memberId.equals(memberID)) {
				member = memberMap.get(memberId);
				break;
			}
		}
		
		if (member != null) {
			Book book = null;
			HashMap<String, Book> bookMap = allBooks();
			for (String bookId : bookMap.keySet()) {
				if (bookId.equals(isbn)) {
					book = bookMap.get(bookId);
					break;
				}
			}
			if (book != null) {
				BookCopy copy = book.getNextAvailableCopy();
				if (copy == null) {
					throw new LoginException("No copy available");
				}
				member.checkout(copy, LocalDate.now(), book.getMaxCheckoutLength());
//				JOptionPane.showMessageDialog(this, "checkout successfully");
				saveMemberList(new ArrayList<>(memberMap.values()));
				saveBookList(new ArrayList<>(bookMap.values()));
				
			} else {
				throw new LoginException("ISBN is not correct");
			}    					
		} else {
			throw new LoginException("Member Id is not correct");
		}
	}
	
	
	public void addNewMemberId(String memberId, String fname, String lname, String tel,Address add) throws LoginException {
		if(getCurrentAuth() != Auth.ADMIN ) {
			throw new LoginException("Only admin can add Member");
		}
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		HashMap<String, LibraryMember> registeredBooks = da.readMemberMap();
		retval.addAll(registeredBooks.keySet());
		if(retval.contains(memberId) ) {
			throw new LoginException("Member already exist");
		} else {
			da.saveNewMember(new LibraryMember(memberId, fname, lname, tel, add));
			//registeredBooks.get(memberId).addCopy();
		}
//		List<Book> registeredBooksList = new ArrayList<>();
//		registeredBooksList.addAll(registeredBooks.values());
//		DataAccessFacade.loadBookMap(registeredBooksList);
		
	}
	
}
