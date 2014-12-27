package BinaryTree;



public class NumOfLeaves<T  extends Comparable<T>>{

	public static void printTree(Node<Integer> root , String indentLevel) {
		if(root == null) {
			return;
		}
		System.out.println(indentLevel + root.getData());
		indentLevel  += "\t";
		printTree(root.getLeft(),indentLevel);
		printTree(root.getRight(),indentLevel);


	}
	
	public static int countNumberofLeaves(Node<Integer> root) {
		if(root == null) {
		return 0;
}
if((root.getLeft() == null) && (root.getRight() == null)) {
	return 1;
}
else {
           return countNumberofLeaves(root.getLeft() ) +countNumberofLeaves(root.getRight());
}
	}
 

	public static void main( String args[]) {
		Node<Integer> rootNode = new Node<Integer>(10);
		rootNode.setLeft(new Node<Integer>(9));
		rootNode.setRight(new Node<Integer>(11));	
		rootNode.getLeft().setLeft(new Node<Integer>(8));
		rootNode.getRight().setRight(new Node<Integer>(12));
		System.out.println("Orginal tree");
		System.out.println(countNumberofLeaves(rootNode) );

	}
} 






