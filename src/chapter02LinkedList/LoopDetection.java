package chapter02LinkedList;

/**
 * 
 * Problem: Given a linked list, return the node where the cycle begins. If
 * there is no cycle, return null. Note: Do not modify the linked list.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 */
public class LoopDetection {
	public ListNode detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		ListNode meetSlow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		if ((fast != null) && (fast.next != null)) {
			while (meetSlow != slow) {
				meetSlow = meetSlow.next;
				slow = slow.next;
			}
			return slow;
		}
		return null;
	}
}
