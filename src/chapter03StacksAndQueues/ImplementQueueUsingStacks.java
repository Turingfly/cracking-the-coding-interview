package chapter03StacksAndQueues;

import java.util.Stack;

/**
 * 
 */
public class ImplementQueueUsingStacks {
	Stack<Integer> input = new Stack<>();
	Stack<Integer> output = new Stack<>();

	public void push(int x) {
		input.push(x);
	}

	public void pop() {
		shift();
		output.pop();
	}

	public int peek() {
		shift();
		return output.peek();
	}

	public boolean empty() {
		return input.isEmpty() && output.isEmpty();
	}

	public void shift() {
		if (output.isEmpty()) {
			while (!input.isEmpty())
				output.push(input.pop());
		}
	}
}
