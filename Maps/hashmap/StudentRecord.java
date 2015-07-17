package hashmap;
/*
 * A simple hash map implementation from scratch
 * using bucket lists
 */

public class StudentRecord {
	static final int _CAPACITY = 37;
	int size;
	LinkedListEntry[] buckets; //bucketArray
	
	//constructor
	public StudentRecord(){
		size = 0;
		buckets = new LinkedListEntry[_CAPACITY];		
		//initialize each array
		for(int i = 0 ; i < buckets.length ; ++i){
			buckets[i] = null; //initializing to null requires a new test condition
		}
	}
	
	private int hash(String key){
		final int MASK = 0x7FFFFFFF;
		return (key.hashCode() & MASK) % _CAPACITY;
	}
	
	//insert
	public void put(String key, Student value){
		int index = hash(key); //O(1)
		
		//XXXX- TO BE REMOVED
		System.out.printf("Key = %s, Index = %d\n\n", key, index);
		
		//check if bucket is empty, null or initialized
		if(buckets[index] == null){
			buckets[index] = new LinkedListEntry(value);
		}else{
			//find and update the student data
			buckets[index].insert(value);
		}
		++size;
	}
	
	public boolean contains(String key){
		int index = hash(key);

		if(buckets[index] == null){
			return false;
		}
		return (buckets[index].containsKey(key));
	}
	
	public Student get(String key){
		LinkedListEntry temp = buckets[hash(key)];
		if(temp == null)
			return null;
		return temp.lookUp(key);
	}
	
	public void displayMap(){
		if(size == 0)	
			System.out.println("Empty List");
		else{
			for(int i = 0; i < buckets.length; ++i ){
				if(!(buckets[i] == null)){
					buckets[i].displayList();
				}
			}
		}
	}
	
	
	private static class LinkedListEntry{
		Node<Student> first; //point to the first element of the list
		//Constructor
		private LinkedListEntry(Student studentData){
			first = null;
			insert(studentData);
		}
		
		//helper functions
		private void insert(Student x){
			//create a new node for x
			Node<Student> newNode = new Node<Student>(x);
			//if list is empty, assign first to new node, 
			if(first == null){
				first = newNode;
				return;
			}
			
			//check if Node is present
			Node<Student> curr = this.first;
//			Node<Student> prev = null;
			
			while(curr!=null){
				if(curr.data.getStudentName().equals(x.getStudentName())){
					curr.data = x; //update - WILL THIS WORK ????
					return;
				}else{
					curr = curr.next;
				}
			}
			// Student x not found, insert new node at the head of the list
			newNode.next = first;
			first = newNode;
		}
		
		private boolean containsKey(String k){
			Node<Student> curr = this.first;
			while(curr!=null){
				if(curr.data.getStudentName().equals(k)){
					return true;
				}
				curr = curr.next;
			}
			return false;
		}
		
		private Student lookUp(String k){
			Node<Student> curr = this.first;
			while(curr != null){
				if(curr.data.getStudentName().equals(k))
					return curr.data;
			}
			return null;
		}
		
		private void displayList(){
			Node<Student> curr = first;
			while(curr != null){
				System.out.println(curr);
				curr = curr.next;
			}
		}
	}
	
	private static class Node<E>{
		private E data;
		private Node<E> next;
		
		Node(E data){
			this.data = data;
			this.next = null;
		}
		
		Node(E data, Node<E> next){
			this.data = data;
			this.next = next;
		}
		//default
		Node(){
			this(null ,null);
		}
		
		public String toString(){
			return data.toString();
		}
		
	}
}
