package Ch5;

/* Given a real number between 0 and 1 that is passed in as a double,
 * Print the binary representation.
 * If the number cannot be represented accurately in binary with at most 32 characters, 
 * print "ERROR".*/
public class Solution02 {// Suppose it is in 32-bit
	public static String binaryRepresentation(double n) {
		if (n >= 1 || n <= 0) {
			return "ERROR";
		} else {
			StringBuilder binary = new StringBuilder();
			binary.append("0.");
			while (n > 0) {
				if (binary.length() >= 32) {
					return "ERROR";
				}
				double r = n * 2;// To judge whether the bit number is 0 or 1
				if (r >= 1) {
					binary.append(1);
					n = r - 1;
				} else {
					binary.append(0);
					n = r;
				}
			}
			return binary.toString();
		}
	}

	public static void main(String args[]) {
		double n1 = 1.5;
		System.out.println(binaryRepresentation(n1));
		double n2 = 0;
		System.out.println(binaryRepresentation(n2));
		double n3 = 0.875;
		System.out.println(binaryRepresentation(n3));
		double n4 = 0.15;
		System.out.println(binaryRepresentation(n4));
	}
}
