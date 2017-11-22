package chapter02LinkedList;

import java.util.Stack;

/**
 * 
 * Problem: Given a singly linked list, determine if it is a palindrome.
 * 
 * Follow up: Could you do it in O(n) time and O(1) space?
 * 
 */
public class Palindrome {
	/**
	 * method 1: O(1) Space. The original LinkedList is changed
	 */
	public boolean isPalindrome1(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// odd number nodes, ignore the middle node
		if (fast != null) {
			slow = slow.next;
		}
		// reverse the second part
		ListNode headSecondPart = reverseList(slow);
		while (headSecondPart != null) {
			if (head.val != headSecondPart.val) {
				return false;
			}
			head = head.next;
			headSecondPart = headSecondPart.next;
		}
		return true;
	}

	// reverse LinkedList
	public ListNode reverseList(ListNode head) {
		ListNode newHead = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}

	/**
	 * method 2: Stack, keep original LinkedList
	 */
	public boolean isPalindrome2(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		Stack<Integer> stack = new Stack<>();
		while (fast != null && fast.next != null) {
			stack.push(slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}
		// odd number nodes, ignore the middle node
		if (fast != null) {
			slow = slow.next;
		}
		while (slow != null) {
			int top = stack.pop().intValue();
			if (top != slow.val) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
}