package Ch4;

/*Write an algorithm to find the "next" node 
 * (i.e., in-order successor) of a given node in a binary search tree.
 * You may assume that each node has a link to its parent.
 */

public class Solution06 {
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
	public static TreeNode nextNode(TreeNode n){
		if(n==null){
			return null;
		}
		if(n.right!=null){
			return leftMostChild(n.right);
		}else{
			TreeNode q=n;
			TreeNode p=q.parent;
			while(p!=null && p.left!=q){
				q=p;
				p=p.parent;
			}
			return p;
		}
	}
	public static TreeNode leftMostChild(TreeNode n){
		if(n==null){
			return null;
		}
		while(n.left!=null){
			n=n.left;
		}
		return n;
	}
	 public static void main(String[] args) {
		  TreeNode n=new TreeNode(4);
		    n.left = new TreeNode(3);
		    n.left.parent = n;
		    n.left.left= new TreeNode(2);
		    n.left.left.parent = n.left;
		    n.left.left.left=new TreeNode(1);
		    n.left.left.left.parent = n.left.left;
		    n.right = new TreeNode(5);
		    n.right.parent=n;
		    TreeNode n2=nextNode(n.left.left);
		    System.out.println(n2.data);
	 }
}
