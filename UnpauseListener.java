import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class UnpauseListener implements ActionListener {
	
	private JTable table;
	private QueueSystem queue;
	
	public UnpauseListener(JTable iTable,QueueSystem q) {
		table=iTable;
		queue=q;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
				System.out.println("Unpause pressed for"+table.getSelectedRow());
				if (table.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Choose one to unpause!");
				} else if (table.getValueAt(table.getSelectedRow(), 1).toString().equals("Active")) {
					JOptionPane.showMessageDialog(null, "You are already active!");
				} else {
				String value = JOptionPane.showInputDialog(null, "Enter Session Password");
				if (value != null) {
				int del = QueueSystem.unpauseElement(queue,table.getValueAt(table.getSelectedRow(), 0).toString());
				}
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int selectedIndex = table.getSelectedRow();
				if (selectedIndex != -1) {
				    model.setValueAt("Active", selectedIndex, 1);
				}
				}
	
}
}