package BinaryTree;





public class ChildSumChecker<T  extends Comparable<T>>{

	public static void printTree(Node<Integer> root , String indentLevel) {
		if(root == null) {
			return;
		}
		System.out.println(indentLevel + root.getData());
		indentLevel  += "\t";
		printTree(root.getLeft(),indentLevel);
		printTree(root.getRight(),indentLevel);


	}


	public static boolean isSumPropertySatisfied(Node<Integer> root) {
		if(root == null) {
			return true;
		}
		if((root.getLeft() == null) &&(root.getRight() == null)) {
			return true;
		}
		int left =0;
		int right =0;
		if(root.getLeft() == null) {
			left = 0;
		}
		else left = root.getLeft().getData();
		if(root.getRight() == null) {
			right = 0;
		}
		else right= root.getRight().getData();

		if(root.getData() == left + right) {
			if(isSumPropertySatisfied(root.getLeft()) &&
					isSumPropertySatisfied(root.getRight())) {

				return true;

			}
		}

		return false;

	}

	public static void main( String args[]) {
		Node<Integer> rootNode = new Node<Integer>(10);
		rootNode.setLeft(new Node<Integer>(8));
		rootNode.setRight(new Node<Integer>(2));	
		rootNode.getLeft().setLeft(new Node<Integer>(8));
		rootNode.getRight().setRight(new Node<Integer>(2));
		System.out.println("Orginal tree");
		System.out.println(isSumPropertySatisfied( rootNode) );

	}
} 









