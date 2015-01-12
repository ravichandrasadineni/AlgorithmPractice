package DyanamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class RepetetiveKnapsack {

	public  static int getMaxKnapsack(List<Integer> weights,List<Integer> values, int maxWeight)  {
		int[] dpArr = new int[maxWeight+1];
		for(int w =0; w<=maxWeight; w++) {
			int currMax = 0;
			for(int i=0; i <values.size(); i++ ) {
				if(weights.get(i) <= w) {
					currMax = Math.max(currMax, values.get(i) + 
							dpArr[w-weights.get(i)]);
				}
			}
			dpArr[w] = currMax;
		}

		return dpArr[maxWeight];
	} 



	public static void main(String args[]) {
		List<Integer> weights = new LinkedList<Integer>();
		List<Integer> values = new LinkedList<Integer>();
		System.out.println("Enter the number of items \n");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfItems  = 0;
		int maxWeight  = 0;
		try {
			System.out.println("Enter the num of items");
			 numOfItems =  Integer.parseInt(br.readLine());
			System.out.println("Enter the Max weight allowed");
			 maxWeight =  Integer.parseInt(br.readLine());

		}catch(IOException   | NumberFormatException e) {
			e.printStackTrace();
		}
		while(numOfItems != 0) {
			System.out.println("Enter the weight and value of all items respectively");
			try {
				weights.add(Integer.parseInt(br.readLine()));
				values.add(Integer.parseInt(br.readLine()));

			} catch(IOException  | NumberFormatException e) {

				e.printStackTrace();
			}
			numOfItems--;
		}	
		System.out.println("Max Knapsack value " +
				getMaxKnapsack(weights,values,maxWeight));
	}


}
