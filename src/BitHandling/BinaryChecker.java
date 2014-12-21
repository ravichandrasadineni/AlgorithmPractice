package BitHandling;



import java.io.*;

public class BinaryChecker {

	public static boolean isNthBitSet(int number, int position) {
		boolean Value =  (((1 << (position -1))  & number) != 0) ;
		return Value;
	}


	public static void main (String args[]) {
		int input=0;
		System.out.println("Enter the number :");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				input = Integer.parseInt(br.readLine());
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		int startPosition = 1 ;
		int endPosition = 	Integer.toBinaryString(input).length(); 
		while (startPosition < endPosition ) {
			if (isNthBitSet(input,startPosition)) {
				if(!isNthBitSet(input,endPosition)) {
					System.out.println("Number is not a Palindrome");
					return;
				}
			}
			else {
				if(isNthBitSet(input,endPosition)) {
					System.out.println("Number is not a Palindrome ");
					return;
				}
			}
			startPosition ++;
			endPosition--;
		}
		System.out.println("Number is a Palindrome ");
		return ;
	}	

}