package BinaryTree;

import java.util.Stack;

public class InorderWithoutRecursion{
	public static void traverseInorder(Node<Integer> rootNode) {
		if(rootNode == null) {
			return;
		}
		Node<Integer> currentNode = rootNode;
		Stack<Node<Integer>> stack = new Stack<Node<Integer>>(); 
		boolean isDone = false;
		while(!isDone) {
			if(currentNode  !=null) {
				stack.push(currentNode);
				currentNode   = currentNode.getLeft();
				
			}	
			else if (!stack.empty()) {
				currentNode = stack.pop();
				System.out.println("The currentElement is " + currentNode.getData());
				currentNode  = currentNode.getRight();   
			}
			else {
				isDone = true;
			}
		}		

	}

	public static void main(String args[]) {
		Node<Integer> rootNode = new Node<Integer>(10);
		rootNode.setLeft(new Node<Integer>(9));
		rootNode.setRight(new Node<Integer>(11));	
		rootNode.getLeft().setLeft(new Node<Integer>(8));
		rootNode.getRight().setRight(new Node<Integer>(12));
		System.out.println("preorder :");
		rootNode.preOrder();
		System.out.println("inOrder :");
		rootNode.inOrder();
		System.out.println("inOrder  without recursion:");
		traverseInorder(rootNode);
		System.out.println("postOrder:");
		rootNode.postOrder();

	}
	
	



} 
