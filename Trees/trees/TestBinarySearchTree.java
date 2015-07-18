package trees;

public class TestBinarySearchTree {
	public static void main(String[] args){
		
		BinarySearchTree<String> bst1 = new BinarySearchTree<String>();
		
		bst1.insert("F");
		bst1.insert("B");
		bst1.insert("G");
		bst1.insert("A");
		bst1.insert("D");
		bst1.insert("C");
		bst1.insert("E");
		bst1.insert("I");
		bst1.insert("H");
		bst1.insert("F");
		bst1.insert("F");
		
		
		bst1.printTreeInOrder();
		
	}
}
