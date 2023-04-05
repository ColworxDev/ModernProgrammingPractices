package business;

import java.util.List;

import business.Book;
import dataaccess.Auth;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

public interface ControllerInterface {
	public void login(String id, String password) throws LoginException;

	public List<LibraryMember> getAllMembers();
	public List<String> allBookIds();
	public List<Book> getAllBooks();
	public void addBookCopy(String bookId) throws LoginException;
	public Auth getCurrentAuth();
	public void addNewMemberId(String memberId, String fname, String lname, String tel,Address add) throws LoginException;
	public void addNewBook(Book book) throws LoginException;
}
