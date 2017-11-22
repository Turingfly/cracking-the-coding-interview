package chapter01ArraysAndStrings;

/**
 * 
 * Problem: Assume you have a method isSubstring which checks if one word is a
 * substring of another. Given two Strings, check if s2 is a rotation of s1
 * using only one call to isSubstring
 *
 */
public class StringRotation {
	public boolean isRotation(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length() || s1.length() == 0) {
			return false;
		}
		return isSubstring((s1 + s2), s1);
	}

	private boolean isSubstring(String string, String s1) {
		return string.contains(s1);
	}

	public static void main(String[] args) {
		StringRotation sr = new StringRotation();
		System.out.println(sr.isRotation("abcd", "cdab"));
	}
}
