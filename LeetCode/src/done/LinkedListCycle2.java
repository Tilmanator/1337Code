package done;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle2 {
	public ListNode detectCycle(ListNode head) {
		Set<ListNode> visited = new HashSet<>();

		// Keep track of all the places we've visited
		while (head != null) {
			visited.add(head);
			head = head.next;
			if (visited.contains(head))
				return head;
		}
		return null;
	}
}
