package Strings;

public class PrintAllPossibleDigits {

	public static String digitToCharMap []  = {"","","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
	public static void printAll (int[] num, char[] output, int curPos) {
		if(curPos == output.length) {	
			System.out.println((output));
			return;
		}
		String currString = digitToCharMap[num[curPos]];
				for (int i=0; i < currString.length(); i++) {
					output[curPos] = currString.charAt(i);
					printAll(num,output,curPos+1);
				}
	}

	public static void printAllWords(int num[]) {
		char[] array = new char[num.length];
		printAll(num,array, 0);
	}
	public static void main(String[] args) {
		int num[]  = {2,3,4};
		printAllWords(num);
	}

}
