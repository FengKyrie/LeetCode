package kyrie_20_1_28.divide;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().divide(Integer.MAX_VALUE, 2073749999));
//		Solution so = new Solution();
//		so.Debug(Integer.toBinaryString(5554));
	}

	public void Debug(String a) {
		System.out.println(a.toString());
	}

	public int divide(int dividend, int divisor) {
		String a = "", b = "";
		StringBuilder c = new StringBuilder();
		StringBuilder ansStr = new StringBuilder();
		int ansFlag = 0, ans = 0;
		if (divisor == Integer.MIN_VALUE && dividend != divisor)
			return 0;
		if (divisor == Integer.MIN_VALUE && dividend == divisor)
			return 1;
		if (dividend == Integer.MIN_VALUE && divisor < -1073741824)
			return 1;
		if (dividend == Integer.MIN_VALUE && divisor > 1073741824)
			return -1;
		if (dividend < 0) {
			a = Integer.toBinaryString(Math.abs(dividend));
			ansFlag++;
		}
		if (divisor < 0) {
			b = Integer.toBinaryString(Math.abs(divisor));
			ansFlag++;
		}
		if (dividend >= 0) {
			a = Integer.toBinaryString(dividend);
		}
		if (divisor >= 0) {
			b = Integer.toBinaryString(divisor);
		}
		// Debug(a + "||" + b);
		try {
			for (int i = 0; i < a.length(); i++) {
				c.append(a.charAt(i));
				if (Integer.parseInt(c.toString(), 2) - Integer.parseInt(b, 2) < 0) {
					Debug("<0...." + c.toString());
					ansStr.append("0");
					continue;
				} else if (Integer.parseInt(c.toString(), 2) - Integer.parseInt(b, 2) > 0) {
					Debug(">0...." + c.toString());
					ansStr.append("1");
					String temp = c.toString();
					c.delete(0, c.length());
					c.append(Integer.toBinaryString(Integer.parseInt(temp, 2) - Integer.parseInt(b, 2)));
				} else {
					Debug("=0...." + c.toString());
					ansStr.append("1");
					c.delete(0, c.length());
				}
			}
			// Debug(ansStr.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return Integer.MAX_VALUE;
		}
		if (ansStr.toString().equals("10000000000000000000000000000000") && (ansFlag == 2 || ansFlag == 0))
			return Integer.MAX_VALUE;
		if (ansStr.toString().equals("10000000000000000000000000000000") && ansFlag == 1)
			return Integer.MIN_VALUE;
		return ansFlag == 0 || ansFlag == 2 ? Integer.parseInt(ansStr.toString(), 2)
				: -Integer.parseInt(ansStr.toString(), 2);
	}
}
