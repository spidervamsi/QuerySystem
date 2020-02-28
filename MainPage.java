import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class MainPage extends JFrame {

	protected JFrame initialFrame;
	protected JFrame adding;

	private JButton add;
	private JButton remove;
	private JButton pause;
	private JButton unpause;
	private JPanel buttonPanel;

	public MainPage() {
		// Change
		JLabel queueStatus = new JLabel("Next Student: ");

		add(BorderLayout.NORTH, queueStatus);

		// Hardcoded initial values
		QueueSystem queue = QueueSystem.initQueue();
		String[][] initNames = new String[5][2];

		int i = 0;
		for (String name : queue.getUserNames()) {
			for (int j = 0; j < 2; j++) {
				if (j == 0) {
					initNames[i][j] = name;
				} else {
					initNames[i][j] = "Active";
				}

			}
			i++;
		}

		String[] columnNames = { "Name", "Status" };
		DefaultTableModel model = new DefaultTableModel(initNames, columnNames);
		JTable table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setRowHeight(table.getFontMetrics(table.getFont()).getHeight() + 2);
		table.setPreferredScrollableViewportSize(new Dimension(420, 250));
		table.setFillsViewportHeight(true);
		
		table.setEnabled(false);
		Font font = new Font("Arial", Font.BOLD, 25);
		JTableHeader tableHeader =table.getTableHeader();
		tableHeader.setFont(font);
		
		JPanel tablePane = new JPanel();
		tablePane.add(scroll);
		add(BorderLayout.CENTER, tablePane);

		buttonPanel = new JPanel();

		add = new JButton("Add");
		AddListener addControl = new AddListener(table, queue,queueStatus);
		add.addActionListener(addControl);

		pause = new JButton("Pause");
		ActionListener pauseControl = new PauseListener(table, queue);
		pause.addActionListener(pauseControl);

		unpause = new JButton("Unpause");
		ActionListener unpauseControl = new UnpauseListener(table, queue);
		unpause.addActionListener(unpauseControl);

		remove = new JButton("Remove");
		ActionListener removeControl = new RemoveListener(table, queue, queueStatus);
		remove.addActionListener(removeControl);

		buttonPanel.add(add);
		buttonPanel.add(pause);
		buttonPanel.add(unpause);
		buttonPanel.add(remove);
		
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		add(buttonPanel, BorderLayout.SOUTH);

	}

	public static void main(String[] args) {
		adjustFontSize(10); 
		MainPage window = new MainPage();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(700, 500);
		window.setVisible(true);
		window.setLocationRelativeTo(null);

	}

	 /*@author Matthew Hertz
	  * 
	  */
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