package Ch3;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;


/* Imagine a (literal) stack of plates. If the stack gets too high, it might topple. 
 * Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.
 * Implement a data structure SetOfStacks that mimics this. 
 * SetOfStacks should be composed of several stacks and should create a new stack once the previous exceeds capacity.
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack 
 * (that is, pop() should return the same values as it would if there were just a single stack)
  */
public class Solution03_1 {
public static class SetOfStacks{
	public int capacity;
	ArrayList<Stack<Integer>> stacks=new ArrayList<Stack<Integer>>();

	public SetOfStacks(int capacity) {
		this.capacity = capacity;
	}

	public void push(int v){
		Stack<Integer> last=getLastStack();
		if(last!=null && last.size() == capacity){
			last.push(v);			
		}else{
			Stack<Integer> newstack=new Stack<Integer>();
			newstack.push(v);
			stacks.add(newstack);
		}
	}

	public int pop(){
		Stack<Integer> last=getLastStack();
		if(last==null){
			throw new EmptyStackException();
		}
		int v=last.pop();
		if(last.size()==0){
			stacks.remove(stacks.size()-1);			
		}
		return v;
	}
	public Stack<Integer> getLastStack(){
		if(stacks.size()==0){
			return null;
		}
		return stacks.get(stacks.size()-1);
	}
}
	public static void main(String args[]) throws Exception{
		SetOfStacks s=new SetOfStacks(3);
		s.push(0);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
}

