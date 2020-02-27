import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AddListener implements ActionListener {
	
	private JList<String> list;
	private QueueSystem queue;
	
	public AddListener(JList<String> iList,QueueSystem q) {
		list=iList;
		queue=q;
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
		if(username.getText().length()==0) {JOptionPane.showMessageDialog(null, "please enter a username");return;}
		if(email.getText().length()==0) {JOptionPane.showMessageDialog(null, "please enter a email");return;}
		if(password.getText().length()==0) {JOptionPane.showMessageDialog(null, "please enter a password");return;}
		if(rePassword.getText().length()==0) {JOptionPane.showMessageDialog(null, "password doesn't match");return;}
		
		ArrayList<String> usernames = queue.getUserNames();
		if(usernames.contains(username.getText())) {JOptionPane.showMessageDialog(null, "username already exists");return;}
		
		ArrayList<String> useremail = queue.getUserEmails();
		if(useremail.contains(email.getText())) {JOptionPane.showMessageDialog(null, "EamilId already exists");return;}
		
		
			queue.addToQueue(username.getText(), email.getText(), password.getText());
		
		DefaultListModel model = (DefaultListModel) list.getModel();	
		model.addElement(username.getText());
		
	}

}
