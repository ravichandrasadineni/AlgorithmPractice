package Strings;

public class RotationPalindromicString {
	public static boolean isPalindromicString(String s) {
		String joined  = s + s;
		char[] input = joined  .toCharArray();
		boolean row1[] = new boolean[input.length];
		boolean row2[] = new boolean[input.length];
		for(int i=0; i <input.length; i ++) {
			row1[i] = true;
		}				
		int range = 1;
		while(range < input.length) {
			boolean isTrueInRow = false;
			for(int i=range; i<input.length;i++) {
				if(input[i-range] == input[i] && (row1[i-1])) {
					isTrueInRow  = true;
					row2[i] = true;
				}
				else {
					row2[i] = false;
				}
			}
			if(((range+2)== s.length()) &&(isTrueInRow)) {
				return true;
			}
			else if((range+2)== s.length()) {
				return false;
			}
			row1 = row2;
			range++;
		}
		return false;
	}


	public static void main(String args[]) {
		System.out.println(isPalindromicString("aab"));
	}
}
