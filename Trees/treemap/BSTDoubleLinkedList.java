package treemap;

import java.util.ArrayDeque;
import java.util.Deque;

public class BSTDoubleLinkedList<K extends Comparable<K>, V> extends
		BinarySearchTreeMap<K, V> {
	Node<K, V> head;

	public Node<K, V> convertToDoubleLinkedList() {
		Node<K, V> curr = this.root;
		Node<K, V> prev = null;

		// in-order traversal
		Deque<Node<K, V>> stack = new ArrayDeque<Node<K, V>>();
		while (curr != null || !stack.isEmpty()) {

			if (curr != null) {
				stack.push(curr);
				curr = curr.left;// move left
			} else {
				if (!stack.isEmpty())
					curr = stack.pop();

				// modify links - instead of printing node
				curr.left = prev;
				if (prev != null)
					prev.right = curr;
				prev = curr;

				// move right
				curr = curr.right;
			}
		}

		// modify head of list
		// traverse reverse from root till (curr.left == null)
		curr = this.root;
		while (curr.left != null) {
			curr = curr.left;
		}
		head = curr; // set head of list
		return head;
	}

	// print linked list
	public void printList() {
		Node<K, V> x = this.head;
		System.out.println();
		while (x != null) {
			System.out.print(x + " ");
			x = x.right;
		}
		System.out.println();
	}
}
