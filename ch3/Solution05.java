package Ch3;

import java.util.Stack;

/*Write a program to sort a stack (s.t.the smallest items are on the top).
 * You can use an additional temporary stack, 
 * but you may not copy the elements into any other data structure (such as an array).
 * The stack supports the following operations:push, pop, peek and isEmpty.
 */

public class Solution05 {
 
	public Stack<Integer> sort(Stack<Integer> s1){
	 Stack<Integer> s2= new Stack<Integer>();
	 while(!s1.isEmpty()){
		 int tmp=s1.pop();
		 while(!s2.isEmpty() && s2.peek()<tmp){
			 s1.push(s2.pop());
		 }
		 s2.push(tmp);
	 }
	 return s2;
}
 public static void main(String args[]) throws Exception {
	 Stack<Integer> stack = new Stack<Integer>();
	 stack.push(91);
	 stack.push(32);
	 stack.push(83);
	 stack.push(13);
	 stack.push(24);
	 stack.push(62);
	 stack.push(34);
	 
	 Solution05 ob = new Solution05();
	 stack = ob.sort(stack);
	 System.out.println(stack.pop());
	 System.out.println(stack.pop());
	 System.out.println(stack.pop());
	 System.out.println(stack.pop());
	 System.out.println(stack.pop());
	 System.out.println(stack.pop());
}
}
