package FacebookHackerCup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class AccountFraudFinder {




	public static void main(String args[]) throws Exception {
		File inf = new File("/home/ravichandrasadineni/Downloads/Input.txt");
		File outf = new File("/home/ravichandrasadineni/Downloads/output.txt");
		BufferedReader br = new BufferedReader(new FileReader(inf));
		BufferedWriter bw = new BufferedWriter(new FileWriter(outf));
		int numOfLines = Integer.parseInt(br.readLine());
		int currentNum=1;
		while(numOfLines > 0) {
			long currentNumber = Long.parseLong(br.readLine());
			long min = getCurrentMin(currentNumber);
			long max = getCurrentMax(currentNumber);
			bw.write("Case #" + currentNum + ": " + min + " " + max + "\n");
			numOfLines--;
			currentNum++;
		}
		bw.close();
		br.close();
	}
	public static long getCurrentMin(long num) {
		long[] arr = new long[10];
		String strNum = String.valueOf(num);
		int currentPos = 0;
		StringBuffer outputString = null;
		boolean isSwapped = false;
		long inputCopy = num;
		while(inputCopy  != 0) {
			arr[(int)(inputCopy%10)] ++;
			inputCopy = inputCopy/10;
		}
		while((currentPos < strNum.length()) && (!isSwapped)) {
			int currentInt = Integer.parseInt(strNum.substring(currentPos,currentPos+1));
			for(int i = 1; i < currentInt; i++) {
				if (arr[i] !=0) {
					int lastIndex =  strNum.substring(currentPos).lastIndexOf(String.valueOf(i));
					if(lastIndex  == -1)
						continue;
					lastIndex += currentPos;
					outputString = new StringBuffer(strNum);
					outputString.replace(lastIndex, lastIndex+1, strNum.substring(currentPos,currentPos+1));
					outputString.replace(currentPos,currentPos+1,strNum.substring(lastIndex,lastIndex+1));
					isSwapped = true;
					break;
				}
			}
			currentPos++;

		}
		if(!isSwapped) {
			return num;
		}
		return Long.valueOf(outputString.toString());
	}
	
	
	public static long getCurrentMax(long num) {
		long[] arr = new long[10];
		String strNum = String.valueOf(num);
		int currentPos = 0;
		StringBuffer outputString = null;
		boolean isSwapped = false;
		long inputCopy = num;
		while(inputCopy  != 0) {
			arr[(int)(inputCopy%10)] ++;
			inputCopy = inputCopy/10;
		}
		while((currentPos < strNum.length()) && (!isSwapped)) {
			int currentInt = Integer.parseInt(strNum.substring(currentPos,currentPos+1));
			for(int i = 9; i > currentInt; i--) {
				if (arr[i] !=0) {
					int lastIndex =  strNum.substring(currentPos).lastIndexOf(String.valueOf(i));
					if(lastIndex  == -1)
						continue;
					lastIndex +=  currentPos;
					outputString = new StringBuffer(strNum);
					outputString.replace(lastIndex, lastIndex+1, strNum.substring(currentPos,currentPos+1));
					outputString.replace(currentPos,currentPos+1,strNum.substring(lastIndex,lastIndex+1));
					isSwapped = true;
					break;
				}
			}
			currentPos++;
		}
		if(!isSwapped) {
			return num;
		}
		return Long.valueOf(outputString.toString());
	}
}