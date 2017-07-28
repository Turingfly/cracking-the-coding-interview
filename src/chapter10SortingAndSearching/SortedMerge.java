package chapter10SortingAndSearching;

/**
 * 
 * Problem: You are given two sorted arrays, A and B, where A has a large enough
 * buffer at the end to hold B. Write a method to merge B into A in sorted
 * order.
 *
 * Solution: Shift the existing elements backwards to make room for it.
 *
 */
public class SortedMerge {
	public void merge(int[] nums1, int[] nums2) {
		int index1 = nums1.length - 1;
		int index2 = nums2.length - 1;
		int mergedIndex = index1 + index2 + 1;
		while (index2 >= 0 && index1 >= 0) {
			if (nums1[index1] > nums2[index2]) {
				nums2[mergedIndex] = nums1[index1];
				index1--;
			} else {
				nums2[mergedIndex] = nums1[index2];
				index2--;
			}
			mergedIndex--;
		}
	}
}
