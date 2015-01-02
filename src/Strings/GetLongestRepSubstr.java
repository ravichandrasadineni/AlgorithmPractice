package Strings;

public class GetLongestRepSubstr {

	public static String getLongSubString (String inpStr) {
		char[] input = inpStr.toCharArray();
		int[][] lsbstr = new int[input.length][input.length];
		for(int i=0; i<input.length;i++) {
			if(input[0] == input[i]) {
				lsbstr[0][i] = 1;
			}
			else {
				lsbstr[0][i] = 0;
			}
		}
		int lenLngst =0;
		int startPos =0;
		for(int i=1; i <input.length-1; i ++) {
			for(int j=i+1; j < input.length;j++) {
				if(input[i] == input[j]) {
					lsbstr[i][j] = lsbstr[i-1][j-1] +1;
					if(lsbstr[i][j]  >lenLngst ) {
						lenLngst = lsbstr[i][j];
						startPos = i-lenLngst+1;
					}
				}
				else {
					lsbstr[i][j] = 0;
				}
			}

		}

		return inpStr.substring(startPos, startPos+lenLngst );
	}


	public static void main(String args[]) {
		System.out.println(getLongSubString("abcpqrabpqpq"));	




	}






}




