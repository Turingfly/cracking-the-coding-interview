package chapter10SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;;;

/**
 * 
 * Problem: Write a method to sort an array of strings so that all the anagrams
 * are next to each other.
 * 
 */
public class GroupAnagrams {
	/**
	 * Method 1: Sort
	 * 
	 * Time Complexity: O(NlogN)
	 */
	public String[] sort1(String[] strs) {
		Comparator<String> comp = new Comparator<String>() {
			private String sortChars(String s) {
				char[] chars = s.toCharArray();
				Arrays.sort(chars);
				return new String(chars);
			}

			public int compare(String s1, String s2) {
				return sortChars(s1).compareTo(sortChars(s2));
			}
		};
		Arrays.sort(strs, comp);
		return strs;
	}

	/**
	 * Method 2: Use a HashTable which maps from the sorted version of a word to
	 * a list of its anagrams. Then put them back into the array.
	 * 
	 * The idea of bucket sort
	 */
	public String[] sort2(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			String key = sortChars2(str);
			if (!map.containsKey(key)) {
				List<String> list = new ArrayList<>();
				map.put(key, list);
			}
			map.get(key).add(str);
		}
		// put them into the array
		int index = 0;
		for (String key : map.keySet()) {
			List<String> list = map.get(key);
			for (String s : list) {
				strs[index++] = s;
			}
		}
		return strs;
	}

	private String sortChars2(String s) {
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

	public static void main(String[] args) {
		GroupAnagrams g = new GroupAnagrams();
		String[] strs = { "ab", "ba", "aad", "dda", "add", "ada" };
		System.out.println(Arrays.toString(g.sort2(strs)));
	}
}
