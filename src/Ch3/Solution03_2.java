package Ch3;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

/*Follow up:
 * Implement a function popAt (int index) which performs a pop operation on a specific substack.
 */
public class Solution03_2 {
	public static class SetOfStacks{
		public int capacity;
		ArrayList<Stack<Integer>> stacks=new ArrayList<Stack<Integer>>();

		public SetOfStacks(int capacity) {
			this.capacity = capacity;
		}

		public void push(int v){
			Stack<Integer> last=getLastStack();
			if(last!=null && last.size() < capacity){
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
		public int popAt(int index) throws Exception{
			//Fetch the stacks[i]，and let it pop;
			if(index>=stacks.size()){
				throw new Exception();
			}
			
			Stack<Integer> indexStack= stacks.get(index);
			if(indexStack.size()==0){
				stacks.remove(index);
			}
			return indexStack.pop();
		}
		
		public static void main(String args[]) throws Exception {
			SetOfStacks stack = new SetOfStacks(3);
			stack.push(11);
			stack.push(12);
			stack.push(13);
			stack.push(14);
			stack.push(15);
			stack.push(16);
			stack.push(17);
			stack.push(18);
			stack.push(19);
			System.out.println(stack.popAt(2));
			System.out.println(stack.popAt(1));
			System.out.println(stack.popAt(0));
			
			
			
		}
	}
}
