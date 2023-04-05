package lesson9.labs.prob1.business;

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lesson9.labs.prob1.dataaccess.DataAccess;
import lesson9.labs.prob1.dataaccess.DataAccessFacade;
import lesson9.labs.prob1.business.Book;
import lesson9.labs.prob1.business.LibraryMember;

public class Main {

	public static void main(String[] args) {
		System.out.println(allWhoseZipContains3());
		System.out.println(allHavingAtLeastTwoCopies());
		System.out.println(allHavingMultipleAuthors());

	}
	//Returns a list of all ids of LibraryMembers whose zipcode contains the digit 3
	public static List<String> allWhoseZipContains3() {


		DataAccess da = new DataAccessFacade();

		Collection<LibraryMember> members = da.readMemberMap().values();
		//(new DataAccessFacade()).readMemberMap().values().stream() //We can also apply below code to more shorten :D
//		List<LibraryMember> mems = new ArrayList<>();
//		mems.addAll(members);
		//Verifying below
		//members.forEach((m1) -> System.out.println(m1.getMemberId() + " " + m1.getAddress().getZip()));
		//implement

		//List<String> members2 = members.stream().filter(val-> val.getAddress().getZip().contains("3")).map(m1->m1.getMemberId()).collect(Collectors.toList());
		return members.stream().filter(val-> val.getAddress().getZip().contains("3")).map(LibraryMember::getMemberId).collect(Collectors.toList());
	}
	//Returns a list of all isbns of books having at least two copies
	public static List<String> allHavingAtLeastTwoCopies() {
		DataAccess da = new DataAccessFacade();
		Collection<Book> books = da.readBooksMap().values();
		//(new DataAccessFacade()).readBooksMap().values().stream() //apply below code :D
//		List<Book> bs = new ArrayList<>();
//		bs.addAll(books);
		//Verifying below
		//books.forEach((m1) -> System.out.println(m1.getIsbn() + " " + m1.getNumCopies()));
		//implement
		return books.stream().filter(b1 -> b1.getNumCopies()>1 ).map(Book::getIsbn).collect(Collectors.toList());
		
	}

	//Returns a list of all isbns of  Books that have multiple authors
	public static List<String> allHavingMultipleAuthors() {
		DataAccess da = new DataAccessFacade();
		Collection<Book> books = da.readBooksMap().values();
		List<Book> bs = new ArrayList<>();
		bs.addAll(books);
		//Verifying below
		//books.forEach((m1) -> System.out.println(m1.getIsbn() + " " + m1.getAuthors().size()));
		//(new DataAccessFacade()).readBooksMap().values().stream() //apply below code :D
		//implement
		return books.stream().filter(b1->b1.getAuthors().size()>1).map(Book::getIsbn).collect(Collectors.toList());
		}

}
