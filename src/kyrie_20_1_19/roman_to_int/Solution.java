package kyrie_20_1_19.roman_to_int;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().romanToInt("MCDLXXVI"));
	}

	public int romanToInt(String s) {
		if (s.isEmpty() || s == null)
			return 0;
		char[] charArr = s.toCharArray();
		int ans = 0;
		int bit = 1;
		for (int i = 0; i < charArr.length; i++) {
			char curr = charArr[i];
			char last = ' ';
			char next = ' ';
			if (i != 0)
				last = charArr[i - 1];
			if (curr == 'M' && last != 'C') {
				ans += 1000;
			} else if (curr == 'M' && last == 'C') {
				ans += 800;
			} else if (curr == 'C' && last != 'X') {
				ans += 100;
			} else if (curr == 'C' && last == 'X') {
				ans += 80;
			} else if (curr == 'L' && last != 'X') {
				ans += 50;
			} else if (curr == 'L' && last == 'X') {
				ans += 30;
			} else if (curr == 'D' && last != 'C') {
				ans += 500;
			} else if (curr == 'D' && last == 'C') {
				ans += 300;
			} else if (curr == 'X' && last != 'I') {
				ans += 10;
			} else if (curr == 'X' && last == 'I') {
				ans += 8;
			} else if (curr == 'V' && last != 'I') {
				ans += 5;
			} else if (curr == 'V' && last == 'I') {
				ans += 3;
			} else if (curr == 'I')
				ans++;
		}
		return ans;
	}
}
