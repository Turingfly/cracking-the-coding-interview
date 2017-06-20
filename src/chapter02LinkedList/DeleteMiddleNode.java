package chapter02LinkedList;

/**
 * 
 * @author chengfeili 
 * Jun 19, 2017 9:33:21 PM
 * 
 *         Problem: Implement an algorithm to delete a node in the middle (i.e.,
 *         any node but the first and last node, not necessarily the exact
 *         middle) of a singly linked list, given only access to that node.
 *         
 *         EXAMPLE lnput:the node c from the linked list a->b->c->d->e->f
 *         Result: nothing is returned, but the new linked list looks like
 *         a->b->d->e->f
 *
 *         Solution:
 *
 */
public class DeleteMiddleNode {
	public boolean deleteNode(ListNode node) {
		if (node == null || node.next == null) {
			return false;
		}
		ListNode nextNode = node.next;
		node.val = nextNode.val;
		node.next = nextNode.next;
		return true;
	}
}
