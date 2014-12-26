package BinaryTree;


public class MirrorTree<T  extends Comparable<T>>{
	
	public static void printTree(Node<Integer> root , String indentLevel) {
		if(root == null) {
			return;
		}
		System.out.println(indentLevel + root.getData());
		indentLevel  += "\t";
		printTree(root.getLeft(),indentLevel);
		printTree(root.getRight(),indentLevel);
		
		
	}
	
	public static Node<Integer> getMirror(Node<Integer> root ) {
		if(root == null) {
			
			return null;
		}	
		Node<Integer> mirrorRoot = new Node<Integer>(root.getData());
		mirrorRoot.setRight(getMirror(root.getLeft()));
		mirrorRoot.setLeft(getMirror(root.getRight()));
		return mirrorRoot;
	}	

	public static void main( String args[]) {
		Node<Integer> rootNode = new Node<Integer>(10);
		rootNode.setLeft(new Node<Integer>(9));
		rootNode.setRight(new Node<Integer>(11));	
		rootNode.getLeft().setLeft(new Node<Integer>(8));
		rootNode.getRight().setRight(new Node<Integer>(12));
		System.out.println("Orginal tree");
		printTree(rootNode, "");
		Node<Integer> mirrorRoot = getMirror(rootNode);
		System.out.println("Mirror tree");
		printTree(mirrorRoot, "");
	}

} 





