package done;

public class RemoveNthNodeFromEndOfList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return null;
		ListNode runner = head;
		for (int i = 0; i < n; ++i) {
			if (runner.next != null)
				runner = runner.next;
			// The nth from last is the head in this case
			else if (i == n - 1)
				return head.next;
		}
		// Move the pointers forward until follow points to the (n-1)th node
		ListNode follow = head;
		while (runner.next != null) {
			follow = follow.next;
			runner = runner.next;
		}
		follow.next = follow.next.next;
		return head;
	}
}
