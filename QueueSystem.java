import java.util.ArrayList;
import java.util.LinkedList;


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
		for(ListNode node: q.listNodes) {
			if(node.name.toString().equals(name)) {
				ele = node;
				break;
			}
		}	
		
		if(listNodes.remove(ele)) {return 0;}
		else {return -1;}	
	}
	
	public static int pauseElement(QueueSystem q, String name) {
		ListNode ele=null;
		for(ListNode node: q.listNodes) {
			if(node.name.toString().equals(name)) {
				node.status="Paused";
			}
		}	
		
		return 0;	
	}
	
	
	public static int unpauseElement(QueueSystem q, String name) {
		for(ListNode node: listNodes) {
			if(node.name.toString().equals(name)) {
				node.status="Active";
			}
		}	
		
		return 0;
	}
	
	
	public void printQueue() {
		for(ListNode node:listNodes) {
			System.out.println(node.name);
		}
	}
	
	
	
	public static QueueSystem initQueue() {
		QueueSystem input = new QueueSystem();
		input.addToQueue("Rohit","rohit@b.com", "Rohit");
		input.addToQueue("Ethiraj","ethiraj@b.com","Ethiraj");
		input.addToQueue("Vamsi","vamsi@b.com","Youtube");
		input.addToQueue("Aditi","Aditi@b.com", "Aditi");
		input.addToQueue("Jimmy","jimmy@b.com", "Jimmy");
		
		input.printQueue();
		
		return input;
		
	}
	

	

}
