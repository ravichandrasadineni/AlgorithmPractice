package Strings;

public class AllPossibleSpaces{
	public static void printAllPossibleSpaces(String inputStr, int orglen,  int start, int numSpcs) {
		if(inputStr == null) {
			return;
		}
		if(numSpcs ==0) {
			System.out.println("'" + inputStr+ "'");
			return;
		}
		if(inputStr.length() == 0) {
			return;
		}
		int remplcs = orglen - start -1;

		if(remplcs  < numSpcs) {
			return;
		}

		if(numSpcs == remplcs) {
			StringBuilder permutations = new StringBuilder(inputStr);
			for(int i=start+1; i < orglen; i++) {
				permutations.insert(i+permutations.length()-orglen," ");
			}	
			System.out.println("'" +permutations +"'");
		}
		else {
			StringBuilder permutations = new StringBuilder(inputStr);
			permutations.insert(start+1+inputStr.length()-orglen, " ");
			printAllPossibleSpaces(permutations.toString(), orglen,start+1, numSpcs-1);
			printAllPossibleSpaces(inputStr, orglen,start+1, numSpcs);
		}
	}

	public static void main (String args[]) {
		String txt = "ABCDE";
		for(int i=0;i< txt.length(); i++) {
			printAllPossibleSpaces(txt, txt.length(),0,i);
		}

	}

}
