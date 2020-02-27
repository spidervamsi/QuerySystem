import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QueueSystem {
	
	class ListNode {
		String name;
		String email;
		String password;
		String status;
		ListNode pre;
		ListNode next;
	}
	
	private ListNode start;
	private int size;
	QueueSystem queue;
	
	QueueSystem(){
		size = 0;
		start = null;	
	}
	
	protected JFrame initialFrame;
	protected JFrame adding;
	private JFrame sessionP;
	private JButton add;
	private JButton remove;
	private JButton pause;
	private JButton unpause;
	private JButton submit;
	private JButton submitP;
	private JPanel panel;
	private JPanel paneli;
	private JPanel panels;
	
	public void addToQueue(String n,String e, String p){
		int email_exists=0;
		ListNode temp = new ListNode();
		temp.name = n;
		temp.email = e;
		temp.password = p;
		temp.status = "unpaused";
		temp.next = null;
		if(size == 0) {
			start = temp;
			start.pre = null;
			start.next = null;
		}else {
			while(start.next!=null) {
				if(start.email.contentEquals(e)) {
					email_exists=1;
				}
				start = start.next;
			}
			if(start.email.contentEquals(e)) {
				email_exists=1;
			}
			if(email_exists==0) {
			temp.pre=start;
			start.next= temp;
			}
			while(start.pre !=null) {
				start=start.pre;
			}
		}
    	if(email_exists==1) {
    		JOptionPane.showMessageDialog(null, "email already exists");
    		email_exists=0;
    	}
		size++;
	}
	
	public void printQueue() {
		int i=0;
		System.out.println(i+" "+start.name);
		while(start.next!=null) {
			i++;
			start = start.next;
			System.out.println(i+" "+start.name);
		}
		while(start.pre !=null) {
			start=start.pre;
		}
	}
	
	public void initialWindow() {
		queue = new QueueSystem();
		initialFrame = new JFrame();
		initialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add = new JButton();
		remove = new JButton();
		pause = new JButton();
		unpause = new JButton();
		add.setText("Add");
		remove.setText("Remove");
		pause.setText("Pause");
		unpause.setText("Unpause");
		panel = new JPanel();
		
		add.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e)
		    { 
		    	adding = new JFrame();
		    	paneli= new JPanel();
		    	adding.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    	submit = new JButton();
		    	submit.setText("submit");
		        JTextField nameT = new JTextField("name");
		        JTextField emailT = new JTextField("email");
		    	submit.addActionListener(new ActionListener() {

		            @Override
		            public void actionPerformed(ActionEvent e) {
		                String nameS = nameT.getText();
		                String emailS = emailT.getText();
		                
				    	sessionP = new JFrame();
				    	panels= new JPanel();
				    	sessionP.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				    	submitP = new JButton();
				    	submitP.setText("submit");
				        JTextField session_pass = new JTextField("session password");				        
				        submitP.addActionListener(new ActionListener() {
				        @Override
			            public void actionPerformed(ActionEvent e) {
				        	String sessP = session_pass.getText();
				        	queue.addToQueue(nameS, emailS, sessP);
				        	queue.printQueue();
				        }
				        });
				        panels.setLayout(null);
				    	submitP.setBounds(200, 200, 80, 50);
				 		panels.add(submitP);
				 		session_pass.setBounds(100, 150, 300, 50);
				 		panels.add(session_pass);
				 		sessionP.add(panels);
				        sessionP.setSize(500, 500);
				        sessionP.setVisible(true);
		                
		            }
		        });
		    	paneli.setLayout(null);
		    	submit.setBounds(200, 250, 80, 50);
		 		paneli.add(submit);
		    	nameT.setBounds(100, 150, 300, 50);
		 		paneli.add(nameT);
		    	emailT.setBounds(100, 200, 300, 50);
		 		paneli.add(emailT);
		 		adding.add(paneli);
				panel.setLocation(0,0);
		    	adding.setSize(500, 500);
		    	adding.setVisible(true);
		    }
		});
		
		remove.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e)
		    { 
		    	sessionP = new JFrame();
		    	panels= new JPanel();
		    	sessionP.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    	submitP = new JButton();
		    	submitP.setText("submit");
		        JTextField session_pass = new JTextField("session password");				        
		        submitP.addActionListener(new ActionListener() {
		        @Override
	            public void actionPerformed(ActionEvent e) {
		        	String sessP = session_pass.getText();
		        }
		        });
		        panels.setLayout(null);
		    	submitP.setBounds(200, 200, 80, 50);
		 		panels.add(submitP);
		 		session_pass.setBounds(100, 150, 300, 50);
		 		panels.add(session_pass);
		 		sessionP.add(panels);
		        sessionP.setSize(500, 500);
		        sessionP.setVisible(true);
                
		    }
		});
		
		pause.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e)
		    { 
		    	sessionP = new JFrame();
		    	panels= new JPanel();
		    	sessionP.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    	submitP = new JButton();
		    	submitP.setText("submit");
		        JTextField session_pass = new JTextField("session password");				        
		        submitP.addActionListener(new ActionListener() {
		        @Override
	            public void actionPerformed(ActionEvent e) {
		        	String sessP = session_pass.getText();
		        }
		        });
		        panels.setLayout(null);
		    	submitP.setBounds(200, 200, 80, 50);
		 		panels.add(submitP);
		 		session_pass.setBounds(100, 150, 300, 50);
		 		panels.add(session_pass);
		 		sessionP.add(panels);
		        sessionP.setSize(500, 500);
		        sessionP.setVisible(true);
                
		    }
		});
		
		unpause.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e)
		    { 
		    	sessionP = new JFrame();
		    	panels= new JPanel();
		    	sessionP.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		    	submitP = new JButton();
		    	submitP.setText("submit");
		        JTextField session_pass = new JTextField("session password");				        
		        submitP.addActionListener(new ActionListener() {
		        @Override
	            public void actionPerformed(ActionEvent e) {
		        	String sessP = session_pass.getText();
		        }
		        });
		        panels.setLayout(null);
		    	submitP.setBounds(200, 200, 80, 50);
		 		panels.add(submitP);
		 		session_pass.setBounds(100, 150, 300, 50);
		 		panels.add(session_pass);
		 		sessionP.add(panels);
		        sessionP.setSize(500, 500);
		        sessionP.setVisible(true);
                
		    }
		});
		
	    panel.setLayout(null);
		add.setBounds(0, 350, 125, 100);
		panel.add(add);
		remove.setBounds(125, 350, 125, 100);
		panel.add(remove);
		pause.setBounds(250, 350, 125, 100);
		panel.add(pause);
		unpause.setBounds(375, 350, 125, 100);
		panel.add(unpause);
		initialFrame.add(panel);
		panel.setLocation(0,0);
		
		initialFrame.setSize(500, 500);
		initialFrame.setVisible(true);	
	}
	
	public static void main(String[] args) {
		QueueSystem qs= new QueueSystem();
		qs.initialWindow();
	}
}
