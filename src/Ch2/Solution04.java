package Ch2;

import java.util.Scanner;

public class Solution04 {
	static class LinkedListNode<T> {
		public T data;
		public LinkedListNode<T> next;

		public LinkedListNode(T data) {
			this.data = data;
		}
	}
public static LinkedListNode<String> partition(LinkedListNode<String> n, int x){
	LinkedListNode<String> before=null;
	LinkedListNode<String> after=null;
	while(n!=null){
		LinkedListNode<String> next=n.next;
		int data=Integer.parseInt(n.data);
	   if(data<x){
		   n.next=before;
		   before=n;
	   }else
	   {
		   n.next=after;
	       after=n;		   
	   }
	   n=next;
	}
	   if(before==null){
		   return after;
	   }
	   LinkedListNode<String> head = before;
	   while(before.next!=null){
		   before=before.next;
	   }
	   before.next=after;	
	  
	   return head;
	   
	}

public static void print(LinkedListNode<String> head){
	System.out.print(head.data);
	head=head.next;
	while(head!= null){
		System.out.print("->"+head.data);
		head = head.next;
	}
}

public static void main(String[] args) {
	// [x]
	// [Number]->[Number]->[Number]
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
	
	    LinkedListNode<String> result = partition(head, num);
	    print(result);
}
}
