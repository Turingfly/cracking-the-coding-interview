package chapter02LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Problem: Write code to remove duplicates from an unsorted linked list. 1 -> 2
 * -> 1 ===> 1 -> 2
 *
 */
public class RemoveDuplicates {
	/**
	 * method 1: with temporary buffer.
	 */
	public ListNode deleteDups(ListNode node) {
		if (node == null) {
			return null;
		}
		ListNode head = node;
		Set<Integer> set = new HashSet<>();
		while (node.next != null) {
			if (set.contains(node.next.val)) {
				node.next = node.next.next;
			} else {
				set.add(node.val);
				node = node.next;
			}
		}
		return head;
	}

	/**
	 * method 2: without temporary buffer. two pointers. time O(N2), space O(1)
	 */
	public ListNode deleteDups2(ListNode node) {
		ListNode head = node;
		while (node != null) {
			ListNode runner = node;
			while (runner.next != null) {
				if (runner.next.val == node.val) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			node = node.next;
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(1);
		n1.next = n2;
		n2.next = n3;
		RemoveDuplicates rmd = new RemoveDuplicates();
		ListNode node = rmd.deleteDups(n1);
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}
}
