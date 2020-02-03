package kyrie_20_2_3.search;

public class Solution {

	public static void main(String[] args) {
		int[] n = new Solution().searchRange(new int[] { 1 }, 0);
		for (int i : n)
			System.out.print(i + " ");
	}

	public int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return new int[] { -1, -1 };
		int left = 0, right = nums.length - 1;
		boolean flag = false;
		if (nums.length == 1 && nums[0] != target)
			return new int[] { -1, -1 };
		if (nums.length == 1 && nums[0] == target)
			return new int[] { 0, 0 };
		while (left < right) {
			if (nums[left] < target)
				left++;
			if (nums[right] > target)
				right--;
			if (nums[left] == nums[right] && nums[left] == target) {
				flag = true;
				break;
			}
		}
		if (flag)
			return new int[] { left, right };
		else
			return new int[] { -1, -1 };
	}
}
