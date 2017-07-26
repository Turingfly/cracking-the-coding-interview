package chapter08RecursionAndDynamicProgramming;

/**
 * 
 * Problem: A magic index in an array A[0...n - 1] is defined to be an index
 * such that A[i] = i. Given a sorted array of distinct integers, write a method
 * to find a magic index, if one exits, in array A.
 * 
 * Follow up: what is the value are not distinct?
 *
 */
public class MagicIndex {

	public int magic(int[] array) {
		return magic(array, 0, array.length - 1);
	}

	private int magic(int[] array, int left, int right) {
		if (right < left) {
			return -1;
		}
		int mid = left + (right - left) / 2;
		if (array[mid] == mid) {
			return mid;
		} else if (array[mid] > mid) {
			return magic(array, left, mid - 1);
		} else {
			return magic(array, mid + 1, right);
		}
	}

	// follow up
	public int magic2(int[] array) {
		return magic2(array, 0, array.length - 1);
	}

	private int magic2(int[] array, int left, int right) {
		if (right < left) {
			return -1;
		}
		int mid = left + (right - left) / 2;
		int midVal = array[mid];
		if (midVal == mid) {
			return mid;
		}

		// search left
		int leftIndex = Math.min(mid - 1, midVal);
		int l = magic2(array, left, leftIndex);
		if (l >= 0) {
			return l;
		}

		// search right
		int rightIndex = Math.max(mid + 1, midVal);
		int r = magic2(array, rightIndex, right);
		return r;
	}
}