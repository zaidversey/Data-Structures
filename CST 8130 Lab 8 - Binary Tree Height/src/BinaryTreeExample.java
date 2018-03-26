
public class BinaryTreeExample {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		
		tree.insertInTree(15);
		tree.insertInTree(10);
		tree.insertInTree(22);
		tree.insertInTree(30);
		tree.insertInTree(28);
		tree.insertInTree(7);
		tree.insertInTree(11);
		tree.insertInTree(24);
		
		
		
		System.out.println(tree.displayHeight());

	}

}
