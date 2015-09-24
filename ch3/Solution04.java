package Ch3;

import java.util.Stack;
/*Implement a MyQueue class which implements a queue using two stacks.*/

public class Solution04 {
public static class MyQueue<T>{
	Stack<T> stackNew, stackOld;
	public MyQueue(){
		stackNew=new Stack<T>();
		stackOld=new Stack<T>();
	}
	public int size(){
		 int size=stackNew.size()+stackOld.size();
		 return size;
	}
/*Add(item): Add an item to the end of the list.*/
	public void add(T value){
		stackNew.push(value);
	}
/*Remove(): Remove the first item in the list.*/
	public T remove(){
		if(stackOld.isEmpty()){
			while(!stackNew.isEmpty()){
				stackOld.push(stackNew.pop());
			}
		}
		return stackOld.pop();
	}
/*Peek():Return the top of the stack*/
	public T peek(){
		if(stackOld.isEmpty()){
			while(!stackNew.isEmpty()){
				stackOld.push(stackNew.pop());
			}
		}
		return stackOld.peek();
	}
}
public static void main(String args[]) throws Exception {
MyQueue<Integer> s=new MyQueue<Integer>();
s.add(0);
s.add(1);
s.add(2);
System.out.println(s.remove());
System.out.println(s.peek());
}
}
