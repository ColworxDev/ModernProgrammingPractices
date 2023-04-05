package librarysystem;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import business.Book;
import business.ControllerInterface;
import business.LibraryMember;
import business.SystemController;
import dataaccess.Auth;

public class LibrarySystem extends JFrame implements LibWindow {
	ControllerInterface ci = new SystemController();
	public final static LibrarySystem INSTANCE = new LibrarySystem();
	JPanel mainPanel;
	JMenuBar menuBar;

	JMenu options;
	JMenuItem login, viewAllBooks, allMemberIds, addMember, logout, checkoutBook, addBookCopy, addNewBook;
	String pathToImage;
	private boolean isInitialized = false;

	Auth currentAuth = null;
	boolean isLoggedIn = false;

	private static LibWindow[] allWindows = { 
			LibrarySystem.INSTANCE, 
			LoginWindow.INSTANCE, 
			ViewCheckoutRecordWindow.INSTANCE,
			ViewAllBooks.INSTANCE,
			AddBookCopyWindow.INSTANCE,
			CheckoutWindow.INSTANCE,
			AddMemberWindow.INSTANCE,
			AddNewBookWindow.INSTANCE
		};

	public static void hideAllWindows() {
		for (LibWindow frame : allWindows) {
			frame.setVisible(false);
		}
	}

	private LibrarySystem() {
	}

	public void initAfterLoggingin() {
		if (!isInitialized) {
			hideAllWindows();

			menuBar = new JMenuBar();
			// menuBar.setBorder(BorderFactory.createRaisedBevelBorder());
			// addMenuItems();

			options = new JMenu("Options");
			menuBar.add(options);
			
			viewAllBooks = new JMenuItem("View All Books");
			viewAllBooks.addActionListener(new AllBookIdsListener());
			
			allMemberIds = new JMenuItem("View Checkout Record");
			allMemberIds.addActionListener(new AllMemberIdsListener());
			
			checkoutBook = new JMenuItem("Checkout a book");
			checkoutBook.addActionListener(new CheckoutBookListener());
			
			addBookCopy = new JMenuItem("Add book copy");
			addBookCopy.addActionListener(new AddBookCopyListener());
			addMember = new JMenuItem("Add New Member");
			addMember.addActionListener(new AddMemberListener());
			
			addNewBook = new JMenuItem("Add Book");
			addNewBook.addActionListener(new AddNewBookIdsListener());
			
			
			// login = new JMenuItem("Login");
			// login.addActionListener(new LoginListener());
			if (INSTANCE.ci.getCurrentAuth() == Auth.LIBRARIAN) {
				
				options.add(viewAllBooks);
				options.add(allMemberIds);
				options.add(checkoutBook);
			} else if (INSTANCE.ci.getCurrentAuth() == Auth.ADMIN) {
				
				options.add(viewAllBooks);
				options.add(addBookCopy);
				options.add(allMemberIds);
				options.add(addMember);
				options.add(addNewBook);
			} else if (INSTANCE.ci.getCurrentAuth() == Auth.BOTH) {
				
				options.add(viewAllBooks);
				options.add(addBookCopy);
				options.add(allMemberIds);
				options.add(checkoutBook);
				options.add(addMember);
				options.add(addNewBook);
			}

			logout = new JMenuItem("Logout");
			logout.addActionListener(new LogoutListener());
			options.add(logout);

			setJMenuBar(menuBar);

			INSTANCE.setVisible(true);
			isInitialized = true;
		}
		updateTitle();
	}
	
	private void updateTitle() {
		String title = "Sample Library Application";
		if (ci.getCurrentAuth() != null) {
			title += ci.getCurrentAuth().getDisplayTitle();
		}
		setTitle(title);
	}

	public void init() {
		if (!isInitialized) {
			formatContentPane();
			setPathToImage();
			insertSplashImage();

			createMenus();
			// pack();
			setSize(660, 500);
			isInitialized = true;
		}
	}

	private void formatContentPane() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(1, 2));
		getContentPane().add(mainPanel);
	}

	private void setPathToImage() {
		String currDirectory = System.getProperty("user.dir");
		// for Windows file system
//    	pathToImage = currDirectory+"\\src\\librarysystem\\library.jpg";
		// for unix file system
		pathToImage = currDirectory + "/src/librarysystem/library.jpg";

	}

	private void insertSplashImage() {
		ImageIcon image = new ImageIcon(pathToImage);
		mainPanel.add(new JLabel(image));
	}

	private void createMenus() {
		menuBar = new JMenuBar();
		menuBar.setBorder(BorderFactory.createRaisedBevelBorder());
		addMenuItems();
		setJMenuBar(menuBar);
	}

	private void addMenuItems() {
		options = new JMenu("Options");
		menuBar.add(options);
		login = new JMenuItem("Login");
		login.addActionListener(new LoginListener());
		/*
		allBookIds = new JMenuItem("All Book Ids");
		allBookIds.addActionListener(new AllBookIdsListener());
		allMemberIds = new JMenuItem("All Member Ids");
		allMemberIds.addActionListener(new AllMemberIdsListener());
		options.add(login);
		options.add(allBookIds);
		options.add(allMemberIds);
		*/
		options.add(login);
	}

	class LogoutListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			hideAllWindows();
			LibrarySystem.INSTANCE.setTitle("Sample Library Application");
            LibrarySystem.INSTANCE.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            INSTANCE.isInitialized = false;
			INSTANCE.isLoggedIn = false;
            LibrarySystem.INSTANCE.init();
            Util.centerFrameOnDesktop(LibrarySystem.INSTANCE);
            LibrarySystem.INSTANCE.setVisible(true);
            
			INSTANCE.currentAuth = null;
			
		}

	}

	class LoginListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LibrarySystem.hideAllWindows();
			INSTANCE.isInitialized = false;
			LoginWindow.INSTANCE.init();
			Util.centerFrameOnDesktop(LoginWindow.INSTANCE);
			LoginWindow.INSTANCE.setVisible(true);
		}

	}
	
	class AddNewBookIdsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LibrarySystem.hideAllWindows();
			INSTANCE.isInitialized = false;
			AddNewBookWindow.INSTANCE.init();
			Util.centerFrameOnDesktop(AddNewBookWindow.INSTANCE);
			AddNewBookWindow.INSTANCE.setVisible(true);
		}
	}

	class AllBookIdsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LibrarySystem.hideAllWindows();
			ViewAllBooks.INSTANCE.init();

			List<Book> ids = ci.getAllBooks();
			Collections.sort(ids, new Comparator<Book>() {

			        public int compare(Book o1, Book o2) {
			            // compare two instance of `Score` and return `int` as result.
			            return o1.getIsbn().compareTo(o2.getIsbn());
			        }
			});

			ViewAllBooks.INSTANCE.setListData(ids);

			Util.centerFrameOnDesktop(ViewAllBooks.INSTANCE);
			ViewAllBooks.INSTANCE.setVisible(true);
		}    	
    }
    
    class AddMemberListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			LibrarySystem.hideAllWindows();
			AddMemberWindow.INSTANCE.init();
			
			Util.centerFrameOnDesktop(AddMemberWindow.INSTANCE);
			AddMemberWindow.INSTANCE.setVisible(true);
		}
    	
    }
    
	class AddBookCopyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LibrarySystem.hideAllWindows();
			AddBookCopyWindow.INSTANCE.init();
			AddBookCopyWindow.INSTANCE.setVisible(true);
			Util.centerFrameOnDesktop(AddBookCopyWindow.INSTANCE);
		}

	}

	class CheckoutBookListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LibrarySystem.hideAllWindows();
			CheckoutWindow.INSTANCE.init();
			Util.centerFrameOnDesktop(CheckoutWindow.INSTANCE);
			CheckoutWindow.INSTANCE.setVisible(true);			

		}

	}

	class AllMemberIdsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			LibrarySystem.hideAllWindows();
			ViewCheckoutRecordWindow.INSTANCE.init();

			List<LibraryMember> ids = ci.getAllMembers();
			Collections.sort(ids, new Comparator<LibraryMember>() {
				@Override
				public int compare(LibraryMember o1, LibraryMember o2) {
					// TODO Auto-generated method stub
					return o2.getMemberId().compareTo(o1.getMemberId());
				}
			});
			ViewCheckoutRecordWindow.INSTANCE.setListData(ids);

			Util.centerFrameOnDesktop(ViewCheckoutRecordWindow.INSTANCE);
			ViewCheckoutRecordWindow.INSTANCE.setVisible(true);

		}

	}

	@Override
	public boolean isInitialized() {
		return isInitialized;
	}

	@Override
	public void isInitialized(boolean val) {
		isInitialized = val;

	}

}
