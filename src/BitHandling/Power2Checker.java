package BitHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Power2Checker {
	public static void main (String args[]) {
		int number = 0;
		System.out.println("Enter the number :");
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		try {
			number = Integer.parseInt(br.readLine());
		}catch(IOException | NumberFormatException e) {
			e.printStackTrace();
		}
		if(number  != 0 ) {
			if((number & number-1) == 0 ) {
				System.out.println("The given number is a power of 2");
			}else {
				System.out.println("The given number is not a power of 2");
			}
		} else {
			System.out.println("The given number is not a power of 2");
		}
	}
}
