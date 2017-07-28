package chapter10SortingAndSearching;

/**
 * 
 * Problem: You are given an array-like data structure Listy which lacks a size
 * method. It does however, have an elementAt(i) method that returns the element
 * at index i in O(1) time. If i is beyond the bounds of the data structure, it
 * return -1 (for this reason, the data structure only supports positive
 * integers).Given a Listy which contains sorted, positive integers, find the
 * index at which an element x occurs. If x occurs multiple times, you may
 * return any index.
 * 
 * Time Complexity: O(logN), find the length in O(logN), sort the length in
 * O(logN)
 *
 */
public class SortedSearchNoSize {
	public static int search(Listy list, int val) {
		int index = 1;
		while (list.elementAt(index) != -1 && list.elementAt(index) < val) {
			index *= 2;
		}
		return binarySearch(list, val, index / 2, index);

	}

	public static int binarySearch(Listy list, int val, int left, int right) {
		int mid = 0;
		while (left + 1 < right) {
			mid = left + (right - left) / 2;
			if (list.elementAt(mid) == val) {
				return mid;
			} else if (list.elementAt(mid) > val) {
				// go left
				right = mid;
			} else {
				// go right
				left = mid;
			}
		}
		return list.elementAt(left) == val ? left : list.elementAt(right) == val ? right : -1;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 10, 15 };
		Listy list = new Listy(array);
		System.out.println(search(list, 2));
	}
}

class Listy {
	int[] array;

	public Listy(int[] arr) {
		array = arr.clone();
	}

	public int elementAt(int index) {
		if (index >= array.length) {
			return -1;
		}
		return array[index];
	}
}