package Kyrie_20_1_31.longest;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().longestValidParentheses("(()"));
	}

	public int Longest(char[] arr) {
		Stack<Character> tempStack = new Stack<Character>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(')
				tempStack.push(arr[i]);
			else {
				if (tempStack.isEmpty())
					return 0;
				tempStack.pop();
			}
		}
		if (tempStack.isEmpty()) {
			System.err.println(arr);
			return arr.length;
		} else {
			return 0;
		}
	}

	public int longestValidParentheses(String s) {
		if (s.isEmpty() || s == null)
			return 0;
		int MaxLength = 0, sLen = s.length();
		for (int i = 0; i < sLen; i++) {
			for (int j = i + 1; j < sLen; j++) {
				MaxLength = Math.max(MaxLength, Longest(s.substring(i, j + 1).toCharArray()));
			}
		}
		return MaxLength;
	}
}
