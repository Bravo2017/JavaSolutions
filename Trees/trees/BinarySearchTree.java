package trees;

public class BinarySearchTree<K extends Comparable<K>> {
	String x;
	private Node<K> root;

	private class Node<E> {
		E key;
		Node<E> left;
		Node<E> right;

		/* constructor */
		public Node(E key, Node<E> left, Node<E> right) {
			this.key = key;
			this.left = left; // can be null
			this.right = right;// can be null
		}

		/* constructor with one argument */
		public Node(E key) {
			this(key, null, null); // calls the three argument constructor
		}

		/*
		 * use the @Override annotation - gives an error if the method does not
		 * override some other method (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return String.format("%s\n", this.key);
		}
	}

	// wrapper
	public void insert(K key) {
//		root = insert(this.root, key); // calls recursive 
		root = insertIterative(this.root, key); //calls iterative
	}

	/* 1 - Insert recursively */
	public Node<K> insert(Node<K> x, K key) {
		if (x == null)
			x = new Node<K>(key, null, null);
		else {
			if (less(key, x.key)) { // if key < x.key- go left, else right
				x.left = insert(x.left, key);
			} else {
				x.right = insert(x.right, key);
			}
		}
		return x;
	}

	private boolean less(K x, K y) {
		return x.compareTo(y) < 0 ? true : false;
	}

	public Node<K> insertIterative(Node<K> x, K key) {
		Node<K> newNode = new Node<K>(key, null, null);

		if (x == null) {
			x = newNode;
			return x;
		}

		Node<K> current = x;
		while (true) {
			if(key.compareTo(current.key) == 0){
				break;
			}
			else if (key.compareTo(current.key) < 0) {
				if (current.left == null) {
					current.left = newNode;
					break;
				} else {
					current = current.left;
				}
			} else if (key.compareTo(current.key) > 0) {
				if (current.right == null) {
					current.right = newNode;
					break;
				} else {
					current = current.right;
				}
			}
		}
		return x;
	}
	
	
	

	public void printTreeInOrder() {
		System.out.print("InOrder Traversal\n");
		printTreeInOrder(this.root);
		System.out.println("");
	}

	private void printTreeInOrder(Node<K> node) {
		if (node == null)
			return;
		else {
			printTreeInOrder(node.left);
			System.out.print(node.key + " ");
			printTreeInOrder(node.right);
		}
	}

}
