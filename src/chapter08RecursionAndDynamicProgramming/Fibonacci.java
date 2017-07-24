package chapter08RecursionAndDynamicProgramming;

/**
 * 
 * Problem: Compute the Nth Fibonacci number.
 *
 */
public class Fibonacci {
	/**
	 * Method 1: Recursive
	 * 
	 * Time Complexity: O(2N), where N is the number of nodes.
	 */
	public int fibonacci1(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		return fibonacci1(n - 1) + fibonacci1(n - 2);
	}

	/**
	 * Method 2: Top-Down Dynamic Programming (or Memorization)
	 * 
	 * Time Complexity: O(N)
	 */
	public int fibonacci2(int n) {
		return helper(n, new int[n + 1]);
	}

	private int helper(int n, int[] memo) {
		if (n == 0 || n == 1) {
			return n;
		}
		if (memo[n] == 0) {
			memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
		}
		return memo[n];
	}

	/**
	 * Method 3: Bottom-Up Dynamic Programming
	 */
	public int fibonacci3(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int[] memo = new int[n];
		memo[0] = 0;
		memo[1] = 1;
		for (int i = 2; i < n; i++) {
			memo[i] = memo[i - 1] + memo[i - 2];
		}
		return memo[n - 1] + memo[n - 2];
	}

	/**
	 * Method 4: Optimize Method3
	 */
	public int fibonacci4(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int a = 0;
		int b = 1;
		for (int i = 2; i < n; i++) {
			int c = a + b;
			a = b;
			b = c;
		}
		return a + b;
	}
}
