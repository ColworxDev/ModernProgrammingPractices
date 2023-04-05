package lab_ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lab_app.Data;
import lab_ui_interfaces.StatusType;
import lesson6.labs.Auth;
import lesson6.labs.Util;

public class AddBookView extends JPanel {

	private JTextField authorFirstName;
	private JTextField authorLastName;
	private JTextField bookTitle;
	private JButton addBookBtn;
	
	private JPanel centerView;

	AddBookView() {
		// TODO Auto-generated constructor stub
		//setLayout(new GridLayout(4, 2));
		setLayout(new BorderLayout());
		
		addtopPanel();
		
		centerView = new JPanel();
		centerView.setLayout(new BoxLayout(centerView, BoxLayout.Y_AXIS));
		
		authorFirstName = getTextFieldWith("Author First Name");
		authorLastName = getTextFieldWith("Author Last Name");
		bookTitle = getTextFieldWith("Book Title");
		
		
		add(centerView, BorderLayout.CENTER);
		
		
		
		addBookBtn = new JButton("Add Book");
		centerView.add(addBookBtn, BorderLayout.SOUTH);
		
		add(Box.createRigidArea(new Dimension(0,20)), BorderLayout.SOUTH);
		
		addBookBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				performBtnAction();
			}
		});
		
	}
	
	private void addtopPanel() {
		JPanel intPanel = new JPanel();
		intPanel.setLayout(new BorderLayout());
		intPanel.add(Box.createRigidArea(new Dimension(0,20)), BorderLayout.NORTH);
		
		JLabel loginLabel = new JLabel("Add Book Title");
		Util.adjustLabelFont(loginLabel, Color.BLUE.darker(), true);
		intPanel.add(loginLabel, BorderLayout.CENTER);
		add(intPanel, BorderLayout.NORTH);
	}
	
	private void performBtnAction() {
		String titleBook = bookTitle.getText();
		if (Data.INSTANCE.currentAuth == Auth.BOTH || 
				Data.INSTANCE.currentAuth == Auth.SELLER) {
			Data.INSTANCE.bookTitles.add(titleBook);
			Data.INSTANCE.listener.updateBottomText("The book " + titleBook + " book has been added to the collection!", StatusType.Success);
		}
	}
	
	private JTextField getTextFieldWith(String placeholder) {
		JPanel textPanel = new JPanel();
		JLabel label = new JLabel(placeholder);
		label.setPreferredSize(new Dimension(150, 40));
		textPanel.add(label);
		
		JTextField jtextfield = new JTextField(10);
		textPanel.add(jtextfield);
		centerView.add(textPanel);
		
		return jtextfield;
	}
}
