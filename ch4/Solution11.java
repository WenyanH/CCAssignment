package Ch4;

import java.util.Random;


/* You are implementing a binary tree class from scratch, which, in addition to insert, 
 * find, and delete, has a method getRandomNode() which returns a random node from the tree.
 * All nodes should be equally likely to be chosen. Design and implement an algorithm for 
 * getRandomNode, and explain how you would implement the rest of the methods. */

public class Solution11 {
	public static class Tree{
		TreeNode root=null;
		public int size(){
			if(root==null){
				return 0;
			}else{
				return root.size();
			}
		}
		public TreeNode getRandomNode(){
			if(root==null){
				return null;
			}
			Random random=new Random(); //Random() just once, which is optimal.
			int i=random.nextInt(size()); // Fetch the random integer from 0 to size();
			return root.getIthNode(i);
		}
		
		public void insertInOrder(int value) {
			if(root == null) {
				root = new TreeNode(value);
			}else{
				root.insertInOrder(value);
			}
		}
	}
	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		private int size=0;
		TreeNode(int data){
			this.data=data;
			left=null;
			right=null;
		}
		public TreeNode getIthNode(int i){  //Recursive
			//Use the size to simulate the pre-order traversal.
			int leftSize=left==null? 0: left.size(); 
			if(i<leftSize){
				return left.getIthNode(i);
			}else if(i==leftSize){
				return this;
			}else{
				return right.getIthNode(i-(leftSize+1));
			}
		}
		public int size(){
			return size;
		}
		public void insertInOrder(int d){
			if(d<=data){
				if(left==null){
					left=new TreeNode(d);
				}else{
					left.insertInOrder(d);
				}	
			}else{
				if(right==null){
					right=new TreeNode(d);
				}else{
					right.insertInOrder(d);
				}
			}
			size++;
		}
		public TreeNode find(int d){
			if(d==data){
				return this;
			}else if(d<=data){
				return left !=null? left.find(d) : null;
			}else if(d>data){
				return right !=null? right.find(d) : null;
			}
			return null;
		}
	}	
	 public static void main(String[] args) {
	    Tree t=new Tree();
	    t.insertInOrder(1);
	    t.insertInOrder(2);
	    t.insertInOrder(3);
	    t.insertInOrder(4);
	    t.insertInOrder(5);
	    t.insertInOrder(6);
	    
	    System.out.print(t.getRandomNode().data);
	    System.out.print(t.getRandomNode().data);
	    System.out.print(t.getRandomNode().data);
	    System.out.print(t.getRandomNode().data);
	    System.out.print(t.getRandomNode().data);
	    System.out.print(t.getRandomNode().data);
	    System.out.print(t.getRandomNode().data);
}
}
