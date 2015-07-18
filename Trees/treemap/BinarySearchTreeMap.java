package treemap;

public class BinarySearchTreeMap<K extends Comparable<K>,V> {
	String x;
	private Node<K,V> root;

	private class Node<K,V> {
		K key;
		V value;
		Node<K,V> left;
		Node<K,V> right;

		/* constructor */
		public Node(K key, V value, Node<K,V> left, Node<K,V> right) {
			this.key = key;
			this.value = value;
			this.left = left; 	// can be null
			this.right = right;	// can be null
		}

		/*
		 * use the @Override annotation - gives an error if the method does not
		 * override some other method (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return String.format(" Key = %s, Value = %s\n", this.key,this.value);
		}
	}

	// wrapper
	public void insert(K key, V value) {
//		root = insert(this.root, key); // calls recursive 
		root = insertIterative(this.root, key, value); //calls iterative
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

	
	private boolean less(K x, K y) {
		return x.compareTo(y) < 0 ? true : false;
	}
	
	/* 2 - Insert iteratively */
	public Node<K,V> insertIterative(Node<K,V> x, K key, V value) {
		Node<K,V> newNode = new Node<K,V>(key,value, null, null);

		if (x == null) {
			x = newNode;
			return x;
		}

		Node<K,V> curr = x;
		while (true) {
			if(key.compareTo(curr.key) == 0){
				curr.value = value;
				break;
			}
			else if (key.compareTo(curr.key) < 0) {
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

	private void printTreeInOrder(Node<K,V> node) {
		if (node == null)
			return;
		else {
			printTreeInOrder(node.left);
			System.out.println(node);
			printTreeInOrder(node.right);
		}
	}

}
