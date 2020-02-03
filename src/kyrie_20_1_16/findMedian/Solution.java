package kyrie_20_1_16.findMedian;

public class Solution {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double results = 0.0;
		int m = nums1.length, n = nums2.length;
		int[] sort = new int[m + n];
		if (m == 0) {
			for (int i = 0; i < n; i++)
				sort[i] = nums2[i];
		} else if (n == 0) {
			for (int i = 0; i < m; i++)
				sort[i] = nums1[i];
		} else if (nums1[0] >= nums2[n - 1]) {
			for (int i = 0; i < n; i++)
				sort[i] = nums2[i];
			for (int i = 0; i < m; i++)
				sort[i + n] = nums1[i];
		} else if (nums2[0] >= nums1[m - 1]) {
			for (int i = 0; i < m; i++)
				sort[i] = nums1[i];
			for (int i = 0; i < n; i++)
				sort[i + m] = nums2[i];
		} else
			for (int i = 0, j = 0, k = 0; k < m + n; k++) {
				if (i == m) {
					sort[k] = nums2[j];
					j++;
				} else if (j == n) {
					sort[k] = nums1[i];
					i++;
				} else if (i < m && nums1[i] < nums2[j]) {
					sort[k] = nums1[i];
					i++;
				} else if (j < n && nums1[i] >= nums2[j]) {
					sort[k] = nums2[j];
					j++;
				}
				System.out.print(sort[k]);
			}
		if ((m + n) % 2 != 0)
			results = sort[(m + n) / 2];
		else {
			results = (sort[(m + n) / 2 - 1] + sort[(m + n) / 2]);
			results /= 2;
		}
		return results;
	}

	public static void main(String[] args) {
		double results = new Solution().findMedianSortedArrays(new int[] { 1, 2, 3 }, new int[] { 1,2 });
		System.out.println("\n" + results);
	}

}
