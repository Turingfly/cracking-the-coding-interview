package chapter04TreesAndGraphs;

/**
 * 
 * Problem: Design an algorithm and write code to find the common ancestor of
 * two nodes in a binary tree. Avoid storing additional nodes in a data
 * structure. Note: this is not necessarily a binary search tree.
 * 
 */
public class FirstCommonAncestor {
	/**
	 * method 1: with links to parent. O(d) time. d is the depth of the
	 * shallower node.
	 */
	public TreeNode1 commonAncestor1(TreeNode1 p, TreeNode1 q) {
		if (p == null || q == null) {
			return null;
		}
		int delta = depth(p) - depth(q);
		TreeNode1 first = delta > 0 ? q : p; // get the shallower node
		return goUpBy(first, delta);
	}

	private TreeNode1 goUpBy(TreeNode1 node, int delta) {
		while (delta > 0 && node != null) {
			delta--;
			node = node.parent;
		}
		return node;
	}

	private int depth(TreeNode1 node) {
		int depth = 0;
		while (node != null) {
			depth++;
			node = node.parent;
		}
		return depth;
	}

	/**
	 * method 2: with links to parent. O(t) time, where t is the size of the
	 * subtree for the first common ancestor.
	 */
	public TreeNode1 commonAncestor2(TreeNode1 root, TreeNode1 p, TreeNode1 q) {
		if (!(covers(root, p) && covers(root, q))) {
			return null;
		} else if (covers(p, q)) {
			return p;
		} else if (covers(q, p)) {
			return q;
		}
		// Traverse upwards until you find a node that covers q;
		TreeNode1 sibling = getSibling(p);
		TreeNode1 parent = p.parent;
		while (!covers(sibling, q)) {
			sibling = getSibling(parent);
			parent = parent.parent;
		}
		return parent;
	}

	private boolean covers(TreeNode1 root, TreeNode1 p) {
		if (root == null) {
			return false;
		}
		if (root == p) {
			return true;
		}
		return covers(root.left, p) || covers(root.right, p);
	}

	private TreeNode1 getSibling(TreeNode1 node) {
		if (node == null || node.parent == null) {
			return null;
		}
		TreeNode1 parent = node.parent;
		return parent.left == node ? parent.right : parent.left;
	}

	/**
	 * method 3 without links to parent. p and q must be the descendants of root
	 */
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

class TreeNode1 {
	int val;
	TreeNode1 left;
	TreeNode1 right;
	TreeNode1 parent;

	public TreeNode1(int val) {
		this.val = val;
	}
}