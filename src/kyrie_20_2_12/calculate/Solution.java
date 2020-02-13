package kyrie_20_2_12.calculate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Solution().combinationSum(new int[] { 4, 2, 1 }, 2);
	}

	public ArrayList<ArrayList<Integer>> findNext(ArrayList<Integer> list, int i, int target) {
		int[] w = new int[list.size() - i];
		w[0] = 1;
		int total = w[0] * list.get(i);
		for (int j = 1; j < w.length; j++) {
			w[j] = 0;
		}
		
		return null;
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates == null || candidates.length == 0)
			return null;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		// Preprocessing
		ArrayList<Integer> newInt = new ArrayList<Integer>();
		for (int i = 0; candidates[i] <= target; i++) {
			newInt.add(candidates[i]);
		}
		int len = newInt.size();
		System.out.println(len);
		if (len == 0)
			return null;
		// Processing
		for (int i = 0; i < len; i++) {
			// For each number ,consider the current number and the numbers behind.
			ArrayList<Integer> tempList = new ArrayList<Integer>();
			if (newInt.get(i) == target) {
				tempList.add(target);
				res.add(tempList);
			} else {
				if (target % newInt.get(i) == 0) {
					for (int z = 0; z < target / newInt.get(i); z++) {
						tempList.add(newInt.get(i));
					}
					res.add(tempList);
				} else {
					if ((i != len - 1 && newInt.get(i + 1) + newInt.get(i) > target)
							|| (i == len - 1 && target % newInt.get(i) != 0)) {
						break;
					}
					ArrayList<ArrayList<Integer>> list = findNext(newInt, i, target);
					if (list != null)
						for (ArrayList<Integer> c : list)
							res.add(c);
				}
			}
		}
		return res;
	}
}
