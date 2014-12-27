package BinaryTree;


import java.util.LinkedList;
import java.util.Queue;



public class LevelOrderTraversal<T  extends Comparable<T>>{

	public static void printTree(Node<Integer> root , String indentLevel) {
		if(root == null) {
			return;
		}
		System.out.println(indentLevel + root.getData());
		indentLevel  += "\t";
		printTree(root.getLeft(),indentLevel);
		printTree(root.getRight(),indentLevel);


	}
	public static void levelOrderTraversal(Node<Integer> root) {
		if (root == null) {
			return;
		}
		Queue<Node<Integer>> queue = new LinkedList<Node<Integer>>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			Node<Integer> currentNode = queue.poll();
			System.out.println(currentNode.getData());
			if(currentNode.getLeft()!=null) {
				queue.offer(currentNode.getLeft());
			}
			if(currentNode.getRight()!=null) {
				queue.offer(currentNode.getRight());
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
		levelOrderTraversal(rootNode);

	}
} 









