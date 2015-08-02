package linkedListProblems;
import java.util.HashSet;
import java.util.Set;


public class LinkedListLoop {
	
	private Node head = null;
	
	public static void main(String[] args) {
		//build the list
		LinkedListLoop llp = new LinkedListLoop();
		llp.buildList();
		
		//test if circular
		System.out.println("TEST RESULT");
		assert(llp.testCircular() == true);
		System.out.println("Circular");

	}
	
	public LinkedListLoop(){
		head = null;
	}
	
	public LinkedListLoop(Node newLinkedListHead){
		this.head = newLinkedListHead;
	}
	
	public void buildList(){
		Node a = new Node("a", null);
		Node b = new Node("b", a);
		Node c = new Node("a", b); //new node, duplicate data, since its a new node object -its not dup
		Node d = new Node("d", c);
		Node e = new Node("e", d);
		a.next = c; 	//creates the circular list
		//a.next = null; 	//no circular list
		this.head = e;	//head node
		
//		System.out.println(a.hashCode());
//		System.out.println(b.hashCode());
//		System.out.println(c.hashCode()); // Node c has different hashCode from Node a.
//		System.out.println(d.hashCode());
//		System.out.println(e.hashCode());
		
		
	}
	
	public boolean testCircular(){	
		return testCircular(this.head);
		//return testCircularWithSet(this.head); // Test with Set 
	}
	
	/** Returns true if list is circular - Uses a Set */
	private boolean testCircularWithSet(Node x){
		// Use a set to add all elements - in case of a cycle- stop at first dup elements
		// Issue - if same objects are present in the list, at different positions
		// then Set might report duplicate, best is to override equals() such that
		// the reference of next node is also considered when looking for identical nodes
		// Observation - default equals() method will take care of this, since even if 
		// data is same, its a new Object, hence different hashCode. 
		Set<Node> setOfNodes = new HashSet<Node>();
		Node refNode = x;
		
		//first test for refNode is not null, then add
		//if refNode is present in Set, add returns false
		while(refNode != null && setOfNodes.add(refNode) )
			refNode = refNode.next;
		//loop will terminate if end of list reached, or same node added twice
		if(refNode == null)	return false; //List not circular
		return true;//List circular
	}
	
	/**
	 * Floyds Cycle-Finding Algorithm:
	 * Returns true if loop found
	 */
	private boolean testCircular(Node x){
		
		Node fast = x; //both point to head
		Node slow = x; 
		
		while(fast != null && fast.next != null && slow != null){
			fast = fast.next.next;
			slow = slow.next;
			
			if(fast == slow)	return true;
		}
		return false;
	}
	
	
	private class Node{
		String item;
		Node next;
		
		public Node(String str, Node next){
			this.item = str;
			this.next = next;
		}
		
		@Override
		public String toString(){
			return String.format(item);
		}
	}
	
	

}
