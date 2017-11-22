package chapter01ArraysAndStrings;

/**
 * 
 * Problem: Palindrome Permutation: Given a string, write a function to check if
 * it is a permutation of a palindrome. A palindrome is a word or phrase that is
 * the same forwards and backwards. A permutation is a rearrangement of letters.
 * The palindrome does not need to be limited to just dictionary words.
 * 
 * EXAMPLE Input: tact coa Output: True (permutations: "taco cat'; "atco eta·;
 * etc.)
 *
 */
public class PalindromePermutation {
	public boolean isPerm(String s) {
		if (s == null) {
			return false;
		}
		int countOdd = 0;
		int[] counts = new int[26];
		for (char c : s.toCharArray()) {
			// 'a' to 'z'
			if (c >= 'a' && c <= 'z') {
				counts[c - 'a']++;
				if (counts[c - 'a'] % 2 == 1) {
					countOdd++;
				} else {
					countOdd--;
				}
			}
		}
		return countOdd < 2;
	}

	public static void main(String[] args) {
		PalindromePermutation pp = new PalindromePermutation();
		System.out.println(pp.isPerm("tact coa"));
	}
}
