package chapter01ArraysAndStrings;

/**
 * 
 * Problem: Implement an algorithm to determine if a string has all unique
 * characters. No extra data structure.
 *
 */

public class IsUnique {
	/**
	 * O(N) O(1)
	 */
	public boolean isUnique1(String s) {
		if (s == null || s.length() > 256) {
			return false;
		}
		boolean[] map = new boolean[256];
		char[] chars = s.toCharArray();
		for (char c : chars) {
			if (map[c]) {
				return false;
			}
			map[c] = true;
		}
		return true;
	}

	/**
	 * Assume the string only uses lowercase letters. Use just a single
	 * int(32bits) to save more space complexity
	 */
	public boolean isUnique2(String s) {
		if (s == null || s.length() > 26) {
			return false;
		}
		int checker = 0;
		char[] chars = s.toCharArray();
		for (char c : chars) {
			int val = c - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}

	public static void main(String[] args) {
		IsUnique iu = new IsUnique();
		String s = "abcb";
		System.out.println(iu.isUnique1(s));
		System.out.println(iu.isUnique2(s));
	}
}
