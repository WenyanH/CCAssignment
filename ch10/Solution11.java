package Ch10;
/* In an array of integers, a "peak" is an element which is greater than or 
 * equal to the adjacent integers and a "valley" is an element which is less than 
 * or equal to the adjacent integers. For example, in the array {5,8,6,2,3,4,6}, 
 * {8.6} are peaks and {5,2} are valleys. Given an array of integers, 
 * sort the array into an alternating sequence of peaks and valleys. */

public class Solution11 {
	public static void sortPeakValley(int[] a){
		for(int i=1; i<a.length-1;i+=2){
			int peak=maxValue(a, i-1, i, i+1);
			if(i!=peak){
				swap(a, i, peak);
			}
		}
		for(int j=0; j<a.length;j++){
			System.out.print(a[j]+" ");
		}
	}
	public static int maxValue(int[]a, int b, int c, int d){ //Get the peak's location
		if(b<0 || b>=a.length){
			return -1;
		}
		if(c<0 || c>=a.length){
			return -1;
		}
		if(d<0 || d>=a.length){
			return -1;
		}
		int max=Math.max(a[b], Math.max(a[c], a[d]));
		if(a[b]==max){
			return b;
		}else if(a[c]==max){
			return c;
		}else{
			return d;
		}
	}
	public static void swap(int[]a, int left, int right){ //Put the peak into the right location
		int temp=a[left];
		a[left]=a[right];
		a[right]=temp;
	}
	public static void main(String args[]){
		int a[]={9,1,0,4,8,7};
		sortPeakValley(a);
	}
}
