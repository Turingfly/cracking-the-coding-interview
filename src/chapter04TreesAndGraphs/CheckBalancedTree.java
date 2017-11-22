package chapter04TreesAndGraphs;

/**
 * 
 * Problem: Implement a function to check if a binary tree is balanced. For the
 * purposes of this question, a balanced tree is defined to be a tree such that
 * the heights of the two subtrees of any node never differ by more than one.
 *
 */
public class CheckBalancedTree {
	/**
	 *  method 1: O(NlogN)
	 */
	private int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
			return false;
		} else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}

	/**
	 *  method 2: O(N)
	 */
	class ResultType {
		boolean isBalanced;
		int maxDepth;

		public ResultType(boolean isBalanced, int maxDepth) {
			this.isBalanced = isBalanced;
			this.maxDepth = maxDepth;
		}
	}

	public boolean isBalanced2(TreeNode root) {
		return helper(root).isBalanced;
	}

	private ResultType helper(TreeNode root) {
		if (root == null) {
			return new ResultType(true, 0);
		}
		ResultType left = helper(root.left);
		ResultType right = helper(root.right);
		// subtree is not balanced
		if (!left.isBalanced || !right.isBalanced) {
			return new ResultType(false, -1);
		}
		// root is not balanced
		if (Math.abs(left.maxDepth - right.maxDepth) > 1) {
			return new ResultType(false, -1);
		}
		return new ResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
	}
}
