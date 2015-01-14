package BinarySearchTree;


public class CheckBinarySearchTree<T extends Comparable<T>> {
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
	
	public boolean isBinarySearchTree() {
		MinMaxHolder<T> minMaxHolder = new MinMaxHolder<T>();
		return isBst(root,minMaxHolder);
	}
	public boolean isBst(Node<T> root,MinMaxHolder<T> minMaxHolder ) {
		if(root == null) {
			return true;
		}
		MinMaxHolder<T> leftMinMaxHolder = new MinMaxHolder<T>();
		MinMaxHolder<T> rightMinMaxHolder = new MinMaxHolder<T>();
		if(!isBst(root.getLeft(),leftMinMaxHolder )) {
			return false;
		}
		
		if(isBst(root.getRight(),rightMinMaxHolder ) ) {
			return false;
		}
		if(!leftMinMaxHolder.isGreaterThanOrEqualMax(root.getData())) {
			return false;
		}
		if(!rightMinMaxHolder.isLessThanOrEqualMin(root.getData())) {
			return false;
		}
		minMaxHolder.setMax(rightMinMaxHolder.getMax());
		minMaxHolder.setMin(leftMinMaxHolder.getMin());
		if(minMaxHolder.getMax() == null) {
			minMaxHolder.setMax(root.getData());
		}
		if(minMaxHolder.getMin() == null) {
			minMaxHolder.setMin(root.getData());
		}
		
		return true;
	}
	
	public static void main(String args[]) {
		CheckBinarySearchTree<Integer> bst = new CheckBinarySearchTree<Integer>();
		bst.insert(10);
		bst.insert(20);
		bst.insert(13);
		bst.insert(16);
		bst.insert(14);
		bst.insert(1);
		bst.printInorder(bst.root);
		bst.root.getLeft().setRight(new Node<Integer>(13));
		bst.printInorder(bst.root);
		System.out.println(bst.isBinarySearchTree());
	}
}

class MinMaxHolder<T extends Comparable<T>>  {
	T min ;
	T max;
	public T getMin() {
		return min;
	}
	public T getMax() {
		return max;
	}
	public void setMin(T min) {
		this.min = min;
	}
	public void setMax(T max) {
		this.max = max;
	}
	
	public  boolean isLessThanOrEqualMax(T currNode) {
		if(currNode == null) {
			return true;
		}
		if(max == null)
			return true;
		else {
			if(max.compareTo(currNode)>0) {
				return false;
			}
			return true;
		}
	}
	
	public  boolean isGreaterThanOrEqualMax(T currNode) {
		if(currNode == null) {
			return true;
		}
		if(max == null)
			return true;
		else {
			if(max.compareTo(currNode) <0) {
				return false;
			}
			return true;
		}
	}
	public  boolean isLessThanOrEqualMin(T currNode) {
		if(currNode == null) {
			return true;
		}
		if(min == null)
			return true;
		else {
			if(min.compareTo(currNode)>0) {
				return false;
			}
			return true;
		}
	}
	public  boolean isGreaterThanOrEqualMin(T currNode) {
		if(currNode == null) {
			return true;
		}
		if(min == null)
			return true;
		else {
			if(min.compareTo(currNode)<0) {
				return false;
			}
			return true;
		}
	}
	
}