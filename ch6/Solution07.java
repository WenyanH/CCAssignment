package Ch6;

import java.util.Random;

/* In the new post-apocalyptic world, the world queen in desperately concerned about the birth rate.
 * Therefore, she decrees that all families should ensure that they have one girl or else 
 * they face massive fines. If all families abide by this policy - that is, 
 * they have continue to have children until they have one girl, 
 * at which point they immediately stop - what will the gender ratio of the new generation be?
 * Solve this out logically and then write a computer simulation of it. */

/* Answer:
 * Let the birth of girl be G, and boy be B.
 * When we the the birth rate in probability, we can see when the sequence in birth is G, BG, BBG,...,
 * the probability of boys are respectively 0, 1/4, 2/8, 3/16, 4/32, 5/64....
 * The sum of 0+1/4+2/8+3/16+... has the converge to 1, which means the gender ratio is still even.
 * Then from the logical view, we see that even the rule says that every family must have a girl, 
 * the birth sequence is still in elements G or B, which are 50% percentage, then for the whole human beings perspective, 
 * the birth rate is still half to half, which is not changed. */

public class Solution07 {
	public static int[] oneFamily() { // The probability for specific one family
		int girls = 0;
		int boys = 0;
		Random random = new Random();
		while (girls == 0) {
			if (random.nextBoolean()) { // Randomly have 1 or 0 for probability simulation
				girls++;
			} else {
				boys++;
			}
		}
		int[] genders = { girls, boys };
		return genders;
	}

	public static double moreFamily(int n) {// The probability of the whole human beings.
		int boys = 0;
		int girls = 0;
		for (int i = 0; i < n; i++) {
			int[] genders = oneFamily();
			girls = girls + genders[1];
			boys = boys + genders[1];
		}
		return girls / (double) (girls + boys);
	}

	public static void main(String args[]) {
		int n = 10000;
		System.out.println(moreFamily(n));
	}
}
