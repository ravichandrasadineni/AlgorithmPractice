package linkedList;

import java.util.LinkedList;
import java.util.List;

public class PalindromeChecker<T extends Comparable<T>>{
	Node<T> head ;
	Node<T> tail;

	public boolean checkIfPalindrome() {
		LinkedList<T> stack  = new LinkedList<T>();
		Node<T> currentPosition = head;
		if(head == null) {
			return  false;
		}
		while (currentPosition  != null) {
			stack.add(0,currentPosition.getData());
			currentPosition   = currentPosition .getNext();
		}
		
		currentPosition = head;
		while(currentPosition  !=null) {
			if(currentPosition.getData().compareTo(stack.poll()) !=0 ) {
				return false;
			}
			currentPosition   = currentPosition.getNext();
			
		}
		return true;

	}

	public void insert(int index, T data ) {
		int currentSize  = this.size(); 
		int maxAllowableIndex = (currentSize -1) + 1;
		if((index  > maxAllowableIndex) || (index < 0) ) {
			throw new IndexOutOfBoundsException();
		}
		if(index   == 0) {
			Node<T> newNode = new Node<T>(data,head);
			head = newNode;
			return;
		}
		if(index ==  currentSize-1) {
			Node<T> newNode = new Node<T>(data,null);
			tail.setNext(newNode);
			tail = newNode;
		}
		Node<T> currentNode = head;
		for(int i =0; i < index -1; i++) {
			currentNode = currentNode.getNext();
		}
		Node<T> newNode = new Node<T>(data,currentNode.getNext());
		currentNode.setNext(newNode);		
	}

	public void append(T data ) {
		int currentSize  = this.size(); 
		this.insert(currentSize, data);
	}

	public  int size() {
		int size;
		Node<T> currentNode = head;
		if(currentNode  == null) {
			return 0;
		}
		size = 1;
		while(currentNode.getNext() !=null) {
			currentNode = currentNode.getNext();
			size ++;
		}
		return size;
	}
	public static void insertArray(char elements[], PalindromeChecker<Character> list) {
		for(int i=0; i < elements.length; i++) {
			list.append(elements[i]);
		}
	} 

	public static void main (String args[]) {
		char[] elements = {'R','A','D','A','R'};
		PalindromeChecker<Character> list = new PalindromeChecker<Character> ();
		insertArray(elements, list );
		System.out.println("Is it A palindrome ? " + list.checkIfPalindrome());
	}

}
