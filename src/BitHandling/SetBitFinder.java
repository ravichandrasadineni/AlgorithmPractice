package BitHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SetBitFinder {
	public static void printSetPosition(int num) {
		if(num == 0) {
			System.out.println("The number has no set bits");
		}
		int currentBit =0;
		while(num !=0) {
			if((num&1)==1) {
				num = num>>1;
				if(num !=0) {
					System.out.println("The number has more than one bit set. Least Significant Bit is " + currentBit);
					return;
				}
				else {
					System.out.println("The position of set bit is " + currentBit);

				}
			}
			num = num>>1;
			currentBit++;
		}
	}


	public static void main (String args[]) {
		int number = 0;
		System.out.println("Enter the number : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			number  = Integer.parseInt(br.readLine());
		}catch(IOException | NumberFormatException e) {
			e.printStackTrace();
			return;
		}
		printSetPosition(number);

	}
}
