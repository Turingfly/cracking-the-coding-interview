package chapter05BitManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Problem: Flip Bit to Win: You have an integer and you can flip exactly one
 * bit from a O to a 1. Write code to find the length of the longest sequence of
 * 1 s you could create.
 * 
 * EXAMPLE Input: 1775 (or: 11011101111) Output: 8
 *
 */

public class FlipBitToWin {

	/**
	 * Method 1: Brute Force
	 * 
	 * Time Complexity: O(b), where b is the length of the sequence
	 * 
	 * Space COmplexity: O(b)
	 */
	public int longestSequence1(int n) {
		if (n == -1) {
			return Integer.BYTES * 8;
		}
		List<Integer> list = getSequence(n);
		return findLongestSequence(list);
	}

	/**
	 * return a list of the size of the sequence. The sequence starts off with
	 * the number of 0s and then alternates with the counts of each value.
	 */
	private List<Integer> getSequence(int num) {
		List<Integer> list = new ArrayList<>();
		int iter = 0;
		int counter = 0;
		for (int i = 0; i < Integer.BYTES * 8; i++) {
			if ((num & 1) != iter) {
				list.add(counter);
				iter = iter == 0 ? 1 : 0; // flip 1 to 0, or 0 to 1
				counter = 0;
			}
			counter++;
			num >>>= 1;
		}
		list.add(counter);
		return list;
	}

	private int findLongestSequence(List<Integer> list) {
		int max = 1;
		for (int i = 0; i < list.size(); i += 2) {
			int zerosSeq = list.get(i);
			int onesSeqRight = i - 1 >= 0 ? list.get(i - 1) : 0;
			int onesSeqLeft = i + 1 < list.size() ? list.get(i + 1) : 0;
			int thisSeq = 0;
			if (zerosSeq == 1) { // can merge
				thisSeq = onesSeqLeft + 1 + onesSeqRight;
			} else if (zerosSeq > 1) { // just ad a zero to either side
				thisSeq = 1 + Math.max(onesSeqLeft, onesSeqRight);
			} else if (zerosSeq == 0) { // no zero, but take either side
				thisSeq = Math.max(onesSeqRight, onesSeqRight);
			}
			max = Math.max(max, thisSeq);
		}
		return max;
	}

	/**
	 * Method 2:
	 * 
	 * Walk through the integer, tracking the current 1s sequence length and the
	 * previous 1s sequence length. When we meet a 0, update previousLength:
	 * 
	 * 1. If the next bit is a 1, priviousLength should be set to current
	 * length;
	 * 
	 * 2. If the next bit is a 0, we cannot merge these sequences together. So,
	 * set previousLength to 0;
	 * 
	 * Time Complexity: O(b)
	 * 
	 * Space Complexity: O(1)
	 * 
	 */
	public int longestSequence2(int num) {
		if (num == -1) {
			return Integer.BYTES;
		}
		int curLength = 0;
		int preLength = 0;
		int max = 1;
		while (num != 0) {
			if ((num & 1) == 1) { // current bit is a 1
				curLength++;
			} else if ((num & 1) == 0) { // current bit is a 0
				preLength = (num & 2) == 0 ? 0 : curLength;
				curLength = 0;
			}
			max = Math.max(max, preLength + 1 + curLength);
			num >>>= 1;
		}
		return max;
	}

	public static void main(String[] args) {
		FlipBitToWin f = new FlipBitToWin();
		System.out.println(f.longestSequence1(1775));
		System.out.println(f.longestSequence2(1775));
	}
}
