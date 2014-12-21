package BitHandling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwapNibbles {
	public static byte shuffleBits(Byte byteVal) {
		return  (byte) (((byteVal & 0X0F) << 4 )|((byteVal & 0XF0)>>4));
	}

	public static void main (String args[]) {
		Byte byteVal = 0;
		System.out.println("Enter the Number :");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			byteVal = new Integer(br .readLine()).byteValue();
		} catch(IOException | NumberFormatException e) {
			e.printStackTrace();
			return;		
		}
		System.out.println("New Value is " + shuffleBits(byteVal));
	}
} 