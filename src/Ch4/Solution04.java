package Ch4;

/*Implement a function to check if a binary tree is balanced. 
 * For the purposes of this question, a balanced tree is defined to be a tree 
 * such that the heights of the two subtrees of any node never differ by more than one.*/

public class Solution04 {
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
	public static int checkHeight(TreeNode root){
		if(root==null){
			return 0;
		}
		int leftHeight=checkHeight(root.left); //Check the balance status of the left part.
		if(leftHeight==-1){
			return -1;
		}  //Not balanced
		int rightHeight=checkHeight(root.right);//Check the balance status of the right part.
		if(rightHeight==-1){
			return -1;
		} //Not balanced
		
		int heightDiff=leftHeight-rightHeight;
		if(Math.abs(heightDiff)>1){
			return -1; //Not balanced
		}else{
			return Math.max(leftHeight, rightHeight)+1; //Return height.
		}
	}
	public static boolean isBalanced(TreeNode root){
		if (checkHeight(root)==-1){
			return false;
		}else{
			return true;
		}
	}

	public static void main(String[] args) {
	    TreeNode n1=new TreeNode(1);
	    n1.left = new TreeNode(2);
	    n1.right = new TreeNode(3);
	    System.out.println(isBalanced(n1));
	    TreeNode n2=new TreeNode(1);
	    n2.left=new TreeNode(2);
	    n2.left.left=new TreeNode(3);
	    System.out.println(isBalanced(n2));
	}
}
