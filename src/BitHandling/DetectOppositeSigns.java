package BitHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DetectOppositeSigns {
	public static void areOppositeSigns(int num1, int num2) {
		if((num1^num2) <0) {
			System.out.println("The numbers have opposite signs");
		}
		else {
			System.out.println("The numbers have same signs");
		}
	}

	public static void main (String args[]) {
		int num1, num2;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			num1 = Integer.parseInt(br.readLine());
			num2 = Integer.parseInt(br.readLine());
		}catch(IOException | NumberFormatException e) {
			e.printStackTrace();
return;	
		}
		areOppositeSigns(num1,num2);
	}

}
