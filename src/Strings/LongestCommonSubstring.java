package Strings;

public class LongestCommonSubstring {
	public static String getLongestCommonSubstring(String s1, String s2) {
		char[] string1 = s1.toCharArray();
		char[] string2 =  s2.toCharArray();
		int[][] subStrLen = new int[string1.length+1][string2.length+1];
		int maxLen = 0;
		int s1StartPos = 0;
		for(int i =0 ; i <= string1.length; i++) {
			for(int j=0; j<=string2.length; j++) {
				if(( i ==0 )||(j==0) ) {
					subStrLen[i][j] = 0;
				}
				else {
					if(string1[i-1] == string2[j-1]) {
						subStrLen[i][j] = subStrLen[i-1][j-1] +1;
						if(maxLen < subStrLen[i][j] )  {
							maxLen  = subStrLen[i][j] ;
							s1StartPos = i -	maxLen-1;
						}
					} 
					else {
						subStrLen[i][j]  = 0;
					}

				}
			}

		}

		return s1.substring(s1StartPos, s1StartPos+maxLen);

	}


	public static void main(String args[]) {

		System.out.println(getLongestCommonSubstring("OldSite:GeeksforGeeks.org",
				"NewSite:GeeksQuiz.com"));


	}	


}
