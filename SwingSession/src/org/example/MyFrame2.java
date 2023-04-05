package org.example;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame2 extends JFrame {
	
	JPanel topJPanel;
	JPanel middleJPanel;
	JPanel bottomJPanel;
	JTextField textfield;
	JLabel label;
	JButton button;

	public MyFrame2() {
		// TODO Auto-generated constructor stub
		initializeWindow();
		defineTopPanel();
		defineMiddlePanel();
		defineBottomPanel();
		add(topJPanel, BorderLayout.NORTH);
		add(middleJPanel, BorderLayout.CENTER);
		add(bottomJPanel, BorderLayout.SOUTH);
		pack();
	}

	private void defineBottomPanel() {
		// TODO Auto-generated method stub
		bottomJPanel = new JPanel();
		button = new JButton("Process");
		bottomJPanel.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// read text content from textfield
				String data = textfield.getText();
				// and update label
				label.setText("You typed: " + data);
				
			}
		});
		
		//register button with event listener interface
		
	}

	private void defineMiddlePanel() {
		// TODO Auto-generated method stub
		middleJPanel = new JPanel();
		
		label = new JLabel("My text");
		middleJPanel.add(label);
		
	}

	private void defineTopPanel() {
		// instantiate top panel
		topJPanel = new JPanel();
		
		//instantiate text field
		textfield = new JTextField(10);
		//add a text field
		topJPanel.add(textfield);
		
	}

	private void initializeWindow() {
		// TODO Auto-generated method stub
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new MyFrame2();
				
			}
		});

	}

}
