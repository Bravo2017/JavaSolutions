package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedList<E extends Comparable<E>> {
	Node<E> head;

	// add to the head
	public void add(E data) {
		Node<E> newNode = new Node(data);
		if (head == null)
			head = newNode;
		else {
			newNode.setNext(head);
			head = newNode;
		}
	}
		
	public void displayList() {
		for (Node<E> current = head; current != null; current = current.getNext())
			System.out.print(current + " ");
		System.out.println();
	}

	
	//NTH to Last Elemnt
	//Recursive solution
	public void findNthToLastElement(int nth){
		findNthToLastElement(head, nth );
	}

	// Find the nth node, does not print it.
	private int findNthToLastElement(Node<E> n, int nth) {
		// if out of list - or - empty list - counter-intuitive
		// can use a static variable instead of  passing the int, but static variables 
		// retain values between calls, and method wont work for a second call.
		// base case
		if (n == null)			
			return 0; //return -1 if assuming last element is 0

		//current index = 1 + index of next element, while counting backwards
		int k = 1 + findNthToLastElement(n.getNext(), nth);

		if (k == nth) {
			System.out.println(n);
		}
		return k;
	}
	
	public void returnNthToLastElement(int k){
		// cannot use Integer since its immutable - so create a non-immutable
		// class and use its field to keep count
		// Similar to passing a pointer
		System.out.println(returnNthToLastElement(head, k, new IntValue() ) );
	}
	
	//create a Wrapper class, with that class we can return both Node and int
	private class IntValue{
		public int value = 0;
	}
	
	private Node<E> returnNthToLastElement(Node<E> x, int k, IntValue i) {
		// base case 
		if (x == null)	return null;
		// count index from end of list to current position.
		Node<E> temp = returnNthToLastElement(x.next, k, i);
		i.value = i.value + 1;

		if (i.value == k)
			return x;   // we are at x now

		return temp;	// keep on returning till value = k
	}
	
	
	
	//iterative solution - use two references separated by N
	public void NthToLastELementIterative(int nth){
		
		Node<E> fast = head;
		Node<E>	slow = head;
		
		int gap = 0;
		// move fast pointer n node ahead.
		while(gap < nth){
			fast = fast.getNext();
			// if fast == null, th node doesnt exist in the list
			if(fast == null){
				return;
			}
			++gap;
		}
		
		//while(fase != null) //depending what is index of last element : 0 or 1
		while(fast.next != null){
			fast = fast.getNext();
			slow = slow.getNext();
		}
		System.out.println(slow);
	}
	
	
	//print in reverse 
	//similar to get Nth from end
	//if length of list is known, run for loop, call getNthElementToLast() from 1 to N;
	
	//implement without calculating length - recursive 
	public void printListReverse(){
		printListReverse(head,new IndexValue());
	}
	private class IndexValue{
		int x = -1; //if starting index = 0, else x = 0 if starting index = 1
	}
	private void printListReverse(Node<E> x, IndexValue index){
		if(x == null) return ;
		printListReverse(x.next, index);
		index.x += 1;
		System.out.printf("[%d]: %s%n", index.x, x);
	}
	
	
	
	//add a node to a sorted - increasing linked list
	public void sortedListVer2(Node<E> newNode) {
		E data = newNode.getKey();
		// test for head
		if (head == null || head.getKey().compareTo(data) > 0) {
			newNode.setNext(head);
			head = newNode;
		} else {
			Node<E> current = head;
			while (current.getNext() != null
					&& current.getNext().getKey().compareTo(data) <= 0) {
				current = current.getNext();
			}// end of while - all nodes in list are lesser than new node
			newNode.setNext(current.getNext());
			current.setNext(newNode);
		}
	}
	//add a node to a sorted - increasing linked list
	public void sortedList(E data) {
		Node<E> newNode = new Node<E>(data);
		sortedListVer2(newNode);
	}

	//previous implmentation - 
	/*public void sortedListVer1(E data) {
		Node<E> newNode = new Node<E>(data);
		Node<E> current = head;
		// test for head
		if (head == null || head.getKey().compareTo(data) > 0) {
			newNode.setNext(head);
			head = newNode;
		} else {
			while (current.getNext() != null) {
				if (current.getNext().getKey().compareTo(data) > 0) {
					newNode.setNext(current.getNext());
					current.setNext(newNode);
					return;
				}
				current = current.getNext();
			}//end of while - all nodes in list are lesser than new node
			current.setNext(newNode);
		}
	}*/
	
	public void recursiveReverse2(){
		head = recursiveReverse2(head);		
	}
	
	//return the new head - if head is not a global variable.
	//useful solution in C. not in OOP
	//general idea to return a node, while backtracking
	//check - selectiveReverse()
	private Node<E> recursiveReverse2(Node<E> x){
		//for null head
		if(x == null) 	return x;
		
		// actual base case- for non-null linked list
		if(x.getNext() == null)	return x;
		else{			
			Node<E> temp = recursiveReverse2(x.getNext());
			x.getNext().setNext(x);
			x.setNext(null);
			return temp;
		}
	}
	
	public void recursiveReverse1() {
		recursiveReverse1(this.head);
	}
	private void recursiveReverse1(Node<E> x) {
		if (x == null || x.getNext() == null ) {
			head = x;
			return;
		}
		
		recursiveReverse1(x.getNext());
		
		//when the method returns, we are pointing to the current node
		//make current.next.next to point to current
		x.next.next = x;
		x.next = null;
//		tail = x; // keep updating - tail traverses from behind to the head
	}
	
	/**
	 * Reverse only a portion of a linked list -	 
	 * Need to handle last element points to null 
	 */
	
	public void selectiveRecurseReverse(int s, int e){
			
		Node<E> start = head;
		for(int i = 1;i < s-1; ++i)		start = start.getNext();
		Node<E> end = start;
		for(int i = s-1; i < e+1; ++i)	end = end.getNext();
		
		Node<E> tail = selectiveRecurseReverse(start, end, start.getNext());
		start.next.next = end;
		start.next = tail;
	}
	
	private Node<E> selectiveRecurseReverse(Node<E> s, Node<E> t, Node<E> current){
		if(current == null || current.getNext().equals(t)){
//			s.next = current;
			return current;
		}			
		else{
			Node<E> temp = selectiveRecurseReverse(s, t, current.getNext());
			current.getNext().setNext(current);
//			temp.setNext(current);
			return temp;
		}		
	}
	
	
	public void recursiveReversePrint(){
		recursiveReversePrint(head);
	}
	private void recursiveReversePrint(Node<E> x){
		if(x == null){
			return;
		}
		// if(x.getNext() == null){
			// System.out.print(x + " ");
		// }
		else{
			recursiveReversePrint(x.getNext());
			System.out.print(x + " ");
		}
	}


	public void removeDuplicates(){
		
		Node<E> next =  head.getNext();
		Node<E> current =  head;
//		while(next !=  null){
//			if (current.getKey().equals(next.getKey())) {
//				current.setNext(next.getNext());
//			}else{
//				current = current.getNext();
//			}
//			next = next.getNext();
//		}
		
		// more elegant - single pointer
		while(current.next != null){
			if(current.key.equals(current.next.key))
				current.next = current.next.next;
			else	
				current = current.next;
		}
		
	}
	//Set and one pointer
	public void removeDuplicateFromUnsortedList2() {
		Set<Node<E>> set = new HashSet<Node<E>>();
		
		set.add(head); // need to add head now,to  detect nodes similar to head
		for (Node<E> current = head; current.next != null;) {
			if (!set.add(current.next)) {
				//if next element cannot be added, rearrange next pointer of current element
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
	}
	
	//Set and two pointers
	public void removeDuplicateFromUnsortedList3(){
		Set<Node<E>> set = new HashSet<Node<E>>();
		Node<E> currRef = head;
		Node<E> prevRef = null;
		while(currRef != null){
			if(!set.add(currRef)){
				prevRef.next = currRef.next;
			}else{
				prevRef = currRef;
			}
			currRef = currRef.next;
		}
	}
	
	//without additional data structures
	public void removeDuplicateFromUnsortedList1() {
		Node<E> current = head;
		Node<E> runner = head;

		while(current.next != null){
			runner = current;
			while(runner.next != null){
				if(current.key.equals(runner.next.key)){
					runner.next = runner.next.next;
				}
				else{
					runner = runner.next;
				}
			}
			current = current.next;
		}
		
		//another was of terminating loops
//		while(current != null){
//			runner = current;
//			while(runner!= null){
//				if(runner.next != null && current.key.equals(runner.next.key)){
//					runner.next = runner.next.next;
//				}
//				else{
//					runner = runner.next;
//				}
//			}
//			current = current.next;
//		}
		
	}
	
	
	//test if circular
	public boolean testCircular(){
		return testCircular(head);
	}
	
	private boolean testCircular(Node<E> x){
		
		Node<E> fast = head;
		Node<E> slow = head;
		while(fast != null && fast.next!= null && slow != null){
//			if(fast.next == null)	break;
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow)	break;
		}
		if(fast != null && fast == slow)	return true;
		else								return false;
	}
	
	//test code
	public Node<String> createCircularList() {

		Node<String> tanmay = new Node<String>("tanmay");
		Node<String> chinmay = new Node<String>("tanmay");
		Node<String> chitta = new Node<String>("chitta");
		Node<String> ranju = new Node<String>("ranju");
		Node<String> ipsita = new Node<String>("ipsita");

		tanmay.next = chinmay;
		chinmay.next = chitta;
		chitta.next = ranju;
		ranju.next = ipsita;
		ipsita.next = ipsita;

		return tanmay;
	}
	
	/**	Partition List   
	 * 
	 * 
	 */
	
	Node<E> headLessThan = null;
	Node<E> tailLessThan = headLessThan;
	Node<E> headEqualTo = null;
	Node<E> tailEqualTo = headEqualTo;
	Node<E> headGreaterThan = null;
	Node<E> tailGreaterThan = headGreaterThan;

	public void partitionList(E val){
		
		//pointers to mark start and end of each sub-lists
//		Node<E> headLessThan = null;Node<E> headEqualTo = null;Node<E> headGreaterThan = null;
//		Node<E> tailLessThan = null;Node<E> tailEqualTo = null;Node<E> tailGreaterThan = null;

		Node<E> x = head;
		Node<E> next = null;
		while(x != null){
			next = x.next;
			x.next = null;
			//if (x.data < val)
			if(x.key.compareTo(val) < 0)		
				moveLNode(x);
			else if(x.key.compareTo(val) == 0)	
				moveENode(x);
			else
				moveGNode(x);
			
			x = next;
		}
		
		//merge all lists
		if(headLessThan != null){
			head = headLessThan; //Head of merged list
			if(headEqualTo != null)	{
				tailLessThan.next = headEqualTo;
				if(headGreaterThan != null)	tailEqualTo.next = headGreaterThan;
				//else nothing
			}else{
				if(headGreaterThan != null)	tailLessThan.next = headGreaterThan;
				//else nothing
			}
		}else if(headEqualTo != null){
				head = headEqualTo;
				if(headGreaterThan != null)	tailEqualTo.next = headGreaterThan;
				//else nothing
		}else if(headGreaterThan != null)
				head = headGreaterThan;
		else{}
		
	}

	private void moveLNode(Node<E> x){
		if(headLessThan == null){
			headLessThan = x;
			tailLessThan = x;
		}else{
			tailLessThan.next = x;
			tailLessThan = x;
		}
	}
	private void moveENode(Node<E> x){
		if(headEqualTo == null){
			headEqualTo = x;
			tailEqualTo = x;
		}else{
			tailEqualTo.next = x;
			tailEqualTo = x;
		}
	}
	
	private void moveGNode(Node<E> x){
		if(headGreaterThan == null){
			headGreaterThan = x;
			tailGreaterThan = x;
		}else{
			tailGreaterThan.next = x;
			tailGreaterThan = x;
		}
	}
	
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder(); 
		for (Node<E> current = head; current != null; current = current.getNext())
			sb.append(current.key + " ");

		return new String(sb);
	}

	
	
	private class Node<E extends Comparable<E>> {
		private E key;
		Node<E> next;

		public Node(){
			key = null; next = null;
		}
		
		
		public Node(E key) {
			this.key = key;
			next = null;
		}		

		public void setNext(Node<E> next) {
			this.next = next;
		}

		public Node<E> getNext() {
			return this.next;
		}

		@Override
		public String toString() {
			return String.format("%s", key);
		}

		/**
		 * @return the key
		 */
		public E getKey() {
			return key;
		}

		/**
		 * @param key the key to set
		 */
		public void setKey(E key) {
			this.key = key;
		}

		
		// Need to override equals - else two nodes with same key will be
		// two different objects with differnet hashCodes
		@Override
		public boolean equals(Object o){
			if(o == null )return false;
			if(o == this)	return true;
			if(!(o instanceof Node)) 	return false;
			Node<E> that = (Node<E>)o;
			return this.key.equals(that.key);
		}
		
		@Override
		public int hashCode(){
			return this.key.hashCode();
		}
		
	}
	
	
	
	
	
}
