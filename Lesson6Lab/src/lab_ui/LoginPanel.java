package lab_ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import lab_app.Data;
import lab_ui_interfaces.StatusType;
import lesson6.labs.User;
import lesson6.labs.Util;

public class LoginPanel extends JPanel {
	
	
	private JTextField username;
	private JPasswordField password;
	

	LoginPanel() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		
		addtopPanel();
		
		JPanel textContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
		textContainer.add(getLoginFieldPanel());
		
		JPanel passPanel = getPasswordFieldPanel();
		textContainer.add(passPanel);
		add(textContainer, BorderLayout.CENTER);
		JButton button = new JButton("Login");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				performLogin();
			}
		});
		
		
		JPanel buttonContainer = new JPanel();
		buttonContainer.add(button);
		passPanel.add(buttonContainer, BorderLayout.SOUTH);
	}
	
	private void addtopPanel() {
		JPanel intPanel = new JPanel();
		intPanel.setLayout(new BorderLayout());
		intPanel.add(Box.createRigidArea(new Dimension(0,20)), BorderLayout.NORTH);
		
		JLabel loginLabel = new JLabel("Login");
		Util.adjustLabelFont(loginLabel, Color.BLUE.darker(), true);
		intPanel.add(loginLabel, BorderLayout.CENTER);
		add(intPanel, BorderLayout.NORTH);
	}
	
	private JPanel getLoginFieldPanel() {
		JPanel textPanel = new JPanel(new BorderLayout());
		username = new JTextField(10);
		textPanel.add(username, BorderLayout.NORTH);
		
		JLabel lbl = new JLabel("Username");
		textPanel.add(lbl, BorderLayout.CENTER);
		textPanel.add(Box.createRigidArea(new Dimension(0,40)), BorderLayout.SOUTH);
		
		return textPanel;
	}
	
	
	private JPanel getPasswordFieldPanel() {
		JPanel textPanel = new JPanel(new BorderLayout());
		password = new JPasswordField(10);
		textPanel.add(password, BorderLayout.NORTH);
		
		JLabel lbl = new JLabel("Password");
		textPanel.add(lbl, BorderLayout.CENTER);
		
		return textPanel;
	}
	
	public void performLogin() {
		String name = username.getText();
		String pass = String.valueOf(password.getPassword());
		for(User user: Data.INSTANCE.logins) {
			if (user.username.equals(name) && user.password.equals(pass)) {
				Data.INSTANCE.currentAuth = user.authorization;
				Data.INSTANCE.listener.updateBottomText("Login Successful", StatusType.Success);
				Data.INSTANCE.listener.updateNameList();
				return;
			}
		}
		Data.INSTANCE.currentAuth = null;
		Data.INSTANCE.listener.updateBottomText("Login Failed", StatusType.Fail);
		Data.INSTANCE.listener.updateNameList();
	}

}
