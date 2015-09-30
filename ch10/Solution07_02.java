package Ch10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/* Follow up: What if you have only 10MB of memory? 
 * Assume that all the values are distinct and we now have no more than one billion 
 * non-negative integers.*/
public class Solution07_02 {
public static int findMissedNumber(String filename) throws FileNotFoundException{
	int rangeSize=(1<<20); //The size of elements in each block, 2^20 bits one of a suitable size.
	int [] blocks=countPerBlock(filename, rangeSize);//Get the integer number of each block.
	int blockIndex=secondCheckBlock(blocks, rangeSize);//Get the blocks which need a further check for non-contained integers.
	if(blockIndex<0){
		return -1;
	}
	byte[] bitVector=getBitVector(filename, blockIndex, rangeSize);//Java does not have the type bit.
	int offset=findZero(bitVector);
	if(offset<0){
		return -1;
	}
	return blockIndex*rangeSize+offset;
}
public static int [] countPerBlock(String filename, int rangeSize) throws FileNotFoundException{
	int arraySize=(2^31-1)/rangeSize+1;//2^31-1 is the Integer_MAX_VALUE, arraSize is the number of blocks.
	int [] blocks=new int[arraySize];
	Scanner in =new Scanner (new FileReader(filename));
	while(in.hasNextInt()){
		int value=in.nextInt();
		blocks[value/rangeSize]++; //For the distinct integer input situation.
	}
	in.close();
	return blocks;
}
public static int secondCheckBlock(int [] blocks, int rangeSize){
	for(int i=0;i<blocks.length;i++){
		if(blocks[i]<rangeSize){// It must has some blank.
			return i;
		}
	}
	return -1;
}
/*For the chosen blocks that does not have enough contain, for a second check*/
public static byte[] getBitVector(String filename, int blockIndex, int rangeSize) throws FileNotFoundException{
	int start=blockIndex*rangeSize;
	int end=start+rangeSize;
	byte[] bitVector=new byte[rangeSize/4];//4 is the Byte.SIZE;
	Scanner in =new Scanner (new FileReader(filename));
	while(in.hasNextInt()){
		int value=in.nextInt();
		if(value>=start && value<end){
			int offset=value-start;
			bitVector[offset/4]=bitVector[offset/4]|=1<<(offset%4);
		}
	}
	in.close();
	return bitVector;
}
public static int findZero(byte[] bitVector){
	for(int i=0;i<bitVector.length;i++){
		if(bitVector[i]!=~0){//Check if there exists 0 in bitVector.
			for (int j=0; j<4;j++){
				if((bitVector[j]&(1<<j))==0){
					return i*4+j;
				}
			}
		}
	}
	return -1;
}
public static void main(String args[]) throws FileNotFoundException{
	String filename="1.avi";
	findMissedNumber(filename);
}
}
