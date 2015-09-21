package Ch2;

import java.util.LinkedList;

public class Solution5_2 {
	public static int addList(LinkedList<Integer> head) {
		int sum = 0;
		while(!head.isEmpty()) {
			sum *= 10;
			sum += head.poll();
		}

		return sum;
	}// Return a normal number.
	
	public static void print(int num) {
		while (num != 0) {
			System.out.printf("%s->", num % 10);
			num = num / 10;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		LinkedList<Integer> build1 = new LinkedList<Integer>();
		build1.add(1);
		build1.add(3);
		build1.add(5);
		//print (addList(build1));
		LinkedList<Integer> build2 = new LinkedList<Integer>();
		build2.add(7);
		build2.add(6);
		build2.add(2);
		//print(addList(build2));
		int sum = addList(build1) + addList(build2);
		System.out.println(sum);
		print(sum);
	}
}
