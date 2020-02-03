package kyrie_20_1_24.merge_k_lists;

public class Solution {

	public static void main(String[] args) {

	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		if (lists.length == 1)
			return lists[0];
		if (lists.length == 2)
			return mergeTwoLists(lists[0], lists[1]);
		int mid = lists.length / 2;
		ListNode[] l1 = new ListNode[mid];
		for (int i = 0; i < mid; i++) {
			l1[i] = lists[i];
		}

		ListNode[] l2 = new ListNode[lists.length - mid];
		for (int i = mid, j = 0; i < lists.length; i++, j++) {
			l2[j] = lists[i];
		}

		return mergeTwoLists(mergeKLists(l1), mergeKLists(l2));
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
