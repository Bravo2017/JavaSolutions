package treemap;

public class TestBinarySearchTreeMap {
	public static void main(String[] args){
		
		BinarySearchTreeMap<Integer,String> bst1 = 
				new BinarySearchTreeMap<Integer,String>();
		
		bst1.insert(122,"F");
		bst1.insert(12,"B");
		bst1.insert(10,"G");
		bst1.insert(12,"A");
		bst1.insert(9,"D");
		bst1.insert(4,"C");
		bst1.insert(15,"E");
		bst1.insert(19,"I");
		bst1.insert(16,"H");
		bst1.insert(43,"F");
		bst1.insert(76,"F");
		
		bst1.printTreeInOrder();
		
		//update
		bst1.insert(9,"DD");
		bst1.insert(4,"XX");
		bst1.insert(15,"EF");
		bst1.insert(19,"IG");
		
		bst1.printTreeInOrder();
		
	}
}
