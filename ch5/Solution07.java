package Ch5;
/* Write a program to swap odd and even bits in an integer with as few instructions as possible.*/
public class Solution07 {
public static int swapBit(int n){ //Suppose it is in 32-bit
	return (((n & 0xaaaaaaaa)>>>1)|((n & 0x55555555)<<1)); 
}//For swap.n & 0xaaaaaaaa means clean the odd bits,n & 0x55555555 means clean the even bits.
public static void main(String[] args){
	int n1=7;
	int n2=8;
	int n3=798;
	
	String input1=Integer.toBinaryString(n1);
	String result1=Integer.toBinaryString(swapBit(n1));	
	while(result1.length()!=input1.length()){
		if(result1.length()<input1.length()){
			result1="0"+result1;
		}else{
			input1="0"+input1;
		}
	}
	String input2=Integer.toBinaryString(n2);
	String result2=Integer.toBinaryString(swapBit(n2));	
	while(result2.length()!=input2.length()){
		if(result2.length()<input2.length()){
			result2="0"+result2;
		}else{
			input2="0"+input2;
		}
	}
	String input3=Integer.toBinaryString(n3);
	String result3=Integer.toBinaryString(swapBit(n3));	
	while(result3.length()!=input3.length()){
		if(result3.length()<input3.length()){
			result3="0"+result3;
		}else{
			input3="0"+input3;
		}
	}
	System.out.println("n1:"+input1);
	System.out.println("After Swap:"+result1);
	System.out.println("n2:"+input2);
	System.out.println("After Swap:"+result2);
	System.out.println("n3:"+input3);
	System.out.println("After Swap:"+result3);
}
}
