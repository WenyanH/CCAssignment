package Ch4;


/*Given a sorted (increasing order) array with unique integer elements, 
 * write an algorithm to create a binary search tree with minimal height.*/

public class Solution02 {
	static class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode(int data){
		this.data=data;
		left=null;
		right=null;
	}
	public void insertTreeNode(TreeNode root, int data){ //Balance tree
		if (data>=root.data){
			if(root.right==null){
				root.right=new TreeNode(data);
			}else{
				insertTreeNode(root.right, data);
			}
		}else{
			if(root.left==null){
				root.left=new TreeNode(data);
			}else{
				insertTreeNode(root.left, data);
		}
	    }
		}
	
	
/*--------------Recursion-----------------*/
	}

	public static TreeNode createMinimalBST(int arr[], int start, int end){
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(arr[mid]);
        n.left=createMinimalBST(arr, start, mid - 1);
        n.right=createMinimalBST(arr, mid + 1, end);
        return n;
    }
    
    public static TreeNode createMinimalBST(int array[]) {
        return createMinimalBST(array, 0, array.length - 1);
    }
/*----------------------------------------*/
	
    public static void main(String[] args) {
    	 int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; 	 
    	 TreeNode n=createMinimalBST(data);
    	 System.out.println(n.data);
    	 System.out.println(n.left.data);
    	 System.out.println(n.right.data);
    }
}
