package linkedList;

import java.util.ArrayList;
import java.util.List;

public class MergeSortLL<T extends Comparable<T>>{
	Node<T> head ;
	Node<T> tail;


	public   List<MergeSortLL<T>> frontBackSplit(MergeSortLL<T> mainList) {
		List<MergeSortLL<T>> frBackSplitList  = new ArrayList<MergeSortLL<T>> ();
		MergeSortLL<T> frontList = new MergeSortLL<T> ();
		MergeSortLL<T> backList = new MergeSortLL<T> ();
		frBackSplitList.add(frontList );
		frBackSplitList.add(backList );

		if((mainList.head == null )|| (mainList.head.getNext() == null) ) {
			frontList.head = mainList.head;
			return frBackSplitList;
		}
		Node<T> slowPointer = mainList.head;
		Node<T>  fastPointer = mainList.head.getNext();
		while(fastPointer != null) {
			fastPointer = fastPointer.getNext();
			if(fastPointer  != null) {
				fastPointer    = fastPointer.getNext();
				slowPointer =  slowPointer.getNext(); 	
			}
		}		
		frontList.head = mainList.head;
		backList. head = slowPointer.getNext();
		slowPointer.setNext(null);
		return frBackSplitList;
	}



	public  MergeSortLL<T> merge( MergeSortLL<T> list2) {
		MergeSortLL<T>  mergedList = new MergeSortLL<T> ();	
		Node<T> list1Pointer = this.head;
		Node<T> list2Pointer = list2.head;

		while((list1Pointer !=null) &&(list2Pointer != null)) {
			if(list1Pointer.getData().compareTo(list2Pointer.getData() ) <0) {
				mergedList.append(list1Pointer.getData());
				list1Pointer  = list1Pointer.getNext();
			}
			else {
				mergedList.append(list2Pointer.getData());
				list2Pointer  = list2Pointer.getNext();
			}
		}
		while(list1Pointer !=null) {
			mergedList.append(list1Pointer.getData());
			list1Pointer  = list1Pointer.getNext();
		}
		while(list2Pointer !=null) {
			mergedList.append(list2Pointer.getData());
			list2Pointer  = list2Pointer.getNext();
		}

		return mergedList;
	}

	public MergeSortLL<T> mergeSort() {
		if((this.size() == 0) || (this.size() == 1) ) {
			return this;
		}
		List<MergeSortLL<T>> frBckList  = frontBackSplit(this);
		MergeSortLL<T> list1 = frBckList.get(0);
		list1 = list1.mergeSort();
		MergeSortLL<T> list2 = frBckList.get(1);
		list2 = list2.mergeSort();
		return list1.merge (list2);
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
	public static void insertArray(char elements[], MergeSortLL<Character> list) {
		for(int i=0; i < elements.length; i++) {
			list.append(elements[i]);
		}
	} 

	public static void main (String args[]) {
		char[] elements = {'R','A','D','A','R'};
		MergeSortLL<Character> list = new MergeSortLL<Character> ();
		insertArray(elements, list );
		list = list.mergeSort();
		

	}

}
