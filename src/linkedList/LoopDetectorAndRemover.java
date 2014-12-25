package linkedList;

public class LoopDetectorAndRemover<T>{
	Node<T> head ;
	Node<T> tail;

	public void removeLoop(Node<T> head , Node<T> loopNode) {
		Node<T> checkNode = head;
		Node<T> runningNode = loopNode;
		while(true) {
			while((runningNode.getNext()  != loopNode) &&(runningNode.getNext()   != checkNode)) {
				runningNode   = runningNode .getNext();
			}
			if(runningNode.getNext()   == checkNode) {
				System.out.println("End node is " +runningNode.getData() );
				runningNode.setNext(null);	
				return;
			} 
			runningNode = loopNode.getNext();
			checkNode = checkNode.getNext();
		}

	}

	public void detectAndRemoveLoop() {
		if((head == null) || (head.getNext() == null)) {
			return;	
		}
		Node<T> slowPointer = head;
		Node<T> fastPointer1 = head;
		Node<T> fastPointer2 = head.getNext();		
		while((fastPointer1  !=null) && (fastPointer2 !=null) && (fastPointer2.getNext() != null)) {
			fastPointer1 = fastPointer1.getNext().getNext();
			fastPointer2 = fastPointer2.getNext().getNext();
			slowPointer  = slowPointer.getNext();
			if((slowPointer  == fastPointer1) || (fastPointer2 == slowPointer)) {
				removeLoop(head, slowPointer);
				return;
			}	
		}
		return;

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
	public static void insertArray(char elements[], LoopDetectorAndRemover<Character> list) {
		for(int i=0; i < elements.length; i++) {
			list.append(elements[i]);
		}
	} 

	public static void main (String args[]) {
		char[] elements = {'R','A','D','A','R'};
		LoopDetectorAndRemover<Character> list = new LoopDetectorAndRemover<Character> ();
		insertArray(elements, list );
		list.head.getNext().getNext().getNext().setNext(list.head.getNext().getNext().getNext());
		list.detectAndRemoveLoop();		
	}

}
