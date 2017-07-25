package chapter08RecursionAndDynamicProgramming;

import java.util.Arrays;

/**
 * 
 * Problem: A child is running up a staircase with n steps and can hop either 1
 * step, 2 steps, or 3 steps at a time. Implement a method to count how many
 * possible ways the child can run up the stairs.
 *
 */
public class TripleSteps {
	/**
	 * Method 1: Brute Force Recursion
	 * 
	 * Time Complexity: O(3N)
	 */
	public int countWays1(int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			return countWays1(n - 1) + countWays1(n - 2) + countWays1(n - 3);
		}
	}

	/**
	 * Method 1: Brute Force Recursion. Number of ways will quickly overflow the
	 * bounds of an integer. n = 37; Time Complexity: O(N)
	 */
	public int countWays2(int n) {
		int[] memo = new int[n + 1];
		Arrays.fill(memo, -1);
		return countWays2(n, memo);
	}

	private int countWays2(int n, int[] memo) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (memo[n] > -1) {
			return memo[n];
		} else {
			memo[n] = countWays2(n - 1, memo) + countWays2(n - 2, memo) + countWays2(n - 3, memo);
			return memo[n];
		}
	}
}
