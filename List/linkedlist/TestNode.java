package linkedlist;

public class TestNode {

	public static void main(String[] args) {
		LinkedList<String> list =  new LinkedList<String>();
		
		list.add("ta");
		list.add("im");
		list.add("ay");
		list.add("ch");
		list.add("crm");
		list.add("ra");
		list.add("im");
		
		System.out.println(list);
		list.partitionList("ch");
		System.out.println(list);
		
	}

}
