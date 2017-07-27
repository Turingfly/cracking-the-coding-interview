package chapter08RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Problem: Write a method to compute all permutations of a string whose
 * characters are not necessarily unique. The list of permutations should not
 * have duplicates.
 *
 * Solution: HashTable, key: char, value count
 * 
 * p(a - 2| b - 4| c - 1) = {a + p(a - 1| b - 4| c - 1 )} + {b + p(a - 2| b - 3|
 * c - 1 )} + {c + p(a - 2| b - 4| c - 0 )}
 */
public class PermutationsWithDuplicates {
	public List<String> getPerms(String s) {
		List<String> res = new ArrayList<>();
		Map<Character, Integer> map = buildFreqTable(s);
		helper(map, "", s.length(), res);
		return res;
	}

	private Map<Character, Integer> buildFreqTable(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 0);
			}
			map.put(c, map.get(c) + 1);
		}
		return map;
	}

	private void helper(Map<Character, Integer> map, String prefix, int remaining, List<String> res) {
		// base case
		if (remaining == 0) {
			res.add(prefix);
			return;
		}
		for (Character c : map.keySet()) {
			int count = map.get(c);
			if (count > 0) {
				map.put(c, count - 1);
				helper(map, prefix + c, remaining - 1, res);
				map.put(c, count);
			}
		}
	}
}
