import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
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
		JTextField password = new JPasswordField();
		Object[] message = {
		    "Password:", password
		};
		int option = JOptionPane.showConfirmDialog(null, message, "Enter Session Password", JOptionPane.OK_CANCEL_OPTION);
		
		if(option!=0) {return;}
		
		String value = password.getText();
		
		
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