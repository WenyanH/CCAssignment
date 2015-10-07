package Ch6;

import java.util.Random;

/* You have 1000 bottles of soda, and exactly one is poisoned. 
 * You have 10 test strips which can be used to detect poison.
 * A single drop of poison will turn the test strip positive permanently.
 * You can put any number of drops on a test strip at once and you can reuse a test strip 
 * as many times as you'd like (as long as the results are negative). However, you can only run
 * tests once per day and it takes seven days to return a result. How would you figure out the
 * poisoned bottle in as few days as possible?
 * Follow up: Write the code to simulate your approach. */

/* Answer:
 * We can use the bottle ID and let the ID numbers to become the binary format. 
 * For the 10 test strips, every test strips test one bit vector of the binary numbers. 
 * Then from the test strips which are in positive result we can know 
 * which bit vectors causes the possible and combine them together to become a new binary, 
 * which is the poisoned. */

public class Solution10 {
	public static int findPoisonedBottle(int bottleNumber, boolean[] strips, int poisonedBottle) {
		for (int i = 1; i <= bottleNumber; i++) { //Know the binary format of the poisoned bottle according to the strip test.
			if (i == poisonedBottle) {
				for (int j = 0; j < 10; j++) {
					if (((i >>> j) & 1) == 1) {
						strips[9 - j] = true;
					}
				}
			}
		}
		int result = 0;
		for (int j = 0; j < strips.length; j++) { //Get the poisoned bottle. 
			result = (result << 1) + (strips[j] ? 1 : 0);
		}
		return result;
	}

	public static void main(String[] args) {
		int bottleNumber=1000;
		boolean[] strips = new boolean[10];
		Random rand = new Random();
		int poisonedBottle = rand.nextInt(bottleNumber) + 1;//Generate randomly a poisoned bottle
		System.out.println("Poisoned bottle Number: " + poisonedBottle);
		int result = findPoisonedBottle(bottleNumber, strips, poisonedBottle);
		System.out.println("Result:"+result);
	}
}
