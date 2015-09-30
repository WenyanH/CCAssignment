package Ch10;

/* You are given two sorted arrays, A and B, 
 * where A has a large enough buffer at the end to hold B.
 * Write a method to merge B into A in sorted order. */
public class Solution01 {
public static void merge(int[]a,int[]b,int sizeA, int sizeB){
	int indexA=sizeA-1; //Have the pointers;
	int indexB=sizeB-1;
	int indexMerge=sizeA+sizeB-1;
	while (indexB>=0){
		if(indexA>=0 && a[indexA]>=b[indexB]){ //Insertion sort
			a[indexMerge]=a[indexA];
			indexA--;
		}else{
			a[indexMerge]=b[indexB];
			indexB--;
		}
		indexMerge--;
	}
	for(int i=0; i<=(sizeA+sizeB-1);i++){
		System.out.print(a[i]+" ");
	}
}
public static void main(String args[]) {
	int[]a={1,3,5,7,9,11,13,15,0,0,0,0,0,0,0};
	int[]b={2,4,6,8,10,12,14};
	int sizeA=8;
	int sizeB=7;
	merge(a,b,sizeA,sizeB);
	
}
}
