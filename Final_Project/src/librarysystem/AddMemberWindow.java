package librarysystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import business.Address;
import business.LoginException;

public class AddMemberWindow  extends JFrame implements LibWindow {
	
	public final static AddMemberWindow INSTANCE =new AddMemberWindow();
	private boolean isInitialized = false;
	
	//member id, first name, last name, street, city, state, zip, telephone number
	private JTextField textFieldMemberId;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldStreet;
	private JTextField textFieldCity;
	private JTextField textFieldState;
	private JTextField textFieldZipCode;
	
	private JTextField textFieldTelephone;
	
	private JButton buttonAddMember;
	
	private JPanel mainPanel;
	
	private JPanel topPanel;
	private JPanel lowerHalf;
	private JPanel middlePanel;
	
	
	/**
	 *    firstName				LastName
	 *	  Street 				city
	 *	  zip					telephone
	 *    member id				Add Member Btn
	 */
	
	

	//Singleton class
	private AddMemberWindow() {}

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
	}
	
	private void defineTopPanel() {
		topPanel = new JPanel();
		JPanel intPanel = new JPanel(new BorderLayout());
		intPanel.add(Box.createRigidArea(new Dimension(0,20)), BorderLayout.NORTH);
		JLabel loginLabel = new JLabel("Add New Member");
		Util.adjustLabelFont(loginLabel, Color.BLUE.darker(), true);
		intPanel.add(loginLabel, BorderLayout.CENTER);
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		topPanel.add(intPanel);
		
	}
	
	
	private void defineMiddlePanel() {
		middlePanel=new JPanel();
		SpringLayout layout = new SpringLayout();
		middlePanel.setLayout(layout);
		
		//======= First Name AND Last Name===================
		
		CustomTextPanel firstNamePanel = defineLeftTextPanel("First Name", middlePanel, layout);
		CustomTextPanel lastNamePanel = defineRightTextPanel("Last Name", middlePanel, layout);
		textFieldFirstName = firstNamePanel.textField;
		textFieldLastName = lastNamePanel.textField;
		
		//======= Street AND City===================
		
		CustomTextPanel streetNamePanel = defineLeftTextPanel("Street", firstNamePanel.containerPanel, layout);
		CustomTextPanel cityNamePanel = defineRightTextPanel("City", lastNamePanel.containerPanel, layout);
		textFieldStreet = streetNamePanel.textField;
		textFieldCity = cityNamePanel.textField;
		
		//======= State AND ZipCode===================
		
		CustomTextPanel statePanel = defineLeftTextPanel("State", streetNamePanel.containerPanel, layout);
		CustomTextPanel zipNamePanel = defineRightTextPanel("Zip Code", cityNamePanel.containerPanel, layout);
		textFieldZipCode = zipNamePanel.textField;
		textFieldState = statePanel.textField;
		
		
		//======= Member ID AND Telephone===================
		
		CustomTextPanel memberIdPanel = defineRightTextPanel("Member Id", statePanel.containerPanel, layout);
		CustomTextPanel telephonePanel = defineLeftTextPanel("Telephone No", zipNamePanel.containerPanel, layout);
		textFieldTelephone = telephonePanel.textField;
		textFieldMemberId = memberIdPanel.textField;
		
		
		defineRightButtonPanel("Add Member", memberIdPanel.containerPanel, layout);
		
	}
	
	
	private void defineLowerHalf() {

		JButton backToMainButn = new JButton("<= Back to Main");
		backToMainButn.addActionListener(new BackToMainListener());
		lowerHalf = new JPanel();
		lowerHalf.setLayout(new FlowLayout(FlowLayout.LEFT));;
		lowerHalf.add(backToMainButn);
		
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
		
		layout.putConstraint(SpringLayout.EAST, leftTextPanel,
                5,
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
		
		layout.putConstraint(SpringLayout.WEST, rightTextPanel,
                5,
                SpringLayout.HORIZONTAL_CENTER, middlePanel);
		
			layout.putConstraint(SpringLayout.NORTH, 
					rightTextPanel,
	                5,
	                (parent == middlePanel) ? SpringLayout.NORTH : SpringLayout.SOUTH, 
	                parent);
		
		return new CustomTextPanel(rightTextPanel, inputField);
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
		//return rightTextPanel;
	}
	
	
	class Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			LibrarySystem.hideAllWindows();
			LibrarySystem.INSTANCE.setVisible(true);
		}
	}
	
	
	class AddMemberListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			
			/*
			 * 	  firstName				LastName
			 *	  Street 				city
			 *	  state					zip
			 *    member id				telephone
			 * */
			String memberID = textFieldMemberId.getText();
			String firstName = textFieldFirstName.getText();
			String lastName = textFieldLastName.getText();
			String streetName = textFieldStreet.getText();
			String cityName = textFieldCity.getText();
			String stateName = textFieldState.getText();
			String zipCode = textFieldZipCode.getText();
			String telephone = textFieldTelephone.getText();
			
			System.out.println(
					"memberId=" + memberID + ", " +
					"firstName=" + firstName + ", " +
					"lastName=" + lastName + ", " +
					"streetName=" + streetName + ", " +
					"cityName=" + cityName + ", " +
					"state=" + stateName + ", " +
					"zip=" + zipCode + ", " +
					"telephone=" + telephone 
					);
			
			//Validation part
			if (!isValidText(firstName)) {
				JOptionPane.showMessageDialog(AddMemberWindow.this, "FirstName cannot be empty");
			} else if (!isValidText(lastName)) {
				JOptionPane.showMessageDialog(AddMemberWindow.this, "LastName cannot be empty");
			} else if (!isValidText(streetName)) {
				JOptionPane.showMessageDialog(AddMemberWindow.this, "StreetName cannot be empty");
			} else if (!isValidText(cityName)) {
				JOptionPane.showMessageDialog(AddMemberWindow.this, "cityName cannot be empty");
			} else if (!isValidText(stateName)) {
				JOptionPane.showMessageDialog(AddMemberWindow.this, "stateName cannot be empty");
			} else if (!isValidText(zipCode) || !Util.isNumeric(zipCode)) {
				JOptionPane.showMessageDialog(AddMemberWindow.this, "Invalid ZipCode or ZipCode has to numeric");
			} else if (!isValidText(telephone) || !Util.isNumeric(telephone)) {
				JOptionPane.showMessageDialog(AddMemberWindow.this, "Invalid telephone number or telephone has to numeric");
			} else if (!isValidText(memberID)) {
				JOptionPane.showMessageDialog(AddMemberWindow.this, "Member id cannot be empty");
			} else if(!Util.isNumeric(memberID)) {
				JOptionPane.showMessageDialog(AddMemberWindow.this, "Member id has to be numeric");
			} else {
				
				Address addr = new Address(streetName, cityName, stateName, zipCode);
				try {
					//addNewMemberId(String memberId, String fname, String lname, String tel,Address add)
					LibrarySystem.INSTANCE.ci.addNewMemberId(memberID, firstName, lastName, telephone, addr);
					JOptionPane.showMessageDialog(AddMemberWindow.this, "Hooray (" + firstName + " " + lastName + ") is added as new Member");
				} catch (LoginException e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					JOptionPane.showMessageDialog(AddMemberWindow.this, e.getMessage());
				}
			}
		}
	}
	
	public Boolean isValidText(String text) {
		if (text.isEmpty()) {
			return false;
		}
		return true;
	}
	
	
	
	class BackToMainListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			LibrarySystem.hideAllWindows();
			LibrarySystem.INSTANCE.setVisible(true);
    		
		}
	}

	public boolean isInitialized() {
		// TODO Auto-generated method stub
		return isInitialized;
	}

	public void isInitialized(boolean val) {
		isInitialized = val;
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
