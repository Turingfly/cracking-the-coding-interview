package chapter04TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Problem: Given a binary tree, design an algorithm which creates a linked list
 * of all the nodes at each depth (e.g., if you have a tree with depth D, you'll
 * have D linked lists).
 *
 */
public class ListOfDepths {
	/**
	 * method 1: DFS A simple modification of pre-order traversal;
	 * 
	 * Time: O(N); Extra Space: O(logN)
	 */
	public List<LinkedList<TreeNode>> create(TreeNode root) {
		List<LinkedList<TreeNode>> res = new ArrayList<>();
		helper(res, root, 0);
		return res;
	}

	private void helper(List<LinkedList<TreeNode>> res, TreeNode node, int level) {
		// base case
		if (node == null) {
			return;
		}
		LinkedList<TreeNode> list = null;
		if (res.size() == level) {
			list = new LinkedList<>();
			res.add(list);
		} else {
			list = res.get(level);
		}
		list.add(node);
		helper(res, node.left, level + 1);
		helper(res, node.right, level + 1);
	}

	/**
	 * method 2: BFS
	 * 
	 * Time: O(N), Extra Space: O(1)
	 * 
	 */
	public List<LinkedList<TreeNode>> create2(TreeNode root) {
		List<LinkedList<TreeNode>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		LinkedList<TreeNode> cur = new LinkedList<>();
		cur.add(root);
		while (cur.size() > 0) {
			res.add(cur);
			// go to the next level
			LinkedList<TreeNode> parents = cur;
			cur = new LinkedList<>();
			for (TreeNode parent : parents) {
				if (parent.left != null) {
					cur.add(parent.left);
				}
				if (parent.right != null) {
					cur.add(parent.right);
				}
			}
		}
		return res;
	}
}
