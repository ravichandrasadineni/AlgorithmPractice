package linkedList;

public class LinkedListDup<T>{
	Node<T> head ;
	Node<T> tail;
	public LinkedListDup() {
		head = null;
		tail = null;
	}

	public  void push(T data) {
		if(head == null) {
			head = new Node<T>();
			tail = head;
			return;
		}
		else {
			Node<T> newNode = new Node<T>(data,head);
			head = newNode;
			return;
		}
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

	public void addFirst(T data ) {
		this.insert(0, data);
	}

	public T get(int index ) {
		int size = this.size();
		if ((index  <0) || (index >=size)) {
			throw new IndexOutOfBoundsException();
		} 	
		Node<T> currentElement = head;
		for(int i=0; i< index; i++) {
			currentElement = currentElement.getNext();
		}
		return currentElement .getData(); 

	}

	public T getFirst() {
		return this.get(0);

	} 
	public T getLast() {
		int size = this.size();
		return this.get(size-1);	
	}

	public void remove(int index) {
		int size = this.size();
		if ((index  <0) || (index >=size)) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			head = head.getNext();
		}
		Node<T> currentElement = head;
		for(int i=0; i < index-1; i++ ) {
			currentElement = currentElement.getNext();
		}
		Node<T>  deleteMe = currentElement.getNext();
		currentElement .setNext(deleteMe.getNext());
		if(deleteMe == tail) {
			tail = currentElement ;
		}	
	}

	public void removeFirst() {
		this.remove(0);
	} 

	public void removeLast() {
		this.remove(this.size()-1);
	}



} 
