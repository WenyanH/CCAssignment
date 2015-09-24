package Ch4;

/*Implement a function to check if a binary tree is a binary search tree*/

public class Solution05 {
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
	/*--------------Recursion-----------------*/
	public static boolean isBST(TreeNode n){
		return isBST(n, null, null);
	}
	public static boolean isBST(TreeNode n, Integer min, Integer max){
	if(n==null){
		return true;
	}	
	if((min!=null && n.data<=min)||(max!=null && n.data>max)){
		return false;
	}
	if(!isBST(n.left, min, n.data)||!isBST(n.right, n.data, max)){
		return false;
	}
	return true;
	}
	/*-------------------------------------*/
	 public static void main(String[] args) {
		  TreeNode n1=new TreeNode(2);
		    n1.left = new TreeNode(1);
		    n1.right = new TreeNode(3);
		    System.out.println(isBST(n1));
		    TreeNode n2=new TreeNode(1);
		    n2.left=new TreeNode(2);
		    n2.right=new TreeNode(3);
		    System.out.println(isBST(n2));
	 }
}
