package chapter05BitManipulation;

/**
 * 
 * Problem: Write a function to determine the number of bits you would need to
 * flip to convert integer A to integer B
 * 
 * Example: Input 29(11101), 15(01111), Output: 2
 *
 */
public class Conversion {

	// shift c repeatedly while checking the least significant bit
	public int count1(int a, int b) {
		int count = 0;
		int res = a ^ b;
		while (res != 0) {
			count += res & 1;
			res >>>= 1;
		}
		return count;
	}

	// flip the least significant bit
	public int count2(int a, int b) {
		int count = 0;
		int res = a ^ b;
		while (res != 0) {
			count += res & 1;
			// clear the least significant in res 101000 & 100111 = 10000
			res = res & (res - 1);
		}
		return count;
	}
}
