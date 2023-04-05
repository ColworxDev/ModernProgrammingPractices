package librarysystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import business.Author;
import business.Book;
import business.LoginException;
import dataaccess.TestData;

public class AddNewBookWindow  extends JFrame implements LibWindow {
	
	public final static AddNewBookWindow INSTANCE =new AddNewBookWindow();
	private boolean isInitialized = false;
	
	private JPanel mainPanel;
	private JPanel topPanel;
	private JPanel lowerHalf;
	private JPanel middlePanel;

	/*
	 * 	  BookTitle				ISBN
	 *	  Authors 				MaxCheckOutLength
	 *	  NoOfCopies			
	 * */
	private JTextField textFieldIsbn;
	private JTextField textFieldBookTitle;
	private JTextField textFieldMaxCheckOut;
	private JTextField textFieldNoOfCopies;
	//private JComboBox textFieldAuthors;
	private JList<String> listAuthors;
		
	private JButton buttonAddMember;
	
	

	private AddNewBookWindow() { }
	
	
	

	@Override
	public void init() {
		// TODO Auto-generated method stub
		if (!isInitialized) {
			mainPanel = new JPanel();
			
			defineTopPanel();
			defineMiddlePanel();
			defineLowerHalf();
			
			BorderLayout bl = new BorderLayout();
			bl.setVgap(30);
			mainPanel.setLayout(bl);
			
			mainPanel.add(topPanel, BorderLayout.NORTH);
			mainPanel.add(middlePanel, BorderLayout.CENTER);
			mainPanel.add(lowerHalf, BorderLayout.SOUTH);
			
			//mainPanel.setBackground(Color.red);
			getContentPane().add(mainPanel);
			isInitialized = true;
			setSize(660, 500);
		}
		clearAllField();
	}
	
	private void defineTopPanel() {
		topPanel = new JPanel();
		JPanel intPanel = new JPanel(new BorderLayout());
		intPanel.add(Box.createRigidArea(new Dimension(0,20)), BorderLayout.NORTH);
		JLabel loginLabel = new JLabel("Add New Book To Library");
		Util.adjustLabelFont(loginLabel, Color.BLUE.darker(), true);
		intPanel.add(loginLabel, BorderLayout.CENTER);
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		topPanel.add(intPanel);
	}
	
	private void defineMiddlePanel() {
		middlePanel=new JPanel();
		SpringLayout layout = new SpringLayout();
		middlePanel.setLayout(layout);
		
		//======= ISBN AND BookTitle===================
		CustomTextPanel firstNamePanel = defineLeftTextPanel("ISBN", middlePanel, layout);
		CustomTextPanel lastNamePanel = defineRightTextPanel("Book Title", middlePanel, layout);
		
		textFieldIsbn = firstNamePanel.textField;
		textFieldBookTitle = lastNamePanel.textField;
		
		//======= No of copies AND MaxCheckout===================
		CustomTextPanel streetNamePanel = defineLeftTextPanel("No of copies", firstNamePanel.containerPanel, layout);
		CustomTextPanel cityNamePanel = defineRightTextPanel("MaxCheckout Length", lastNamePanel.containerPanel, layout);
		
		textFieldNoOfCopies = streetNamePanel.textField;
		textFieldMaxCheckOut = cityNamePanel.textField;
		
		//======= Authors===================
		defineListAuthorsPanel("Authors", lastNamePanel.containerPanel, layout);
		
		//======= Add Book Button===================
		defineRightButtonPanel("Add Book", streetNamePanel.containerPanel, layout);
		
	}
	
	private CustomTextPanel defineLeftTextPanel(String placeholder, JPanel parent, SpringLayout layout) {
		
		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		
		
		
		JTextField inputField = new JTextField(10);
		JLabel label = new JLabel(placeholder);
		label.setFont(Util.makeSmallFont(label.getFont()));
		topText.add(inputField);
		bottomText.add(label);
		
		JPanel leftTextPanel = new JPanel();
		leftTextPanel.setLayout(new BorderLayout());
		leftTextPanel.add(bottomText,BorderLayout.NORTH);
		leftTextPanel.add(topText,BorderLayout.CENTER);
		
		middlePanel.add(leftTextPanel);
		
		layout.putConstraint(SpringLayout.WEST, leftTextPanel,
                -215,
                SpringLayout.HORIZONTAL_CENTER, middlePanel);
		
		layout.putConstraint(SpringLayout.NORTH, 
				leftTextPanel,
	                5,
	                (parent == middlePanel) ? SpringLayout.NORTH : SpringLayout.SOUTH, 
	                parent);
		
		return new CustomTextPanel(leftTextPanel, inputField);
	}
	
	private CustomTextPanel defineRightTextPanel(String placeholder, JPanel parent, SpringLayout layout) {
		
		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		
		
		JTextField inputField = new JTextField(10);
		JLabel label = new JLabel(placeholder);
		label.setFont(Util.makeSmallFont(label.getFont()));
		topText.add(inputField);
		bottomText.add(label);
		
		JPanel rightTextPanel = new JPanel();
		rightTextPanel.setLayout(new BorderLayout());
		rightTextPanel.add(bottomText,BorderLayout.NORTH);
		rightTextPanel.add(topText,BorderLayout.CENTER);
		
		middlePanel.add(rightTextPanel);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, rightTextPanel,
                0,
                SpringLayout.HORIZONTAL_CENTER, middlePanel);
		
			layout.putConstraint(SpringLayout.NORTH, 
					rightTextPanel,
	                5,
	                (parent == middlePanel) ? SpringLayout.NORTH : SpringLayout.SOUTH, 
	                parent);
		
		return new CustomTextPanel(rightTextPanel, inputField);
	}
	
	private void defineListAuthorsPanel(String placeholder, JPanel parent, SpringLayout layout) {
		
		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));		
		
		
		listAuthors = new JList<>(getListData());
		//listAuthors.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JLabel label = new JLabel(placeholder);
		label.setFont(Util.makeSmallFont(label.getFont()));
		topText.add(listAuthors);
		bottomText.add(label);
		
		JPanel rightTextPanel = new JPanel();
		rightTextPanel.setLayout(new BorderLayout());
		rightTextPanel.add(bottomText,BorderLayout.NORTH);
		rightTextPanel.add(topText,BorderLayout.CENTER);
		
		middlePanel.add(rightTextPanel);
		
		layout.putConstraint(SpringLayout.WEST, rightTextPanel,
                5, SpringLayout.EAST, parent);
		
		layout.putConstraint(SpringLayout.NORTH, rightTextPanel,
	                5, SpringLayout.NORTH, middlePanel);
	}
	
	private void defineRightButtonPanel(String placeholder, JPanel parent, SpringLayout layout) {
		
		JPanel topText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		buttonAddMember = new JButton(placeholder);
		buttonAddMember.addActionListener(new AddMemberListener());
		
		topText.add(buttonAddMember);
		JPanel rightTextPanel = new JPanel();
		rightTextPanel.setLayout(new BorderLayout());
		rightTextPanel.add(Box.createRigidArea(new Dimension(0,10)), BorderLayout.NORTH);
		rightTextPanel.add(topText,BorderLayout.CENTER);
		
		middlePanel.add(rightTextPanel);
		
		layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, rightTextPanel,
                5,
                SpringLayout.HORIZONTAL_CENTER, middlePanel);
		
		layout.putConstraint(SpringLayout.NORTH, rightTextPanel,
                5,
                SpringLayout.SOUTH, parent);
	}
	
	
	private void defineLowerHalf() {

		JButton backToMainButn = new JButton("<= Back to Main");
		backToMainButn.addActionListener(new BackToMainListener());
		lowerHalf = new JPanel();
		lowerHalf.setLayout(new FlowLayout(FlowLayout.LEFT));;
		lowerHalf.add(backToMainButn);
		
	}
	
	class BackToMainListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			LibrarySystem.hideAllWindows();
			LibrarySystem.INSTANCE.setVisible(true);
    		
		}
	}
	
	private String[] getListData() {
		//ControllerInterface ci = new SystemController();
		TestData td = new TestData();
		String [] arr = new String[td.allAuthors.size()];
		int index = 0;
		for (Author auth:  td.allAuthors) {
			arr[index] = auth.getFirstName() + " " + auth.getLastName();
			index ++;
		}
		return arr;
	}
	
	class AddMemberListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			
			/*
			 * 	  BookTitle				ISBN
			 *	  Authors 				MaxCheckOutLength
			 *	  NoOfCopies			
			 * */
			
			String bookTitle = textFieldBookTitle.getText();
			String isbn = textFieldIsbn.getText();
			int[] selectedIndexes = listAuthors.getSelectedIndices();
			List<Author> authors = new ArrayList<>();
			TestData td = new TestData();
			List<String> authNames = new ArrayList<>();
			int index = 0;
			for(Author auth: td.allAuthors) {
				if (containsIndex(selectedIndexes, index++)) {
					authNames.add(auth.getFirstName() + " " + auth.getLastName()); 
					authors.add(auth);
				}
			}
			//String authorName = listAuthors.getSelectedIndices();
			int maxCheckout = 0;
			int noOfCopies = 0;
			try {
				maxCheckout = Integer.parseInt(textFieldMaxCheckOut.getText());
				noOfCopies = Integer.parseInt(textFieldNoOfCopies.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(AddNewBookWindow.this, e.getMessage());
			}
			
			
			//TestData td = new TestData();
			//Author selectedAuthor = td.allAuthors.get(textFieldAuthors.getSelectedIndex());
			
			
			System.out.println(
					"bookTitle=" + bookTitle + ", " +
					"isbn=" + isbn + ", " +
					"authorName=" + String.join(",", authNames) + ", " +
					"maxCheckOut=" + maxCheckout + ", " +
					"noOfCopies=" + noOfCopies 
					);
			
//			//Validation part
			if (!isValidText(bookTitle)) {
				JOptionPane.showMessageDialog(AddNewBookWindow.this, "bookTitle cannot be empty");
			} else if (!isValidText(isbn)) {
				JOptionPane.showMessageDialog(AddNewBookWindow.this, "isbn cannot be empty");
			} else if (maxCheckout <= 0) {
				JOptionPane.showMessageDialog(AddNewBookWindow.this, "maxcheckout cannot be less than 0");
			} else if (noOfCopies <= 0) {
				JOptionPane.showMessageDialog(AddNewBookWindow.this, "no of Copies cannot be less than 0");
			}  else {
				
				
				try {
					//Book(String isbn, String title, int maxCheckoutLength, List<Author> authors)
					Book book = new Book(isbn, bookTitle, maxCheckout, authors);
					for(int i = 0; i< noOfCopies - 1; i++) {
						book.addCopy();
					}
					LibrarySystem.INSTANCE.ci.addNewBook(book);
					JOptionPane.showMessageDialog(AddNewBookWindow.this, "Hooray (" + bookTitle + ") is added as new Book");
					clearAllField();
				} catch (LoginException e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					JOptionPane.showMessageDialog(AddNewBookWindow.this, e.getMessage());
				}
			}
		}
	}
	
	public boolean containsIndex(final int[] array, final int key) {
	    for (final int i : array) {
	        if (i == key) {
	            return true;
	        }
	    }
	    return false;
	}
	
	private void clearAllField() {
		textFieldIsbn.setText("");
		textFieldBookTitle.setText("");
		textFieldMaxCheckOut.setText("");
		textFieldNoOfCopies.setText("");
		listAuthors.clearSelection();
	}
	
	public Boolean isValidText(String text) {
		if (text.isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean isInitialized() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void isInitialized(boolean val) {
		// TODO Auto-generated method stub
		
	}
	
	class CustomTextPanel {
		JPanel containerPanel;
		JTextField textField;
		
		public CustomTextPanel(JPanel panel, JTextField input) {
			this.containerPanel = panel;
			this.textField = input;
		}
	}

}
