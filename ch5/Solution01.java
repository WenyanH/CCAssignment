package Ch5;
/* You are given two 32-bit numbers N and M, and two bit positions i and j. 
 * Write a method to insert M into N such that M starts at big j and ends at bit i.
 * You can assume that the bits j through i have enough space to fit all of M. 
 * That is, if M=10011, you can assume that there are at least 5 bits between j and i. 
 * You would not, for example, have j=3 and i=2 
 * because M could not fully fit between bit 3 and bit 2. */
public class Solution01 { // Suppose it is in 32-bit
	public static int clearBit(int i, int j) { // Zero the space for M
		int allOnes = ~0;
		int left = allOnes << (j + 1);
		int right = (1 << i) - 1;
		int clearbit = left | right;
		return clearbit;
	}

	public static int insertBit(int n, int m, int i, int j) {// Insert the M
		int clearbit = clearBit(i, j);
		int clearN = n & clearbit;
		int M = m << i;
		int newN = clearN | M;
		return newN;
	}

	public static void main(String args[]) {
		int n = 512;// 32-bit numbers
		System.out.println("N:" + Integer.toBinaryString(n));
		int m = 19;// 32-bit numbers
		System.out.println("M:" + Integer.toBinaryString(m));
		int i = 2;
		int j = 6;// At least have the space fit for M.
		int newM = insertBit(n, m, i, j);
		System.out.println(Integer.toBinaryString(newM));

	}
}
