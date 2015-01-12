package DyanamicProgramming;

public class MatrixChainMultiplication {
	public static int getMinCost(int[] inputSizes) {
		int numOfMatrices = inputSizes.length -1;
		int[][] dpArr = new int[numOfMatrices+1][numOfMatrices+1];
		for(int range = 2; range <= numOfMatrices; range++) {
			for(int begin =0; begin< numOfMatrices - range+1 ; begin++) {
				int end = begin + range;
				int currentMin = Integer.MAX_VALUE; 
				for(int breakP =begin+1; breakP<end; breakP++)
					currentMin  = Math.min(currentMin, dpArr[begin][breakP] + 
							dpArr[breakP][end] + inputSizes[begin]*inputSizes[breakP]*inputSizes[end]);
				dpArr[begin][end]  = currentMin;
			}
		}
		return dpArr[0][numOfMatrices];
	}


	public static void main(String args[]) {
		int inputSizes[] = {10, 20, 30, 40, 30};
		System.out.println("Minimum cost is " + getMinCost(inputSizes));

	}
}


