package chapter04TreesAndGraphs;

/**
 * 
 * Problem: Given a sorted (increasing order) array with unique integer
 * elements, write an algorithm to create a binary search tree with minimal
 * height.
 * 
 * Solution:
 * 
 * 1. Insert into the tree the middle element of the array
 * 
 * 2. Insert (into the left subtree) the left sub-array element
 * 
 * 3. Insert (into the right subtree) the right sub-array element
 * 
 * 4. Recurse
 *
 */
public class MinimalTree {
	public TreeNode create(int[] array) {
		if (array == null || array.length == 0) {
			return null;
		}
		return helper(array, 0, array.length - 1);
	}

	private TreeNode helper(int[] array, int start, int end) {
		if (end < start) {
			return null;
		}
		int mid = start + (end - start) / 2;
		TreeNode node = new TreeNode(array[mid]);
		node.left = helper(array, start, mid - 1);
		node.right = helper(array, mid + 1, end);
		return node;
	}
}
