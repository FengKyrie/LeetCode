package kyrie_20_1_17.longest_palinedrome;

public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().longestPalindrome("cabad"));
	}

	public String longestPalindrome(String s) {
		String string = "";
		if (s == null || s.length() < 1) {
			return string;
		}
		char[] charArr;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			sb.append("#");
			sb.append(s.charAt(i));
		}
		sb.append("#");
		charArr = sb.toString().toCharArray();
		System.out.println(charArr);
		int MAX_LENGTH = 0, j, MaxI = 0, MaxJ = 0;
		for (int i = 0; i < charArr.length; i++) {
			int temp_length = 0;
			for (j = 0; i + j <= charArr.length - 1 && i - j >= 0; j++) {
				if (charArr[i - j] == charArr[i + j]) {
					temp_length = 2 * j + 1;
				} else {
					break;
				}
			}
			j--;
			if (MAX_LENGTH <= temp_length) {
				MAX_LENGTH = temp_length;
				MaxI = i;
				MaxJ = j;
			}
		}
		System.out.println(MAX_LENGTH + " " + MaxI + " " + MaxJ);
		StringBuilder tempBuilder = new StringBuilder();
		for (int i = MaxI - MaxJ; i <= MaxI + MaxJ; i++) {
			if (charArr[i] != '#')
				tempBuilder.append(charArr[i]);
		}
		string = tempBuilder.toString();
		return string;
	}
}
