package Ch2;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution5 {
	public static int reverseAddList(LinkedList<Integer> head) {
		int sum = 0;
		for (int i = 0; i < head.size(); i++) {
			sum = (int) (head.get(i) * Math.pow(10, i));
														
		}
		return sum;
	}// return a reversing number


	public static void reversePrint(int n) {
		ArrayList<Integer> storage = new ArrayList();
		int i = 0;
		while (n >= 0) {
			storage.add(n % 10);

		}
	}

	public static void main(String[] args) {
		LinkedList<Integer> build1 = new LinkedList<Integer>();
		build1.add(1);
		build1.add(3);
		build1.add(5);
		//Print(addList(build1));
		LinkedList<Integer> build2 = new LinkedList<Integer>();
		build2.add(7);
		build2.add(6);
		build2.add(2);
		//Print(addList(build2));
		int sum = reverseAddList(build1) + reverseAddList(build2);
		System.out.println(sum);
		reversePrint(sum);
	}
}
