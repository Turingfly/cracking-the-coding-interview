package chapter02LinkedList;

/**
 * 
 * Problem: Given a linked list and a value x, partition it such that all nodes
 * less than x come before nodes greater than or equal to x. You should preserve
 * the original relative order of the nodes in each of the two partitions.
 * 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 *
 */
public class Partition {
	/**
	 * method 1
	 */
	public ListNode partition(ListNode head, int x) {
		ListNode less = new ListNode(0);
		ListNode greater = new ListNode(0);
		ListNode l1 = less;
		ListNode l2 = greater;
		while (head != null) {
			if (head.val < x) {
				l1.next = head;
				l1 = head;
			} else {
				l2.next = head;
				l2 = head;
			}
			head = head.next;
		}
		// make sure there is no cycle.
		// 3->4->1->2. 4->2 change to 4->null
		l2.next = null;
		l1.next = greater.next;
		return less.next;
	}

	/**
	 * method 2; Do not care about the relative order
	 * 
	 * Elements bigger than the pivot element are put at the tail and elements
	 * smaller are put at the head. Each time we insert an element, we update
	 * wither the head or tail.
	 * 
	 */
	public ListNode partition2(ListNode node, int x) {
		ListNode head = node;
		ListNode tail = node;
		while (node != null) {
			if (node.val < x) {
				node.next = head;
				head = node;
			} else {
				tail.next = node;
				tail = node;
			}
			node = node.next;
		}
		tail.next = null;
		return head;
	}
}