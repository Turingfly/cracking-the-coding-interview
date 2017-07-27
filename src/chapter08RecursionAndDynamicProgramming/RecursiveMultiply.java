package chapter08RecursionAndDynamicProgramming;

/**
 * 
 * Problem: Write a recursive function to multiply two positive integers without
 * using the * operator(or / operator). You can use addition, subtraction, and
 * bit shifting, but you should minimize the number of those operations.
 *
 */
public class RecursiveMultiply {

	/**
	 * Method 1: Duplicate work
	 */
	public int minProduct1(int a, int b) {
		int bigger = a < b ? b : a;
		int smaller = a < b ? a : b;
		return helper1(smaller, bigger);
	}

	private int helper1(int smaller, int bigger) {
		if (smaller == 0) {
			return 0;
		} else if (smaller == 1) {
			return bigger;
		}
		// compute half, if uneven, compute other half. if even, double it.
		int s = smaller >> 1;
		int side1 = helper1(s, bigger);
		int side2 = side1;
		if (smaller % 2 == 1) {
			side2 = helper1(smaller - s, bigger);
		}
		return side1 + side2;
	}

	/**
	 * Method 2: use memorization to cache the results.
	 */
	public int minProduct2(int a, int b) {
		int bigger = a < b ? b : a;
		int smaller = a < b ? a : b;
		int memo[] = new int[smaller + 1];
		return helper2(smaller, bigger, memo);
	}

	private int helper2(int smaller, int bigger, int[] memo) {
		if (smaller == 0) {
			return 0;
		} else if (smaller == 1) {
			return bigger;
		} else if (memo[smaller] > 0) {
			return memo[smaller];
		}
		// compute half, if uneven, compute other half. if even, double it.
		int s = smaller >> 1;
		int side1 = helper1(s, bigger);
		int side2 = side1;
		if (smaller % 2 == 1) {
			side2 = helper2(smaller - s, bigger, memo);
		}
		memo[smaller] = side1 + side2;
		return memo[smaller];
	}

	/**
	 * Method 3:minProd(31, 35) = 2 * minProd(15, 35) + 35
	 * 
	 * The function just recurses straight downwards. It will never repeat the
	 * same call, so there's no need to cache any information.
	 * 
	 * Time Complexity: O(logs), where s is the smaller of the tow numbers.
	 */
	public int minProduct3(int a, int b) {
		int bigger = a < b ? b : a;
		int smaller = a < b ? a : b;
		return helper3(smaller, bigger);
	}

	private int helper3(int smaller, int bigger) {
		if (smaller == 0) {
			return 0;
		} else if (smaller == 1) {
			return bigger;
		}
		int s = smaller >> 1;
		int halfProd = helper3(s, bigger);
		if (smaller % 2 == 0) {
			return halfProd + halfProd;
		} else {
			return halfProd + halfProd + bigger;
		}
	}
}
