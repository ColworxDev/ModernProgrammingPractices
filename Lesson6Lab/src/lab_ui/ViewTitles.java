package lab_ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import lab_app.Data;
import lesson6.labs.Util;

public class ViewTitles extends JPanel {

	private JTextArea textarea;
	

	ViewTitles() {
		// TODO Auto-generated constructor stub
		setLayout(new BorderLayout());
		
		addtopPanel();
		textarea = new JTextArea();
		JScrollPane textPanel = new JScrollPane(textarea);
		textPanel.setPreferredSize(new Dimension(100, 150));
		add(textPanel, BorderLayout.CENTER);
	}
	
	private void addtopPanel() {
		JPanel intPanel = new JPanel();
		intPanel.setLayout(new BorderLayout());
		intPanel.add(Box.createRigidArea(new Dimension(0,20)), BorderLayout.NORTH);
		
		JLabel loginLabel = new JLabel("View Titles");
		Util.adjustLabelFont(loginLabel, Color.BLUE.darker(), true);
		intPanel.add(loginLabel, BorderLayout.CENTER);
		add(intPanel, BorderLayout.NORTH);
	}
	
	public void refreshText() {
		textarea.setText(String.join("\n", Data.INSTANCE.bookTitles));
	}
}
