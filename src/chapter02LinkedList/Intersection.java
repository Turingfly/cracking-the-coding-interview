package chapter02LinkedList;

/**
 * 
 * Problem: 
 * Write a program to find the node at which the intersection of two singly linked lists begins.
For example, the following two linked lists:
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.
Notes:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 * 
 * Algorithm: 
 *
 * Time Complexity: O(A+B)
 *
 * Space Complexity: O(1)
 *
 */
public class Intersection {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int len1 = getLength(headA);
		int len2 = getLength(headB);
		int gap = 0;
		if (len1 > len2) {
			gap = len1 - len2;
			while (gap-- > 0) {
				headA = headA.next;
			}
		} else {
			gap = len2 - len1;
			while (gap-- > 0) {
				headB = headB.next;
			}
		}
		while (headA != headB) {
			if (headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
	}

	public int getLength(ListNode node) {
		int res = 0;
		while (node != null) {
			res++;
			node = node.next;
		}
		return res;
	}
}