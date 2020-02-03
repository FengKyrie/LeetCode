package kyrie_20_1_18.my_atoi;

import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) {
		// System.out.println(-160 % 100);
		System.out.println(new Solution().myAtoi("       ++132"));
	}

	public boolean isLegal(char c) {
		return c == '+' || c == '-' || (c >= '0' && c <= '9');
	}

	public boolean isNum(char c) {
		return c >= '0' && c <= '9';
	}

	public int myAtoi(String str) {
		// 如果字符串为null
		if (str == null)
			return 0;
		str = str.trim();
		if (str.length() == 0)
			return 0;
		char[] charArr = str.toCharArray();
		ArrayList<Character> finalChar = new ArrayList<Character>();
		boolean check = true;
		// 如果字符串里全是空格或者首个非空字符不是有效字符
		for (int i = 0; i < charArr.length; i++) {
			// 第一个非空字符无效
			if (!isLegal(charArr[i])) {
				check = false;
				break;
			}
			// 第一个非空字符有效
			else if (isLegal(charArr[i])) {
				finalChar.add(charArr[i]);
				if (i + 1 < charArr.length && !isNum(charArr[i + 1]))
					break;
			}
			// 所有有效的字符
			else if (isNum(charArr[i])) {
				finalChar.add(charArr[i]);
				if (i + 1 < charArr.length && !isNum(charArr[i + 1]))
					break;
			}
		}
		if (!check || (finalChar.size() == 1 && !isNum(finalChar.get(0)))) {
			return 0;
		}
		System.out.println(finalChar.toString());
		// Convert to Numbers
		int ans = 0;
		int size = finalChar.size();
		int flag = 0;
		if (finalChar.get(0) == '+' || finalChar.get(0) == '-') {
			flag = 1;
		}
		for (int i = flag; i < size; i++) {
			if (finalChar.get(0) == '-') {
				if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && (finalChar.get(i) - 48) > 8))
					return Integer.MIN_VALUE;
				ans = ans * 10 - (finalChar.get(i) - 48);
			} else {
				if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && (finalChar.get(i) - 48) > 7))
					return Integer.MAX_VALUE;
				ans = ans * 10 + (finalChar.get(i) - 48);
			}
		}

		return ans;
	}
}
