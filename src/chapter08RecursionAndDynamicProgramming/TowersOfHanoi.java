package chapter08RecursionAndDynamicProgramming;

import java.util.Stack;

/**
 * 
 * Problem:
 *
 */
public class TowersOfHanoi {
	public static void main(String[] args) {
		int n = 3;
		Tower[] towers = new Tower[n];
		for (int i = 0; i < 3; i++) {
			towers[i] = new Tower(i);
		}
		for (int i = n - 1; i >= 0; i--) {
			towers[0].add(i);
		}
		towers[0].moveDisks(n, towers[2], towers[1]);
	}
}

class Tower {
	private Stack<Integer> disks;
	private int index;

	public Tower(int index) {
		disks = new Stack<>();
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public void add(int d) {
		if (!disks.isEmpty() && disks.peek() <= d) {
			System.out.println("ERROR placing disk" + d);
		} else {
			disks.add(d);
		}
	}

	public void moveToTop(Tower t) {
		int top = disks.pop();
		t.add(top);
	}

	public void moveDisks(int n, Tower destination, Tower buffer) {
		if (n > 0) {
			moveDisks(n - 1, buffer, destination);
			moveToTop(destination);
			buffer.moveDisks(n - 1, destination, this);
		}
	}
}