package kyrie_20_1_27.remove_duplicates;

public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().removeDuplicates(new int[] { 1, 1, 2 }));
	}

	public int removeDuplicates(int[] nums) {
		int cursor = 1;
		if (nums.length == 0 || nums == null) {
			return 0;
		}
		if (nums.length == 1)
			return 1;
		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];
			if (nums[i - 1] != num) {
				nums[cursor] = num;
				cursor++;
			}
		}
		return cursor;
	}
}
