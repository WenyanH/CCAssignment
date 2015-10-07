package Ch5;

/* A monochrome screen is stored as a single array of bytes, 
 * allowing eight consecutive pixel to be stored in one byte.
 * The screen has width w, where w is divisible by 8 (that is, no byte will be split across rows)
 * The height of the screen, of course, can be derived from the length of the array and the width.
 * Implement a function that draws a horizontal line from (x1, y) to (x2, y).
 * The method signature should look something like:
 * drawLine(byte[] screen, int width, int x1, int x2, int y) */

public class Solution08 {
	public static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
		int startoffset = x1 % 8;
		int firstfullbyte = x1 / 8;
		if (startoffset != 0) {
			firstfullbyte++;
		}
		int endoffset = x2 % 8;
		int lastfullbyte = x2 / 8;
		if (endoffset != 7) {
			lastfullbyte--;
		}
		// Find the full byte part
		if (lastfullbyte >= firstfullbyte) {
			for (int i = firstfullbyte; i <= lastfullbyte; i++) {
				screen[(width / 8) * y + i] = (byte) 0xFF;
			}
		}

		byte start = (byte) (0xFF >> startoffset);
		byte end = (byte) ~(0xFF >> (endoffset + 1));

		// Set the start and the end of the line
		if ((x1 / 8) == (x2 / 8)) {// x1,x2 are in the same byte
			byte draw = (byte) (start & end);
			screen[(width / 8) + (x1 / 8)] |= draw;
		} else {
			if (startoffset != 0) {
				int firstbyte = (width / 8) * y + firstfullbyte - 1;
				screen[firstbyte] |= start;
			}
			if (endoffset != 7) {
				int lastbyte = (width / 8) * y + lastfullbyte + 1;
				screen[lastbyte] |= end;
			}
		}
	}

	public static int byteNum(int width, int x, int y) {
		return (width * y + x) / 8;
	}

	public static void printByte(byte b) {
		for (int i = 7; i >= 0; i--) {
			System.out.print((b >> i) & 1);// Output the last bit of b
		}
	}

	public static void printScreen(byte[] screen, int width) {
		int height = screen.length * 8 / width;
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c += 8) {
				byte b = screen[byteNum(width, c, r)];
				printByte(b);
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		int width = 32;
		int height = 5;
		byte[] screen = new byte[width * height / 8];
		drawLine(screen, width, 1, 17, 2);
		printScreen(screen, width);
	}
}
