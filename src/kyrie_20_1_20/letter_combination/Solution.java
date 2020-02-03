package kyrie_20_1_20.letter_combination;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().letterCombinations("234").toString());
	}

	public List<String> letterCombinations(String digits) {
		int bits = 1;
		List<String> list = new ArrayList<String>();
		if (digits.length() == 0 || digits == null)
			return list;
		for (char c : digits.toCharArray()) {
			if (c < 50 || c > 57)
				return list;
			if (c == '7' || c == '9') {
				bits *= 4;
			} else {
				bits *= 3;
			}
		}
		List<StringBuilder> sbList = new ArrayList<StringBuilder>();
		for (int i = 0; i < digits.length(); i++) {
			sbList.add(new StringBuilder());
		}
		int flag = 1, len = digits.length();
		for (int i = len - 1; i >= 0; i--) {
			switch (digits.charAt(len - 1)) {
			case '2':
				for (int j = 0; j < len; j += flag) {
					sbList.get(i).insert(0, "a");
				}
				for(int j=flag;j<len;j+=flag) {
					sbList.get(i).insert(0, "b");
				}
				for(int j=flag;j<len;j+=flag) {
					sbList.get(i).insert(0, "b");
				}
				flag *= 3;
				break;
			case '3':
				if (i % 3 == 0)
					sbList.get(i).append("d");
				if (i % 3 == 1)
					sbList.get(i).append("e");
				if (i % 3 == 2)
					sbList.get(i).append("f");
				flag *= 3;
				break;
			case '4':
				if (i % 3 == 0)
					sbList.get(i).append("g");
				if (i % 3 == 1)
					sbList.get(i).append("h");
				if (i % 3 == 2)
					sbList.get(i).append("i");
				flag *= 3;
				break;
			case '5':
				if (i % 3 == 0)
					sbList.get(i).append("j");
				if (i % 3 == 1)
					sbList.get(i).append("k");
				if (i % 3 == 2)
					sbList.get(i).append("l");
				flag *= 3;
				break;
			case '6':
				if (i % 3 == 0)
					sbList.get(i).append("m");
				if (i % 3 == 1)
					sbList.get(i).append("n");
				if (i % 3 == 2)
					sbList.get(i).append("o");
				flag *= 3;
				break;
			case '7':
				if (i % 4 == 0)
					sbList.get(i).append("p");
				if (i % 4 == 1)
					sbList.get(i).append("q");
				if (i % 4 == 2)
					sbList.get(i).append("r");
				if (i % 4 == 3)
					sbList.get(i).append("s");
				flag *= 4;
				break;
			case '8':
				if (i % 3 == 0)
					sbList.get(i).append("t");
				if (i % 3 == 1)
					sbList.get(i).append("u");
				if (i % 3 == 2)
					sbList.get(i).append("v");
				flag *= 3;
				break;
			case '9':
				if (i % 4 == 0)
					sbList.get(i).append("w");
				if (i % 4 == 1)
					sbList.get(i).append("x");
				if (i % 4 == 2)
					sbList.get(i).append("y");
				if (i % 4 == 3)
					sbList.get(i).append("z");
				flag *= 4;
				break;
			}
		}
		return list;
	}
}
