package prob2.control;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JFrame;

import prob2.data.Data;
import prob2.data.Logins;
import prob2.ui.*;

public enum Control {
	INSTANCE;
	Start start;
	Grades grades;
	Login login;
	String username;
	Remarks remarks;
	private boolean isLoggedIn = false;
	LastAction action = LastAction.none;
	
	enum LastAction {
		none, toGrades, toRemarks
	}
	
	
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	public void setLoggedIn(boolean b) {
		isLoggedIn = b;
	}
	
	public void setStart(Start st) {
		this.start = st;
	}
	public void backToStart(JFrame frame) {
		Control.INSTANCE.action = LastAction.none;
		frame.setVisible(false);
		start.setMessage("");
		start.setVisible(true);
	}
	
	class LoginListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			launchLogin();
		}
	}
	
	public void launchLogin() {
		login = new Login();
		start.setVisible(false);
		login.setVisible(true);
	}
	
	class LogoutListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			Control.this.isLoggedIn = false;
			Control.INSTANCE.action = LastAction.none;
			Control.INSTANCE.start.setMessage("Logout successful");
			Control.INSTANCE.start.setVisible(true);
		}
	}
	
	public void launchGrades() {
		// TODO Auto-generated method stub
		grades = new Grades();
		HashMap<String, String> gr 
			= Data.dataMap.get(Control.INSTANCE.username).getGrades();
		StringBuilder sb = new StringBuilder();
		for(String key : gr.keySet()) {
			sb.append(key + " : " + gr.get(key) + "\n");
		}
		grades.setGrades(sb.toString());
		grades.setTitle("Grades for " + Control.INSTANCE.username);
		grades.setHeading("Grades for " + Control.INSTANCE.username);
		Control.INSTANCE.start.setMessage("");
		Control.INSTANCE.start.setVisible(false);
		grades.setVisible(true);
	}
	
	public void launchRemarks() {
		remarks = new Remarks();
		HashMap<String, String> rem = Data.dataMap.get(Control.INSTANCE.username).getTeacherRemarks();
		StringBuilder sb = new StringBuilder();
		for(String key : rem.keySet()) {
			sb.append(key + " : " + rem.get(key) + "\n");
		}
		remarks.setRemarks(sb.toString());
		remarks.setTitle("Teacher Remarks for " + Control.INSTANCE.username);
		remarks.setHeading("Teacher Remarks for " + Control.INSTANCE.username);
		Control.INSTANCE.start.setMessage("");
		Control.INSTANCE.start.setVisible(false);
		remarks.setVisible(true);
	}
	
	class RemarksListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			
			if (Control.this.isLoggedIn) {
				launchRemarks();
			} else {
				Control.INSTANCE.action = LastAction.toRemarks;
				launchLogin();
			}
			
		}
	}
	
	class GradesListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			if (Control.this.isLoggedIn) {
				launchGrades();
			} else {
				Control.INSTANCE.action = LastAction.toGrades;
				launchLogin();
			}
			
		}		
	}
	class SubmitLoginListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			String username = login.getUserName();
			String password = login.getPassword();
			if(!Logins.foundUserNamePwd(username, password)) {
				login.setMessage("Login failed.");
			} else {
				Control.this.username = username;
				Control.this.isLoggedIn = true;
				login.setMessage("Successful login");
				if (action != LastAction.none) {
					if (action == LastAction.toGrades) {
						launchGrades();
					} else {
						launchRemarks();
					}
					login.setVisible(false);
				}
			}
		}
	}
	public SubmitLoginListener getSubmitLoginListener() {
		return new SubmitLoginListener();
	}
	public LoginListener getLoginListener() {
		return new LoginListener();
	}
	
	public LogoutListener getLogoutListener() {
		return new LogoutListener();
	}
	
	public RemarksListener getRemarksListener() {
		return new RemarksListener();
	}
	public GradesListener getGradesListener() {
		return new GradesListener();
	}
}
