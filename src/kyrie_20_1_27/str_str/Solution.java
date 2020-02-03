package kyrie_20_1_27.str_str;

public class Solution {

	public static void main(String[] args) {
		String string = "";
		System.out.println(string == null);
		System.out.println(new Solution().strStr("heccececeal", "ecc"));
	}

	public int strStr(String haystack, String needle) {
		int location = 0;
		int simiDegree = 0;
		if (needle == null || haystack == null || needle.equals(""))
			return 0;
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			location = i;
			if (haystack.charAt(i) == needle.charAt(0)) {
				simiDegree++;
				for (int j = 1; j < needle.length(); j++) {
					if (haystack.charAt(i + j) != needle.charAt(j)) {
						simiDegree = 0;
						break;
					} else {
						simiDegree++;
					}
				}
			}
			if (simiDegree == needle.length())
				break;
		}
		return simiDegree == needle.length() ? location : -1;
	}
}
