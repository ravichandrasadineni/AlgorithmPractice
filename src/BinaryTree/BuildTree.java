package BinaryTree;



public class BuildTree<T  extends Comparable<T>>{

	
	
	
	public static void printTree(Node<Character> root , String indentLevel) {
		if(root == null) {
			return;
		}
		System.out.println(indentLevel + root.getData());
		indentLevel  += "\t";
		printTree(root.getLeft(),indentLevel);
		printTree(root.getRight(),indentLevel);


	}


	public static Node<Character> buildTree(StringBuilder preOrder, StringBuilder inOrder) {
		if(preOrder == null || inOrder == null) {
			throw new IllegalArgumentException();
		}
		if(preOrder.length() ==0 ||  inOrder.length() ==0) {
			return null;
		}
		if(inOrder.length() ==1 ) {
			preOrder.deleteCharAt(0);
			return new Node<Character>(inOrder.charAt(0));
		}
		char currentRootVal = preOrder.charAt(0);
		preOrder.deleteCharAt(0);
		int indexOfRoot = inOrder.lastIndexOf(String.valueOf(currentRootVal));
		StringBuilder leftSubtree = null;
		StringBuilder rightSubtree = null;
		if(indexOfRoot  > 0) {
			 leftSubtree = new StringBuilder(inOrder.substring(0,indexOfRoot));
		}
		else {
			 leftSubtree = new StringBuilder();	
		}
		if(indexOfRoot < inOrder.length()-1) {
			 rightSubtree = new StringBuilder(inOrder.substring(indexOfRoot+1));
		}
		else {
			 rightSubtree = new StringBuilder();	
		}
		Node<Character> root  = new Node<Character>(currentRootVal);
		root.setLeft(buildTree(preOrder,leftSubtree));

		root.setRight(buildTree(preOrder,rightSubtree));
		return root;		
	}

	public static void main( String args[]) {
		Node<Integer> rootNode = new Node<Integer>(10);
		rootNode.setLeft(new Node<Integer>(9));
		rootNode.setRight(new Node<Integer>(11));	
		rootNode.getLeft().setLeft(new Node<Integer>(8));
		rootNode.getRight().setRight(new Node<Integer>(12));
		StringBuilder preOrder = new StringBuilder("abdecf");
		StringBuilder inOrder = new StringBuilder("dbeafc");

		printTree(buildTree(preOrder,inOrder),"" );

	}	
} 










