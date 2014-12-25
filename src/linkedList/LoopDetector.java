package linkedList;


public class LoopDetector<T> {
	Node<T> head ;
	Node<T> tail;

	public  boolean doesLoopExist() {
		if(head == null) {
			return false;
		}
		Node<T>  slowPointer = head;
		Node<T>  fastPointer1 = head;
		Node<T>  fastPointer2 =  fastPointer1.getNext();
		while((fastPointer1 != null)&& (fastPointer2 != null) && (fastPointer2.getNext() !=null) ) {

			slowPointer  = slowPointer .getNext();
			fastPointer1 = fastPointer1.getNext().getNext();
			fastPointer2 = fastPointer2.getNext().getNext();
			if((slowPointer  == fastPointer1) || (slowPointer   == fastPointer2)) {
				return true;
			} 
		}
		return false;


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
	public static void insertArray(int elements[], LoopDetector<Integer> list) {
		for(int i=0; i < elements.length; i++) {
			list.append(elements[i]);
		}
	} 

	public static void main (String args[]) {
		int[] elements = {1,2,3,4,5,6,7,8,9,10,11,12};
		LoopDetector<Integer> list = new LoopDetector<Integer> ();
		insertArray(elements, list );
		list.head.getNext().getNext().setNext(list.head);
		System.out.println("Loop Exist ? " + list.doesLoopExist());
	}

}
