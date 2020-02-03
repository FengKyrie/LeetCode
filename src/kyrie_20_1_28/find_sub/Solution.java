package kyrie_20_1_28.find_sub;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		Solution so = new Solution();
		List<Integer> list = so.findSubstring("barfoothefoobarman", new String[] { "foo", "bar" });
		System.out.println(list);
		List<Integer> l = so.findSubstring("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "word" });
		System.out.println(l);
	}

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<Integer>();
		if (s == null || s.length() == 0 || words.length == 0 || words == null)
			return res;
		ArrayList<String> strs = new ArrayList<>();
		ArrayList<Character> firstCh = new ArrayList<>();
		for (String str : words) {
			strs.add(str);
			firstCh.add(str.charAt(0));
		}
		int sLen = s.length(), wSize = words.length, wLen = words[0].length();
		for (int i = 0; i <= sLen - wSize * wLen; i++) {
			if (firstCh.contains(s.charAt(i))) {
				// System.out.println("\nFirst char matched!");
				ArrayList<String> check = new ArrayList<>();
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < wSize * wLen; j++) {
					if ((j + 1) % wLen == 0 && (j + 1) / wLen != 0) {
						sb.append(s.charAt(i + j));
						check.add(sb.toString());
						sb.delete(0, wLen);
					} else {
						sb.append(s.charAt(i + j));
					}
				}
				boolean flag = true;
				ArrayList<String> temp = new ArrayList<String>();
				for (String st : check)
					temp.add(st);
				for (int m = 0; m < strs.size(); m++) {
					if (!temp.contains(strs.get(m))) {
						flag = false;
					} else {
						temp.remove(strs.get(m));
					}
				}
				if (!temp.isEmpty())
					flag = false;
				temp.clear();
				for (String st : strs)
					temp.add(st);
				for (int m = 0; m < check.size(); m++) {
					if (!temp.contains(check.get(m))) {
						flag = false;
					} else {
						temp.remove(check.get(m));
					}
				}
				if (!temp.isEmpty()) {
					flag = false;
				}
				// System.out.println(flag);
				if (flag) {
					res.add(i);
				}
			}
		}
		return res;
	}
}
