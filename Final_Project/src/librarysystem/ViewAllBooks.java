package librarysystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import business.Book;
import business.CheckoutRecordEntity;
import business.ControllerInterface;
import business.LibraryMember;
import business.SystemController;



public class ViewAllBooks extends JFrame implements LibWindow {
	private static final long serialVersionUID = 1L;
	public static final ViewAllBooks INSTANCE = new ViewAllBooks();
    ControllerInterface ci = new SystemController();
    private boolean isInitialized = false;
	
	private JPanel mainPanel;
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel lowerPanel;

	private GenericTablePanel bookList;
	private GenericTablePanel tableData;
	private List<Book> bookListData = new ArrayList<>();

	

	//Singleton class
	private ViewAllBooks() {}
	
	public void init() {
		if (!isInitialized) {
			mainPanel = new JPanel();
			mainPanel.setLayout(new BorderLayout());
			defineTopPanel();
			defineMiddlePanel();
			defineLowerPanel();
			mainPanel.add(topPanel, BorderLayout.NORTH);
			mainPanel.add(middlePanel, BorderLayout.CENTER);
			mainPanel.add(lowerPanel, BorderLayout.SOUTH);
			getContentPane().add(mainPanel);
			setSize(660, 500);
			isInitialized = true;
		}
	}
	
	public void defineTopPanel() {
		topPanel = new JPanel();
		JLabel AllIDsLabel = new JLabel("View All Books");
		Util.adjustLabelFont(AllIDsLabel, Util.DARK_BLUE, true);
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		topPanel.add(AllIDsLabel);
	}
	
	public void defineMiddlePanel() {
		middlePanel = new JPanel();
		middlePanel.setLayout(new BorderLayout());
		
		bookList = new GenericTablePanel(new MyRowSelectionListener());
		tableData = new GenericTablePanel(null);
		
		middlePanel.add(bookList, BorderLayout.NORTH);
		
		middlePanel.add(new JLabel("Checkout by Below Members",SwingConstants.CENTER), BorderLayout.CENTER);
		middlePanel.add(tableData, BorderLayout.SOUTH);
		clearTableData();
	}
	
	public void defineLowerPanel() {
		
		JButton backToMainButn = new JButton("<= Back to Main");
		backToMainButn.addActionListener(new BackToMainListener());
		lowerPanel = new JPanel();
		lowerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));;
		lowerPanel.add(backToMainButn);
	}
	
	class BackToMainListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			LibrarySystem.hideAllWindows();
			LibrarySystem.INSTANCE.setVisible(true);
    		
		}
	}
	
	private void clearTableData() {
		String[] columns = new String[] {
				"Name", "Checkout Date", "Due Date", "OverDue"	
		};
		String[][] rows = new String[][] {};
		tableData.refreshDataWith(columns, rows);
	}
	
	public void setListData(List<Book> data) {
		bookListData = data;
		String[] columns = new String[] {
				"Isbn", "Title", "No Of Copies", "Checkout Length", "IsAvailable"
		};
		String[][] rows = new String[data.size()][columns.length];
		int index = 0;
		for(Book book: data) {
			if(index < data.size()) {
				
				rows[index++] = new String[] {
						 book.getIsbn(),
						 book.getTitle(),
						 Integer.toString(book.getNumCopies()),
						 Integer.toString(book.getMaxCheckoutLength()),
						 Boolean.toString(book.isAvailable())
				};
			}
			
		}
		bookList.refreshDataWith(columns, rows);
		//bookList.setListData(data.toArray(new String[0]));
	}
	

	@Override
	public boolean isInitialized() {
		// TODO Auto-generated method stub
		return isInitialized;
	}

	@Override
	public void isInitialized(boolean val) {
		isInitialized = val;
		
	}
	
	
	class MyRowSelectionListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			int selectedRow = bookList.getTableView().getSelectedRow();
			if (selectedRow > -1 && selectedRow < bookListData.size()) {
				String isbnId = bookListData.get(selectedRow).getIsbn();
				//Book selectedBook = bookListData.get(selectedRow);
				
				String[] columns = new String[] {
						"Name", "Checkout Date", "Due Date", "OverDue"	
				};
				//String[][] rows = new String[][] {};
				List<String[]> rows = new ArrayList<>();
				
				if (isbnId != null) {
					SystemController controller = new SystemController();
					List<LibraryMember> allMembers = new ArrayList<>(controller.allMembers().values());
					
					
					//rows= new String[allMembers.size()][columns.length];
					for(LibraryMember mem: allMembers) {
						if (mem.getCheckoutRecord() != null) {
							List<CheckoutRecordEntity> checkoutRecords = mem.getCheckoutRecord().getCheckoutRecordEntities();
							if (checkoutRecords != null) {
								for(CheckoutRecordEntity record: checkoutRecords) {
									if (record.getBookCopy().getBook().getIsbn().equals(isbnId)) {
										
										rows.add(new String[] {
												mem.getFirstName() + " " + mem.getLastName(), 
												record.getCheckoutDate().toString(), 
												record.getDueDate().toString(), 
												Boolean.toString(record.getDueDate().isBefore(LocalDate.now()))
										});
									
									}
								}
							}
						}
					}
					
					
					
				}
				
				//System.out.println(output);
				//outputLabel.setText(output + "\n\n");
				String[][] rows2 = new String[rows.size()][columns.length];
				int index = 0;
				for(String[] rowitem : rows) {
					rows2[index] = rowitem;
					index++;
				}
				tableData.refreshDataWith(columns, rows2);
				
			}
			
			
		}
		
	}
}
