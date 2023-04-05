package lab_ui;


import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import lab_ui_interfaces.StatusType;
import lesson6.labs.Util;

public class BottomPanel extends JPanel {
	
	private JTextArea label;
	
	BottomPanel() {
		// TODO Auto-generated constructor stub
		setLayout(new FlowLayout(FlowLayout.LEFT));
		label = new JTextArea();
		add(label);
	}
	
	public void setText(String text, StatusType type) {
		label.setForeground(type.getColor());
		label.setText(text);
	}
}
