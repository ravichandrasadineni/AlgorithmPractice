package Strings;

public class KMP {
	public static int[] preprocess(String patternString) {
		char pattern[] = patternString.toCharArray();
		int lps[] = new int[pattern.length];
		int matchingLength = 0;
		int currentPosition = 1;
		lps[0] = 0;
		while(currentPosition < pattern.length) {

			if(pattern[currentPosition] == pattern[matchingLength]) {
				matchingLength++;
				lps[currentPosition] = matchingLength;
				currentPosition++;			
			}
			else if(matchingLength == 0) {
				lps[currentPosition]  = 0;
				currentPosition++;

			}
			else {
				matchingLength = lps[matchingLength-1];

			}
		}

		return lps;
	}

	public static void printMatchIndex(String txtString, String patternString) {
		if(patternString == null || txtString == null) {
			return;
		}
		if(patternString.length() > txtString.length()) {
			return;
		}

		if(patternString.length() == 0 ) {
			return;
		}
		int lps[] = preprocess(patternString);
		char[] pattern = patternString.toCharArray();
		char[] txt =  txtString.toCharArray();
		int matchedTxt = 0;
		int matchedPtrn = 0;
		while(matchedTxt  < txt.length) {
			if(txt[matchedTxt] == pattern[matchedPtrn]) {
				matchedTxt ++;
				matchedPtrn++;
			}

			if(matchedPtrn == pattern.length) {
				System.out.println("Found pattern at index " + (txt.length -pattern.length) );
				matchedTxt += 1;
				matchedPattern = 0;
			}
			else if ((matchedTxt < txt.length) &&(txt[matchedTxt] != 
					pattern[matchedPtrn])) {
				if(matchedPtrn  != 0) {
					matchedPtrn  = lps[matchedPtrn -1];
				}
				else {
					matchedTxt = matchedTxt+1;

				}

			}

		}



	}

	public static void main (String args[]) {
		String txt = "ABABDABACDABABCABAB";
		String pat = "ABABCABAB";
		printMatchIndex(txt,pat);
	}

}
