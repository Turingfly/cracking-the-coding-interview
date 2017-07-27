package chapter08RecursionAndDynamicProgramming;

import java.util.HashMap;

/**
 * 
 * Problem: Given a boolean expression consisting of the symbols 0 (false),
 * 1(true),
 *
 */
public class BooleanEvaluation {

	/**
	 * Method 1: Brute force
	 */
	public static int count = 0;

	public static boolean stringToBool(String c) {
		return c.equals("1") ? true : false;
	}

	public static int countEval1(String s, boolean result) {
		count++;
		if (s.length() == 0) {
			return 0;
		}
		if (s.length() == 1) {
			return stringToBool(s) == result ? 1 : 0;
		}
		int ways = 0;
		for (int i = 1; i < s.length(); i += 2) {
			char c = s.charAt(i);
			String left = s.substring(0, i);
			String right = s.substring(i + 1, s.length());
			int leftTrue = countEval1(left, true);
			int leftFalse = countEval1(left, false);
			int rightTrue = countEval1(right, true);
			int rightFalse = countEval1(right, false);
			int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);
			int totalTrue = 0;
			if (c == '^') { // required: one true and one false
				totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
			} else if (c == '&') { // required: both true
				totalTrue = leftTrue * rightTrue;
			} else if (c == '|') { // required: anything but both false
				totalTrue = leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse;
			}
			int subWays = result ? totalTrue : total - totalTrue;
			ways += subWays;
		}
		return ways;
	}

	/**
	 * Method 2: Memorization
	 */
	public static int countEval2(String s, boolean result) {
		return countEval2(s, result, new HashMap<String, Integer>());
	}

	public static int countEval2(String s, boolean result, HashMap<String, Integer> memo) {
		count++;
		if (s.length() == 0) {
			return 0;
		}
		if (s.length() == 1) {
			return stringToBool(s) == result ? 1 : 0;
		}
		if (memo.containsKey(result + s)) {
			return memo.get(result + s);
		}
		int ways = 0;
		for (int i = 1; i < s.length(); i += 2) {
			char c = s.charAt(i);
			String left = s.substring(0, i);
			String right = s.substring(i + 1, s.length());
			int leftTrue = countEval2(left, true, memo);
			int leftFalse = countEval2(left, false, memo);
			int rightTrue = countEval2(right, true, memo);
			int rightFalse = countEval2(right, false, memo);
			int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);
			int totalTrue = 0;
			if (c == '^') {
				totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
			} else if (c == '&') {
				totalTrue = leftTrue * rightTrue;
			} else if (c == '|') {
				totalTrue = leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse;
			}
			int subWays = result ? totalTrue : total - totalTrue;
			ways += subWays;
		}
		memo.put(result + s, ways);
		return ways;
	}
}
