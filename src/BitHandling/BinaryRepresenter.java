package BitHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryRepresenter {
	public static String convertToBinary(int number)  {
		int masker = 1;
		StringBuilder binaryString  = new StringBuilder();
		while(masker  <= number) {
			if((number & masker) != 0) {
				binaryString .insert(0,'1');
			} 
			else {
				binaryString .insert(0,'0');
			}
			masker = masker<<1;
		}
		return binaryString.toString();
	}

	public static void convertToBinaryRecursive(StringBuilder sBuff, int num) {
		if(num/2 != 0) {
			convertToBinaryRecursive(sBuff,num/2);
		}
		sBuff.insert(0, String.valueOf(num%2));	
	}

	public static void main (String args [] ) {
		int number =0 ;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			number = Integer.parseInt(br.readLine());	
		}catch(IOException | NumberFormatException e) {
			e.printStackTrace();
			return;
		}
		System.out.println("The binary representation is " +convertToBinary(number));
		StringBuilder sBuff = new StringBuilder();
		convertToBinaryRecursive(sBuff,number);
		System.out.println("The binary representation is " +sBuff);
	}


}
