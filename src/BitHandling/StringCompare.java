package BitHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringCompare {
	public static int compareStrings(String s1, String s2) {
		int  differingPosition =0;
		while((differingPosition<s1.length()) && (differingPosition<s2.length())) {
			int s1AsciiBit = Integer.valueOf(s1.charAt(differingPosition));
			int s2AsciiBit = Integer.valueOf(s2.charAt(differingPosition));
			if((s1AsciiBit == s2AsciiBit ) || ((s1AsciiBit ^ 32) ==  s2AsciiBit)) {
				differingPosition++;
				continue;
			}
			else {
				if ((s1AsciiBit|32) > (s2AsciiBit|32)) {
					return 1;
				}
				else {
					return -1;
				}
			}

		}
		if(differingPosition < s1.length()) {
			return 1;
		}
		if(differingPosition < s2.length()) {
			return -1;
		}
		return 0;
	}


	public static void main(String args[]) {
		String s1 =null, s2=null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Enter the first string");
			s1 = br.readLine();
			System.out.println("Enter the second string");
			s2 = br.readLine();	
		}catch(IOException e) {
			e.printStackTrace();
			return;
		}
		int returnValue;
		if((returnValue = compareStrings(s1,s2)) ==0) {
			System.out.println("The strings are equal");
			return;
		}
		else {
			System.out.println("The strings are not equal" + returnValue);
			return;

		}

	}


}
