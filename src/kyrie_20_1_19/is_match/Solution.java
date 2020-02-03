package kyrie_20_1_19.is_match;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().isMatch("fengkanghuiiiiii", "ff*feng*kanghu*i*"));
	}

	public boolean isMatch(String s, String p) {
		// 考虑为空的情况
		if (p.isEmpty())
			return s.isEmpty();
		boolean firstMatch = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
		if (p.length() >= 2 && p.charAt(1) == '*') {
			return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
		} else {
			return firstMatch && isMatch(s.substring(1), p.substring(1));
		}

	}
}
