package Ch1;

import java.util.Scanner;

public class Solution08 {
public static void setZeros(int[][] matrix){
	boolean rowHasZero=false;
	boolean columnHasZero=false;
	for (int i=0; i<matrix.length; i++){ //Check whether the first column has a zero
		if (matrix[i][0]==0){
			columnHasZero=true;
		break;
		}
	}
	for(int j=0; j<matrix[0].length;j++){//Check whether the first row has a zero
		if(matrix[0][j]==0){
			rowHasZero=true;
			break;
		}
	}
	for(int i=1; i<matrix.length;i++){//Check whether the rest of the array has a zero
		for(int j=1;j<matrix[0].length;j++){
			if(matrix[i][j]==0){
				matrix[i][0]=0;
				matrix[0][j]=0;
			}
		}
	}
	if(rowHasZero){
		setZeroRow(matrix,0);
	}
	if(rowHasZero){
		setZeroColumn(matrix,0);
	}
	for(int i=1; i<matrix.length;i++){
		if (matrix[i][0]==0){
			setZeroRow(matrix,i);
		}
	}
	for(int j=1; j<matrix[0].length;j++){
		if (matrix[0][j]==0){
			setZeroColumn(matrix,j);
		}
	}
}
public static void setZeroRow(int[][] matrix, int row){
	for(int j=0;j<matrix[0].length;j++){
		matrix[row][j]=0;
	}
}
public static void setZeroColumn(int[][] matrix, int column){
	for(int i=0;i<matrix.length;i++){
		matrix[0][column]=0;
	}
}
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String[] rowControlStr = in.nextLine().split("\\s+");
	int m = Integer.parseInt(rowControlStr[0]);
	int n = Integer.parseInt(rowControlStr[1]);
	int[][] matrix = new int[m][n];
	for (int i = 0; i < m; i++) {
		String[] split = in.nextLine().split("[^0-9]+");
		for (int j = 0; j < n; j++) {
			matrix[i][j] = Integer.parseInt(split[j]);
		}
	}
	in.close();

	System.out.println("~~~~~~~~~");
	Solution08.setZeros(matrix);
	for (int i = 0; i < matrix.length; i++) {
		for (int j = 0; j < matrix[i].length; j++) {			
			System.out.print(matrix[i][j] + "\t");
		}
		System.out.println();
	}
}
}
