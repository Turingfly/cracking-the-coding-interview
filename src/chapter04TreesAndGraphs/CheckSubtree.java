package chapter04TreesAndGraphs;

/**
 * 
 * Problem: T1 and T2 are tow very large binary trees, with T1 much bigger than
 * T2. Create an algorithm to determine if T2 is a subtree of T1.
 * 
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that the
 * subtree of n is identical to T2. That is, if you cut off the tree at node n,
 * the two trees would be identical.
 *
 */
public class CheckSubtree {

	/**
	 * method 1: Assume that there is just a small amount of data.
	 * 
	 * Time Complexity: O(N + M)
	 * 
	 * Space Complexity: O(N + M)
	 */
	public boolean containsTree(TreeNode t1, TreeNode t2) {
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		getOrderString(t1, sb1);
		getOrderString(t2, sb2);
		return sb1.indexOf(sb2.toString()) != -1;
	}

	// pre-order
	private void getOrderString(TreeNode node, StringBuilder sb) {
		if (node == null) {
			sb.append("X");
			return;
		}
		sb.append(node.val + " ");
		getOrderString(node.left, sb);
		getOrderString(node.right, sb);
	}

	/**
	 * method 2: Search through the larger tree.
	 * 
	 * Time Complexity: O(N +kM), where k is the number of occurrences of T2's
	 * root in T1. Worst-case O(MN);
	 * 
	 * Space Complexity: O(log(N) + log(M))
	 */

	public boolean contains2(TreeNode t1, TreeNode t2) {
		if (t2 == null) {
			return true;
		}
		return subtree(t1, t2);
	}

	private boolean subtree(TreeNode t1, TreeNode t2) {
		// big tree empty and subtree still not found
		if (t1 == null) {
			return false;
		} else if (t1.val == t2.val && matchTree(t1, t2)) {
			return true;
		}
		return subtree(t1.left, t2) || subtree(t1.right, t2);
	}

	private boolean matchTree(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return true;
		} else if (t1 == null || t2 == null) {
			return false;
		} else if (t1.val == t2.val) {
			return false;
		} else {
			return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
		}
	}
}
