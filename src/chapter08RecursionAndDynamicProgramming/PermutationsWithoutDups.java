package chapter08RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Problem: Write a method to compute all permutations of a string of unique
 * characters
 *
 */
public class PermutationsWithoutDups {

	/**
	 * Method 1: Building from permutation of first n - 1 characters.
	 * 
	 * p(a1, a2, a3) = {(a1, a2, a3), (a1, a3, a2), (a2, a1, a3), (a2, a3, a1),
	 * (a3, a1, a2), (a3, a2, a1)}
	 * 
	 * (a1, a2, a3) -> (a4, a1, a2, a3), (a1, a4, a2, a3) (a1, a2, a4, a3) (a1,
	 * a2, a3, a4)
	 */
	public List<String> getPerms1(String str) {
		if (str == null) {
			return null;
		}
		List<String> permutations = new ArrayList<>();
		// base case
		if (str.length() == 0) {
			permutations.add("");
			return permutations;
		}
		char first = str.charAt(0);
		String remainder = str.substring(1);
		List<String> words = getPerms1(remainder);
		for (String word : words) {
			for (int i = 0; i <= word.length(); i++) {
				String s = insertCharAt1(word, first, i);
				permutations.add(s);
			}
		}
		return permutations;
	}

	private String insertCharAt1(String word, char c, int i) {
		String left = word.substring(0, i);
		String right = word.substring(i);
		return left + c + right;
	}

	/**
	 * Method 2: Building from permutations of all n - 1 character substrings.
	 * 
	 * p(a1, a2, a3) = {a1 + p(a2, a3)} + {a2 + p(a1, a3)} + {a3, p(a1, a2)}
	 */
	public List<String> getPerms2(String remainder) {
		int len = remainder.length();
		List<String> res = new ArrayList<>();
		// base case
		if (len == 0) {
			// be sure to return empty String
			res.add("");
			return res;
		}
		for (int i = 0; i < len; i++) {
			// remove char i and find permutations of remaining chars
			String before = remainder.substring(0, i);
			String after = remainder.substring(i + 1, len);
			List<String> partials = getPerms1(before + after);
			// prepend char i to each permutation
			for (String s : partials) {
				res.add(remainder.charAt(i) + s);
			}
		}
		return res;
	}

	/**
	 * Method 3: Instead of passing the permutations back up the stack, we can
	 * push the prefix down the stack. When we get to the bottom(base case),
	 * prefix holds a full permutation.
	 * 
	 * Time Complexity(N^2 * N!)
	 */
	public List<String> getPerms3(String str) {
		if (str == null) {
			return null;
		}
		List<String> res = new ArrayList<>();
		helper3("", str, res);
		return res;
	}

	private void helper3(String prefix, String remainder, List<String> res) {
		if (remainder.length() == 0) {
			res.add(prefix);
		}
		int len = remainder.length();
		for (int i = 0; i < len; i++) {
			String before = remainder.substring(0, i);
			String after = remainder.substring(i + 1, len);
			char c = remainder.charAt(i);
			helper3(prefix + c, before + after, res);
		}
	}
}
