package Ch5;
/* Given a positive integer, print the next smallest and the next largest number 
 * that have the same number of 1 bits in their binary representation. */
public class Solution04 {
	public static int[] count(int n){
		int []count={0,0};
		int c=n;
		while(((c&1)==0)&&(c!=0)){ // Calculate the number of zeros.
			count[0]++;
			c=c>>1;
		}
		while((c&1)==1){ //Calculate the number of ones.
			count[1]++;
			c=c>>1;
		}
		return count; 
	}
	public static int getNextSmallestLarger(int n, int[] count){ //Get the next smallest
		int smallestlarger =n;
		if(count[0]+count[1]==31 || count[0]+count[1]==0){// The biggest is with 31 bits of 1 and the smallest if with 1 bit of 0
			return -1;
		}
		smallestlarger=smallestlarger + (1 << count[0]) + (1 << (count[1]-1)) - 1;
		return smallestlarger;
	}
	public static int getNextLargestSmaller(int n, int[] count){//Get the next largest
		int largestsmaller =n;
	    largestsmaller =largestsmaller - (1 << count[1]) - (1 << (count[0]-1)) + 1;
		return largestsmaller;
	}
	public static void main (String args[]){
		int n=13948;//32-bit numbers
		System.out.println("n:"+Integer.toBinaryString(n));
		int [] count=count(n);
		int smallestlarger=getNextSmallestLarger(n, count);
		System.out.println("smallestlarger:"+Integer.toBinaryString(smallestlarger));
		int largestsmaller=getNextLargestSmaller(n, count);
		System.out.println("largestsmaller:"+Integer.toBinaryString(largestsmaller));
	}
}
