package Ch6;

/* There is a building of 100 floors. If an egg drops from the Nth floor or above, it will break.
 * If it's dropped from any floor below, it will not break. You are given two eggs. 
 * Find N, while minimizing the number of drops for the worst case. */

/* Answer:
 * Since we need to find a best way for the most consistent solution of the total number of 
 * drops for both eggs.
 * Therefore, we need to find a solution that when we drop one more time of egg1, 
 * then we drop one less time of egg2.
 * Then for egg1, x+(x-1)+(x-2)+...+1=100, we can use x=14. 
 * It is the first beginning floor for dropping egg1.  */

public class Solution08 {
	public static int findBreakingFloor(int floors) {
		int layerNumber = 14; // The initial interval of the egg1 drop.
		int lastFloor = 0;
		int egg1 = layerNumber;
		while (!drop(egg1) && egg1 <= floors) {//Continue to drop egg1 first until the egg1 breaks.
			layerNumber = layerNumber - 1;
			lastFloor = egg1;
			egg1 = egg1 + layerNumber;
		}
		int egg2 = lastFloor + 1;
		while (egg2 < egg1 && egg2 <= floors && !drop(egg2)) {//Then continue to drop egg2 first until the egg2 break, which floor is the breaking floor.
			egg2 = egg2 + 1;
		}
		if (egg2 > floors) {
			return -1;
		} else {
			return egg2;
		}
	}

	public static boolean drop(int floor) {
		int breakingLayer = 50; //Set the Nth floor randomly by the program.
		if (floor >= breakingLayer) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		int floors = 100; //Set the floors of the building.
		System.out.println(Solution08.findBreakingFloor(floors));
	}
}
