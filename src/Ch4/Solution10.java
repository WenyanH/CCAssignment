package Ch4;

/*T1 and T2 are two very large binary trees, with T1 much bigger than T2. 
 * Create an algorithm to determine if T2 is a subtree of T1.*/

public class Solution10 {
	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	/*
	 * Checks whether the binary tree rooted at n1 contains the binary tree
	 * rooted at n2 as a subtree somewhere within it.
	 */
	public static boolean isSubTree(TreeNode n1, TreeNode n2) {
		if (n2 == null) {// The empty tree is a subtree of every tree.
			return true;
		} else if (n1 == null) {// The bigger tree is empty,subtree is not found.
			return false;
		} else if (n1.data == n2.data && matchTree(n1, n2)) {
			return true;
		}
		return (isSubTree(n1.left, n2) || isSubTree(n1.right, n2));//Recursive
	}

	/*
	 * Checks whether the binary tree rooted at n1 contains the binary tree
	 * rooted at n2 as a subtree starting at n1.
	 */
	public static boolean matchTree(TreeNode n1, TreeNode n2) {
		if (n2 == null && n1 == null){
			return true; // Nothing 
		}else if (n1 == null || n2 == null){
			return false; // big tree empty & subtree still not found
		}else if (n1.data != n2.data){
			return false; // Data doesn't match
		}else{
			return (matchTree(n1.left, n2.left) && matchTree(n1.right, n2.right));//Recursive
		}
			
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(50);
		n1.left = new TreeNode(20);
		n1.left.left = new TreeNode(10);
		n1.left.right = new TreeNode(25);
		n1.left.left.left = new TreeNode(5);
		n1.left.left.right = new TreeNode(15);
		n1.right = new TreeNode(60);
		n1.right.right = new TreeNode(70);
		n1.right.right.left = new TreeNode(65);
		n1.right.right.right = new TreeNode(80);
		TreeNode n2 = new TreeNode(20);
		n2.left = new TreeNode(10);
		n2.left.left = new TreeNode(5);
		n2.left.right = new TreeNode(15);
		n2.right = new TreeNode(25);
		System.out.println(isSubTree(n1, n2));

	}
}
