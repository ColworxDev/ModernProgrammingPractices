package org.example;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	MyFrame() {
		// TODO Auto-generated method stub
		initializeWindow();
	}
	
	private void initializeWindow() {
		// TODO Auto-generated constructor stub
				setVisible(true);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				setTitle("My Window");
				setSize(400, 600);
		
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new MyFrame();
				
			}
		});
	}

	

}
