package chapter10SortingAndSearching;

import java.util.Arrays;

/**
 * 
 * Problem:Merge Sort, stable
 * 
 * Time Complexity: O(NlogN) average and worst.
 * 
 * Space Complexity: O(N)
 *
 */
public class MergeSort {
	public int[] mergeSort(int[] nums) {
		int[] helper = new int[nums.length];
		mergeSort(nums, helper, 0, nums.length - 1);
		return nums;
	}

	private void mergeSort(int[] nums, int[] helper, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(nums, helper, low, mid);
			mergeSort(nums, helper, mid + 1, high);
			merge(nums, helper, low, mid, high);
		}
	}

	private void merge(int[] nums, int[] helper, int low, int mid, int high) {
		for (int i = low; i <= high; i++) {
			helper[i] = nums[i];
		}
		int helperLeft = low;
		int helperRight = mid + 1;
		int cur = low;
		// iterate through helper array. Compare the left and right half,
		// copying back the smaller element from the two halves into the
		// original array.
		while (helperLeft <= mid && helperRight <= high) {
			if (helper[helperLeft] <= helper[helperRight]) {
				nums[cur] = helper[helperLeft];
				helperLeft++;
			} else {
				nums[cur] = helper[helperRight];
				helperRight++;
			}
			cur++;
		}
		// copy the rest of the left side of the array into the target array.
		// The right side doesn't need to be copied because it's already there.
		int remaining = mid - helperLeft;
		for (int i = 0; i <= remaining; i++) {
			nums[cur + i] = helper[helperLeft + i];
		}
	}

	public static void main(String[] args) {
		MergeSort m = new MergeSort();
		int[] nums = { 1, 2, 3, 5, 2, 4, 6, 7 };
		System.out.println(Arrays.toString(m.mergeSort(nums)));
	}
}
