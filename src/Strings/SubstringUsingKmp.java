package Strings;
public class SubstringUsingKmp {
	public static int[]  preprocess(String pattern) {
		char[] pattArray = pattern.toCharArray();
		int[] lps = new int[pattArray.length];

		lps[0] = 0;
		int i = 1;
		int currMatchPos =0 ;
		while(i < lps.length){
			if(pattArray[i] == currMatchPos) {
				i++;
				currMatchPos++;
				lps[i] = 	currMatchPos;
			}
			else if(currMatchPos == 0) {
				lps[i] = 0;
				i++;
			}
			else {
				currMatchPos = lps[currMatchPos-1];
			}
		}

		return lps;
	}

	public static void printMatchIndexes(String textString,String pattString)  {
		char[] pattern = pattString.toCharArray();
		char[] text = textString.toCharArray();
		int[] lps =  preprocess(pattString);
		int txtMatchPos = 0;
		int pattMatchPos = 0;
		while(txtMatchPos < text.length) {
			if(pattern[pattMatchPos ] == text[txtMatchPos]) {
				txtMatchPos++;
				pattMatchPos ++;
			}		
			if  (pattMatchPos == pattern.length -1 ) {
				System.out.println("Matched at :"  + (txtMatchPos - pattMatchPos) );
				pattMatchPos = 0;					

			}
			else if((txtMatchPos < text.length) && (pattern[pattMatchPos] != text[txtMatchPos])){
				if(pattMatchPos != 0 ) {
					pattMatchPos = lps[pattMatchPos - 1];
				}
				if (pattMatchPos == 0) {
					txtMatchPos++;
				}
			}
		}
	}


		public static void main(String args[]) {
			String text = "THIS IS A TEST TEXT";
			printMatchIndexes(text,"THIS IS");
			printMatchIndexes(text," A ");
		
		}


	}










