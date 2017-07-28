package chapter10SortingAndSearching;

/**
 * 
 * Problem: Suppose an array sorted in ascending order is rotated at some pivot
 * unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 *
 */
public class SearchInRotatedArray {
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int left = 0;
		int right = nums.length - 1;
		int mid = 0;
		while (left + 1 < right) {
			mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			// largest number is on the left
			if (nums[mid] < nums[right]) {
				if (target > nums[mid] && target <= nums[right]) {
					left = mid;
				} else {
					right = mid;
				}
			} else { // largest number is on the right
				if (target < nums[mid] && target >= nums[left]) {
					right = mid;
				} else {
					left = mid;
				}
			}
		}
		return nums[left] == target ? left : nums[right] == target ? right : -1;
	}
}
