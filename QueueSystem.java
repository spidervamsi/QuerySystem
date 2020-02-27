import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.JOptionPane;

public class QueueSystem {

	static LinkedList<ListNode> listNodes;
	

	QueueSystem() {
		listNodes = new LinkedList<ListNode>();
	}

	public void addToQueue(String name, String email, String password) {
		ListNode temp = new ListNode();
		temp.name = name;
		temp.email = email;
		temp.password = password;
		temp.status = "unpaused";
		listNodes.add(temp);
	}
	
	public ArrayList<String> getUserNames() {
		ArrayList<String> arr = new ArrayList<String>();
		for(ListNode node:listNodes) {
			System.out.println(node.name);
			arr.add(node.name);
		}
		return arr;
	}
	
	public ArrayList<String> getUserEmails() {
		ArrayList<String> arr = new ArrayList<String>();
		for(ListNode node:listNodes) {
			System.out.println(node.email);
			arr.add(node.email);
		}
		return arr;
	}
	
	public static int removeElement(QueueSystem q, String name) {
		ListNode ele=null;
		q.printQueue();
		for(ListNode node: listNodes) {
			if(node.name.toString().equals(name)) {
				ele = node;
				break;
			}
		}	
		
		if(listNodes.remove(ele)) {return 0;}
		else {return -1;}	
	}
	
	
	public void printQueue() {
		for(ListNode node:listNodes) {
			System.out.println(node.name);
		}
	}
	
	public static QueueSystem initQueue() {
		QueueSystem input = new QueueSystem();
		input.addToQueue("Ethiraj", "Ethiraj", "ethiraj@b.com");
		input.addToQueue("Vamsi       Paused", "Youtube", "vamsi@b.com");
		input.addToQueue("Aditi", "Aditi", "Aditi@b.com");		
		
		input.printQueue();
		
		return input;
		
	}
	

	

}
