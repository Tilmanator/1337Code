package done;

public class RemoveNthNodeFromEnd {
	public static int len(ListNode h) {
		if (h == null)
			return 0;
		return 1 + len(h.next);

	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		int l = len(head);
		int index = l - n;
		if (index == 0 && len(head) == 1)
			return null;
		if (index == 0)
			return head.next;
		int i = 1;
		ListNode temp = head;
		while (i < index) {
			temp = temp.next;
			i++;
		}
		temp.next = temp.next.next;
		return head;
	}
}
