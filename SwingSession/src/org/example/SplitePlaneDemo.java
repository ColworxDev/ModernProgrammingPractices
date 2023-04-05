package org.example;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class SplitePlaneDemo extends JFrame {
	
	
	JPanel cardDeck;
	JPanel firstPanel;
	JPanel secondPanel;
	JPanel thirdPanel;
	JList<String> nameList;
	
	JSplitPane splitPane;
	

	SplitePlaneDemo() {
		// TODO Auto-generated constructor stub
		initializeWindow();
		setUpCards();
		setUpLists();
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, 	//Orientation 
								nameList, 							//left side
								cardDeck);							//right side
		splitPane.setDividerLocation(300);
		add(splitPane, BorderLayout.CENTER);
		//setSize(500, 450);
		pack();
		centreOnDeskTop(this);
		
	}
	
	private void centreOnDeskTop(Component component) {
		// TODO Auto-generated method stub
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		component.setLocation(
				(toolkit.getScreenSize().width - component.getWidth()) / 2,
				(toolkit.getScreenSize().height - component.getHeight()) / 3
				);
		
	}

	private void setUpLists() {
		// TODO Auto-generated method stub
		nameList = new JList<String>(new String[] {"first", "second", "third"});
		nameList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				//if (nameList.getSelectedValue().equals("first")) {
					((CardLayout)(cardDeck.getLayout())).show(cardDeck, nameList.getSelectedValue());
				//}
				
			}
		});
		
	}

	private void setUpCards() {
		cardDeck = new JPanel();
		//set its layout as CardLayout
		cardDeck.setLayout(new CardLayout());
		firstPanel = new JPanel();
		firstPanel.add(new JLabel("This is first card"));
		
		secondPanel = new JPanel();
		secondPanel.add(new JLabel("This second card"));
		
		thirdPanel = new JPanel();
		thirdPanel.add(new JLabel("This third card"));
		//add all panels to deck
		cardDeck.add("first", firstPanel);
		cardDeck.add("second", secondPanel);
		cardDeck.add("third", thirdPanel);
	}
	
	private void initializeWindow() {
		// TODO Auto-generated method stub
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new SplitePlaneDemo();
				
			}
		});
	}

}
