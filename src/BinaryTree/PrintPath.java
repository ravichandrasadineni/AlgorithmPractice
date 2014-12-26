package BinaryTree;



public class PrintPath<T  extends Comparable<T>>{

	public static void printTree(Node<Integer> root , String indentLevel) {
		if(root == null) {
			return;
		}
		System.out.println(indentLevel + root.getData());
		indentLevel  += "\t";
		printTree(root.getLeft(),indentLevel);
		printTree(root.getRight(),indentLevel);


	}

	public static void printPath(Node<Integer> root, String currentPath) {
		if(root == null) {
			return;	
		}
		currentPath = currentPath+ root.getData() + "\t";
		if( root.getLeft() == null  && root.getRight() == null) {
			System.out.println(currentPath);
			return;
		}
		printPath(root.getLeft(),currentPath);
		printPath(root.getRight(),currentPath);
	}

	public static void main( String args[]) {
		Node<Integer> rootNode = new Node<Integer>(10);
		rootNode.setLeft(new Node<Integer>(9));
		rootNode.setRight(new Node<Integer>(11));	
		rootNode.getLeft().setLeft(new Node<Integer>(8));
		rootNode.getRight().setRight(new Node<Integer>(12));
		System.out.println("Orginal tree");
		printPath(rootNode, "");

	}
} 







