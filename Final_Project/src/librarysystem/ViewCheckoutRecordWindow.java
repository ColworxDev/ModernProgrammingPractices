package librarysystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import business.CheckoutRecord;
import business.CheckoutRecordEntity;
import business.ControllerInterface;
import business.LibraryMember;
import business.SystemController;


public class ViewCheckoutRecordWindow extends JFrame implements LibWindow {
	public static final ViewCheckoutRecordWindow INSTANCE = new ViewCheckoutRecordWindow();
    
	private ControllerInterface ci = new SystemController();
	private boolean isInitialized = false;
	public JPanel getMainPanel() {
		return mainPanel;
	}
	private JPanel mainPanel;
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel lowerPanel;

	
	private List<LibraryMember> memberListData = new ArrayList<>();
	private GenericTablePanel nameList;
	private GenericTablePanel tableData;
	
	
	private ViewCheckoutRecordWindow() {}
	
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
			//pack();
			setSize(660, 500);
			isInitialized = true;
		}
		
	}
	
	public void defineTopPanel() {
		topPanel = new JPanel();
		JLabel AllIDsLabel = new JLabel("View Checkout Records");
		Util.adjustLabelFont(AllIDsLabel, Util.DARK_BLUE, true);
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		topPanel.add(AllIDsLabel);
	}
	
	public void defineMiddlePanel() {
		middlePanel = new JPanel();
		middlePanel.setLayout(new BorderLayout());
		
		nameList = new GenericTablePanel(new MemberIdSelectionListener());
		tableData = new GenericTablePanel(null);
		
		middlePanel.add(nameList, BorderLayout.NORTH);
		
		middlePanel.add(new JLabel("Checked out below Books",SwingConstants.CENTER), BorderLayout.CENTER);
		middlePanel.add(tableData, BorderLayout.SOUTH);
		clearTableData();
		
	}
	
	public void defineLowerPanel() {
		lowerPanel = new JPanel();
		FlowLayout fl = new FlowLayout(FlowLayout.LEFT);
		lowerPanel.setLayout(fl);
		JButton backButton = new JButton("<== Back to Main");
		addBackButtonListener(backButton);
		lowerPanel.add(backButton);
	}
	

	
	private void clearTableData() {
		String[] columns = new String[] {
				"Checkoutby", "Due Date", "OverDue"	
		};
		String[][] rows = new String[][] {};
		tableData.refreshDataWith(columns, rows);
	}
	
	public void setListData(List<LibraryMember> data) {
		memberListData = data;
		String[] columns = new String[] {
				"MemberId", "Name", "Telephone", "Checkout Book count(s)"
		};
		String[][] rows = new String[data.size()][columns.length];
		int index = 0;
		for(LibraryMember member: data) {
			int checkoutCount = 0;
			if (member.getCheckoutRecord() != null) {
				checkoutCount = member.getCheckoutRecord().getCheckoutRecordEntities().size();
			}
			rows[index++] = new String[] {
					 member.getMemberId(),
					 member.getFirstName() + " " + member.getLastName(),
					 member.getTelephone(),
					 Integer.toString(checkoutCount)
			};
		}
		nameList.refreshDataWith(columns, rows);
		
	}
	
	
	private void addBackButtonListener(JButton butn) {
		butn.addActionListener(evt -> {
		   LibrarySystem.hideAllWindows();
		   LibrarySystem.INSTANCE.setVisible(true);
	    });
	}
	
	class MemberIdSelectionListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			int selectedRow = nameList.getTableView().getSelectedRow();
			if(selectedRow == -1) {
				return;
			}
			
			String output = "Checkout Records are below\n";
			
			String[] columns = new String[] {
					"Checkout Date", "Due Date", "Book Title", "Isbn", "# of copies", "isAvailable"	
			};
			String[][] rows = new String[][] {};
			
			CheckoutRecord checkoutRecord = memberListData.get(selectedRow).getCheckoutRecord();
			
			if (checkoutRecord != null) {
				List<CheckoutRecordEntity> entities = checkoutRecord.getCheckoutRecordEntities();
				rows= new String[entities.size()][columns.length];
				int index = 0;
				for (CheckoutRecordEntity entity : entities) {
					//"CheckoutDate", "Due Date", "BookTitle", "BookISBN", "Copy No", "is Available"
					rows[index][0] = entity.getCheckoutDate().toString();
					rows[index][1] = entity.getDueDate().toString();
					rows[index][2] = entity.getBookCopy().getBook().getTitle();
					rows[index][3] = entity.getBookCopy().getBook().getIsbn();
					rows[index][4] = Integer.toString(entity.getBookCopy().getBook().getNumCopies()) ;
					rows[index][5] = Boolean.toString(entity.getBookCopy().getBook().isAvailable());
					index ++;
					output += "\n\n" +
							"checkout date: " + entity.getCheckoutDate() + ", " +
							"Due date: " + entity.getDueDate() + ", " +
							"BookTitle: " + entity.getBookCopy().getBook().getTitle() + ", " +
							"Book Isbn: " + entity.getBookCopy().getBook().getIsbn() + ", " +
							"# of copies: " + entity.getBookCopy().getBook().getNumCopies() + ", " +
							"isAvailable: " + entity.getBookCopy().getBook().isAvailable();
					
				}
			} else {
				output += "\n\nno checkout record found";
			}
			
			System.out.println(output);
			tableData.refreshDataWith(columns, rows);
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


