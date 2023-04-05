package org.example;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuDemo extends JFrame {
	
	JMenuBar menuBar;
	
	JMenu fileMenu;
	JMenu editMenu;
	

	MenuDemo() {
		// TODO Auto-generated constructor stub
		initializeWindow();
		windowHandling();
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		
		JMenuItem openMenuItem = new JMenuItem("Open");
		JMenuItem remoteMenuItem = new JMenuItem("Remote");
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		
		fileMenu.add(openMenuItem);
		fileMenu.add(remoteMenuItem);
		fileMenu.add(exitMenuItem);
		
		JMenu newSubMenu = new JMenu("New");
		JMenuItem item1 = new JMenuItem("Project");
		JMenuItem item2 = new JMenuItem("Open Existing File");
		newSubMenu.add(item1);
		newSubMenu.add(item2);
		//add new to submenu to exsting file menu
		fileMenu.add(newSubMenu, 0);
		
		// do event handling for open existing menu items
		item2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// display a file chooser window
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.showDialog(getParent(), "Choose your file");
				
				
			}
		});
		
	}
	
	private void windowHandling() {
		// TODO Auto-generated method stub
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				dispose();
				//cleanup operations
				System.exit(0);
			}
		});
		
	}

	private void initializeWindow() {
		// TODO Auto-generated method stub
		setTitle("Menu Sample");
		setSize(300, 250);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MenuDemo();
				
			}
		});
	}

}
