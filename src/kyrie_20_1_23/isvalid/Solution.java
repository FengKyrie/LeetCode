package kyrie_20_1_23.isvalid;

import java.util.HashMap;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().isValid(")[") ? "∂‘¿≤£°" : "≤ª∂‘‡∏");
	}

	public boolean isValid(String s) {
		Stack<Character> left = new Stack<Character>();
		HashMap<Character, Character> check = new HashMap<Character, Character>();
		check.put('(', ')');
		check.put('[', ']');
		check.put('{', '}');
		char[] charArr = s.toCharArray();
		if (charArr.length % 2 != 0) {
			System.err.println("Wrong length...");
			return false;
		}
		for (char c : charArr) {
			if (c == '(' || c == '[' || c == '{') {
				left.push(c);
			} else if (c == ')' || c == ']' || c == '}') {
				if (left.isEmpty())
					return false;
				char ch = left.pop();
				if (c != check.get(ch)) {
					System.err.println(c + "!=" + ch);
					return false;
				}
			} else {
				return false;
			}
		}
		if (!left.isEmpty())
			return false;
		return true;
	}
}
