package chapter01ArraysAndStrings;

/**
 * 
 * Problem: Implement a method to perform basic string compression using the
 * counts of repeated characters.
 * 
 * For example, the string aabcccccaaa would become a2blc5a3. If the
 * "compressed" string would not become smaller than the original string, your
 * method should return the original string. You can assume the string has only
 * uppercase and lowercase letters (a - z)
 *
 */
public class StringCompression {
	public String compressBad(String str) {
		StringBuilder compressedString = new StringBuilder();
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;
			/**
			 * If next character is different than current, append this char to
			 * result.
			 */
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressedString.append("" + str.charAt(i) + countConsecutive);

				countConsecutive = 0;
			}
		}
		return compressedString.length() < str.length() ? compressedString.toString() : str;
	}

	public static void main(String[] args) {
		StringCompression sc = new StringCompression();
		System.out.println(sc.compressBad("aabcccccaaa"));
	}
}
