package BitHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TurnOffBit {
	public static int switchOffBit(int number, int position) {
		return ((~(1<<(position-1)))&(number));

}
	
public static void main (String args[]) {
		int number =0;
		int bitPosition =0;
		System.out.println("Enter the number : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			number = Integer.parseInt(br.readLine());
			System.out.println("Enter the bit position");
			bitPosition  = Integer.parseInt(br.readLine());
		} catch(IOException|NumberFormatException e ) {
			e.printStackTrace();
			return;
}
System.out.println("The new Number is " + switchOffBit(number, bitPosition));	
	}

}