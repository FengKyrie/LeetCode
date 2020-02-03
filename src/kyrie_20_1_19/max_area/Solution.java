package kyrie_20_1_19.max_area;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
	}

	public int maxArea(int[] height) {
		int maxArea = 0;
		// 暴力法
//		for (int i = 0; i < height.length - 1; i++) {
//			for (int j = i + 1; j < height.length; j++) {
//				maxArea = Math.max(Math.min(height[i], height[j]) * Math.abs(j - i), maxArea);
//			}
//		}		
		// 尝试优化,双指针法
		int leftPointer = 0, rightPointer = height.length - 1;
		while (leftPointer < rightPointer) {
			maxArea = Math.max(maxArea,
					(rightPointer - leftPointer) * Math.min(height[rightPointer], height[leftPointer]));
			if (height[leftPointer] < height[rightPointer])
				leftPointer++;
			else
				rightPointer--;
		}
		return maxArea;
	}
}
