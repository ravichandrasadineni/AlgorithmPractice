package DyanamicProgramming;

public class CoinExchange {

	public static int getCount(int cents[], int totalCount) {
		int[] dpArr = new int[totalCount +1];
		dpArr[0] = 1;
		for(int k=0; k< cents.length;k++) {
			for(int i=cents[k]; i<= totalCount; i ++) {

				dpArr[i] += dpArr[i-cents[k]];
			}
		}
		return dpArr[totalCount];

	}


	public static void main(String args[]) {
		int[] inpArr = {2, 3, 5, 6,1};
		System.out.println(getCount(inpArr,10));
	}
}
