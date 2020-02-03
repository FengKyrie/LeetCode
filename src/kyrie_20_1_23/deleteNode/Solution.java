package kyrie_20_1_23.deleteNode;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode listNode = new ListNode(1);
		listNode.next = new ListNode(2);
		listNode.next.next = new ListNode(3);
		listNode.next.next.next = new ListNode(4);
		listNode.next.next.next.next = new ListNode(5);
		System.out.println(new Solution().removeNthFromEnd(listNode, 2).val);
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return null;
		ListNode curr = head;
		ListNode L = head, R = head.next;
		int flag = 0;
		while (curr != null) {
			if (flag > n)
				L = L.next;
			if (flag >= n)
				R = R.next;
			flag++;
			curr = curr.next;
		}
		if (L.next == R)
			return R;
		else {
			L.next = R;
			return head;
		}
	}
}
