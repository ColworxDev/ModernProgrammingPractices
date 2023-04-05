package librarysystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import business.ControllerInterface;
import business.LoginException;
import business.SystemController;


public class AddBookCopyWindow extends JFrame implements LibWindow {
	private static final long serialVersionUID = 1L;
	public static final AddBookCopyWindow INSTANCE = new AddBookCopyWindow();
    ControllerInterface ci = new SystemController();
    private boolean isInitialized = false;
	
	private JPanel mainPanel;
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel submitPanel;
	private JPanel lowerPanel;
	
	//private JTextField bookId;
	private JComboBox bookId;
	private JLabel label;
	private JButton copyButton;
	

	//Singleton class
	private AddBookCopyWindow() {}
	
	public void init() {
		if (!isInitialized) {
			JPanel middleContentPanel = new JPanel();
			middleContentPanel.setLayout(new BorderLayout());
			middleContentPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
			mainPanel = new JPanel();
			mainPanel.setLayout(new BorderLayout());
			defineTopPanel();
			defineMiddlePanel();
			defineSubmitPanel();
			defineLowerPanel();
			mainPanel.add(topPanel, BorderLayout.NORTH);
			middleContentPanel.add(middlePanel, BorderLayout.NORTH);
			middleContentPanel.add(submitPanel, BorderLayout.SOUTH);
			mainPanel.add(middleContentPanel, BorderLayout.CENTER);
			mainPanel.add(lowerPanel, BorderLayout.SOUTH);
			getContentPane().add(mainPanel);
			setSize(660, 500);
			
			isInitialized = true;
		}
		
	}
	
	public void defineTopPanel() {
		topPanel = new JPanel();
		JLabel AllIDsLabel = new JLabel("Add book copy");
		Util.adjustLabelFont(AllIDsLabel, Util.DARK_BLUE, true);
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		topPanel.add(AllIDsLabel);
	}
	
	public void defineMiddlePanel() {
		middlePanel = new JPanel();
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 25, 25);
		middlePanel.setLayout(fl);
		//bookId = new JTextField(20);
		bookId = new JComboBox<>(getListData());
		label = new JLabel("Book ID");
		label.setFont(Util.makeSmallFont(label.getFont()));
		middlePanel.add(label);
		middlePanel.add(bookId);
		
	}
	
	public void defineSubmitPanel() {
		submitPanel = new JPanel();
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 25, 25);
		submitPanel.setLayout(fl);
		copyButton = new JButton("Submit");
		addSubmitButtonListener(copyButton);
		submitPanel.add(copyButton);
	}
	
	public void defineLowerPanel() {
		
		JButton backToMainButn = new JButton("<= Back to Main");
		backToMainButn.addActionListener(new BackToMainListener());
		lowerPanel = new JPanel();
		lowerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));;
		lowerPanel.add(backToMainButn);
	}
	
	private String[] getListData() {
		ControllerInterface ci = new SystemController();
		return ci.allBookIds().toArray(new String[0]);
	}
	
	class BackToMainListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			LibrarySystem.hideAllWindows();
			LibrarySystem.INSTANCE.setVisible(true);
    		
		}
	}
	
	private void addSubmitButtonListener(JButton butn) {
		butn.addActionListener(evt -> {

			String bookId = this.bookId.getSelectedItem().toString();
			try {
				LibrarySystem.INSTANCE.ci.addBookCopy(bookId);
				JOptionPane.showMessageDialog(this, "Book copied succesfully");
			} catch (LoginException e) {
    			JOptionPane.showMessageDialog(this, e.getMessage());
			}
		});
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
}
