package chapter03StacksAndQueues;

import java.util.EmptyStackException;

/**
 * 
 * Problem: Describe how you could use a single array to implement three stacks.
 *
 */
public class ArrayToStack {
	private static final int NUMBEROFSTACKS = 3;
	private int stackCapacity;
	private int[] vals;
	private int[] sizes;

	public ArrayToStack(int stackCapacity) {
		this.stackCapacity = stackCapacity;
		vals = new int[NUMBEROFSTACKS * stackCapacity];
		sizes = new int[NUMBEROFSTACKS];
	}

	public void push(int stackNum, int num) {
		if (isFull(stackNum)) {
			return;
		}
		sizes[stackNum]++;
		vals[indexOfTop(stackNum)] = num;
	}

	public int pop(int stackNum) {
		if (isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		int topIndex = indexOfTop(stackNum);
		int val = vals[topIndex];
		vals[topIndex] = 0;
		sizes[stackNum]--;
		return val;
	}

	public int peek(int stackNum) {
		if (isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		return vals[indexOfTop(stackNum)];
	}

	public boolean isEmpty(int stackNum) {
		return sizes[stackNum] == 0;
	}

	public boolean isFull(int stackNum) {
		return sizes[stackNum] == stackCapacity;
	}

	private int indexOfTop(int stackNum) {
		int offset = stackNum * stackCapacity;
		int size = sizes[stackNum];
		return offset + size;
	}
}
