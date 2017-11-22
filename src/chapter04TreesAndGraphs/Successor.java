package chapter04TreesAndGraphs;

/**
 * 
 * Problem: Write an algorithm to find the "next" node (i.e., in-order
 * successor) of a given node in a binary search tree. You may assume that each
 * node has a link to its parent.
 *
 */
public class Successor {

	// with parent
	/**
	 * public TreeNode inOrderSuccessor(TreeNode root) { if (root == null) {
	 * return null; } // Found right children -> return leftmost node of right
	 * subtree. if (root.right != null) { return leftMostchild(root.right); }
	 * else { TreeNode q = root; TreeNode x = q.parent; // Go up until we are on
	 * left instead of right while (x != null && x.left != q) { q = x; x =
	 * x.parent; } return x; } }
	 * 
	 * private TreeNode leftMostchild(TreeNode root) { if (root == null) {
	 * return null; } while (root.left != null) { root = root.left; } return
	 * root; }
	 */

	// without parent
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null)
			return null;
		TreeNode next = null;
		TreeNode cur = root;
		while (cur != null && cur.val != p.val) {
			if (cur.val > p.val) {
				next = cur;
				cur = cur.left;
			} else {
				cur = cur.right;
			}
		}
		if (cur == null) {
			return null;
		}
		if (cur.right != null) {
			cur = cur.right;
			while (cur.left != null) {
				cur = cur.left;
			}
			return cur;
		} else {
			return next;
		}
	}
}
