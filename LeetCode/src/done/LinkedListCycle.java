package done;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class LinkedListCycle {

	// Could keep an array of visited but that would take extra space
	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		// Run the two pointers, one twice as fast as the other
		// If they ever meet, we know the faster one caught up to the slower one
		// through a cycle
		while (fast != null) {
			fast = fast.next;
			if (fast == slow)
				return true;
			if (fast != null)
				fast = fast.next;
			if (fast == slow)
				return true;
			slow = slow.next;
		}
		return false;
	}
}
