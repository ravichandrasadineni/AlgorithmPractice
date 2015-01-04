package Strings;

import java.util.Arrays;
import java.util.Collections;

public class CountPossibleStrings{
	public static int getPossibleCount (String inputStr) {
		char[] input = inputStr.toCharArray();
		Collections.reverse(Arrays.asList(input));
		int numOfPoss[] = new int[input.length+1];
		numOfPoss[0] = 0;
		numOfPoss[1] = 1;
		for(int i=2; i <=input.length;i++) {
			int currVal = input[i-1] -'1'; 
			int prevVal = input[i-2] -'1';

			if(prevVal*10+currVal  <= 26) {

				numOfPoss[i] += numOfPoss[i-2];

			}
			numOfPoss[i] += numOfPoss[i-1]; 
		}

		return numOfPoss[input.length];
	}


	public static void main(String args[]) {
		String digits = "1234";
		System.out.println(getPossibleCount(digits));
	}


}
