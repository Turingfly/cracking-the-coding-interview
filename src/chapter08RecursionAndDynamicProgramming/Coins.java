package chapter08RecursionAndDynamicProgramming;

/**
 * 
 * Problem: Given an infinite number of quarters(25 cents), dimes(10 cents),
 * nickels(5 cents), and pennies (1 cent), write code to calculate the number of
 * ways of representing n cents
 */
public class Coins {
	/**
	 * Method 1: Recursively call helper several times for the same values of
	 * amount and index. Duplicates
	 */

	public int makeChange1(int n) {
		int[] denoms = { 25, 10, 5, 1 };
		return helper1(n, denoms, 0);
	}

	public int helper1(int amount, int[] denoms, int index) {
		if (index >= denoms.length - 1) {
			// last denom
			return 1;
		}
		int denomAmount = denoms[index];
		int res = 0;
		for (int i = 0; i * denomAmount <= amount; i++) {
			int amountRemaining = amount - i * denomAmount;
			res += helper1(amountRemaining, denoms, index + 1);
		}
		return res;
	}

	/**
	 * Method 2: Memorization. Store the previously computed values. Store a
	 * mapping from each pair to the precomputed result
	 */
	public int makeChange2(int n) {
		int[] denoms = { 25, 10, 5, 1 };
		int[][] map = new int[n + 1][denoms.length];
		return helper2(n, denoms, 0, map);
	}

	public int helper2(int amount, int[] denoms, int index, int[][] map) {
		if (map[amount][index] > 0) {
			return map[amount][index];
		}
		if (index >= denoms.length - 1) {
			// last denom
			return 1;
		}
		int denomAmount = denoms[index];
		int res = 0;
		for (int i = 0; i * denomAmount <= amount; i++) {
			int amountRemaining = amount - i * denomAmount;
			res += helper1(amountRemaining, denoms, index + 1);
		}
		map[amount][index] = res;
		return res;
	}
}
