package chapter04TreesAndGraphs;

import java.util.HashMap;

/**
 * 
 * Problem: You are given a binary tree in which each node contains an integer
 * value (which might be positive or negative). Design an algorithm to count the
 * number of paths that sum to a given value. The path does not need to start or
 * end at the root or a leaf, but it must go downwards (traveling only from
 * parent nodes to child nodes).
 *
 */

public class PathsWithSum {

	/**
	 * Method 1: Brute force Traverse to each node. At each node, try all
	 * downwards, tracking the sum. Increase once hit the target sum.
	 * 
	 * Time Complexity: O(NlogN) in a balanced tree. O(N2) in an unbalanced
	 * tree. Node at depth d will be touched by d nodes above it.
	 */
	public int countPathsWithSum(TreeNode root, int target) {
		if (root == null) {
			return 0;
		}
		// count paths with sum starting from the root
		int pathsFromRoot = countPathsWithSumFromNode(root, target, 0);
		int pathsOnLeft = countPathsWithSum(root.left, target);
		int pathsOnRight = countPathsWithSum(root.right, target);
		return pathsFromRoot + pathsOnLeft + pathsOnRight;
	}

	// returns the number of paths with this sum starting from this node
	private int countPathsWithSumFromNode(TreeNode root, int target, int curSum) {
		int totalPaths = 0;
		if (root == null) {
			return totalPaths;
		}
		curSum += root.val;
		if (curSum == target) {
			totalPaths++;
		}
		totalPaths += countPathsWithSumFromNode(root.left, target, curSum);
		totalPaths += countPathsWithSumFromNode(root.right, target, curSum);
		return totalPaths;
	}

	/**
	 * Method 2: Traverse through the tree using DFS. As we visit each node:
	 * 
	 * 1. Track its runningSum.We'll take this in as a parameter and immediately
	 * increment it by node.val;
	 * 
	 * 2. Look up runningSum - targetSum in the hash table. The value there
	 * indicates the total number. Set totalPaths to this value;
	 * 
	 * 3. If runningSum == targetSum in the hash table, then there's one
	 * additional path that starts at the root. Increment totalPaths.
	 * 
	 * 4. Update runningSum to the hash table.
	 * 
	 * 5. Recurse left and right, counting the number of paths with sum
	 * targetSum.
	 * 
	 * 6. After we're done recurring left and right, decrement the value of
	 * runningSum in the hash table. This is essentially backing out of our
	 * work; it reverses the changes to the hash table so that other nodes don't
	 * use it.
	 * 
	 * Time Complexity: O(N), where N is the number of nodes in the tree. We
	 * travel to each node just once, doing O(1) operation each time.
	 * 
	 * Space Complexity: O(logN) in a balanced tree. O(N) in an unbalanced tree.
	 */
	public int countPathsWithSum2(TreeNode root, int targetSum) {
		return countPathsWithSum2(root, targetSum, 0, new HashMap<Integer, Integer>());
	}

	private int countPathsWithSum2(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> map) {
		if (node == null) {
			return 0;
		}
		runningSum += node.val;
		int sum = runningSum - targetSum;
		int totalPaths = map.getOrDefault(sum, 0);
		if (runningSum == targetSum) {
			totalPaths++;
		}
		incrementHash(map, runningSum, 1);
		totalPaths += countPathsWithSum2(node.left, targetSum, runningSum, map);
		totalPaths += countPathsWithSum2(node.right, targetSum, runningSum, map);
		incrementHash(map, runningSum, -1);
		return totalPaths;
	}

	private void incrementHash(HashMap<Integer, Integer> map, int key, int delta) {
		int newCount = map.getOrDefault(key, 0) + delta;
		if (newCount == 0) {
			// remove when zero to reduce space usage
			map.remove(key);
		} else {
			map.put(key, newCount);
		}
	}
}
