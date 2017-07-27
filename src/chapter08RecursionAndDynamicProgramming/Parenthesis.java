package chapter08RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Problem:Implement an algorithm to print all valid combinations of n pairs of
 * parentheses.
 *
 */
public class Parenthesis {
	/**
	 * DFS, open and close variable. open < numberOfparis and close < open
	 */
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		helper(res, "", 0, 0, n);
		return res;
	}

	public void helper(List<String> res, String s, int open, int close, int numberOfPairs) {
		if (s.length() == numberOfPairs * 2) {
			res.add(s);
			return;
		}
		if (open < numberOfPairs) {
			helper(res, s + "(", open + 1, close, numberOfPairs);
		}
		if (close < open) {
			helper(res, s + ")", open, close + 1, numberOfPairs);
		}
	}
}
