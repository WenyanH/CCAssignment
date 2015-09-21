package Ch1;

import java.util.Scanner;

public class Solution04 {
public boolean isPermutationOfPalindrome(String s){
	int[] table=buildCharFrequencyTable(s);
	return checkOdd(table);
}
public boolean checkOdd(int[] table){
	boolean foundOdd=false;
	for(int count:table){
		if(count%2==1){
			if(foundOdd){
				return false;
			}
			foundOdd=true;
		}
	}
return true;
}
int getCharNum(Character c){
	int a=Character.getNumericValue('a');
	int z=Character.getNumericValue('z');
	int A=Character.getNumericValue('A');
	int Z=Character.getNumericValue('Z');
	int value=Character.getNumericValue(c);
	if(a<=value && value<=z){
		return value -a;
	}else if (A<=value && value<=Z){
		return value -A;
	}
	return -1;
}
int[] buildCharFrequencyTable(String s){
	int[] table=new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
	for (char c:s.toCharArray()){
		int x=getCharNum(c);
		if(x!=-1){
			table[x]++;
		}
	}
	return table;
}
public static void main(String args[]){
	Scanner scanner = new Scanner(System.in);
	while(scanner.hasNextLine()){
		String inputStr = scanner.next();
		Solution04 obj = new Solution04();
		System.out.print(obj.isPermutationOfPalindrome(inputStr)?"TRUE\n":"FALSE\n");	
	}
	scanner.close();
}
}
