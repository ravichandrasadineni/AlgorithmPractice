package BitHandling;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaRegexExp {
	public static void main(String args[]) {
		String str = "Jon Jonathan Frank Ken Todd";
		Pattern pat = Pattern.compile("Jon\\W*?");
		Matcher mat = pat.matcher(str);
		System.out.println("Original sequence: " + str);
		str = mat.replaceAll("Eric");
		System.out.println(str);
	}
}