package BinaryTree;

class  IdenticalChecker<T  extends Comparable<T>>{
	
	public static boolean areIdentical (Node<Integer> root1, Node<Integer> root2  ) {
		if((root1== null) &&(root2 == null)) {
			return true;
		}	
		else if ((root1 == null) || (root2 == null)) {
			return false;
		}
		boolean isLeftIdentical = areIdentical(root1.getLeft(),root2.getLeft());
		boolean isRightIdentical = areIdentical(root1.getLeft(),root2.getLeft());
		boolean isNodeIdentical = (root1.getData() == root2.getData());
		if(isLeftIdentical && isRightIdentical && isNodeIdentical)
			return true;
		return false;
	}
	public static void main( String args[]) {
		Node<Integer> rootNode = new Node<Integer>(10);
		rootNode.setLeft(new Node<Integer>(9));
		rootNode.setRight(new Node<Integer>(11));	
		rootNode.getLeft().setLeft(new Node<Integer>(8));
		rootNode.getRight().setRight(new Node<Integer>(12));
		Node<Integer> rootNode2 = rootNode; 
		System.out.println("Are trees identical ?  " +areIdentical(rootNode,rootNode2));
	}

} 