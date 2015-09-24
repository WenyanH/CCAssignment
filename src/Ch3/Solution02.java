package Ch3;

import java.util.Stack;

/* How would you design a stack which, in addition to push and pop, 
 * has a function min which returns the minimum element?
 * Push, pop and min should all operate in O(1) time.*/

public class Solution02 {
	public class MinStack extends Stack<Integer>{
		Stack<Integer> s;
		public MinStack(){
			s=new Stack<Integer>();
		}
		public void push(int value){
			if(value<=min()){
				s.push(value);
			}
			super.push(value);
		}
		public Integer pop(){
			int value=super.pop();
			if (value==min()){
				s.pop();
			}
			return value;
		}
		public int min(){
			if(s.isEmpty()){
				return Integer.MAX_VALUE;
			}else{
				return s.peek();
			}			
		}
}
	public static void main(String args[]) throws Exception {
		MinStack stack = new Solution02().new MinStack();
		stack.push(5);
		System.out.println(stack.min());
		stack.push(1);
		System.out.println(stack.min());
		stack.push(2);
		System.out.println(stack.min());
		stack.push(3);
		System.out.println(stack.min());
		System.out.println(stack.pop());
		System.out.println(stack.min());
		System.out.println(stack.pop());
		System.out.println(stack.min());
		System.out.println(stack.pop());
		System.out.println(stack.min());
		System.out.println(stack.pop());
	}
}

