package Strings;

import java.util.LinkedList;
import java.util.List;

public class PrintExcelColumn  {

	public static void printString(int colNum) {
		int baseAscii = (int)'A' -1;
		int input = colNum;
		List<Character> output = new LinkedList<Character>();
		while(input > 0) {
			int rem = input%26;
			if(rem ==0) {
				output.add('Z');
				input = input/26 -1;	
			}
			else {
				output.add((char)((input)%26 + baseAscii));
				input = input /26;
			}
		}

		StringBuilder column = new StringBuilder();
		for(char charecter  : output ) {
			column.insert(0,charecter);
		}
		System.out.println(column);
	}


	public static void main(String args[]) {
		printString(26);
		printString(51);
		printString(52);
		printString(80);
		printString(676);
		printString(702);
		printString(705);



	}



}
