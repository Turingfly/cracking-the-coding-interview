package chapter05BitManipulation;

/**
 * 
 * Problem: Write a program to swap odd and even bits in an integer with as few
 * instructions as possible
 *
 *oxaa: 10101010
 *ox55: 01010101
 */
public class PairwiseSwap {
	public int swap(int num) {
		return (((num & 0xaaaaaaaa)) >>> 1) | ((num & 0x55555555) << 1);
	}
}
