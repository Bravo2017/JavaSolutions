//package linkedlist;
//
//public class Node<E extends Comparable<E>, V> {
//
//	private E key;
//	private V value;
//	Node<E, V> next;
//
//	public Node(E key) {
//		this.key = key;
//		this.value = null;
//		next = null;
//	}
//
//	public Node(E key, V value) {
//		this.key = key;
//		this.value = value;
//		next = null;
//	}
//
//	@Override
//	public String toString() {
//		return String.format("Key = %s, Value = %s", key, value);
//	}
//
//	/**
//	 * @return the key
//	 */
//	public E getKey() {
//		return key;
//	}
//
//	/**
//	 * @param key the key to set
//	 */
//	public void setKey(E key) {
//		this.key = key;
//	}
//	
//	public void setNext(Node<E, V> next) {
//		this.next = next;
//	}
//
//	public Node<E, V> getNext() {
//		return this.next;
//	}
//
//}
