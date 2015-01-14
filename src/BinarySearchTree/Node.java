package BinarySearchTree;

class Node<T extends Comparable<T>> {
	private T data;
	private Node<T> left;
	private Node<T> right;
	Node() {	
	}
	Node(T data , Node<T> left, Node<T> right) {
		this.data  = data;
		this.left = left;
		this.right = right;	
	}
	Node(T data ) {
		this.data  = data;
	}

	public T getData() {
		return this.data;
	}

	public void setData( T data) {
		this.data = data;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getLeft() {
		return this.left;
	}


	public void setRight(Node<T> right) {
		this.right = right;
	}

	public Node<T> getRight() {
		return this.right;
	}
	
	public void preOrder() {
		System.out.println(this.data);
		if(this.left != null) {
			this.left.preOrder();
		}
		if(this.right != null) {
			this.right.preOrder();
		}
	}
	
	public void postOrder () {
		if(this.left != null) {
			this.left.postOrder();
		}
		if(this.right != null) {
			this.right.postOrder();
		}
		System.out.println(this.data);
	}
	public void inOrder () {
		if(this.left != null) {
			this.left.inOrder();
		}
		System.out.println(this.data);
		if(this.right != null) {
			this.right.inOrder();
		}
		
	}
	
	

}
