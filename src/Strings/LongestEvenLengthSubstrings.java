package Strings;

public class LongestEvenLengthSubstrings{
	public static void getLngtEvenLenSubstr(String inputStr) {
		int maxLength =1;
		int startIndex = 0;
		if(inputStr == null ) {
			return;
		}
		if(inputStr.length() == 0) {
			return;
		}
		int lenSums[][] = new int[inputStr.length()][inputStr.length()];

		char[] input = inputStr.toCharArray(); 
		for(int i=0;i < input.length; i++) {
			lenSums [i][i] = Integer.parseInt(String.valueOf(input[i]));
		}
		int range =1;
		while(range <input.length) {
			for(int i=0;i < input.length-range; i++) {
				int mid =  (i+range+i)/2;
				lenSums[i][i+range] = lenSums[i][mid] + lenSums[mid+1][i+range]; 
				if(range%2 != 0) {
					if(lenSums[i][mid]  == lenSums[mid+1][i+range]) {
						maxLength = range+1;
						startIndex = i;
					}
				}
			}

			range++;
		}
		System.out.println(maxLength);
		System.out.println(inputStr.substring(startIndex,startIndex+maxLength));

	}

	public static void main (String args[]) {
		String txt = "12123";
		getLngtEvenLenSubstr(txt);
		

	}

}
