package kyrie_20_2_16;

import java.util.ArrayList;

public class Trap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Trap().trap(new int[] { 0,1,0,2,1,0,1,3,2,1,2,1 }));
	}

	public int trap(int[] height) {
		int res = 0;
		if (height == null || height.length < 2)
			return res;
		int maxNum = 0, left = -1;
		for (int i = 0; i < height.length; i++) {
			maxNum = Math.max(maxNum, height[i]);
		}
		for (int i = 0; i < maxNum; i++) {
			boolean isStart = false;
			int isPure = 0;
			for (int j = 0; j < height.length; j++) {
				// 找出有空的区间 然后将区间首尾-1
				if (!isStart && height[j] != 0) {
					left = j;
					isStart = true;
				} else if (isStart && height[j] != 0) {
					// 疑似可能，继续判断
					for (int m = left + 1; m < j; m++) {
						if (height[m] != 0) {
							isPure--;
						} else if (height[m] == 0) {
							isPure++;
						}
					}
					if (isPure == j - left - 1 && j - left != 1) {
						res += j - left - 1;
						if (j != height.length - 1 && height[j + 1] == 0)
							j--;
					} else {
						j--;
					}
					isPure = 0;
					isStart = false;
				}
			}
			for (int j = 0; j < height.length; j++) {
				if (height[j] != 0)
					height[j]--;
			}
			System.out.println(res);
		}
		return res;
	}
}
