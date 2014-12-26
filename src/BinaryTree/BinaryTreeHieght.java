package BinaryTree;


public class BinaryTreeHieght<T  extends Comparable<T>>{
	
	public static int getHieght(Node<Integer> root ) {
		if(root == null) {
			return 0;
		}	
		int hieght =  Math.max(getHieght(root.getLeft()) ,getHieght(root.getRight())) + 1;
		return hieght;
	}	

	public static void main( String args[]) {
		Node<Integer> rootNode = new Node<Integer>(10);
		rootNode.setLeft(new Node<Integer>(9));
		rootNode.setRight(new Node<Integer>(11));	
		rootNode.getLeft().setLeft(new Node<Integer>(8));
		rootNode.getRight().setRight(new Node<Integer>(12));
		System.out.println("THe hieght is  " +getHieght(rootNode));
	}

} 



