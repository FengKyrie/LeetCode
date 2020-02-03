package kyrie_20_1_17.convert;

import java.awt.List;
import java.util.ArrayList;

import javax.sound.sampled.LineListener;

import jdk.nashorn.internal.ir.Flags;

public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().convert("abcdefghijklmnopq", 4));
		// System.out.println(new Solution().convert("c", 4));
	}

	public String convert(String s, int numRows) {
		String result = "";
		if (s == null || s.length() == 0 || numRows == 0)
			return result;
		if (numRows == 1)
			return s;
		ArrayList<StringBuilder> vectorRow = new ArrayList<>();
		for (int i = 0; i < Math.min(numRows, s.length()); i++)
			vectorRow.add(new StringBuilder());
		int currentRow = 0;
		boolean flag = false;
		for (char c : s.toCharArray()) {
			vectorRow.get(currentRow).append(c);
			if (currentRow == 0 || currentRow == numRows - 1)
				flag = !flag;
			currentRow += flag ? 1 : -1;
		}
		StringBuilder res = new StringBuilder();
		for (StringBuilder sb : vectorRow) {
			res.append(sb);
		}
		result = res.toString();
		return result;
	}
}
