package BitHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SwapTwoNumbers{
	public static void main(String args[]) {
		int num1 =0, num2 =0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Enter the First number :");
			num1 = Integer.parseInt(br.readLine());
			System.out.println("Enter the second number :");
			num2 = Integer.parseInt(br.readLine());
		}catch(IOException | NumberFormatException e) {
			e.printStackTrace();
			return;
		}
		num1 = num1^num2;
		num2 = num1^num2;
		num1 = num1^num2;
		System.out.println("The numbers are  :" + num1 + " ," + num2 );
	}	
}
