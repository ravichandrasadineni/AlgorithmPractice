package Strings;

public class RabinAnagramFinding {
	public static long buildHash(String s) {
		long hash =0;
		char[] input  = s.toCharArray();
		int baseAscii = ((int)'A' );
		for(int i=0; i< input.length;i++) {
			long setBit = 1 <<(input[i] - baseAscii);
			hash  += setBit;
		} 
		return hash;
	}

	public static int findOccurance(String pat, String txt) {
		if(pat == null || txt == null ) 
			return -1;
		if((pat.length() ==0 || pat. length() > txt.length()))
			return -1;

		long patHash = buildHash(pat);
		int patLength = pat.length();
		long txtHash = buildHash(txt.substring(0, patLength));
		if(patHash  == txtHash) {
			System.out.println(0);
		}
		int baseAscii = ((int)'A' );

		for(int i=patLength ; i < txt.length();i++) {
			long msd  = 1 <<(txt.charAt(i-patLength) -baseAscii);
			long lsd =  1 <<(txt.charAt(i) - baseAscii);
			txtHash = txtHash -msd  + lsd;
			if(txtHash == patHash) 
				System.out.println(i-patLength); 
		}		

		return -1;
		

	}
	public static void main(String args[]) {
		String txt = "BACDGABCDA";
		String pat = "ABCD";
		System.out.print(findOccurance(pat,txt));
	}


}

