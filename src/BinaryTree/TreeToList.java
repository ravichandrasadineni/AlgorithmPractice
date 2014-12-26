package BinaryTree;




public class TreeToList<T  extends Comparable<T>>{

	public static void printTree(Node<Integer> root , String indentLevel) {
		if(root == null) {
			return;
		}
		System.out.println(indentLevel + root.getData());
		indentLevel  += "\t";
		printTree(root.getLeft(),indentLevel);
		printTree(root.getRight(),indentLevel);

	}

	public static LinkedListNode<Integer> treeToList(Node<Integer> root) {
		if(root == null) {
			return null;
		}
		if((root .getLeft() == null) &&(root.getRight() == null)) 
			return new  LinkedListNode<Integer>(root.getData());
		else if(root .getLeft() == null ) {
			LinkedListNode<Integer> rootLLNode = new  
					LinkedListNode<Integer>(root.getData());
			LinkedListNode<Integer> rightSubtree =   treeToList(root.getRight());
			rootLLNode.setLarge(rightSubtree );
			rightSubtree.setSmall(rootLLNode );
			return rootLLNode;	
		}

		else if(root .getRight() == null ) {
			LinkedListNode<Integer> rootLLNode = new 
					LinkedListNode<Integer>(root.getData());
			LinkedListNode<Integer> leftSubtree =   treeToList(root.getLeft());
			LinkedListNode<Integer>  traverseNode = leftSubtree;
			while(traverseNode.getLarge() !=null) {
				traverseNode =traverseNode.getLarge();
			}	
			traverseNode.setLarge(rootLLNode );
			rootLLNode.setSmall(traverseNode );
			return leftSubtree;	
		}

		LinkedListNode<Integer> rootNode = new LinkedListNode<Integer>(root.getData());
		LinkedListNode<Integer> leftSubtree =   treeToList(root.getLeft());
		LinkedListNode<Integer> rightSubtree =   treeToList(root.getRight());	
		LinkedListNode<Integer>  traverseNode = leftSubtree;
		while(traverseNode.getLarge() !=null) {
			traverseNode =traverseNode.getLarge();
		}		
		traverseNode.setLarge(rootNode);
		rootNode.setSmall(leftSubtree);
		rootNode.setLarge(rightSubtree);
		rightSubtree.setSmall(rootNode);
		return leftSubtree;	
	}

	public static void printList(LinkedListNode<Integer>  rootNode) {
		while(rootNode !=null) {
			System.out.print(rootNode.getData() + "-->");
			rootNode = rootNode.getLarge();
		}
		System.out.println();

	}

	public static void main( String args[]) {
		Node<Integer> rootNode = new Node<Integer>(10);
		rootNode.setLeft(new Node<Integer>(9));
		rootNode.setRight(new Node<Integer>(11));	
		rootNode.getLeft().setLeft(new Node<Integer>(8));
		rootNode.getRight().setRight(new Node<Integer>(12));
		printList(treeToList(rootNode));
	}
}



class  LinkedListNode<T extends Comparable<T>> {
	T data;
	LinkedListNode<T> small;
	LinkedListNode<T> large;	
	public T getData() {
		return data;
	}
	LinkedListNode() {
	}
	LinkedListNode(T data) {
		this.data = data;
	}

	LinkedListNode(T data, LinkedListNode<T> small, LinkedListNode<T> large) {
		this.data = data;
		this.small = small;
		this.large  = large;
	}

	public void setData(T data) {
		this.data  = data;

	}
	public LinkedListNode<T> getSmall() {
		return small;
	}

	public  void setSmall(LinkedListNode<T> small ) {
		this.small = small;
	}

	public LinkedListNode<T> getLarge() {
		return large;
	}

	public  void setLarge(LinkedListNode<T> large ) {
		this.large = large;
	}



}







