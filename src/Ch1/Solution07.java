package Ch1;

import java.util.Scanner;

public class Solution07 {
public static void rotate(int[][] matrix, int n){
	for(int i=0;i<n/2;i++){ 
		int front=i;
		int end=n-1-i;
		for(int j=front; j<end; j++){ 
			int diff=j-front;
			int top=matrix[front][j]; 
			matrix[front][j]=matrix[end-diff][front];//Let the left be the top.
			matrix[end-diff][front]=matrix[end][end-diff];//Let the bottom be the left.
			matrix[end][end-diff]=matrix[j][end];//Let the right be the bottom.
			matrix[j][end]=top;//Let the top be the right.
		}
	}
}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine().trim());
		int[][] matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] split = in.nextLine().split("[^0-9]+");
			for (int j = 0; j < n; j++) {
				matrix[i][j] = Integer.parseInt(split[j]);
			}
		}
		in.close();

		System.out.println("~~~~~~~~~");
		Solution07.rotate(matrix, n);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
