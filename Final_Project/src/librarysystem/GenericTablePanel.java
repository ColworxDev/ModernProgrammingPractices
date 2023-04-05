package librarysystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import business.CheckoutRecord;
import business.CheckoutRecordEntity;
import business.SystemController;

//Generic helper class for windows using Table
public class GenericTablePanel extends JPanel {
	private JTable tableView;
	
	public JTable getTableView() {
		return tableView;
	}

	public GenericTablePanel(ListSelectionListener delegate) {
		// TODO Auto-generated constructor stub
		super(new GridLayout(1,0));
		 
		String[] columnNames = {
				"CheckoutDate", "Due Date", "BookTitle", "BookISBN", "Copy No", "is Available"
				};
		
		tableView = new JTable(new DefaultTableModel(columnNames, 0));
		if (delegate != null) {
			tableView.getSelectionModel().addListSelectionListener(delegate);
		}
		
		tableView.setPreferredScrollableViewportSize(new Dimension(500, 70));
		tableView.setFillsViewportHeight(true);
		tableView.getTableHeader().setDefaultRenderer(new SimpleHeaderRenderer());
		tableView.setOpaque(false);
        tableView.setVisible(false);
        
 
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(tableView);
 
        //Add the scroll pane to this panel.
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        
        add(scrollPane);
        setOpaque(false); //content panes must be opaque
	}
	
	//method for refresh data in Table
	public void refreshDataWith(String[] columns, String[][] rows) {
		
		try {
			if(rows != null && rows.length > 0) {
				DefaultTableModel model = (DefaultTableModel) tableView.getModel();
				model.setDataVector(rows, columns);
				tableView.setVisible(true);
			} else {
				tableView.setVisible(false);
			}
		} catch (Exception e) {
//			e.printStackTrace();
		}
	}
	
	final class SimpleHeaderRenderer extends JLabel implements TableCellRenderer {
		
		public SimpleHeaderRenderer() {
			setFont(new Font("Consolas", Font.BOLD, 14));
			setForeground(Color.BLUE);
			setBorder(BorderFactory.createEtchedBorder());
		}
		
		public Component getTableCellRendererComponent(JTable table, Object value,
				boolean isSelected, boolean hasFocus, int row, int column) {
			setText(value.toString());
			return this;
		}
	}
}
