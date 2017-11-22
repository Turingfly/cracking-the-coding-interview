package chapter04TreesAndGraphs;

/**
 * 
 * Problem: Implement a function to check if a binary tree is a binary search
 * tree.
 *
 * Solution: The first leverages the in-order traversal, and the second builds
 * off the property that left <= current < right
 * 
 * Time Complexity: O(N)
 * 
 * Space Complexity: O(H). H is the height of the tree.
 *
 */
public class ValidateBST {
	/**
	 * method 1: Assume that the tree cannot have duplicate values. In-Order
	 * Traversal
	 */
	class WrapInt {
		public int val;

		public WrapInt(int val) {
			this.val = val;
		}
	}

	WrapInt last_printed = null;

	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		// check left
		if (!isValidBST(root.left)) {
			return false;
		}
		// check current
		if ((last_printed != null) && last_printed.val >= root.val) {
			return false;
		}
		last_printed = new WrapInt(root.val);
		// check right
		if (!isValidBST(root.right)) {
			return false;
		}
		return true;
	}

	/**
	 *  method 2: left <= current < right; The Min / Max Solution
	 */
	public boolean isValidBST2(TreeNode root) {
		return check(root, null, null);
	}

	public boolean check(TreeNode root, Integer min, Integer max) {
		if (root == null) {
			return true;
		}
		// When we branch right, min gets updated.
		// When we branch left, max gets updated.
		if ((min != null && root.val <= min) || (max != null && root.val > max)) {
			return false;
		}
		if (!check(root.left, min, root.val) || !check(root.right, root.val, max)) {
			return false;
		}
		return true;
	}

	// method 2.5: left <= current < right; The Min / Max Solution
	class ResultType {
		int max;
		int min;
		boolean is_bst;

		public ResultType(int max, int min, boolean is_bst) {
			this.max = max;
			this.min = min;
			this.is_bst = is_bst;
		}
	}

	public boolean isValidBST25(TreeNode root) {
		ResultType res = helper(root);
		return res.is_bst;
	}

	private ResultType helper(TreeNode root) {
		if (root == null) {
			return new ResultType(Integer.MIN_VALUE, Integer.MAX_VALUE, true);
		}
		ResultType left = helper(root.left);
		ResultType right = helper(root.right);
		if (!left.is_bst || !right.is_bst) {
			return new ResultType(0, 0, false);
		}
		if (root.left != null && left.max > root.val || root.right != null && right.min <= root.val) {
			return new ResultType(0, 0, false);
		}
		return new ResultType(Math.max(root.val, right.max), Math.min(root.val, left.min), true);
	}
}
