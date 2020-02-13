package Kyrie_20_2_13;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstMissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstMissingPositive sFirstMissingPositive = new FirstMissingPositive();
		int i = sFirstMissingPositive.firstMissingPositive(new int[] {1});
		System.out.println(i);
	}

	public int firstMissingPositive(int[] nums) {
		if (nums == null || nums.length == 0)
			return 1;
		Arrays.sort(nums);
		// Remove the same elements...
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int c : nums) {
			if (!temp.contains(c))
				temp.add(c);
		}
		int[] final_ = new int[temp.size()];
		for (int i = 0; i < temp.size(); i++)
			final_[i] = temp.get(i);
		// Processing...
		int j = 1;
		for (int i = 0; i < final_.length; i++) {
			if (final_[i] >= 1) {
				if (final_[i] != j)
					return j;
				else {
					j++;
				}
			}
		}
		return j;
	}
}
