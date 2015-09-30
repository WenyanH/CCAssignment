package Ch10;
/* Given an M*N matrix in which each row and each column is sorted in ascending order, 
 * write a method to find an element. */
public class Solution09 {
	public static boolean search(int[][] matrix, int x){
		int row=0;
		int column=matrix[0].length-1;
		while(row<matrix.length && column>=0){ //Use the property that the matrix is in ascending order.
			if(matrix[row][column]==x){
				return true;
			}else if(matrix[row][column]>x){
				column--;
			}else{
				row++;
			}			
		}
		return false;
	}	
	public static void main(String args[]){
		int[][] matrix={{15,20,40,85},{20,35,80,95}, {30,55,95,105}, {40,80,100,120}};
		System.out.println(search(matrix, 55));
		System.out.println(search(matrix, 65));
	}
}
