package Ch1;

import java.util.Scanner;

public class Solution01 {
	
boolean isUniqueChars(String s){
	if(s.length()>128) //Suppose it is a string of ASCII
		return false;
	boolean[] set=new boolean[128]; //The initial value of the array boolean[] is all zero.
	for(int i=0; i<s.length();i++){
		int value=s.charAt(i); //Get the number of the char i.
		if(set[value]){  //To test if the set[i] has been set 1 for true. If set, it is repeated.
			return false;
		}
		set[value]=true;
	}
        return true;
}

public static void main(String args[]){
	Scanner scanner = new Scanner(System.in);
	while(scanner.hasNextLine()){
		String inputStr = scanner.next();
		Solution01 obj = new Solution01();
		System.out.print(obj.isUniqueChars(inputStr)?"TRUE\n":"FALSE\n");	
	}
	scanner.close();
}
}

