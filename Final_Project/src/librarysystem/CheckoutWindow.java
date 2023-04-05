package librarysystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import business.CheckoutRecord;
import business.CheckoutRecordEntity;
import business.SystemController;

public class CheckoutWindow extends JFrame implements LibWindow {
	public static final CheckoutWindow INSTANCE = new CheckoutWindow();
	
	private boolean isInitialized = false;
	private JPanel mainPanel;
	private JPanel upperHalf;
	private JPanel middleHalf;
	private JPanel lowerHalf;
	private GenericTablePanel tableData;
//	private JPanel container;
	
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel lowerPanel;
	private JPanel leftTextPanel;
	private JPanel rightTextPanel;
	
	private JTextField memberID;
	private JTextField isbnNumber;
	private JLabel label;
	private JButton checkoutButton;
	private String memberId;
	private String isbn;
	
	/* This class is a singleton */
    private CheckoutWindow () {}
    
	@Override
	public boolean isInitialized() {
		// TODO Auto-generated method stub
		return isInitialized;
	}

	@Override
	public void isInitialized(boolean val) {
		// TODO Auto-generated method stub
		isInitialized = val;
	}
    
    public void init() {
    		//setSize(660, 500);
    	if (!isInitialized) {
    		JPanel outerMainPanel = new JPanel(new BorderLayout());
    		
    		mainPanel = new JPanel();
    		defineUpperHalf();
    		defineMiddleHalf();
    		defineLowerHalf();
    		BorderLayout bl = new BorderLayout();
    		bl.setVgap(30);
    		mainPanel.setLayout(bl);
    					
    		mainPanel.add(upperHalf, BorderLayout.NORTH);
    		mainPanel.add(middleHalf, BorderLayout.CENTER);
    		outerMainPanel.add(lowerHalf, BorderLayout.SOUTH);
    		outerMainPanel.add(mainPanel, BorderLayout.NORTH);
    		tableData = new GenericTablePanel(null);
    		outerMainPanel.add(tableData, BorderLayout.CENTER);
    		
    		getContentPane().add(outerMainPanel);
    		isInitialized(true);
    		//pack();
    		setSize(660, 500);
    		isInitialized = true;
    	}
    }
    private void defineUpperHalf() {    		
    		upperHalf = new JPanel();
    		upperHalf.setLayout(new BorderLayout());
    		defineTopPanel();
    		defineMiddlePanel();
    		defineLowerPanel();
    		upperHalf.add(topPanel, BorderLayout.NORTH);
    		upperHalf.add(middlePanel, BorderLayout.CENTER);
    		upperHalf.add(lowerPanel, BorderLayout.SOUTH);
    		
    	}
		private void defineTopPanel() {
			topPanel = new JPanel();
			JPanel intPanel = new JPanel(new BorderLayout());
			intPanel.add(Box.createRigidArea(new Dimension(0,20)), BorderLayout.NORTH);
			JLabel loginLabel = new JLabel("Checkout");
			Util.adjustLabelFont(loginLabel, Color.BLUE.darker(), true);
			intPanel.add(loginLabel, BorderLayout.CENTER);
			topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			topPanel.add(intPanel);
			
		}
    	private void defineMiddlePanel() {
    		middlePanel=new JPanel();
    		middlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    		defineLeftTextPanel();
    		defineRightTextPanel();
    		middlePanel.add(leftTextPanel);
    		middlePanel.add(rightTextPanel);
    	}
    	private void defineLeftTextPanel() {    		
    		JPanel topText = new JPanel();
    		JPanel bottomText = new JPanel();
    		topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
    		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		
    		
    		memberID = new JTextField(10);
    		label = new JLabel("Member ID");
    		label.setFont(Util.makeSmallFont(label.getFont()));
    		topText.add(memberID);
    		bottomText.add(label);
    		
    		leftTextPanel = new JPanel();
    		leftTextPanel.setLayout(new BorderLayout());
    		leftTextPanel.add(topText,BorderLayout.NORTH);
    		leftTextPanel.add(bottomText,BorderLayout.CENTER);
    	}
    	private void defineRightTextPanel() {    		
    		JPanel topText = new JPanel();
    		JPanel bottomText = new JPanel();
    		topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
    		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		
    		
    		isbnNumber = new JTextField(10);
    		label = new JLabel("ISBN Number");
    		label.setFont(Util.makeSmallFont(label.getFont()));
    		topText.add(isbnNumber);
    		bottomText.add(label);
    		
    		rightTextPanel = new JPanel();
    		rightTextPanel.setLayout(new BorderLayout());
    		rightTextPanel.add(topText,BorderLayout.NORTH);
    		rightTextPanel.add(bottomText,BorderLayout.CENTER);
    	}
    	private void defineLowerPanel() {
    		lowerPanel = new JPanel();
    		checkoutButton = new JButton("Checkout");
    		addCheckoutButtonListener(checkoutButton);
    		lowerPanel.add(checkoutButton);
    	}
    	private void addCheckoutButtonListener(JButton butn) {
    		butn.addActionListener(evt -> {
    			memberId = this.memberID.getText();
    			isbn = this.isbnNumber.getText();
    			
    			try {
    				SystemController controller = new SystemController();
    				controller.checkout(memberId, isbn);
    				JOptionPane.showMessageDialog(this, "Checkout done successfully");
    				//tableData.refreshData(memberId);
    				updateTableData();
    				
				} catch (Exception e) {
	    			JOptionPane.showMessageDialog(this, e.getMessage());
	    			updateTableData();
				}
    		});
    	}
    	
    	private void updateTableData() {
    		SystemController controller = new SystemController();
    		CheckoutRecord checkoutRecord = controller.allMembers().get(memberId).getCheckoutRecord();
    		String[] columns = new String[] {
					"CheckoutDate", "Due Date", "Book Title", "Book Isbn"
				};
    		String[][] rows = new String[][] {};
    		
			if (checkoutRecord != null) {
				List<CheckoutRecordEntity> entities = checkoutRecord.getCheckoutRecordEntities();
				rows = new String[entities.size()][columns.length];
				int index = 0;
				for (CheckoutRecordEntity entity : entities) {
					//"CheckoutDate", "Due Date", "BookTitle", "BookISBN", "Copy No", "is Available"
					rows[index++] = new String[] {
							entity.getCheckoutDate().toString(), 
							entity.getDueDate().toString(),
							entity.getBookCopy().getBook().getTitle(),
							entity.getBookCopy().getBook().getIsbn()
//							Integer.toString(entity.getBookCopy().getBook().getNumCopies()),
//							Boolean.toString(entity.getBookCopy().getBook().isAvailable())
					};
					
				}
				
				
			} 
			tableData.refreshDataWith(columns, rows);
    	}
    	
    	
    	private void defineMiddleHalf() {
    		middleHalf = new JPanel();
    		middleHalf.setLayout(new BorderLayout());
    		JSeparator s = new JSeparator();
    		s.setOrientation(SwingConstants.HORIZONTAL);
    		middleHalf.add(s, BorderLayout.SOUTH);
    		
    	}
    	
    	private void defineLowerHalf() {

    		lowerHalf = new JPanel();
    		lowerHalf.setLayout(new FlowLayout(FlowLayout.LEFT));
    		
    		JButton backButton = new JButton("<= Back to Main");
    		addBackButtonListener(backButton);
    		lowerHalf.add(backButton);
    		
    	}    	    	  
    	    	
    	private void addBackButtonListener(JButton butn) {
    		butn.addActionListener(evt -> {
    			//23-11451
    			// This is a sample code for checkout information
//    			
    			LibrarySystem.hideAllWindows();
    			LibrarySystem.INSTANCE.setVisible(true);
    			
    		});
    	}
}
