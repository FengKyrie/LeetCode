package kyrie_20_2_9.search;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int target = solution.search(new int[] {4,5,6,7,0,1,2},8); 
		System.out.println(target);
	}

	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		if (nums[0] > target && nums[nums.length - 1] < target)
			return -1;
		int loca = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				loca = i;
				break;
			}
		}
		return loca;
	}
}
