package chapter10SortingAndSearching;

/**
 * 
 * Problem: Given a sorted array of String that is interspersed with empty
 * strings, write a method to find the location of a given string.
 *
 * Example: Input "ball", {"", "", "", "", "ball", "", "", "car"}, output 4
 * 
 * Time Complexity: O(logN) average, O(N) worst case.
 */
public class SparseSearch {
	public static int searchI(String[] strings, String str) {
		int left = 0;
		int right = strings.length - 1;
		while (left <= right) {
			int mid = (right + left) / 2;
			System.out.println(right + " " + left + " " + mid);
			// If mid is empty, find closest non-empty string
			if (strings[mid].equals("")) {
				int left1 = mid - 1;
				int right1 = mid + 1;
				while (true) {
					if (left1 < left && right1 > right) {
						return -1;
					} else if (right1 <= right && !strings[right1].equals("")) {
						mid = right1;
						break;
					} else if (left1 >= left && !strings[left1].equals("")) {
						mid = left1;
						break;
					}
					right1++;
					left1--;
				}
			}
			int res = strings[mid].compareTo(str);
			if (res == 0) {
				return mid;
			} else if (res < 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		String[] stringList = { "", "", "", "", "ball", "", "", "car" };
		System.out.println(searchI(stringList, "ball"));
	}
}
