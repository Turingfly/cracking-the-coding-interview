package chapter02LinkedList;

/**
 * Problem: Implement an algorithm to find the kth to last element of a singly
 * linked list. 1 -> 2 -> 3 3th to last node is 1
 * 
 */
class Index {
	public int value = 0;
}

public class ReturnKthToLast {

	/**
	 * method 1: recursion; Space O(N)
	 */
	public int printKthToLast(ListNode head, int k) {
		if (head == null) {
			return 0;
		}
		int index = printKthToLast(head.next, k) + 1;
		if (index == k) {
			System.out.println(k + "th to last node is " + head.val);
		}
		return index;
	}

	/**
	 * method 2: Wrapper class, recursion; Space O(N)
	 */
	public ListNode kthToLast(ListNode head, int k) {
		Index idx = new Index();
		return helper(head, k, idx);
	}

	private ListNode helper(ListNode head, int k, Index idx) {
		if (head == null) {
			return null;
		}
		ListNode node = helper(head.next, k, idx);
		idx.value = idx.value + 1;
		if (idx.value == k) {
			return head;
		}
		return node;
	}

	/**
	 * mehtod 3: iteration Time: O(N), Space O(1)
	 */
	public ListNode kthToLast3(ListNode node, int k) {
		ListNode left = node;
		ListNode right = node;
		for (int i = 0; i < k; i++) {
			if (right == null) {
				return null;
			}
			System.out.println("==" + right.val);
			right = right.next;
		}
		while (right != null) {
			right = right.next;
			left = left.next;
		}
		return left;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		ReturnKthToLast rmd = new ReturnKthToLast();
		// rmd.printKthToLast(n1, 3);
		System.out.println(rmd.kthToLast3(n1, 1).val);
	}
}
