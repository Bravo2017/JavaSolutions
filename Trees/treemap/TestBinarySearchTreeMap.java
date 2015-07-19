package treemap;

public class TestBinarySearchTreeMap {
	public static void main(String[] args){
		
		BinarySearchTreeMap<Integer,String> bst1 = 
				new BinarySearchTreeMap<Integer,String>();
		
		bst1.insert(50,"F");
		bst1.insert(40,"B");
		bst1.insert(60,"G");
		bst1.insert(35,"D");
		bst1.insert(45,"C");
		bst1.insert(55,"E");
		bst1.insert(75,"I");
//		bst1.insert(37,"I");
//		bst1.insert(42,"I");
		
		bst1.printTreePreOrder();
		bst1.printTreePostOrder();
		bst1.printTreeInOrder();
		
		//update - test for map
//		bst1.insert(9,"DD"); //search and update in O(log n)
//		bst1.insert(4,"XX");
//		bst1.insert(15,"EF");
//		bst1.insert(19,"IG");
		
//		bst1.printTreePostOrder();
	}
}
