package kyrie_20_1_27.reverse_list;

public class Solution {

	public static void main(String[] args) {
		ListNode tail = new ListNode(1);
		tail.next = new ListNode(2);
		tail.next.next = new ListNode(3);
		tail.next.next.next = new ListNode(4);
		tail.next.next.next.next = new ListNode(5);
		ListNode head = new Solution().reverseKGroup(tail, 1);
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (k == 1)
			return head;
		int leftNum = 0;
		ListNode curr = head;
		while (curr != null) {
			leftNum++;
			curr = curr.next;
		}
		if (leftNum < k)
			return head;
		curr = head;
		leftNum = k;
		for (; leftNum > 1; leftNum--) {
			curr = curr.next;
		}
		ListNode next = curr;
		ListNode temp = next;
		ListNode memory = head.next;
		head.next = reverseKGroup(next.next, k);
		for (leftNum = k; leftNum > 1; leftNum--) {
			ListNode tail = memory;
			for (int i = leftNum - 2; i > 1; i--) {
				tail = tail.next;
			}
			temp.next = tail;
			temp = temp.next;
		}
		temp.next = head;
		return next;
	}
}
