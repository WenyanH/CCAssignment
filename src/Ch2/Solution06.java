package Ch2;

import java.util.Scanner;
import java.util.Stack;

public class Solution06 {
	static class LinkedListNode<T> {
		public T data;
		public LinkedListNode<T> next;

		public LinkedListNode(T data) {
			this.data = data;
		}
	}
	static boolean isPalindrome(LinkedListNode<String> head){
		LinkedListNode<String> fast=head;
		LinkedListNode<String> slow=head;
		Stack<Integer> stack=new Stack<Integer>();
		while(fast !=null && fast.next!=null){ //Push elements.
			int slowData=Integer.parseInt(slow.data);
			stack.push(slowData);
			slow=slow.next;
			fast=fast.next.next;
		}
		if(fast!=null){ // If has odd number of elements, skip the middle element.
			slow=slow.next;
		}
		while (slow!=null){
			int top=stack.pop().intValue();
			if(top!=Integer.parseInt(slow.data)){ //If values are different, then it is not a palindrome.
				return false;
			}
			slow=slow.next;
		}
		return true;
	}
	public static void main(String[] args) {
		// [Content]->[Content]->[Content]
		Scanner in = new Scanner(System.in);
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
	
		    boolean result = isPalindrome(head);
		    System.out.println(result);
		    in.close();
}
}
