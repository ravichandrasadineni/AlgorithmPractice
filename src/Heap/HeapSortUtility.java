package Heap;

public class HeapSortUtility<T extends Comparable<T>>{
	T[] inputArray ;
	int size;
	HeapSortUtility(T[] inputArray) {
		this.inputArray = inputArray;
		this.size = inputArray.length;
	}
	public int leftChild(int pos) {
		return (2*pos) + 1;
	}
	public int rightChild(int pos) {
		return (2*pos) +2;
	}
	boolean isRightChildExist(int pos) {
		return (((2*pos) +2) < size);
		
	}
	public int parent(int pos) {
		return (pos-1)/2;
	}

	public void swap(int pos1, int pos2) {
		T temp = inputArray[pos1];
		inputArray[pos1] = inputArray[pos2];
		inputArray[pos2] = temp;

	}
	public  void max_heapify(int pos) {
		
		if((pos+1) > ((size)/2 )) {
			return ;
		}		
		else {
			int leftC = inputArray[pos].compareTo(inputArray[leftChild(pos)]);
			int rightC =0;
			if(isRightChildExist(pos))
				 rightC = inputArray[pos].compareTo(inputArray[rightChild(pos)]);
			int leftRightC =
					inputArray[leftChild(pos)].compareTo(inputArray[rightChild(pos)]);
			//if(rightC) 
			if(leftC  > 0 && rightC >0) {
				return;
			}
			else if (leftRightC > 0) {
				swap(pos, leftChild(pos));
				max_heapify(leftChild(pos));
				return;
			}
			else {
				swap(pos, rightChild(pos));
				max_heapify(rightChild(pos));
				return;
			}
		}
	}
	public  void build_maxHeap() {
		for(int i=(size-1)/2-1; i>=0;i--) {
			max_heapify(i);	
		}
	}

	public   T extract_max() {
		T currMax =  inputArray[0];
		swap(0,size-1);
		size = size -1;
		max_heapify(0);
			
		return currMax;
	}	

	public static void main(String args[]) {
		 Integer arr[] = {12, 11, 13, 5, 6, 7};
		 HeapSortUtility<Integer> sorter = new HeapSortUtility<Integer>(arr);
		 sorter.build_maxHeap();
		 for(int i=0; i< arr.length; i++) {
			 System.out.println(sorter.extract_max());
		 }

	}



}
