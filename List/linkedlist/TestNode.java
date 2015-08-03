package linkedlist;

public class TestNode {

	public static void main(String[] args) {
		LinkedList<String> list =  new LinkedList<String>();
		
//		list.head = list.createCircularList();
//		System.out.println(	list.testCircular());
		list.add("ta");
		list.add("im");
		list.add("ay");
		list.add("ch");
		list.add("crm");
		list.add("ra");
		list.add("im");
		
		
		System.out.println(list);
		list.removeDuplicateFromUnsortedList2();
		System.out.println(list);
		
//		list.returnNthToLastElement(2);
		
//		list.partitionList("ay");
//		System.out.println(list);
		
	}

}
