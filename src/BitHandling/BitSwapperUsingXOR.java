package BitHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BitSwapperUsingXOR {
	public static int  swapBits(int num, int pos1, int pos2, int numOfBits) {
		int temp1 = num;
		int temp2 = num;
		temp1   = temp1 >>pos1;
		temp1 = ((1<<numOfBits)-1) & temp1;
		temp2   = temp2 >>pos2;
		temp2 = ((1<<numOfBits)-1) & temp2;
		int xor = temp1^temp2;
		temp1 = (xor << pos2) | (xor<<pos1);
		temp1 = temp1^ num;
		return temp1;
	}

	public static void main(String args[]) {
		int num , pos1, pos2, numOfBits;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Enter the number");
			num = Integer.parseInt(br.readLine());
			System.out.println("Enter the first position");
			pos1 = Integer.parseInt(br.readLine());
			System.out.println("Enter the second position");
			pos2 = Integer.parseInt(br.readLine());
			System.out.println("Enter the number of bits");
			numOfBits = Integer.parseInt(br.readLine());
		}catch(IOException | NumberFormatException e) {
			e.printStackTrace();
			return;
		}
		System.out.println("The swapped number is" + swapBits(num, pos1, pos2, numOfBits)  );		

	}







}
