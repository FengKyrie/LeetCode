package kyrie_20_2_3.next_per;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = new int[] { 1,3,2 };
		new Solution().nextPermutation(nums);
		for (int c : nums)
			System.out.print(c);
	}

	public int findBiger(int[] nums, int i, int target, HashMap<Integer, Integer> map, Stack<Integer> stack) {
		if (i == nums.length)
			return map.get(stack.peek());
		else {
			if (nums[i] > target && nums[i] < map.get(stack.peek())) {
				map.clear();
				stack.push(i);
				map.put(i, nums[i]);
			}
			i++;
			return findBiger(nums, i, target, map, stack);
		}
	}

	public void Resort(int[] nums, int i) {
		int[] temp = new int[nums.length - i];
		for (int j = 0; j < temp.length; j++) {
			temp[j] = nums[i + j];
		}
		Arrays.sort(temp);
		for (int j = 0; j < temp.length; j++) {
			nums[i + j] = temp[j];
		}
	}

	public void nextPermutation(int[] nums) {
		if (nums.length < 2 || nums == null)
			return;
		int len = nums.length;
		for (int i = len - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				int temp = nums[i - 1];
				HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
				map.put(i, nums[i]);
				int lastI = i;
				Stack<Integer> stack = new Stack<Integer>();
				stack.push(i);
				nums[i - 1] = findBiger(nums, i, nums[i - 1], map, stack);
				nums[stack.peek()] = temp;
				System.err.println(nums[i - 1]);
				Resort(nums, i);
				return;
			}
		}
		Arrays.sort(nums);
	}
}
