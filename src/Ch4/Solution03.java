package Ch4;
/*Given a binary tree, design an algorithm which creates a linked list of all the nodes 
 * at each depth (e.g., if you have a tree with depth D, you'll have D linked lists.*/
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Solution03 {
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


	  public static ArrayList<LinkedList<TreeNode>> findLevelLinkList(TreeNode root) {
	        int level = 0;
	        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
	        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
	        list.add(root);
	        result.add(level, list);
	        while (true) {
	            list = new LinkedList<TreeNode>();
	            for(int i = 0; i < result.get(level).size(); i++){
	                TreeNode n = (TreeNode) result.get(level).get(i);
	                if(n != null) {
	                    if(n.left != null) list.add(n.left);
	                    if(n.right!= null) list.add(n.right);
	                }
	            }
	            if (list.size() > 0) {
	                result.add(level + 1, list);
	            }
	            else { 
	                break;
	            }
	            level++;
	        }
	        return result;
	    }
	    
	    public static void print(ArrayList<LinkedList<TreeNode>> result){
	        int depth = 0;
	        for(LinkedList<TreeNode> entry : result) {
	            Iterator<TreeNode> i = entry.listIterator();
	            System.out.print("Link list at depth " + depth + ":");
	            while(i.hasNext()){
	                System.out.print(" " + ((TreeNode)i.next()).data);
	            }
	            System.out.println();
	            depth++;
	        }
	    }
	   
	    public static void main(String[] args) {
	    	TreeNode n1=new TreeNode(1);
		    n1.left = new TreeNode(2);
		    n1.right = new TreeNode(3);
		    TreeNode n2=new TreeNode(1);
		    n2.left=new TreeNode(2);
		    n2.left.left=new TreeNode(3); 
	        ArrayList<LinkedList<TreeNode>> list1 = findLevelLinkList(n1);
	        ArrayList<LinkedList<TreeNode>> list2 = findLevelLinkList(n2);
	        print(list1);
	        print(list2);
	    }
}
