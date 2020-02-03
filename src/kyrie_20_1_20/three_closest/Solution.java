package kyrie_20_1_20.three_closest;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().threeSumClosest(new int[] { -3, -2, -5, 3, -4 }, -1));
	}

	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length < 3)
			return 0;
		Arrays.sort(nums);
		int ans = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length; i++) {
			int L = i + 1, R = nums.length - 1;
			while (L < R) {
//				if (Math.abs(nums[i] + nums[L] + nums[R] - target) < Math.abs(ans - target)) {
//					ans = nums[i] + nums[L] + nums[R];
//					System.out.println(nums[i] + " " + nums[L] + " " + nums[R] + " Return:" + ans);
//				}
				ans = Math.abs(nums[i] + nums[L] + nums[R] - target) < Math.abs(ans - target)
						? (nums[i] + nums[L] + nums[R])
						: ans;
				if (nums[i] + nums[L] + nums[R] - target > 0)
					R--;
				else if (nums[i] + nums[L] + nums[R] - target < 0)
					L++;
				else if (nums[i] + nums[L] + nums[R] - target == 0) {
					System.err.println("err," + nums[i] + " " + nums[L] + " " + nums[R]);
					return nums[i] + nums[L] + nums[R];
				}
			}
		}
		return ans;
	}
}
