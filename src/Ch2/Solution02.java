package Ch2;

import java.util.Scanner;


public class Solution02 {
	static class LinkedListNode<T> {
		public T data;
		public LinkedListNode<T> next;

		public LinkedListNode(T data) {
			this.data = data;
		}
	}

	public static LinkedListNode<String> nToLast(LinkedListNode<String> head, int k) {
		if (k <= 0) // Check the failure
			return null;
		LinkedListNode<String> p1 = head;
		LinkedListNode<String> p2 = head;
		for (int i = 0; i < k - 1; i++) {
			if (p2 == null)
				return null; // Check the failure
			p2 = p2.next;// Move p2 k nodes towards
		}
		if (p2 == null)
			return null;
		while (p2.next != null) { // Move p1 & p2 in the same speed until p2
									// came to the end.
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}

	public static void main(String[] args) {
		// [number]
		// [Content]->[Content]->[Content]
		Scanner in = new Scanner(System.in);
		int num = Integer.parseInt(in.nextLine());
		LinkedListNode<String> head = null;
		LinkedListNode<String> tail = null;
		String input = in.nextLine();
		String[] split = input.split("\\-\\>");
		for (String s : split) {
			if (head == null) {
				head = new LinkedListNode<String>(s);
				tail = head;
			} else {
				LinkedListNode<String> temp = new LinkedListNode<String>(s);
				tail.next = temp;
				tail = temp;
			}
		}
	
		    LinkedListNode<String> result = nToLast(head, num);
		    System.out.println(result.data);
		in.close();
		
//		LinkedListNode<String> iterator = head;
//		while(iterator != null) {
//			System.out.println(iterator.data);
//			iterator = iterator.next;
//		}
		// List<String[]> arrayList = new ArrayList<String[]>();
		// while(in.hasNext()) {
		// String[] split = in.nextLine().split("\\s+");
		// int[] l = new int[split.length];
		// for(int i=0; i<l.length; i++) {
		// l[i] = Integer.parseInt(split[i]);
		// }
		// }
	}
}
