package BitHandling;

public class BinaryMul{
	public static void makeEqualLength(StringBuffer num1, StringBuffer num2 ) {
		if(num1.length() == num2.length()) {
			return;
		}
		StringBuffer changeNumber  = num1;
		int changeNumberLength = Math.abs(num1.length()-num2.length());
		if(num1.length() > num2.length()) {
			changeNumber = num2;
		}
		for(int i =0; i < changeNumberLength; i++) {
			changeNumber.insert(0,"0");
		}
	}
	
	public static String add(String num1, String num2) {
		StringBuffer result = new StringBuffer();
		int carry =0;
		StringBuffer num1Buf = new StringBuffer(num1);
		StringBuffer num2Buf = new StringBuffer(num2);
		makeEqualLength(num1Buf,num2Buf);
		for(int i=num1Buf.length()-1; i>= 0;i--) {
			int num1iBit = Integer.valueOf((num1Buf.substring(i,i+1)));
			int num2iBit = Integer.valueOf(num2Buf.substring(i,i+1));
			int resultBit = num1iBit + num2iBit + carry;
			if(resultBit  == 2) {
				carry = 1;
				result.insert(0,'0');
			}
			if(resultBit  == 3) {
				carry = 1;
				result.insert(0,'1');
			}
			if(resultBit  == 1) {
				carry = 0;
				result.insert(0,'1');
			}
			if(resultBit  == 0) {
				carry = 0;
				result.insert(0,'0');
			}
		}	
		if(carry == 1) {
			result.insert(0,'1');
		}
		return result.toString();

	}

	public static int multiplySingleBits(String num1, String num2) {
		return Integer.parseInt(num1)*Integer.parseInt(num2);
	}

	public static int multiply(String num1, String num2) {
		StringBuffer num1Buf = new StringBuffer(num1);
		StringBuffer num2Buf = new StringBuffer(num2);
		makeEqualLength(num1Buf,num2Buf);	
		if((num1Buf.length() ==0)) {
			return 0;
		}
		if(num1Buf.length() == 1) {
			return multiplySingleBits(num1Buf.toString(), num2Buf.toString());
		}
		int leftLength = num1Buf.length()/2;
		int rightLength = num1Buf.length() - leftLength;
		String num1Left = num1Buf.substring(0,leftLength);
		String num1Right = num1Buf.substring(leftLength,num1Buf.length());
		String num2Left = num2Buf.substring(0,leftLength);
		String num2Right = num2Buf.substring(leftLength,num2Buf.length());
		int p1 = multiply(num1Left, num2Left);
		int p2 = multiply(num1Right, num2Right);
		int p3 = multiply(add(num1Left,num1Right), add(num2Left,num2Right));
		return p1*(1<<(2*rightLength)) + (p3-p2-p1)*(1<<rightLength) + p2;
	}
	public static void main(String args[]) {
		System.out.println (multiply("1100", "1010"));
		System.out.println  ( multiply("110", "1010"));
		System.out.println  (multiply("11", "1010"));
		System.out.println  (multiply("1", "1010"));
		System.out.println  (multiply("0", "1010"));
		System.out.println  (multiply("111", "111"));
		System.out.println  (multiply("11", "11"));

	}





}
