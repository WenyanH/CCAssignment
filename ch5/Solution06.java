package Ch5;

import java.util.Scanner;

/*Write a function to determine the number of bits you would need 
 * to flip to convert integer A to integer B */
public class Solution06 {
	public static int swapNumber(int a, int b) {
		int count = 0;
		for (int c = a ^ b; c != 0; c = c & (c - 1)) {
			count++;
		}
		return count;
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			String s1 = in.nextLine();
			String s2 = in.nextLine();
			int n1 = Integer.parseInt(s1);
			int n2 = Integer.parseInt(s2);
			System.out.println(swapNumber(n1, n2));
		}
		in.close();

	}
}
