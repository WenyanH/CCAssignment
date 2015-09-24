package Ch4;

import java.util.ArrayList;
import java.util.LinkedList;

/* A binary search tree was created by traversing through an array from left to right 
 * and inserting each element. Given a binary search tree with distinct elements, 
 * print all possible arrays that could have led to this tree. */

public class Solution09 {
	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data){
			this.data=data;
			left=null;
			right=null;
		}
	}
	public static ArrayList<LinkedList<Integer>> sequences(TreeNode node){
		ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		if(node==null){
			result.add(new LinkedList<Integer>());
			return result;
		}
		LinkedList<Integer> prefix=new LinkedList<Integer>();
		prefix.add(node.data);
		
		ArrayList<LinkedList<Integer>> leftSeq=sequences(node.left); //Recurse on left subtrees.
		ArrayList<LinkedList<Integer>> rightSeq=sequences(node.right);//Recurse on right subtrees.
		
		for (LinkedList<Integer> left : leftSeq){
			for (LinkedList<Integer> right : rightSeq){
				ArrayList<LinkedList<Integer>> weaved=new ArrayList<LinkedList<Integer>>();
				weaveLists(left, right, weaved, prefix);
				result.addAll(weaved);
			}
		}
		return result;
	}
// weaveLists: the core function of the sequences	
	public static void weaveLists(LinkedList<Integer>first, LinkedList<Integer> second, 
			ArrayList<LinkedList<Integer>> results, LinkedList<Integer>prefix){
		if (first.size()==0||second.size()==0){
			LinkedList<Integer> result=(LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;					
		}
		int headFirst=first.removeFirst();
		prefix.addLast(headFirst);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		first.addFirst(headFirst);
		
		int headSecond=second.removeFirst();
		prefix.addLast(headSecond);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		second.addFirst(headSecond);
	}
	
	public static void print(ArrayList<LinkedList<Integer>> n){
		for(LinkedList<Integer> l : n) {
			for(Integer x:l)
				System.out.print(x+" ");
			System.out.println();
		}
		
		/*int sizeArray = n.size();
		for(int i =0; i< sizeArray; i++){
			int linkedsize = n.get(i).size();
			for(int j = 0; j< linkedsize; j++){
				System.out.print(n.get(i).get(j)+"->");
			}
			System.out.println();
		}*/
	}
	
	 public static void main(String[] args) {
		  TreeNode n=new TreeNode(50);
		    n.left = new TreeNode(20);
		    n.left.left= new TreeNode(10);
		    n.left.right=new TreeNode(25);
		    n.left.left.left=new TreeNode(5);
		    n.left.left.right=new TreeNode(15);
		    n.right = new TreeNode(60);
		    n.right.right=new TreeNode(70);
		    n.right.right.left=new TreeNode(65);
            n.right.right.right=new TreeNode(80);
		    ArrayList<LinkedList<Integer>> n2=sequences(n);
		    print(n2);
		    
	 }
	
}
