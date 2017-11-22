package chapter01ArraysAndStrings;

/**
 * 
 * Problem: One Away: There are three types of edits that can be performed on
 * strings: insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check if they are one edit (or zero
 * edits) away.
 * 
 * Solution:
 *
 */
public class OneAway {
	/**
	 * method1: replace, insert, delete.It is clearer and easier to follow but
	 * has some duplicate code.
	 */
	public boolean oneEditAway(String s1, String s2) {
		if (s1 == null || s2 == null) {
			return false;
		}
		if (s1.length() == s2.length()) {
			return replace(s1, s2);
		} else if (s1.length() + 1 == s2.length()) {
			return insert(s1, s2);
		} else if (s1.length() - 1 == s2.length()) {
			return insert(s2, s1);
		}
		return false;
	}

	private boolean replace(String s1, String s2) {
		boolean foundDiff = false;
		char[] chars1 = s1.toCharArray();
		char[] chars2 = s2.toCharArray();
		for (int i = 0; i < chars1.length; i++) {
			if (chars1[i] != chars2[2]) {
				if (foundDiff) {
					return false;
				}
				foundDiff = true;
			}
		}
		return true;
	}

	private boolean insert(String s1, String s2) {
		int index1 = 0;
		int index2 = 0;
		char[] chars1 = s1.toCharArray();
		char[] chars2 = s2.toCharArray();
		while (index1 < s1.length() && index2 < s2.length()) {
			if (chars1[index1] != chars2[index2]) {
				if (index1 != index2) {
					return false;
				}
				index2++;
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}

	/**
	 *  method2: Handle replace and insert in the same method;
	 */
	public boolean method2(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() - s2.length() == 0) {
			return false;
		}
		String str1 = s1.length() < s2.length() ? s1 : s2;
		String str2 = s1.length() < s2.length() ? s2 : s1;
		assert (str1.length() <= str2.length());
		int index1 = 0;
		int index2 = 0;
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		boolean foundDiff = false;
		while (index1 < s1.length() && index2 < s2.length()) {
			if (chars1[index1] != chars2[index2]) {
				if (foundDiff) {
					return false;
				}
				foundDiff = true;
				if (chars1.length == chars2.length) {
					index1++;
				}
			} else {
				index1++;
			}
			index2++;
		}
		return true;
	}

	public static void main(String[] args) {
		OneAway one = new OneAway();
		System.out.println(one.oneEditAway("ac", "abc"));
		System.out.println(one.method2("ac", "abc"));
	}
}
