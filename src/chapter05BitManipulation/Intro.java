package chapter05BitManipulation;

/**
 * 
 * Bit Facts and Tricks
 * x ^ 0s = x       x & 0s = 0		x | 0s = x
 * x ^ 1s = ~x		x & 1s = x		x | 1s = 1s
 * x ^ x = 0		x & x = x 		x | x = x
 * 
 * The binary representation of -K as a N-bit number is concat(1, 2(N-1) -k).
 * 7: 0111;  -1: 1111
 * 
 */
public class Intro {
	// arithmetic right shift; x =-93242, count = 40; return -1
	public int repeatedArithmeticShift(int x, int count) {
		for (int i = 0; i < count; i++) {
			x >>= 1;
		}
		return x;
	}

	// logic right shift; x =-93242, count = 40; return 0
	public int repeatedLogicalShift(int x, int count) {
		for (int i = 0; i < count; i++) {
			x >>>= 1;
		}
		return x;
	}

	public int getBit(int num, int i) {
		return ((num & (1 << i)) != 0) ? 1 : 0;
	}

	public int setBit(int num, int i) {
		return num | (1 << i);
	}

	public int clearBit(int num, int i) {
		int mask = ~(1 << i);
		return num & mask;
	}

	// clear all bits from the most significant bit through i(inclusive)
	public int clearBitsMSBthroughI(int num, int i) {
		int mask = (1 << i) - 1;
		return num & mask;
	}

	// clear all bits from i through 0 (inclusive)
	public int clearBitsIthrough0(int num, int i) {
		int mask = (-1 << (i + 1));
		return num & mask;
	}

	public int updateBit(int num, int i, boolean bitIs1) {
		int val = bitIs1 ? 1 : 0;
		int mask = ~(1 << i);
		return (num & mask) | (val << i);
	}
	
	// n == 0 | n is a power of 2
	public boolean powerOfTwo(int n) {
		return (n & (n - 1)) == 0;
	}
}
