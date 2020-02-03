package kyrie_20_1_24.merge_two_lists;

public class Solution {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);

		ListNode finaListNode = new Solution().mergeTwoLists(l1, l2);
		while (finaListNode != null) {
			System.out.print(finaListNode.val + "->");
			finaListNode = finaListNode.next;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode finalList;
		ListNode head;
		if (l1 != null && l2 == null) {
			finalList = new ListNode(l1.val);
			l1 = l1.next;
		} else if (l1 == null && l2 != null) {
			finalList = new ListNode(l2.val);
			l2 = l2.next;
		} else if (l1 == null && l2 == null) {
			return null;
		} else {
			if (l1.val > l2.val) {
				finalList = new ListNode(l2.val);
				l2 = l2.next;
			} else {
				finalList = new ListNode(l1.val);
				l1 = l1.next;
			}
		}
		head = finalList;
		merge(l1, l2, finalList);
		return head;
	}

	public ListNode merge(ListNode l1, ListNode l2, ListNode finalList) {
		if (l1 != null && l2 == null) {
			finalList.next = l1;
			finalList = finalList.next;
			return merge(l1.next, l2, finalList);
		} else if (l1 == null && l2 != null) {
			finalList.next = l2;
			finalList = finalList.next;
			return merge(l1, l2.next, finalList);
		} else if (l1 == null && l2 == null) {
			return finalList;
		} else {
			if (l1.val > l2.val) {
				finalList.next = l2;
				finalList = finalList.next;
				return merge(l1, l2.next, finalList);
			} else {
				finalList.next = l1;
				finalList = finalList.next;
				return merge(l1.next, l2, finalList);
			}
		}
	}
}
