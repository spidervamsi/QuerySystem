import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;


 
public class RemoveListener implements ActionListener {
	
	private JList<String> list;
	private QueueSystem queue;
	
	public RemoveListener(JList<String> iList,QueueSystem q) {
		list=iList;
		queue=q;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Remove pressed for"+(String) list.getSelectedValue());
		String value = JOptionPane.showInputDialog(null, "Enter Session Password");
		if (value != null) {
		int del = QueueSystem.removeElement(queue,(String) list.getSelectedValue());
		}
		DefaultListModel model = (DefaultListModel) list.getModel();
		int selectedIndex = list.getSelectedIndex();
		if (selectedIndex != -1) {
		    model.remove(selectedIndex);
		}
	}
	
}