package BinarySearchTree;

public class BinarySearchTree<T extends Comparable<T>> {
	Node<T> root;
	public void insert(T ele) {
		root = insertEle(root, ele);
	}
	
	public Node<T> insertEle(Node<T> root, T ele) {
		if(root == null) {
			Node<T> newEle = new Node<T>(ele);
			return newEle;
		}
		else if(root.getData().compareTo(ele) < 0) {
			root.setRight(insertEle(root.getRight(),ele));
		}
		else {
			root.setLeft(insertEle(root.getLeft(),ele));
		}
		return root;
	}
	
	public void  delete(T ele) {
		root =  deleteEle(root, ele);
	}
	public T getMin(Node<T> root) {
			if(root == null) {
				return null;
			}
			else if (root.getLeft() == null) {
				return root.getData();
			}
			else {
				return getMin(root.getLeft());
			}
	}
	public Node<T> deleteEle(Node<T> root, T ele) {
		 if(root == null) {
			 System.out.println("Element Not foud");
			 return null;
		 }
		 else if(root.getData().equals(ele)) {
			 if(root.getLeft() == null && root.getRight() == null ) {
				 return null; 
			 }
			 else if(root.getLeft() == null) {
				 return root.getRight();
			 }
			 else if(root.getRight() == null) {
				 return root.getLeft();
			 }
			 else {
				 T minOnRight = getMin(root.getRight());
				 root.setData(minOnRight);
				 deleteEle(root.getRight(),minOnRight);
				 return root;
			 }
		 }
		 else if(root.getData().compareTo(ele) <1 ) {
			 root.setRight(deleteEle(root.getRight(), ele));
		 }
		 else {
			 root.setLeft(deleteEle(root.getLeft(), ele));
		 }
		return root;
	}
	
	public void printInorder(Node<T> root) {
		if(root == null) 
			return;
		printInorder(root.getLeft());
		System.out.println(root.getData());
		printInorder(root.getRight());
	}
	
	public static void main(String args[]) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.insert(1);
		bst.insert(10);
		bst.insert(3);
		bst.insert(6);
		bst.insert(4);
		bst.printInorder(bst.root);
		bst.delete(4);
		bst.printInorder(bst.root);
	}
}
