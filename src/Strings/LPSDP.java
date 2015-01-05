package Strings;

public class LPSDP {
	public static void  getMaxPalindromicString(String originalString) {
		char[] original = originalString.toCharArray();
		boolean [] preRow= new boolean[original.length];
		boolean [] prePreRow= new boolean[original.length];
		int maxLength =1;
		int maxStartIndex =0;
		for(int i=0; i<prePreRow.length; i++) {
			prePreRow[i] = true;
		}

		for(int i=0; i<preRow.length-1; i++) {
			if(original[i] == original[i+1]) {
				preRow[i] = true;
				maxLength = 2;
				maxStartIndex = i;	
			}else {
				preRow[i] = false;
			}
		}

		int range =2;

		while(range < original.length) {
			for(int i=0;i<original.length-range;i++) {
				if(original[i] == original[i+range]) {
					if(prePreRow[i+1]) {
						prePreRow[i] = true;
						maxLength = range+1;
						maxStartIndex = i;
					}
					else {
						prePreRow[i] = false;
					}
				}
				else {
					prePreRow[i] = false;
				}	

			}
			range += 1;
			for(int i=0;i<original.length-range;i++) {
				if(original[i] == original[i+range]) {
					if(preRow[i+1]) {
						preRow[i] = true;
						maxLength = range+1;
						maxStartIndex = i;
					}
					else {
						preRow[i] = false;
						}
				}
				else {
					preRow[i] = false;
				}	
			}
			range += 1;
		}
		System.out.println(originalString.substring(maxStartIndex,maxStartIndex+maxLength));

	}

	public static void main (String args[]) {
		String txt = "forgeeksskeegfor";
		getMaxPalindromicString(txt);
	}

}
