package lab_ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import lab_app.Data;
import lab_ui_interfaces.MainUITextListener;
import lab_ui_interfaces.StatusType;
import lesson6.labs.User;
import lesson6.labs.Util;

public class MainUI extends JFrame implements MainUITextListener {
	
	private BottomPanel bottomPanel;
	private TopSplitPlaneView topSplitPlane;
	final int SCREEN_WIDTH = 600;
	final int SCREEN_HEIGHT = 300;

	MainUI() {
		// TODO Auto-generated constructor stub
		initializeWindow();
		Data.INSTANCE.listener = this;
		bottomPanel = new BottomPanel();
		bottomPanel.setText("Welcome to the Book Club!", StatusType.none);
		
		topSplitPlane = new TopSplitPlaneView();
		
		JSplitPane verticalSplitPane = new JSplitPane(
				JSplitPane.VERTICAL_SPLIT, 			//Orientation 
				topSplitPlane, 						//left side
				bottomPanel);						//right side
		
		verticalSplitPane.setDividerLocation((int)(SCREEN_HEIGHT* 0.7));
		add(verticalSplitPane, BorderLayout.CENTER);
	}
	
	private void initializeWindow() {
		// TODO Auto-generated method stub
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		Util.centerFrameOnDesktop(this);
		setTitle("Book Club");
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainUI();
			}
		});
	}

	public void updateBottomText(String text, StatusType type) {
		// TODO Auto-generated method stub
		bottomPanel.setText(text, type);
		
	}
	
	
	public void updateNameList() {
		// TODO Auto-generated method stub
		topSplitPlane.refreshListRenderer();
	}

}
