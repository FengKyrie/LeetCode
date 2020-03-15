package kyrie_20_2_17;

import java.util.HashMap;

public class Jump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Jump().jump(new int[] { 2, 3, 1}));
	}

	public int jump(int[] nums) {
		int jumps = 0;
		if (nums.length == 2)
			return 1;
		if (nums.length == 1)
			return 0;
		int current = nums.length - 1;
		while (current != 0) {
			int tempC = current - 1;
			for (int i = tempC; i >= 0; i--) {
				if (nums[i] >= current - i) {
					if (tempC > i) {
						tempC = i;
					}
				}
			}
			jumps++;
			current = tempC;
		}
		return jumps;
	}
}
