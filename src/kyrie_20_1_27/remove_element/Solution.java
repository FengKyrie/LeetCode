package kyrie_20_1_27.remove_element;

public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().removeElement(new int[] { 1, 2, 4, 5, 7, 6 }, 4));
	}

	public int removeElement(int[] nums, int val) {
		int cursor = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[cursor] = nums[i];
				cursor++;
			}
		}
		return cursor;
	}
}
