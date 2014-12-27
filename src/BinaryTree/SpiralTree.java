package BinaryTree;


import java.util.Stack;



public class SpiralTree<T  extends Comparable<T>>{

	public static void printTree(Node<Integer> root , String indentLevel) {
		if(root == null) {
			return;
		}
		System.out.println(indentLevel + root.getData());
		indentLevel  += "\t";
		printTree(root.getLeft(),indentLevel);
		printTree(root.getRight(),indentLevel);


	}

	public static void printInSpiralForm(Node<Integer> root) {
		if(root == null) {
			return;
		}
		Stack<Node<Integer>> s1 = new Stack<Node<Integer>> ();
		Stack<Node<Integer>> s2 = new Stack<Node<Integer>> ();
		s1.add(root);
		while(!(s1.empty() && s2.empty())) {

			while(!s1.empty()) {
				Node<Integer> currentNode = s1.pop();
				System.out.println(currentNode.getData());
				if(currentNode.getRight()!=null) {
					s2.push(currentNode.getRight());
				}			
				if(currentNode.getLeft()!=null) {
					s2.push(currentNode.getLeft());
				}
				continue;
			}
			while(!s2.empty()) {
				Node<Integer> currentNode = s2.pop();
				System.out.println(currentNode.getData());

				if(currentNode.getLeft()!=null) {
					s1.push(currentNode.getLeft());
				}
				if(currentNode.getRight()!=null) {
					s1.push(currentNode.getRight());
				}

			}


		}	

	}


	public static void main( String args[]) {
		Node<Integer> rootNode = new Node<Integer>(10);
		rootNode.setLeft(new Node<Integer>(9));
		rootNode.setRight(new Node<Integer>(11));	
		rootNode.getLeft().setLeft(new Node<Integer>(8));
		rootNode.getRight().setRight(new Node<Integer>(12));
		System.out.println("Orginal tree");
		printInSpiralForm(rootNode);

	}
} 









