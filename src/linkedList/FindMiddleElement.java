package linkedList;

public class FindMiddleElement<T>{
	Node<T> head ;
	Node<T> tail;

	public T getMiddleElement() {
		if(head == null)
			return null;
		Node<T> currentElement = head;
		Node<T> reqElement = head;
		if(currentElement .getNext() == null) {
			return reqElement .getData();
		}
		currentElement  = currentElement .getNext();
		while((currentElement.getNext() !=null)  &&(currentElement.getNext().getNext() !=null))  {
			currentElement = currentElement.getNext().getNext();
			reqElement  = reqElement.getNext();
		}
		return reqElement.getData() ;


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
	public static void insertArray(int elements[], FindMiddleElement<Integer> list) {
		for(int i=0; i < elements.length; i++) {
			list.append(elements[i]);
		}
	} 

	public static void main (String args[]) {
		int[] elements = {1,2,3,4,5,6,7,8,9,10,11,12};
		FindMiddleElement<Integer> list = new FindMiddleElement<Integer> ();
		insertArray(elements, list );
		System.out.println(list.getMiddleElement());
		


	}



}

