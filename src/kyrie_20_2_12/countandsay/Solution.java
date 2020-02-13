package kyrie_20_2_12.countandsay;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(5 + "" + '2');
		String str = new Solution().countAndSay(1);
		System.out.println(str);
	}

	public String countAndSay(int n) {
		if (n <= 0)
			return "";
		return iterate(n, "1");
	}

	public String iterate(int n, String res) {
		System.err.println(res);
		if (n == 1) {
			return res;
		} else {
			StringBuilder sb = new StringBuilder();
			if (res.length() == 0 || res == null)
				return "";
			char[] charArr = res.toCharArray();
			int num = 1;
			char c = charArr[0];
			for (int i = 0; i < charArr.length - 1; i++) {
				c = charArr[i];
				if (c == charArr[i + 1]) {
					num++;
				} else {
					sb.append(num + "" + c);
					num = 1;
				}
			}
			if (c == charArr[charArr.length - 1]) {
				sb.append(num + "" + c);
			} else {
				sb.append(1 + "" + charArr[charArr.length - 1]);
			}
			return iterate(n - 1, sb.toString());
		}
	}
}
