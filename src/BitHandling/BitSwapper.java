package BitHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BitSwapper {
	public static int getSwappedNumber(int input){
		int evenBits = input &  0XAAAAAAAA;
		int oddBits = input &  0X55555555;
		oddBits = oddBits << 1;
		evenBits = evenBits >> 1;
		int newNumber = 0;
		newNumber  |= oddBits;
		newNumber  |= evenBits;
		return newNumber;
	}

	public static void main(String args[]) {
		int input =0;
		System.out.println("Enter the number  : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			input = Integer.parseInt(br.readLine());
		}catch(IOException | NumberFormatException e) {
			e.printStackTrace();
		}

		int swappedNumber = getSwappedNumber(input);
		System.out.println("The swapped Number is  " + swappedNumber);	
	}
}
