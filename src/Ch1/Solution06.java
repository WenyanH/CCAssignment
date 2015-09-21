package Ch1;

import java.util.Scanner;

public class Solution06 {
	public static String compress(String s) {
		int finalLength = countCompression(s);
		if (finalLength >= s.length()) {
			return s;
		}
		StringBuilder compressed = new StringBuilder(finalLength);
		int countConsecutive = 0;
		for (int i = 0; i < s.length(); i++) {
			countConsecutive++;
			if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
				compressed.append(s.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.toString();
	}

	public static int countCompression(String s) {
		int compressedLength = 0;
		int countConsecutive = 0;
		for (int i = 0; i < s.length(); i++) {
			countConsecutive++;
			if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
				compressedLength += 1 + String.valueOf(countConsecutive)
						.length();
				countConsecutive = 0;
			}
		}
		return compressedLength;
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			String inputStr = scanner.next();
			System.out.print(compress(inputStr) + "\n");
		}
		scanner.close();
	}
}
