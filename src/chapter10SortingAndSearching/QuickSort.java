package chapter10SortingAndSearching;

import java.util.Arrays;

/**
 * 
 * Problem:Quick Sort, not stable
 * 
 * Time Complexity: O(NlogN) for average, O(N^2) for worst case.
 * 
 * Space Complexity: O(logN)
 *
 */
public class QuickSort {
	public int[] quickSort(int[] nums, int left, int right) {
		int index = partition(nums, left, right);
		if (left < index - 1) {
			// sort left
			quickSort(nums, left, index - 1);
		}
		if (index < right) {
			// sort right
			quickSort(nums, index, right);
		}
		return nums;
	}

	private int partition(int[] nums, int left, int right) {
		int pivot = nums[(left + right) / 2];
		while (left <= right) {
			// find element on left that should be on right
			while (nums[left] < pivot) {
				left++;
			}
			// find element on right that should be on left
			while (nums[right] > pivot) {
				right--;
			}
			// swap elements, and move left and right indices
			if (left <= right) {
				swap(nums, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		QuickSort q = new QuickSort();
		int[] nums = { 3, 2, 1, 12, 4, 5, 3 };
		System.out.println(Arrays.toString(q.quickSort(nums, 0, nums.length - 1)));
	}
}
