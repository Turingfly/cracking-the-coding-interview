package chapter01ArraysAndStrings;

/**
 * 
 * Problem: Write a method to replace all spaces in a string with '%20 You may
 * assume that the string has sufficient space at the end to hold the additional
 * characters, and that you are given the "true" length of the string. (Note: if
 * implementing in Java, please use a character array so that you can perform
 * this operation in place.) EXAMPLE Input: "Mr John Smith     ", 13 Output:
 * "Mr%20John%20Smith"
 * 
 * Solution: Start from the end and work backwards
 *
 */
public class Urlify {
	public String replaceSpaces(char[] chars, int len) {
		if (chars == null) {
			return "";
		}
		int spaceCount = 0;
		int index = 0;
		// first loop, locate last position
		for (int i = 0; i < len; i++) {
			if (chars[i] == ' ') {
				spaceCount++;
			}
		}
		index = len + spaceCount * 2 - 1;
		// second loop, replace spaces from the end
		for (int i = len - 1; i >= 0; i--) {
			if (chars[i] == ' ') {
				chars[index] = '0';
				chars[index - 1] = '2';
				chars[index - 2] = '%';
				index -= 3;
			} else {
				chars[index] = chars[i];
				index--;
			}
		}
		return new String(chars).trim();
	}

	public static void main(String[] args) {
		Urlify u = new Urlify();
		char[] chars = "Mr John Smith       ".toCharArray();
		System.out.println(u.replaceSpaces(chars, 13));
	}
}
