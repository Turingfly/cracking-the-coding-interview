package chapter03StacksAndQueues;

import java.util.Stack;

/**
 * 
 * Problem: How would you design a stack which, in addition to push and pop, has
 * a function min which returns the minimum element? Push, pop and min should
 * all operate in 0(1) time.
 *
 * Solution: Use an additional stack which keeps track of the mins.
 *
 */
public class MinStack extends Stack<Integer> {
	private Stack<Integer> stack2 = new Stack<>();

	public void push(int val) {
		// must be <=
		if (val <= min()) {
			stack2.push(val);
		}
		super.push(val);
	}

	public Integer pop() {
		int val = super.pop();
		if (val == min()) {
			stack2.pop();
		}
		return val;
	}

	public Integer min() {
		if (stack2.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return stack2.peek();
		}
	}

	public static void main(String[] args) {
		MinStack min = new MinStack();
		min.push(3);
		min.push(4);
		min.push(2);
		System.out.println(min.min());
	}
}
