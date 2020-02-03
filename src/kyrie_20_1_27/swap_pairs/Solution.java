package kyrie_20_1_27.swap_pairs;

public class Solution {

	public static void main(String[] args) {
		ListNode tail = new ListNode(1);
		tail.next = new ListNode(2);
		tail.next.next = new ListNode(3);
		tail.next.next.next = new ListNode(4);
		ListNode head = new Solution().swapPairs(tail);
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode next = head.next;
		head.next = swapPairs(next.next);
		next.next = head;
		return next;
	}
}
