package chapter05BitManipulation;

/**
 * Problem: Given a positive integer, print the next smallest and the previous
 * largest number that have the same number of 1 bits in their binary
 * representation.
 * 
 */

public class NextNumber {
	/**
	 * 1. flip rightmost non-tailing zero, position p
	 * 
	 * 2. clear bits to the right of p.
	 * 
	 * 3. add in (c1 - 1) ones
	 * 
	 * return the smallest number bigger than n with the same number ones.
	 */
	public int getNext(int num) {
		int c = num;
		// c0 is the number of zeros to the right of p
		// c1 is the number of ones to the right of p
		int c0 = 0;
		int c1 = 0;
		while ((c & 1) == 0 && c != 0) {
			c0++;
			c >>>= 1;
		}
		while ((c & 1) == 1) {
			c1++;
			c >>>= 1;
		}
		// 1100000. there is no bigger number with the same number of 1s
		if (c0 + c1 == 31 || c0 + c1 == 0) {
			return -1;
		}
		// rightmost non-trailing zero
		int p = c0 + c1;
		// 1. flip
		num |= (1 << p);
		// 2. clear bits to the right p
		int a = 1 << p;
		int b = a - 1;
		int mask = ~b;
		num = num & mask;
		// 3. add in (c1 - 1) ones
		a = 1 << (c1 - 1);
		b = a - 1;
		num |= b;
		return num;
	}

	/**
	 * 1. Initial Number
	 * 
	 * 2. clear bits to the right of p.
	 * 
	 * 3. insert c1 + 1 ones immediately to the right of the position of p
	 * 
	 * return the smallest number bigger than n with the same number ones.
	 * 
	 */
	public int getPrev(int num) {
		int c = num;
		// c0 is the number of zeros to the right of p
		// c1 is the number of ones to the right of p
		int c0 = 0;
		int c1 = 0;
		while ((c & 1) == 1) {
			c1++;
			c >>>= 1;
		}
		// 111111
		if (c == 0) {
			return -1;
		}
		while ((c & 1) == 0 && (c != 0)) {
			c0++;
			c >>>= 1;
		}
		// rightmost non-trailing one
		int p = c0 + c1;
		// clear bits to the right of p
		// 2. clear bits to the right p
		int a = 1 << p;
		int b = a - 1;
		int mask = ~b;
		num = num & mask;
		// 3. insert c1 + 1 ones immediately to the right of the position of p
		int mask2 = (1 << (c1 + 1)) - 1;
		num |= mask2 << (c0 - 1);
		return num;
	}
}
