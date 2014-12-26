package BinaryTree;


public class SizeCalculation<T  extends Comparable<T>>{
	
	public static int getSize(Node<Integer> root ) {
		if(root == null) {
			return 0;
		}	
		int size =  getSize(root.getLeft()) + getSize(root.getRight()) + 1;
		return size;
	}	

	public static void main( String args[]) {
		Node<Integer> rootNode = new Node<Integer>(10);
		rootNode.setLeft(new Node<Integer>(9));
		rootNode.setRight(new Node<Integer>(11));	
		rootNode.getLeft().setLeft(new Node<Integer>(8));
		rootNode.getRight().setRight(new Node<Integer>(12));
		System.out.println("THe size is  " +getSize(rootNode));
	}

} 
