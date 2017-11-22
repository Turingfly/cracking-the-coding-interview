package chapter04TreesAndGraphs;

import java.util.Random;

/**
 * 
 * Problem: You are implementing a binary search tree class from scratch, which,
 * in addition to insert, find, and delete, has a method getRandomNode() which
 * returns a random node from the tree. All nodes should be equally likely to be
 * chosen. Design and implement an algorithm for getRandomNode, and explain how
 * you would implement the rest of the methods.
 * 
 * Time Complexity: O(logN), where N is the number of nodes.
 *
 */
public class RandomNode {
	TreeNode root = null;

	public void insertInOrder(int val) {
		if (root == null) {
			root = new TreeNode(val);
		} else {
			root.insertInOrder(val);
		}
	}

	public int size() {
		return root == null ? 0 : root.getSize();
	}

	public TreeNode getRandomNode() {
		if (root == null) {
			return null;
		}
		Random random = new Random();
		int i = random.nextInt(size());
		return root.getIthNode(i);
	}

	class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;
		private int size = 0;

		public TreeNode(int val) {
			val = this.val;
			size = 1;
		}

		public void insertInOrder(int val) {
			if (this.val <= val) {
				if (left == null) {
					left = new TreeNode(this.val);
				} else {
					left.insertInOrder(this.val);
				}
			} else {
				if (right == null) {
					right = new TreeNode(this.val);
				} else {
					right.insertInOrder(this.val);
				}
			}
			size++;
		}

		public int getSize() {
			return size;
		}

		public TreeNode find(int val) {
			if (this.val == val) {
				return this;
			} else if (this.val <= val) {
				return left != null ? left.find(this.val) : null;
			} else if (this.val > val) {
				return right != null ? right.find(this.val) : null;
			}
			return null;
		}

		public TreeNode getIthNode(int i) {
			int leftSize = left == null ? 0 : left.getSize();
			if (i < leftSize) {
				return left.getIthNode(i);
			} else if (i == leftSize) {
				return this;
			} else {
				return right.getIthNode(i - (leftSize + 1));
			}
		}
	}

}
