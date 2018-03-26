
public class BinaryTree {
	BinaryTreeNode root = null;

	public void insertInTree (int newData) {
		if (root == null) 
			root = new BinaryTreeNode(newData);
		else root.insert(newData);
	}


	public void displayInOrder () {
		displayInOrder (root);
	}

	public void displayInOrder (BinaryTreeNode subRoot){
		if (subRoot == null)   return;
		displayInOrder (subRoot.getLeft());
		System.out.print(" " + subRoot.getData() + " ");
		displayInOrder (subRoot.getRight());

	}

	public void displayPreOrder () {
		displayPreOrder (root);
	}

	public void displayPreOrder (BinaryTreeNode subRoot){
		if (subRoot == null)   return;
		System.out.print(" " + subRoot.getData() + " ");
		displayPreOrder (subRoot.getLeft());
		displayPreOrder (subRoot.getRight());

	}

	public void displayPostOrder () {
		displayPostOrder (root);
	}

	public void displayPostOrder (BinaryTreeNode subRoot){
		if (subRoot == null)   return;

		displayPostOrder (subRoot.getLeft());
		displayPostOrder (subRoot.getRight());
		System.out.print(" " + subRoot.getData() + " ");

	}

	public int displayHeight(){
		return displayHeight(root);
	}

	public int displayHeight(BinaryTreeNode subRoot){
		if (subRoot == null)   return 0;

		int leftHeight=displayHeight(subRoot.getLeft()) ;
		
		
		int rightHeight=displayHeight(subRoot.getRight());


		if (leftHeight > rightHeight) {
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}

	}



}// end of class
