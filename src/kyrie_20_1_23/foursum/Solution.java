package kyrie_20_1_23.foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().fourSum(new int[] { 1, -2, -5, -4, -3, 3, 3, 5 }, -11));
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 4)
			return res;
		Arrays.sort(nums);
//		for (int n : nums)
//			System.out.print(n+" ");
		int len = nums.length;
		for (int i = 0; i < len - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1; j < len - 2; j++) {
				if (nums[j] == nums[j - 1] && j > 1 + i)
					continue;
				int L = j + 1, R = len - 1;
				while (L < R) {
					int sum = nums[i] + nums[L] + nums[R] + nums[j];
					if (sum == target) {
						res.add(Arrays.asList(nums[i], nums[L], nums[R], nums[j]));
						while (L < R && nums[L] == nums[L + 1])
							L++; // 去重
						while (L < R && nums[R] == nums[R - 1])
							R--; // 去重
						L++;
						R--;
					} else if (sum < target)
						L++;
					else if (sum > target)
						R--;
				}
			}
		}
		return res;
	}
}
