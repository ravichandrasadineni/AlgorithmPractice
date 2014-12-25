package linkedList;

public class IntersectionPointFinder<T>{
	Node<T> head ;
	Node<T> tail;

	public T getIntersectionPoint(IntersectionPointFinder<T> list2) {
		int firstLinkedListSize = this.size();
		int secondLinkedListSize = list2.size();
		if((firstLinkedListSize  ==0) || (secondLinkedListSize == 0 )) {
			return  null;
		}
		int diff = Math.abs(firstLinkedListSize-secondLinkedListSize);
		IntersectionPointFinder<T> bigList = this;
		IntersectionPointFinder<T> smallList = list2;
		if(secondLinkedListSize  > firstLinkedListSize ) {
			bigList = list2;
			smallList = this;
		}
		Node<T> bigListIterator = bigList.head;
		Node<T> smallListIterator = smallList.head;
		for(int i=0; i< diff; i++) {
			bigListIterator = bigListIterator.getNext();	
		}
		while((smallListIterator !=null) && (bigListIterator != null) ) {
			bigListIterator  = bigListIterator.getNext();
			smallListIterator  = smallListIterator.getNext();
			if(bigListIterator   == smallListIterator  ) {

				return smallListIterator.getData();
			}

		}
		return null;
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
	public static void insertArray(Character elements[], IntersectionPointFinder<Character> list) {
		for(int i=0; i < elements.length; i++) {
			list.append(elements[i]);
		}
	} 

	public static void main (String args[]) {
		Character [] elements = {'R','A','D','A','R'};
		IntersectionPointFinder<Character> list1 = new IntersectionPointFinder<Character> ();
		insertArray(elements, list1 );

		IntersectionPointFinder<Character> list2 = new IntersectionPointFinder<Character> ();
		insertArray(elements, list2 );

		list2.head.getNext().setNext(list1.head.getNext().getNext());
		System.out.println("The intersection point is " +list1. getIntersectionPoint(list2));

	}

}
