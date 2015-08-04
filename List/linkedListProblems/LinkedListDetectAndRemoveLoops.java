package linkedListProblems;

import java.util.Set;
import java.util.HashSet;

public class LinkedListDetectAndRemoveLoops {
	private Node head = null;

	public static void main(String[] args) {
		LinkedListDetectAndRemoveLoops app = new LinkedListDetectAndRemoveLoops();
		app.buildList();
		app.findAndRemoveLoop(); // find and remove
		app.findAndRemoveLoop(); // test if loop present

	}

	public void buildList() {
		Node a = new Node("a", null);
		Node b = new Node("b", a);
		Node c = new Node("a", b);
		Node d = new Node("d", c);
		Node e = new Node("e", d);
		a.next = e; // creates the loop
		this.head = e;
	}

	public void findAndRemoveLoop() {
		findAndRemoveLoop(this.head);
	}

	private void findAndRemoveLoop(Node x) {
		Node ref_curr = x;
		Set<Node> nodes = new HashSet<Node>();
		nodes.add(ref_curr); // add the first node - head (check for null -
								// since hashSet allows for one null element)
		// check if next node can be added to set. If its a loop, then next
		// node is already in the set, add() returns false,
		// thus current node points to a list- making a loop.
		// update current node's next to NULL- loop broken.
		while (ref_curr != null && ref_curr.next != null) {
			if (!nodes.add(ref_curr.next)) { // if cannot add next node, then
												// its a loop. modify current
				System.out.println("Loop found - removing...!!!");
				ref_curr.next = null;
				// break; //not necessary - as ref becomes null in the following
				// line
				return; // exit from the method- break wont work as we do not
						// want to print anything if there is a loop
			}
			ref_curr = ref_curr.next;
		}
		System.out.println("No loop found");
	}

	private class Node {
		String data;
		Node next;

		public Node(String data, Node next) {
			this.data = data;
			this.next = next;
		}

		@Override
		public String toString() {
			return String.format(data);
		}
	}
}
