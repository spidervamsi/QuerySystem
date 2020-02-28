import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PauseListener implements ActionListener {

	private JTable table;
	private QueueSystem queue;

	public PauseListener(JTable iTable, QueueSystem q) {
		table = iTable;
		queue = q;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Pause pressed for" + table.getSelectedRow());
		System.out.println(table.getValueAt(table.getSelectedRow(), 1).toString());
		if (table.getSelectedRow() < 0) {
			JOptionPane.showMessageDialog(null, "Choose one to pause!");
		} else if (table.getValueAt(table.getSelectedRow(), 1).toString().equals("Paused")) {
			JOptionPane.showMessageDialog(null, "You are already paused!");
		} else {

			String value = JOptionPane.showInputDialog(null, "Enter Session Password");
			if (value != null) {
				int del = QueueSystem.pauseElement(queue, table.getValueAt(table.getSelectedRow(), 0).toString());
			}
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			int selectedIndex = table.getSelectedRow();
			if (selectedIndex != -1) {
				model.setValueAt("Paused", selectedIndex, 1);
				;
			}
		}

	}
}