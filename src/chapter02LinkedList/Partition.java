package chapter02LinkedList;

/**
 * 
 * @author chengfeili
 * Jun 19, 2017 9:38:52 PM
 * 
 * Problem: Given a linked list and a value x, partition it such that all nodes
 * less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 * 
 *
 */
public class Partition {
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
}