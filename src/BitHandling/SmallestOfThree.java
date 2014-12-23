package BitHandling;
public class SmallestOfThree {
	public static int smallestofThree(int a, int b, int c) {
		int small = 0;
		while ((a!=0)&&(b !=0) && (c != 0 )) {
			a --; b --; c--;
			small ++; 
		}
		return small;
	}


	public static int smallOfTwo(int a, int b) {
		return a + ((b-a)& ((b-a) >> (Integer.SIZE -1)));
	}

	public static int method2(int a , int b, int c ) {
		return smallOfTwo(a,smallOfTwo(b,c));
	}

	public static void main (String args[]) {
		System.out.println("Small of two is " + smallestofThree(13,4,5));
		System.out.println("Small of two is " +  method2(13,4,5));



	}

}
