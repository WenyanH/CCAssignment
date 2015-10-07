package Ch5;
/* You have an integer and you can flip exactly one bit from a 0 to a 1.
 * Write code to find the length of the longest sequence of 1s you could create. 
 * Running time: O(n); Running space: O(1)*/
public class Solution03 {//Suppose it is in 32-bit
public static int longestSequence(int n){
	if (n==-1){
		return 32;
	}
	int searchFor=0;
	int [] sequences={0,0,0};
	int maxSequence=1;
	for(int i=0;i<32;i++){
/* The first-time into means meet the first bit 1, this time it will jump the next if(searchFor==1);
 * The second-time into means meet the next bit 0, this time it will go into the next if(searchFor==1).
 * This time, the getMaxSequence() must be 1.;
 * The third-time into means meet the bit 1. 
 * If the bit 1 is just the next bit, the maxSequence must be sequences[0]+sequences[2]+1;
 * If the bit 1 is not the next bit, there is more than one bit 0, then return Math.max(sequences[0],sequences[2])+1  */
		if((n&1)!=searchFor){
			if(searchFor==1){//
				maxSequence=Math.max(maxSequence, getMaxSequence(sequences));
			}
			searchFor=n&1;
			shift(sequences);
		}
		sequences[0]++;
		n=n>>>1;
	}
	if (searchFor==0){
		shift(sequences);		
	}
	return Math.max(maxSequence, getMaxSequence(sequences));
}

public static int getMaxSequence(int[] sequences){
	if(sequences[1]==1){
		return sequences[0]+sequences[2]+1;
	}else if (sequences[1]==0){
		return Math.max(sequences[0],sequences[2]);
	}else{
		return Math.max(sequences[0],sequences[2])+1;
	}
}

public static void shift(int[]sequences){
	sequences[2]=sequences[1];
	sequences[1]=sequences[0];
	sequences[0]=0;
}

public static void main(String args[]){
	int n1=5;
	System.out.println("n:"+Integer.toBinaryString(n1));
	System.out.println(longestSequence(n1));
	}
}
