package Ch3;

import java.util.EmptyStackException;

/*Describe how you could use a single array to implement three stacks*/
public class Solution01 {
public static class FixedStacks{
	private int number=3;
	private int capacity;
	private int[]values;
	private int[]sizes;
	
	public FixedStacks(int stackSize){
		capacity=stackSize;
		values=new int[stackSize*number];
		sizes=new int[number];
	}
	
/*Push: Add an item to the top of the stack.*/	
	public void push(int stackNumber, int value) throws Exception{
		if (isFull(stackNumber)){
			throw new Exception();
		}
		sizes[stackNumber]++;  //Move the stack pointer to update the top value.
		values[indexOfTop(stackNumber)]=value;
	}
/*Pop:Remove the top item from the stack.*/
	public int pop(int stackNumber){
		if(isEmpty(stackNumber)){
			throw new EmptyStackException();
		}
		int top=indexOfTop(stackNumber);
		int value =values[top];//Get the top.
		sizes[stackNumber]--;
		return value;
	}
/*Peek: Return the top of the stack*/
	public int peek(int stackNumber){
		if(isEmpty(stackNumber)){
			throw new EmptyStackException();
		}
		return values[indexOfTop(stackNumber)];
	}
/*isEmpty: Return true if and only if the stack is empty.*/
	public boolean isEmpty(int stackNumber){
		if(sizes[stackNumber]==0){
			return true;
		}else{
			return false;
		}
	}
/*isFull: Return true if the stack is full.*/
	public boolean isFull(int stackNumber){
		if(sizes[stackNumber]==capacity) {
			return true;
		}else{
			return false;
		}				
	}
/*Index: return index of the top of the stack.*/
	public int indexOfTop(int stackNumber){
		int offset =stackNumber*capacity; 
		int size=sizes[stackNumber];
		return offset+size-1; //For sizes[stackNumber]++; 
	}
}
public static void main(String args[]) throws Exception {
	FixedStacks s = new FixedStacks(5);
	s.push(0, 1);
	s.push(1, 3);
	s.push(2, 2);
	s.push(1, 1);
	s.push(2, 6);
	System.out.println(s.pop(0));
	System.out.println(s.pop(1));
	System.out.println(s.pop(2));
	System.out.println(s.pop(1));
	System.out.println(s.pop(2));
	
}
}
