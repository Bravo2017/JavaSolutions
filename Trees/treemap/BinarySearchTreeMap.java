package treemap;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinarySearchTreeMap<K extends Comparable<K>, V> {
	Node<K, V> root;

	static class Node<K, V> {
		K key;
		V value;
		Node<K, V> left;
		Node<K, V> right;

		/* constructor */
		public Node(K key, V value, Node<K, V> left, Node<K, V> right) {
			this.key = key;
			this.value = value;
			this.left = left; // can be null
			this.right = right; // can be null
		}

		/*
		 * use the @Override annotation - gives an error if the method does not
		 * override some other method (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return String.format(" Key = %s, Value = %s\n", this.key,
					this.value);
		}
	}

	// wrapper
	public void insert(K key, V value) {
		// root = insert(this.root, key); // calls recursive
		root = insertIterative(this.root, key, value); // calls iterative
	}

	/* 1 - Insert recursively */
	public Node<K, V> insert(Node<K, V> x, K key, V value) {
		if (x == null) {
			x = new Node<K, V>(key, value, null, null);
			return x;
		}

		if (key.compareTo(x.key) == 0) { // if key == x.key, update value
			x.value = value;
		} else if (key.compareTo(x.key) < 0) {
			x.left = insert(x.left, key, value);
		} else {
			x.right = insert(x.right, key, value);
		}
		return x;
	}

	/* 2 - Insert iteratively */
	public Node<K, V> insertIterative(Node<K, V> x, K key, V value) {
		Node<K, V> newNode = new Node<K, V>(key, value, null, null);

		if (x == null) {
			x = newNode;
			return x;
		}

		Node<K, V> curr = x;
		while (true) {
			if (key.compareTo(curr.key) == 0) {
				curr.value = value;
				break;
			} else if (key.compareTo(curr.key) < 0) {
				if (curr.left == null) {
					curr.left = newNode;
					break;
				} else {
					curr = curr.left;
				}
			} else if (key.compareTo(curr.key) > 0) {
				if (curr.right == null) {
					curr.right = newNode;
					break;
				} else {
					curr = curr.right;
				}
			}
		}
		return x;
	}

	public void printTreeInOrder() {
		System.out.print(" \nInOrder Traversal\n");
		printTreeInOrder(this.root);
		System.out.println("");
	}

	/* Recursive In-Order */
	/*
	 * private void printTreeInOrder(Node<K,V> node) { if (node == null) return;
	 * else { printTreeInOrder(node.left); System.out.println(node);
	 * printTreeInOrder(node.right); } }
	 */

	/* Iterative In-Order */
	public void printTreeInOrder(final Node<K, V> r) {
		Deque<Node<K, V>> stack = new ArrayDeque<Node<K, V>>();
		Node<K, V> x = r;

		while (x != null || !stack.isEmpty()) {

			if (x != null) {
				stack.push(x);
				x = x.left;
			} else {
				// when x is null, out of tree
				if (!stack.isEmpty())	x = stack.pop();
				System.out.println(x);
				x = x.right;
			}
		}
	}
	
	public void printTreePostOrder() {
		System.out.print(" \nPostOrder Traversal\n");
		printTreePostOrder(this.root);
		System.out.println("");
	}
	
	/* Iterative PostOrder */
	/*public void printTreePostOrder(final Node<K, V> r) {
		Deque<Node<K, V>> stack = new ArrayDeque<Node<K, V>>();
		Node<K, V> x = r;
		Node<K, V> lastVisited = x;

		while (x != null || !stack.isEmpty()) {
			while (x != null) {
				stack.push(x);
				x = x.left;
			}
			//after traversing left
			//traverse right
			//if no right, then print
			//keep updated lastPrinted node
			
			x = stack.peek();
			if (x.right == null || x.right == lastVisited) {
				System.out.println(x);
				lastVisited = x;
				x = null;
				stack.pop();
			} else {
				x = x.right;
			}
		}
	}*/
	
	/* Iterative PostOrder - single while loop, if-else constructs*/
	public void printTreePostOrder(final Node<K, V> r) {
		Deque<Node<K, V>> stack = new ArrayDeque<Node<K, V>>();
		Node<K, V> x = r;
		Node<K, V> lastVisited = x;

		while (x != null || !stack.isEmpty()) {
			if (x != null) {
				stack.push(x);
				x = x.left;
			}
			//after traversing left
			//traverse right
			//if no right, then print
			//update lastPrinted node
			else{
				x = stack.peek();
				if (x.right == null || x.right == lastVisited) {
					System.out.println(x);
					lastVisited = x;
					x = null; //important step
					stack.pop(); //remove visited node from stack
				} 
				else {
					x = x.right;
				}//end of inner else
			}//end of outer else
		}//end of while loop
	}//end of method

	public void printTreePreOrder() {
		System.out.print(" \nPreOrder Traversal\n");
		printTreePreOrder(this.root);
		System.out.println("");
	}

	/* Iterative PreOrder - cleaner code */
	public void printTreePreOrder(final Node<K,V> r){
		Deque<Node<K,V>> stack = new ArrayDeque<Node<K,V>>();
		Node<K,V> x = r;
		
		while(x != null || !stack.isEmpty()){
			if(x != null){ // x can be null
				System.out.println(x);
				if(x.right != null){  stack.push(x.right); }
				x = x.left;
			}else{ //x is null, pop the top node
				if(!stack.isEmpty()){ //if stack empty, do nothing
					x = stack.pop();	
				}
			}
		}
	}
	
	
	/* Iterative PreOrder */
	/*public void printTreePreOrder(final Node<K,V> r){
		Deque<Node<K,V>> stack = new ArrayDeque<Node<K,V>>();
		Node<K,V> x = r;
		while(x != null || !stack.isEmpty()){
			System.out.println(x);
			if(x.right != null){
				stack.push(x.right);
			}
			if(x.left != null){
				stack.push(x.left);
			}
			
			if(!stack.isEmpty()){
				x = stack.pop();
			}
			else break;
				
		}
	}*/
	
	public void printLevelOrder() {
		System.out.print(" \nLevelOrder Traversal\n");
		printLevelOrder(this.root);
		System.out.println("");
	}
	
	public void printLevelOrder(final Node<K,V> x){
		Node<K,V> curr = x;
		Deque<Node<K,V>> queue = new ArrayDeque<Node<K,V>>();
		queue.add(curr);
		
		while(!queue.isEmpty()){
			curr = queue.poll();
			System.out.println(curr);
			if(curr.left != null)	queue.offer(curr.left);
			if(curr.right != null)	queue.offer(curr.right);
		}
	}
	
	/**
	 * Print every level in a row - modified Level order traversal
	 */
	public void printLevelOrderModified(){
		Node<K,V> curr = this.root;
		
		int nodeCounterCurrent = 1;
		int nodeCounterNext = 0;
		Deque<Node<K,V>> queue = new ArrayDeque<Node<K,V>>();
		queue.add(curr);
		
		while(!queue.isEmpty()){
			curr = queue.poll();

			if(curr.left != null){
				queue.offer(curr.left);
				++nodeCounterNext;
			}
			if(curr.right != null){
				queue.offer(curr.right);
				++nodeCounterNext;
			}

			System.out.print("[" + curr.key +" " + curr.value+ " ]"+ " ");
			
			if(--nodeCounterCurrent == 0)	{
				System.out.println();
				nodeCounterCurrent = nodeCounterNext;
				nodeCounterNext = 0;
			}
		}
		
	}
	
}
