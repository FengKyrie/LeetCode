package kyrie_20_1_16.add2numbers;

public class Solution {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		Solution solution = new Solution();
		ListNode re = solution.addTwoNumbers(l1, l2);
		System.out.println(re.val+"->"+re.next.val+"->"+re.next.next.val);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode((l1.val + l2.val) % 10);
		ListNode currentNode = result;
		ListNode currentNode1 = l1;
		ListNode currentNode2 = l2;
		int flag = (currentNode1.val + currentNode2.val) / 10;
		while (true) {
			currentNode1 = currentNode1.next;
			currentNode2 = currentNode2.next;
			if (currentNode1 != null && currentNode2 != null) {
				if ((flag + currentNode1.val + currentNode2.val) / 10 > 0) {
					currentNode.next = new ListNode((flag + currentNode1.val + currentNode2.val) % 10);
					flag = 1;
				} else {
					currentNode.next = new ListNode(flag + currentNode1.val + currentNode2.val);
					flag = 0;
				}
			} else if (currentNode1 == null && currentNode2 != null) {
				if (flag + currentNode2.val >= 10) {
					currentNode.next = new ListNode((flag + currentNode2.val) % 10);
					flag = 1;
				} else {
					currentNode.next = new ListNode(flag + currentNode2.val);
					flag = 0;
				}
			} else if (currentNode1 != null && currentNode2 == null) {
				if (flag + currentNode1.val >= 10) {
					currentNode.next = new ListNode((flag + currentNode1.val) % 10);
					flag = 1;
				} else {
					currentNode.next = new ListNode(flag + currentNode1.val);
					flag = 0;
				}
			} else {
				if (flag == 1) {
					currentNode.next = new ListNode(1);
				}
				break;
			}
			currentNode = currentNode.next;
		}
		return result;
	}
}
