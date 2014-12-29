package Strings;

public class GrammerCheck {

	/*
	 * A simple sentence if syntactically correct if it fulfills given rules. The following are given rules.

	1. Sentence must start with a Uppercase character (e.g. Noun/ I/ We/ He etc.)
	2. Then lowercase character follows.
	3. There must be spaces between words.
	4. Then the sentence must end with a full stop(.) after a word.
	5. Two continuous spaces are not allowed.
	6. Two continuous upper case characters are not allowed.
	7. However the sentence can end after an upper case character
	 */

	public static void main(String args[]) {
		String pattern = "[A-Z][a-z]*(\\s[A-Z]?[a-z]*)*[\\w]\\.$";
		String text = "GeeksQuiz. is a quiz site.";
		System.out.println(text.matches(pattern));


	}

}
	