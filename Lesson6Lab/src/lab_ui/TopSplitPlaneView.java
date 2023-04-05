package lab_ui;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import lab_app.Data;
import lesson6.labs.Auth;

public class TopSplitPlaneView extends JSplitPane {
	
	private JSplitPane splitPane;
	private JList<String> nameList;
	private JPanel cardDeck;
	private LoginPanel loginPanel;
	private ViewTitles viewtitlePanel;
	private AddBookView addbookPanel;
	private PanelViewType selectedViewType;
	
	
	enum PanelViewType {
		Login, ViewTitles, AddBook
	}
	
	TopSplitPlaneView() {
		// TODO Auto-generated constructor stub
		setUpLists();
		setUpCards();
		setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		setLeftComponent(nameList);
		setRightComponent(cardDeck);
		setDividerLocation(150);
	}
	
	public JSplitPane getSplitPlane() {
		return splitPane;
	}
	
	
	private void setUpLists() {
		// TODO Auto-generated method stub
		
		nameList = new JList<String>(new String[] {"Login", "View Titles", "Add Book"});
		nameList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		nameList.setSelectedIndex(0);
		refreshListRenderer();
		nameList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
					showSelected(nameList.getSelectedValue());
			}
			
			
		});
		
	}
	
	public void refreshListRenderer() {
		nameList.setCellRenderer(new DisabledItemListCellRenderer());
	}
	
	private class DisabledItemListCellRenderer extends DefaultListCellRenderer {
		@Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component comp = super.getListCellRendererComponent(list, value, index, false, false);
            JComponent jc = (JComponent) comp;
            
            Boolean isItemEnabled = true;
            if (Data.INSTANCE.currentAuth == Auth.SELLER) {
            	isItemEnabled = index != 1;
            } else if (Data.INSTANCE.currentAuth == Auth.MEMBER) {
            	isItemEnabled = index != 2;
            } else if (Data.INSTANCE.currentAuth == null) {
            	isItemEnabled = false;
            }
            
            if (isItemEnabled) {
            	if (nameList.getSelectedIndex() == index) {
                    comp.setForeground(Color.black);
                    comp.setBackground(Color.getHSBColor(51, 204, 255));
                } else {
                    comp.setForeground(Color.blue);
                    comp.setBackground(Color.white);
                }
            } else {
            	comp.setForeground(Color.gray);
            	comp.setBackground(Color.white);
            }
            comp.setEnabled(isItemEnabled);
            return comp;
		}
	
	}
	
	public void showSelected(String value) {
		if (value.equals("View Titles")) {
			getViewTitlesPanel().refreshText();
		}
		((CardLayout)(cardDeck.getLayout())).show(cardDeck, value);
	}
	
	public LoginPanel getLoginPanel() {
		if (loginPanel == null) {
			loginPanel = new LoginPanel();
		}
		return loginPanel;
	}
	
	public ViewTitles getViewTitlesPanel() {
		if (viewtitlePanel == null) {
			viewtitlePanel = new ViewTitles();
		}
		return viewtitlePanel;
	}
	
	public AddBookView getAddBookPanel() {
		if (addbookPanel == null) {
			addbookPanel = new AddBookView();
		}
		return addbookPanel;
	}
	
	private void setUpCards() {
		cardDeck = new JPanel();
		//set its layout as CardLayout
		cardDeck.setLayout(new CardLayout());
		
		
		JPanel thirdPanel = new JPanel();
		thirdPanel.add(new JLabel("This third card"));
		//add all panels to deck
		cardDeck.add("Login", getLoginPanel());
		cardDeck.add("View Titles", getViewTitlesPanel());
		cardDeck.add("Add Book", getAddBookPanel());
	}

}
