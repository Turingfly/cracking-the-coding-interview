package chapter01ArraysAndStrings;

/**
 * 
 * Problem: Given two strings, write a method to decide if one is a permutation
 * of other.
 *
 * Solution: clarify case sensitive and whitespace
 *
 */
public class CheckPermutation {
	/**
	 * method1: sort then compare.
	 */

	/**
	 * method2: Check if two strings have identical character counts
	 */
	public boolean perm(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length()) {
			return false;
		}
		int[] counts = new int[256];
		for (char c : s1.toCharArray()) {
			counts[c]++;
		}
		for (char c : s2.toCharArray()) {
			if (--counts[c] < 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		CheckPermutation cp = new CheckPermutation();
		String s1 = "aa";
		String s2 = "ab";
		System.out.println(cp.perm(s1, s2));
	}
}
