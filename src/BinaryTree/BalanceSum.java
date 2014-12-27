package BinaryTree;



public class BalanceSum<T  extends Comparable<T>>{

	public static void printTree(Node<Integer> root , String indentLevel) {
		if(root == null) {
			return;
		}
		System.out.println(indentLevel + root.getData());
		indentLevel  += "\t";
		printTree(root.getLeft(),indentLevel);
		printTree(root.getRight(),indentLevel);


	}


	public static void balanceSum(Node<Integer> root) {
		if(root == null) {
			return;
		}
		if((root.getLeft() == null) &&(root.getRight() == null)) {
			return;
		}
		balanceSum(root.getLeft() );
		balanceSum(root.getRight() );

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

		if(root.getData()  < left + right) {
			root.setData(left + right)  ;
		}
		if(root.getData()   > left + right) {
			root.getLeft().setData(root.getData()-right);
			balanceSum(root.getLeft() );
		}
		

		return;

	}

	public static void main( String args[]) {
		Node<Integer> rootNode = new Node<Integer>(10);
		rootNode.setLeft(new Node<Integer>(9));
		rootNode.setRight(new Node<Integer>(11));	
		rootNode.getLeft().setLeft(new Node<Integer>(8));
		rootNode.getRight().setRight(new Node<Integer>(12));
		System.out.println("Orginal tree");
		balanceSum( rootNode) ;
		printTree(rootNode ,"");
		
	}
} 









