package Ch2;

import java.util.*;

public class Solution01 {

	static class LinkedListNode<T> {
		public T data;
		public LinkedListNode<T> next;

		public LinkedListNode(T data) {
			this.data = data;
		}
	}

	public static void deleteDups(LinkedListNode<String> n) {
		Hashtable<String, Boolean> table = new Hashtable<String, Boolean>();// Use hashtable to check Existence of
											// certain key

		LinkedListNode<String> previous = null;// perviouse node in linkedList
		while (n != null) {
			if (table.containsKey(n.data)) {
				previous.next = n.next;// If the current n is dupulicated, skip
										// current node.
			} else {
				table.put(n.data, true);// Track current n's data
				previous = n;
			}
			n = n.next;
		}
	}

	public static void main(String args[]) {
		String firstStr = "First";
		String secondStr = "Second";
		String thirdStr = "Third";

		LinkedListNode<String> node_1 = new LinkedListNode<String>(firstStr);
		LinkedListNode<String> node_2 = new LinkedListNode<String>(secondStr);
		node_1.next = node_2;
		LinkedListNode<String> node_3 = new LinkedListNode<String>(secondStr);
		node_2.next = node_3;
		LinkedListNode<String> node_4 = new LinkedListNode<String>(thirdStr);
		node_3.next = node_4;
		LinkedListNode<String> node_5 = new LinkedListNode<String>(firstStr);
		node_4.next = node_5;

		System.out
				.println("*** Print contents of linked list before deleteDups");
		LinkedListNode<String> current = node_1;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
		deleteDups(node_1);
		System.out
				.println("*** Print contents of linked list AFTER deleteDups");

		while (node_1 != null) {
			System.out.println(node_1.data);
			node_1 = node_1.next;
		}
	}
}