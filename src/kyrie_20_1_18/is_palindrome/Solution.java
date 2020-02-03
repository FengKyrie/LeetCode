package kyrie_20_1_18.is_palindrome;

public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().isPlindrome(54345));
	}

	public boolean isPlindrome(int x) {
		char[] charArr = String.valueOf(x).toCharArray();
		for (int i = 0; i < charArr.length / 2; i++) {
			if (charArr[i] != charArr[charArr.length - i - 1])
				return false;
		}
		return true;
	}
}
