import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


 
public class RemoveListener implements ActionListener {
	
	private JTable table;
	private QueueSystem queue;
	private JLabel label;
	
	public RemoveListener(JTable iTable,QueueSystem q,JLabel empty) {
		table=iTable;
		queue=q;
		label=empty;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Remove pressed for"+table.getSelectedRow());
		if (table.getSelectedRow() < 0) {
			JOptionPane.showMessageDialog(null, "Choose one to remove!");
		} else if (table.getValueAt(table.getSelectedRow(), 1).toString().equals("Paused")) {
			JOptionPane.showMessageDialog(null, "You are already paused!");
		} else {
		
		JPasswordField passwordField = new JPasswordField();
		String value = JOptionPane.showInputDialog(null, "Enter Session Password");
		if (value != null) {
		int del = QueueSystem.removeElement(queue,table.getValueAt(table.getSelectedRow(), 0).toString());
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int selectedIndex = table.getSelectedRow();
		if (selectedIndex != -1) {
		    model.removeRow(selectedIndex);
		}
		if(model.getRowCount()==0) {
			label.setText("Queue is Empty");
			table.setVisible(false);
		}
		}
	}
	
}