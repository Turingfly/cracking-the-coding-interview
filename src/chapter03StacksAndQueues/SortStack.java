package chapter03StacksAndQueues;

import java.util.Stack;

/**
 * Problem: Write a program to sort a stack such that the smallest items are on
 * the top. You can use an additional temporary stack, but you may not copy the
 * elements into any other data structure (such as an array). The stack supports
 * the following operations: push, pop, peek, and isEmpty.
 *
 * Solution:
 * 
 * Time Complexity: O(N2)
 * 
 * Space Complexity: O(N)
 *
 */
public class SortStack {
	public void sort(Stack<Integer> stack1) {
		Stack<Integer> stack2 = new Stack<>();
		while (!stack1.isEmpty()) {
			int tmp = stack1.pop();
			while (!stack2.isEmpty() && stack2.peek() > tmp) {
				stack1.push(stack2.pop());
			}
			stack2.push(tmp);
		}
		// move back to stack1
		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
	}
}
