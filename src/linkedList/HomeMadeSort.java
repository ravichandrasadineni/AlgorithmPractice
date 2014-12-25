package linkedList;
import java.util.Random;


public class HomeMadeSort {



	private static  Random ranNumGen =  new Random();
	public static int getRandomNumBetween(int start, int end) {
		int range  = end -start;
		return start + ranNumGen.nextInt(range);
	}

	public static <T extends Comparable<T>>void quickSort(LinkedListDup<T> elements, int begin, int end) {
		int pivotIndex = getRandomNumBetween(begin,end);
		T pivotElement = elements.get(pivotIndex); 
		int i = begin;
		int j = end;
		while (i < j) {

			while(elements.get(i).compareTo(pivotElement) < 0) {
				i++;
			}
			while(elements.get(j).compareTo(pivotElement) > 0) {
				j--;
			}

			if(i <= j) {
				T temp = elements.get(i);
				elements.insert(i,elements.get(j));
				elements.insert(j, temp);	
				i++;
				j--;	
			}
		}
		if( i < end) {
			quickSort(elements, i,end);
		}
		if( j > begin) {
			quickSort(elements, begin,j);				
		}

	}

	public static  <T extends Comparable<T>> void sort(T[] elements) {
		if((elements == null ) || (elements.length == 0)) {
			return;
		}

	}

}




