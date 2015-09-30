package Ch10;
/* You have an array with all the numbers from 1 to N, where N is at most 32,000. 
 * The array may have duplicate entries and you do not know what N is. With only 4 kilobytes of memory available,
 * how would you print all duplicate elements in the array?*/

/*Use the bit vector to determine the location and the number*/
public class Solution08 {
	public static void duplication(int[] array){
		BitSet bs=new BitSet(32000);
		for(int i=0;i<=array.length-1;i++){
			int number=array[i];
			int bitIndex=number-1;
		    if(bs.get(bitIndex)){
		    	System.out.println(number);
		    }else{
		    	bs.set(bitIndex);
		    }
		}
	}
	static class BitSet{
		int[] bitSet;
		public BitSet(int size){
			bitSet=new int[(size>>5)+1]; //1 integer need 4 bytes. bitset starts at 0 while integer start at 1.
		}
		public boolean get(int index){
			int wordNumber=index>>5;
			int bitNumber=index & (0x1F);// Get the lowest 4 bit of the integer.
			return(bitSet[wordNumber] & (1<<bitNumber))!=0;
		}
		public void set(int index){
			int wordNumber=index>>5;
			int bitNumber=index & (0x1F);// Get the lowest 4 bit of the integer.
			bitSet[wordNumber]|=1<<bitNumber;
		}
	}
	public static void main(String args[]){
		int [] array=new int[32000];
		for(int i=0;i<=31990;i++){
			array[i]=i+1;
		}
		for(int j=1;j<=9;j++){
			array[31990+j]=j;
		}
		duplication(array);
	}
}
