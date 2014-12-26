package BinaryTree;

class Traversals {
	public static void main(String args[]) {
		Node<Integer> rootNode = new Node<Integer>(10);
		rootNode.setLeft(new Node<Integer>(9));
		rootNode.setRight(new Node<Integer>(11));	
		rootNode.getLeft().setLeft(new Node<Integer>(8));
		rootNode.getRight().setRight(new Node<Integer>(12));
		System.out.println("preorder :");
		rootNode.preOrder();
		System.out.println("inOrder :");
		rootNode.inOrder();
		System.out.println("postOrder:");
		rootNode.postOrder();

	} 	
} 
