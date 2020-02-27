import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

public class MainPage extends JFrame{

	
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
	private JPanel buttonPanel;
	private JList<String> queueList;
	private JLabel title;
	private JList<String>  myList;

	
	public MainPage() {
		JLabel description = new JLabel("Who should be called on next: ");
		add(BorderLayout.NORTH, description);
		queueList = new JList();
		
		QueueSystem queue=QueueSystem.initQueue();
		DefaultListModel dlm1=new DefaultListModel();
		queueList.setModel(dlm1);		
		for(String name : queue.getUserNames()) {
			dlm1.addElement(name);
		}
	
		add(BorderLayout.CENTER, queueList);
		
		JList myList2 = new JList();
		
		// Finally, create the button component.
		JButton button = new JButton("Add a student");
		buttonPanel=new JPanel();
		add = new JButton("Add");
		pause = new JButton("Pause");
		unpause = new JButton("Unpause");
		
		remove = new JButton("Remove");
		ActionListener removeControl = new RemoveListener(queueList,queue);
		AddListener addControl = new AddListener(queueList,queue);
		remove.addActionListener(removeControl);
		add.addActionListener(addControl);
		buttonPanel.add(add);
		buttonPanel.add(pause);
		buttonPanel.add(unpause);
		buttonPanel.add(remove);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		add(buttonPanel, BorderLayout.SOUTH);
        
	}

	

	
	@SuppressWarnings("unchecked")
	/*public void initialWindow() {
		
		
		initialFrame = new JFrame();
		initialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		/*add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				adding = new JFrame();
				paneli = new JPanel();
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
						panels = new JPanel();
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
				panel.setLocation(0, 0);
				adding.setSize(500, 500);
				adding.setVisible(true);
			}
		});

		remove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("###" + ((String) queueList.getSelectedValue()));
				sessionP = new JFrame();
				panels = new JPanel();
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

		pause.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sessionP = new JFrame();
				panels = new JPanel();
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

		unpause.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sessionP = new JFrame();
				panels = new JPanel();
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

		

		initialFrame.setSize(500, 500);
		initialFrame.setVisible(true);
	}*/

	public static void main(String[] args) {
		adjustFontSize(15); // Only needed to scale the font for lectures

		MainPage window = new MainPage();

		// Finish setting up this window.
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.setSize(700, 500);
		window.setVisible(true);
		window.setLocationRelativeTo(null);
		
		
		
	}
	
	public static void adjustFontSize(int adjustment) {

		UIDefaults defaults = UIManager.getDefaults();
		List<Object> newDefaults = new ArrayList<Object>();
		Map<Object, Font> newFonts = new HashMap<Object, Font>();

		Enumeration<Object> en = defaults.keys();
		while (en.hasMoreElements()) {
			Object key = en.nextElement();
			Object value = defaults.get(key);
			if (value instanceof Font) {
				Font oldFont = (Font) value;
				Font newFont = newFonts.get(oldFont);
				if (newFont == null) {
					newFont = new Font(oldFont.getName(), oldFont.getStyle(), oldFont.getSize() + adjustment);
					newFonts.put(oldFont, newFont);
				}
				newDefaults.add(key);
				newDefaults.add(newFont);
			}
		}
		defaults.putDefaults(newDefaults.toArray());
	}
}