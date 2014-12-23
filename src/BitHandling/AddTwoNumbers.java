package BitHandling;

public class AddTwoNumbers {
	public static int add(int a, int b) {
		int sum = a;
		int carry =0;
		while(b != 0) {
			carry = sum & b;		 
			sum = sum ^ b;
			b = carry<<1;
		}	
		return sum;
	}

	public static void main (String args[]) {
		System.out.println(add(3,4));
		System.out.println(add(1,4));

	}
}
