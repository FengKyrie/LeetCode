package kyrie_20_1_19.int_to_roman;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().intToRoman(1994));
	}

	public String intToRoman(int num) {
		char[] charArr = String.valueOf(num).toCharArray();
		StringBuilder sb = new StringBuilder();
		int bits = charArr.length;
		for (int i = bits - 1; i >= 0; i--) {
			int currentNum = charArr[i] - 48;
			switch (bits - i) {
			case 1:
				switch (currentNum) {
				case 1:
					sb.insert(0, "I");
					break;
				case 2:
					sb.insert(0, "II");
					break;
				case 3:
					sb.insert(0, "III");
					break;
				case 4:
					sb.insert(0, "IV");
					break;
				case 5:
					sb.insert(0, "V");
					break;
				case 6:
					sb.insert(0, "VI");
					break;
				case 7:
					sb.insert(0, "VII");
					break;
				case 8:
					sb.insert(0, "VIII");
					break;
				case 9:
					sb.insert(0, "IX");
					break;
				default:
					break;
				}
				break;
			case 2:
				switch (currentNum) {
				case 1:
					sb.insert(0, "X");
					break;
				case 2:
					sb.insert(0, "XX");
					break;
				case 3:
					sb.insert(0, "XXX");
					break;
				case 4:
					sb.insert(0, "XL");
					break;
				case 5:
					sb.insert(0, "L");
					break;
				case 6:
					sb.insert(0, "LX");
					break;
				case 7:
					sb.insert(0, "LXX");
					break;
				case 8:
					sb.insert(0, "LXXX");
					break;
				case 9:
					sb.insert(0, "XC");
					break;
				default:
					break;
				}
				break;
			case 3:
				switch (currentNum) {
				case 1:
					sb.insert(0, "C");
					break;
				case 2:
					sb.insert(0, "CC");
					break;
				case 3:
					sb.insert(0, "CCC");
					break;
				case 4:
					sb.insert(0, "CD");
					break;
				case 5:
					sb.insert(0, "D");
					break;
				case 6:
					sb.insert(0, "DC");
					break;
				case 7:
					sb.insert(0, "DCC");
					break;
				case 8:
					sb.insert(0, "DCCC");
					break;
				case 9:
					sb.insert(0, "CM");
					break;
				default:
					break;
				}
				break;
			case 4:
				switch (currentNum) {
				case 1:
					sb.insert(0, "M");
					break;
				case 2:
					sb.insert(0, "MM");
					break;
				case 3:
					sb.insert(0, "MMM");
					break;
				default:
					break;
				}
				break;
			default:
				break;
			}
		}
		return sb.toString();
	}
}
