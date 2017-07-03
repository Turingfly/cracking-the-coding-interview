package chapter04TreesAndGraphs;

/**
 * 
 * @author chengfeili 
 * Jul 2, 2017 10:31:22 PM
 * 
 *         Problem: Design an algorithm and write code to find the common
 *         ancestor of two nodes in a binary tree. Avoid storing additional
 *         nodes in a data structure. Note: this is not necessarily a binary
 *         search tree.
 * 
 *         Solution:
 *
 */
public class FirstCommonAncestor {
	public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		TreeNode left = commonAncestor(root.left, p, q);
		TreeNode right = commonAncestor(root.right, p, q);
		if (left != null && right != null) {
			return root;
		}
		if (left == null && right != null) {
			return right;
		}
		if (left != null && right == null) {
			return left;
		}
		return null;
	}
}
