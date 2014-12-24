package linkedList;


public class NumRepCounter {
	public static void insertArray(int elements[], LinkedListDup<Integer> list) {
		for(int i=0; i < elements.length; i++) {
			list.append(elements[i]);
		}
	} 


	public static void main (String args[]) {
		int[] elements = {1,2,1,2,1,2,1,3,4,5,6,1};
		LinkedListDup<Integer> list = new LinkedListDup<Integer> ();
		insertArray(elements, list );
		int count = 0;
		int elmentToSearch  =1;
		for(int i=0; i < list.size(); i ++) {
			if(elmentToSearch == list.get(i)) {
				count ++;
			}
		}
		System.out.println("The count is " + count);

	}

} 
