package BitHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BitStringAddition  {
	public static void makeEqualLengths(StringBuilder num1, StringBuilder num2) {
		int lengthDiff = Math.abs(num1.length() - num2.length());	
		
		if(lengthDiff  == 0)  {
			return;
		}
		StringBuilder smallString = num1;
		if(num2.length() < num1.length()) {
			smallString = num2;
		}
		
		for (int i=lengthDiff-1; i >=0; i--) {
	smallString.insert(0,'0'); 
}			

	}

public static String addBitStrings(String num1,String num2) {
		StringBuilder result = new StringBuilder(); 	
StringBuilder num1Buff = new StringBuilder(num1);
		StringBuilder num2Buff = new StringBuilder(num2);
		makeEqualLengths(num1Buff,num2Buff);
		int carry =0;
		for (int i=num1Buff.length()-1 ; i >=0 ; i--) {
			int num1Bit=   Integer.parseInt(num1Buff.substring(i,i+1));
			int num2Bit=   Integer.parseInt(num2Buff.substring(i,i+1));
			int resultBit =  num1Bit ^num2Bit^carry;
			carry = (num1Bit &carry) | (num2Bit & carry) | (num2Bit & num1Bit);
			result.insert(0,resultBit);
		}
		if(carry == 1) {
			result.insert(0,'1');
		}
		
		return result.toString();
	
	}

public static void main(String args[]) {
		String num1, num2;
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
try {
	System.out.println("Enter the first Number");
	num1 = br.readLine();
	System.out.println("Enter the second Number");
	num2 = br.readLine();
	
}catch(IOException e) {
	e.printStackTrace();
	return;
}	
		String result = addBitStrings(num1,num2);
		System.out.println("Result is" + result);
	}



}
