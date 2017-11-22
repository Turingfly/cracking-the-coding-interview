package chapter05BitManipulation;

/**
 * 
 * Problem: You are given two 32-bit numbers, N and M, and two bit positions, i
 * and j. Write a method to insert M into N such that M starts at bit j and ends
 * at bit i. You can assume that the bits j through i have enough space to fit
 * all of M. That is, if M = 10011, you can assume that there are at least 5
 * bits between j and i. You would not, for example, have j = 3 and i = 2,
 * because M could not fully fit between bit 3 and bit 2.
 * 
 * EXAMPLE
 * 
 * Input: N = 10000000000, M = 10011, i = 2, j = 6
 * 
 * Output: N = 10001001100
 *
 * Solution:
 * 
 * 1. Clear that bits j through i in n
 * 
 * 2. Shift m so that it lines up with bits j through i
 * 
 * 3. Merge m and n
 *
 */
public class Insertion {
	public int updateBits(int n, int m, int i, int j) {
		// will equal sequence of all 1s
		int allOnes = ~0;
		int left = allOnes << (j + 1);
		int right = (1 << i) - 1;
		int mask = left | right;
		n = n & mask;
		m = m << i;
		return n | m;
	}
}
