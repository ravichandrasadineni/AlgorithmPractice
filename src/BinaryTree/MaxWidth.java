package BinaryTree;

import java.util.Stack;



public class MaxWidth<T  extends Comparable<T>>{

	public static void printTree(Node<Integer> root , String indentLevel) {
		if(root == null) {
			return;
		}
		System.out.println(indentLevel + root.getData());
		indentLevel  += "\t";
		printTree(root.getLeft(),indentLevel);
		printTree(root.getRight(),indentLevel);


	}


	public static int getMaxWidth(Node<Integer>  rootNode) {
		if(rootNode == null) {
			return 0;
		}
		Stack<Node<Integer>> s1 = new Stack<Node<Integer>>();
		Stack<Node<Integer>> s2 = new Stack<Node<Integer>>();				
		s1.push(rootNode);
		int maxWidth =0;
		while(!(s1.empty() && s2.empty())) {
			if(maxWidth < s1.size()) {
				maxWidth = s1.size();
			}

			while(!s1.empty()) {
				Node<Integer> currentNode  = s1.pop();
				if(currentNode.getLeft() !=null) {
					s2.push(currentNode.getLeft());	
				}
				if(currentNode.getRight() !=null) {
					s2.push(currentNode.getRight());
				}
			}
			if(maxWidth < s2.size()) {
				maxWidth = s2.size();
			}
			while(!s2.empty()) {
				Node<Integer> currentNode  = s2.pop();
				if(currentNode.getLeft() !=null) {
					s1.push(currentNode.getLeft());	
				}
				if(currentNode.getRight() !=null) {
					s1.push(currentNode.getRight());
				}
			}

		}

		return maxWidth;
	}

	public static void main( String args[]) {
		Node<Integer> rootNode = new Node<Integer>(10);
		rootNode.setLeft(new Node<Integer>(9));
		rootNode.setRight(new Node<Integer>(11));	
		rootNode.getLeft().setLeft(new Node<Integer>(8));
		rootNode.getRight().setRight(new Node<Integer>(12));
		rootNode.getRight().setLeft(new Node<Integer>(14));
		System.out.println(getMaxWidth(rootNode) );

	}
} 










