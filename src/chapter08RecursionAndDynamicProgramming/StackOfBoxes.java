package chapter08RecursionAndDynamicProgramming;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * Problem: You have a stack of n boxes, with width Wi, height Hi, and depth Di.
 * The boxes cannot be rotated and can only be stacked on top of one another if
 * each each box in the stack is strictly larger than the box above it in width,
 * height, and depth. Implement a method to compute the height of the tallest
 * possible stack. The height of a stack is the sum of the heights of each box.
 *
 */
public class StackOfBoxes {

	/**
	 * Method 1:
	 * 
	 */
	public int createStack1(List<Box> boxes) {
		Comparator<Box> byHeight = new Comparator<Box>() {
			@Override
			public int compare(Box a, Box b) {
				return b.height - a.height;
			}
		};
		Collections.sort(boxes, byHeight);
		int max = 0;
		for (int i = 0; i < boxes.size(); i++) {
			int height = createStack1(boxes, i);
			max = Math.max(max, height);
		}
		return max;
	}

	public int createStack1(List<Box> boxes, int bottomIndex) {
		Box bottom = boxes.get(bottomIndex);
		int max = 0;
		for (int i = bottomIndex + 1; i < boxes.size(); i++) {
			if (boxes.get(i).canBeAbove(bottom)) {
				int height = createStack1(boxes, i);
				max = Math.max(height, max);
			}
		}
		max += bottom.height;
		return max;
	}

	/**
	 * Method 2: Cache results using memorization
	 */

	public static int createStack2(List<Box> boxes) {
		Comparator<Box> byHeight = new Comparator<Box>() {
			@Override
			public int compare(Box a, Box b) {
				return b.height - a.height;
			}
		};
		Collections.sort(boxes, byHeight);
		int max = 0;
		int[] stackMap = new int[boxes.size()];
		for (int i = 0; i < boxes.size(); i++) {
			int height = createStack2(boxes, i, stackMap);
			max = Math.max(max, height);
		}
		return max;
	}

	public static int createStack2(List<Box> boxes, int bottomIndex, int[] stackMap) {
		if (bottomIndex < boxes.size() && stackMap[bottomIndex] > 0) {
			return stackMap[bottomIndex];
		}
		Box bottom = boxes.get(bottomIndex);
		int max = 0;
		for (int i = bottomIndex + 1; i < boxes.size(); i++) {
			if (boxes.get(i).canBeAbove(bottom)) {
				int height = createStack2(boxes, i, stackMap);
				max = Math.max(height, max);
			}
		}
		max += bottom.height;
		stackMap[bottomIndex] = max;
		return max;
	}

	/**
	 * 
	 * Method 3: Think about the recursive algorithm as making a choice, at each
	 * step, whether to put a particular box in the stack.
	 */
	public static int createStack3(List<Box> boxes) {
		Comparator<Box> byHeight = new Comparator<Box>() {
			@Override
			public int compare(Box a, Box b) {
				return b.height - a.height;
			}
		};
		Collections.sort(boxes, byHeight);
		int[] stackMap = new int[boxes.size()];
		return createStack3(boxes, null, 0, stackMap);
	}

	public static int createStack3(List<Box> boxes, Box bottom, int offset, int[] stackMap) {
		if (offset >= boxes.size()) {
			return 0;
		}

		/* height with this bottom */
		Box newBottom = boxes.get(offset);
		int heightWithBottom = 0;
		if (bottom == null || newBottom.canBeAbove(bottom)) {
			if (stackMap[offset] == 0) {
				stackMap[offset] = createStack3(boxes, newBottom, offset + 1, stackMap);
				stackMap[offset] += newBottom.height;
			}
			heightWithBottom = stackMap[offset];
		}

		/* without this bottom */
		int heightWithoutBottom = createStack3(boxes, bottom, offset + 1, stackMap);

		return Math.max(heightWithBottom, heightWithoutBottom);
	}
}

class Box {
	public int width;
	public int height;
	public int depth;

	public Box(int w, int h, int d) {
		width = w;
		height = h;
		depth = d;
	}

	public boolean canBeUnder(Box b) {
		if (width > b.width && height > b.height && depth > b.depth) {
			return true;
		}
		return false;
	}

	public boolean canBeAbove(Box b) {
		if (b == null) {
			return true;
		}
		if (width < b.width && height < b.height && depth < b.depth) {
			return true;
		}
		return false;
	}

	public String toString() {
		return "Box(" + width + "," + height + "," + depth + ")";
	}
}
