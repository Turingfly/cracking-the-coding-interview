package chapter08RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Problem: Write a method to return all subsets of a set.
 *
 */
public class PowerSet {
	/**
	 * Method 1: DFS
	 */
	public List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		helper(nums, 0, res, cur);
		return res;
	}

	private void helper(int[] nums, int index, List<List<Integer>> res, List<Integer> cur) {
		res.add(new ArrayList<Integer>(cur));
		for (int i = index; i < nums.length; i++) {
			cur.add(nums[i]);
			helper(nums, i + 1, res, cur);
			cur.remove(cur.size() - 1);
		}
	}

	/**
	 * Combinatorics
	 */
	public List<List<Integer>> subsets2(List<Integer> set) {
		List<List<Integer>> res = new ArrayList<>();
		int max = 1 << set.size(); // compute 2^N
		for (int i = 0; i < max; i++) {
			List<Integer> cur = convertIntToSet(set, i);
			res.add(cur);
		}
		return res;
	}

	private List<Integer> convertIntToSet(List<Integer> set, int x) {
		List<Integer> res = new ArrayList<>();
		int index = 0;
		for (int i = x; i > 0; i >>= 1) {
			if ((i & 1) == 1) {
				res.add(set.get(index));
			}
			index++;
		}
		return res;
	}

}
