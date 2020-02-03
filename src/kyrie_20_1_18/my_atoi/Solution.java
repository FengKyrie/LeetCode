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
		// ����ַ���Ϊnull
		if (str == null)
			return 0;
		str = str.trim();
		if (str.length() == 0)
			return 0;
		char[] charArr = str.toCharArray();
		ArrayList<Character> finalChar = new ArrayList<Character>();
		boolean check = true;
		// ����ַ�����ȫ�ǿո�����׸��ǿ��ַ�������Ч�ַ�
		for (int i = 0; i < charArr.length; i++) {
			// ��һ���ǿ��ַ���Ч
			if (!isLegal(charArr[i])) {
				check = false;
				break;
			}
			// ��һ���ǿ��ַ���Ч
			else if (isLegal(charArr[i])) {
				finalChar.add(charArr[i]);
				if (i + 1 < charArr.length && !isNum(charArr[i + 1]))
					break;
			}
			// ������Ч���ַ�
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
