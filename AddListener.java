import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AddListener implements ActionListener {
	
	private JTable table;
	private QueueSystem queue;
	private JLabel label;
	
	public AddListener(JTable iTable,QueueSystem q, JLabel empty) {
		table=iTable;
		queue=q;
		label=empty;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JTextField username = new JTextField();
		JTextField email = new JTextField();
		JTextField password = new JPasswordField();
		JTextField rePassword = new JPasswordField();
		Object[] message = {
		    "Username:", username,
		    "Email Id:", email,
		    "Password:", password,
		    "Re-Enter Password:", rePassword,
		};
		
		int option = JOptionPane.showConfirmDialog(null, message, "CREATE ACCOUNT", JOptionPane.OK_CANCEL_OPTION);
		
		System.out.println("email "+email.getText().length());
		
		if(option == 2 ) {return;}
		if(username.getText().length()==0&&email.getText().length()==0) {return;}
		if(username.getText().length()==0) {JOptionPane.showMessageDialog(null, "Please enter a username");return;}
		if(email.getText().length()==0) {JOptionPane.showMessageDialog(null, "Please enter a email");return;}
		if(password.getText().length()==0) {JOptionPane.showMessageDialog(null, "Please enter a password");return;}
		if(rePassword.getText().length()==0) {JOptionPane.showMessageDialog(null, "Password did not match");return;}
		
		ArrayList<String> usernames = queue.getUserNames();
		if(usernames.contains(username.getText())) {JOptionPane.showMessageDialog(null, "Username already exists");return;}
		
		ArrayList<String> useremail = queue.getUserEmails();
		if(useremail.contains(email.getText())) {JOptionPane.showMessageDialog(null, "EamilId already exists");return;}
		
		
			queue.addToQueue(username.getText(), email.getText(), password.getText());
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();	
		model.addRow(new Object[]{username.getText(),"Active"});
		if(label.getText().equals("Queue is Empty")) {
			label.setText("Next Student :");
			table.setVisible(true);
		}
		
	}

}
