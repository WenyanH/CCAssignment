package Ch4;

/*Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
 * Avoid storing additional nodes in a data structure.
 * NOTE:This is not necessarily a binary search tree.*/

public class Solution08 {
	static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode parent;
		TreeNode(int data){
			this.data=data;
			left=null;
			right=null;
		}
	}
	public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if(!covers(root, p)||!covers(root, q)){ //Check the situation when node is not in the tree or one covers the other.
			return null;
		}else if(covers(p,q)){ //If p,q are the father and child relationship, return the father node.
			return p;
		}else if(covers(q,p)){
			return q;
		}
		TreeNode sibling =getSibling(p);
		TreeNode parent=p.parent;
		while(!covers(sibling,q)){ //Do a circulation until sibling can be the father node of q.
			sibling = getSibling(parent);
			parent=parent.parent;
		}
		return parent;
	}
	public static boolean covers(TreeNode root, TreeNode p){
		if(root==null){
			return false;
		}
		if(root==p){
			return true;
		}
		return covers(root.left, p)||covers(root.right, p);		
	}
	public static TreeNode getSibling(TreeNode node){ //Find the sibling of the node.
		if(node==null || node.parent==null){
			return null;
		}
		TreeNode parent=node.parent;
		return parent.left==node? parent.right : parent.left;
	}
	 public static void main(String[] args) {
		  TreeNode n=new TreeNode(1);
		    n.left = new TreeNode(2);
		    n.left.parent = n;
		    n.left.left= new TreeNode(3);
		    n.left.left.parent = n.left;
		    n.left.left.left=new TreeNode(4);
		    n.left.left.left.parent = n.left.left;
		    n.right = new TreeNode(5);
		    n.right.parent=n;
		    n.left.right=new TreeNode(6);
		    n.left.right.parent=n.left;
		    TreeNode n2=commonAncestor(n, n.right, n.left.right);
		    System.out.println(n2.data);
	 }
}
