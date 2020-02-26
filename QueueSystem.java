import java.util.ArrayList;

import javax.swing.JOptionPane;

public class QueueSystem {

	public ListNode start;
	private int size;
	

	QueueSystem() {
		size = 0;
		start = null;
	}

	public void addToQueue(String n, String e, String p) {
		int email_exists = 0;
		ListNode temp = new ListNode();
		temp.name = n;
		temp.email = e;
		temp.password = p;
		temp.status = "unpaused";
		temp.next = null;
		if (size == 0) {
			start = temp;
			start.pre = null;
			start.next = null;
		} else {
			while (start.next != null) {
				if (start.email.contentEquals(e)) {
					email_exists = 1;
				}
				start = start.next;
			}
			if (start.email.contentEquals(e)) {
				email_exists = 1;
			}
			if (email_exists == 0) {
				temp.pre = start;
				start.next = temp;
			}
			while (start.pre != null) {
				start = start.pre;
			}
		}
		if (email_exists == 1) {
			JOptionPane.showMessageDialog(null, "email already exists");
			email_exists = 0;
		}
		size++;
	}
	
	public ArrayList<String> populateArray() {
		ArrayList<String> arr = new ArrayList<String>();

		if (start != null) {
			arr.add(start.name);
			while (start.next != null) {
				start = start.next;
				arr.add(start.name);
			}
			while (start.pre != null) {
				start = start.pre;
			}
		}

		return arr;
	}
	
	public static int removeElement(QueueSystem q, String name) {
		ListNode node=q.start;
		while (node!=null) {
			if(node.name.toString().equals(name)) {
				node.pre.next=node.next;
				node.next.pre = node.pre;
				break;
			}
			node=node.next;
		}
		
		return 0;
		
	}
	public void printQueue() {
		int i = 0;
		System.out.println(i + " " + start.name);
		while (start.next != null) {
			i++;
			start = start.next;
			System.out.println(i + " " + start.name);
		}
		while (start.pre != null) {
			start = start.pre;
		}
	}
	
	public static QueueSystem initQueue() {
		QueueSystem input = new QueueSystem();
		input.addToQueue("Ethiraj", "Ethiraj", "ethiraj@b.com");
		input.addToQueue("Vamsi       Paused", "Vamsi", "vamsi@b.com");
		input.addToQueue("Aditi", "Vamsi", "Aditi@b.com");		
		
		return input;
		
	}
	

	

}
