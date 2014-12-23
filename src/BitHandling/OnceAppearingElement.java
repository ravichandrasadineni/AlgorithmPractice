package BitHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Element appearing only once in an array containing triplets
public class OnceAppearingElement {
	public static int findSingleElement(int[] inputArray) {
		int  singleBits=0;
		int twoBits = 0;
		for(int i=0; i<inputArray.length;i++) {
			twoBits = twoBits | (singleBits & inputArray[i]);
			singleBits = singleBits ^inputArray[i];
			int commonBitMask = ~(singleBits & twoBits);
			twoBits  = twoBits  & commonBitMask;
			singleBits  = singleBits  & commonBitMask; 
		}		
		return singleBits;
	}


	public static void main(String args[]) {
		int[] inputArray;
		int size;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Enter the size");
			size = Integer.parseInt(br.readLine());
			inputArray = new int[size];
			System.out.println("Enter the elements one by one");
			for(int i=0; i< inputArray.length; i ++) {
				inputArray[i] = Integer.parseInt(br.readLine());
			}

		}catch(IOException|NumberFormatException e) {
			e.printStackTrace();
			return;
		}

		System.out.println("The single element is " + findSingleElement(inputArray));


	}
}
