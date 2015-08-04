package hashmap;

import java.util.Objects;

/*
 * An improved implementation of the hashMap data structure, Generic implementation
 * Completely removed the redundant linked list inner class.
 * bucket array of type Node, which stores Keys and Values
 */

public class StudentRecordII<K, V> {
	static final int _CAPACITY = 37;
	int size;
	Node<K, V>[] buckets; // an array of Entry nodes - bucket array

	// constructor
	@SuppressWarnings("unchecked")
	public StudentRecordII() {
		size = 0;
		buckets = new Node[_CAPACITY];
		// initialize each array
		for (int i = 0; i < buckets.length; ++i) {
			buckets[i] = null; // initialize to null,not new bucket(space
								// efficient)
		}
	}

	private final int hash(Object key) {
		final int MASK = 0x7FFFFFFF;
		return (key == null) ? 0 : ((key.hashCode() & MASK) % _CAPACITY);
	}

	// insert a new key, value
	public void put(K key, V newValue) {
		int index = hash(key); // O(1)
		Node<K, V> tempNewNode = new Node<K, V>(key, newValue, null);

		// XXXX- TO BE REMOVED
		// System.out.printf("Key = %s, Index = %d\n\n", key, index);

		// check if bucket is empty, null or initialized
		if (buckets[index] == null) {
			buckets[index] = tempNewNode;
			++size;
			return;
		} else {// find and update the student data
			Node<K, V> current = buckets[index];
			while (current != null) {
				if (current.getKey().equals(key)) {
					current.setValue(newValue);
					return;
				} else {
					current = current.next;
				}
			}
		}
		// if node not found, add to the head of the list
		tempNewNode.next = buckets[index];
		buckets[index] = tempNewNode;
	}

	public boolean contains(K key) {
		int index = hash(key);
		if (buckets[index] == null) {
			return false;
		} else {
			Node<K, V> current = buckets[index];
			while (current != null) {
				if (current.getKey().equals(key)) {
					return true;
				}
				current = current.next;
			}
		}
		return false;
	}

	public V get(K key) {
		Node<K, V> current = buckets[hash(key)];
		while (current != null) {
			if (current.getKey().equals(key)) {
				return current.getValue();
			}
			current = current.next;
		}
		return null;
	}

	public void displayMap() {
		if (size == 0)
			System.out.println("Empty List");
		else {
			for (int i = 0; i < buckets.length; ++i) {
				if (!(buckets[i] == null)) {
					Node<K, V> current = buckets[i];
					display(current);
				}
			}
		}
	}

	static int counter = 0; // not a part of hashmap implementation

	private void display(Node<K, V> current) {
		while (current != null) {
			System.out.println(++counter + ".  " + current);
			current = current.next;
		}
	}

	/**
	 * Static Inner class
	 * 
	 * @param <K>
	 * @param <V>
	 */
	private static class Node<K, V> {
		final K key;
		private V value;
		private Node<K, V> next;

		Node(K key, V value, Node<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

		// public final String toString() {
		// return key + "=" + value;
		// }

		// modified since value also has the key.
		@Override
		public final String toString() {
			return value.toString();
		}

		@Override
		public final int hashCode() {
			return Objects.hashCode(key) ^ Objects.hashCode(value);
		}

		public final V setValue(V newValue) {
			V oldValue = value;
			value = newValue;
			return oldValue;
		}

		public final K getKey() {
			return key;
		}

		public final V getValue() {
			return value;
		}

		@Override
		public final boolean equals(Object o) {
			if (o == this)
				return true;
			if (o instanceof Node) {
				Node<?, ?> e = (Node<?, ?>) o;
				if (Objects.equals(key, e.getKey())
						&& Objects.equals(value, e.getValue()))
					return true;
			}
			return false;
		}

	}
}
