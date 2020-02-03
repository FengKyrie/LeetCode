package kyrie_20_2_3.search_insert;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().searchInsert(new int[] {1,4}, -1));
	}

	public int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		int i;
		for (i = 0; i < nums.length && nums[i] <= target; i++) {
			if (nums[i] == target)
				return i;
		}
		return i;
	}
}
