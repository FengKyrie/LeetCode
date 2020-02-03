package kyrie_20_1_16.longest_substring;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.lengthOfLongestSubstring("abcabcbb123456789"));
	}

	public int lengthOfLongestSubstring(String s) {
		int n = s.length(), ans = 0;
		HashMap<Character, Integer> map = new HashMap<>(); // current index of character
		// try to extend the range [i, j]
		for (int j = 0, i = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return ans;
	}

	public int lengthOfLongestSubstring_version1(String s) {
		char[] original = s.toCharArray();
		int length = 0, sLength = original.length;
		ArrayList<Character> longest = new ArrayList<>();
		for (int j = 0; j < sLength; j++) {
			longest.clear();
			for (int i = j; i < sLength; i++) {
				if (longest.contains(original[i]))
					break;
				else
					longest.add(original[i]);
			}
			if (length < longest.size())
				length = longest.size();
		}
		return length;
	}
}
