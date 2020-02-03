package kyrie_20_1_19.longest_common;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().longestCommonPrefix(new String[] {}));
	}

	public String longestCommonPrefix(String[] strs) {
		StringBuilder sb = new StringBuilder();
		int maxLength = Integer.MAX_VALUE;
		for (String str : strs) {
			maxLength = Math.min(maxLength, str.length());
		}
		if (maxLength == 0 || strs.length == 0)
			return "";
		else {
			int i = 0;
			boolean flag = true;
			char temp;
			while (i < maxLength) {
				temp = strs[0].charAt(i);
				for (String str : strs) {
					if (str.charAt(i) != temp) {
						flag = false;
					}
				}
				if (flag)
					sb.append(temp);
				else {
					return sb.toString();
				}
				i++;
			}
		}
		return sb.toString();
	}
}
