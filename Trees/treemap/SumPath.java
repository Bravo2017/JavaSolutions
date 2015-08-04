package treemap;

public class SumPath<K extends Comparable<K>, V> extends
		BinarySearchTreeMap<K, V> {

	public void printPathWithSum(int sum) {
		Node<K, V>[] path = new Node[100];
		int pathIndex = 0;
		printPathWithSum(this.root, sum, path, pathIndex);
	}

	public void printPathWithSum(Node<K, V> x, int sum, Node<K, V>[] path,
			int pathIndex) {
		if (x == null) {
			return;
		}
		sum = sum - (int) x.key;
		path[pathIndex++] = x;

		if (sum == 0 && isLeaf(x)) {
			printArray(path, pathIndex);
		} else {
			printPathWithSum(x.left, sum, path, pathIndex);
			printPathWithSum(x.right, sum, path, pathIndex);
		}
	}

	private boolean isLeaf(Node<K, V> x) {
		return (x.left == null && x.right == null);
	}

	private void printArray(Node<K, V>[] paths, final int index) {
		for (int i = 0; i < index; ++i) {
			System.out.print(paths[i]);
		}
		System.out.println();
	}

}
