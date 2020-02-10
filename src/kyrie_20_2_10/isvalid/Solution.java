package kyrie_20_2_10.isvalid;

import java.util.ArrayList;

public class Solution {
	public boolean nineCheck(char[][] board, int i, int j, ArrayList<ArrayList<Character>> nine) {
		if (!isValid(board[i][j]))
			return true;
		char c = board[i][j];
		// 0
		if (i < 3 && j < 3) {
			if (nine.get(0).contains(c))
				return false;
			nine.get(0).add(c);
		}
		// 1
		if (i >= 3 && i < 6 && j < 3) {
			if (nine.get(1).contains(c))
				return false;
			nine.get(1).add(c);
		}
		// 2
		if (i >= 6 && j < 3) {
			if (nine.get(2).contains(c))
				return false;
			nine.get(2).add(c);
		}
		// 3
		if (i < 3 && j >= 3 && j < 6) {
			if (nine.get(3).contains(c))
				return false;
			nine.get(3).add(c);
		}
		// 4
		if (i < 6 && j < 6 && i >= 3 && j >= 3) {
			if (nine.get(4).contains(c))
				return false;
			nine.get(4).add(c);
		}
		// 5
		if (i >= 3 && i < 6 && j >= 6) {
			if (nine.get(5).contains(c))
				return false;
			nine.get(5).add(c);
		}
		// 6
		if (i >= 6 && j < 3) {
			if (nine.get(6).contains(c))
				return false;
			nine.get(6).add(c);
		}
		// 7
		if (i >= 6 && j >= 3 && j < 6) {
			if (nine.get(7).contains(c))
				return false;
			nine.get(7).add(c);
		}
		// 8
		if (i >= 6 && j >= 6) {
			if (nine.get(8).contains(c))
				return false;
			nine.get(8).add(c);
		}
		return true;
	}

	public boolean isValid(char s) {
		if (s > '0' && s <= '9')
			return true;
		return false;
	}

	public boolean isValidSudoku(char[][] board) {
			ArrayList<Character> checkRow = new ArrayList<>();
			ArrayList<Character> checkCol = new ArrayList<>();
			ArrayList<ArrayList<Character>> nine = new ArrayList<ArrayList<Character>>();
			for (int m = 0; m < 9; m++) {
				ArrayList<Character> s = new ArrayList<Character>();
				nine.add(s);
			}
			for (int i = 0; i < 9; i++) {
				checkCol.clear();
				checkRow.clear();
				for (int j = 0; j < 9; j++) {
					// ¾Å¹¬¸ñÅÐ¶Ï
					if (isValid(board[i][j])) {
						char c = board[i][j];
						// 0
						if (i < 3 && j < 3) {
							if (nine.get(0).contains(c))
								return false;
							nine.get(0).add(c);
						}
						// 1
						if (j >= 3 && j < 6 && i < 3) {
							if (nine.get(1).contains(c))
								return false;
							nine.get(1).add(c);
						}
						// 2
						if (j >= 6 && i < 3) {
							if (nine.get(2).contains(c))
								return false;
							nine.get(2).add(c);
						}
						// 3
						if (j < 3 && i >= 3 && i < 6) {
							if (nine.get(3).contains(c))
								return false;
							nine.get(3).add(c);
						}
						// 4
						if (i < 6 && j < 6 && i >= 3 && j >= 3) {
							if (nine.get(4).contains(c))
								return false;
							nine.get(4).add(c);
						}
						// 5
						if (i >= 3 && i < 6 && j >= 6) {
							if (nine.get(5).contains(c))
								return false;
							nine.get(5).add(c);
						}
						// 6
						if (i >= 6 && j < 3) {
							if (nine.get(6).contains(c))
								return false;
							nine.get(6).add(c);
						}
						// 7
						if (i >= 6 && j >= 3 && j < 6) {
							if (nine.get(7).contains(c))
								return false;
							nine.get(7).add(c);
						}
						// 8
						if (i >= 6 && j >= 6) {
							if (nine.get(8).contains(c))
								return false;
							nine.get(8).add(c);
						}
					}
					// ÁÐÅÐ¶Ï
					if (isValid(board[j][i])) {
						if (checkCol.contains(board[j][i]))
							return false;
						checkCol.add(board[j][i]);
					}
					// ÐÐÅÐ¶Ï
					if (isValid(board[i][j])) {
						if (checkRow.contains(board[i][j]))
							return false;
						checkRow.add(board[i][j]);
					}
				}
			}
			return true;
		}
}
