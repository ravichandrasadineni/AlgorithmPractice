package Arrays;

public class SearchMissingElement {
	public static int getMissingNumber(int[] inputArr) {
		if(inputArr == null) {
			return -1;
		}
		
		int start = 0;
		int end = inputArr.length-1;
		while(true) {
			if(start > end ) 
				return end +2;
			int mid = (start + end)/2;
			if(start != inputArr[start] -1)
				return start+1;
			if(mid  == inputArr[mid] - 1) {
					start = mid +1;
					
			}
			else  {
				end = mid;
			}
			
		}
		
	}
	
	public static void main(String args[]) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 10};
		System.out.println(getMissingNumber(arr));
	}
}
