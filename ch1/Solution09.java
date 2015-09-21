package Ch1;

import java.util.Scanner;

public class Solution09 {
public boolean isRotation(String s1, String s2){
	int length1=s1.length();
	int length2=s2.length();			
	if(length1!=length2) //Judge whether the lengths of s1 & s2 are the same.
		return false;
	else
	{
		if (length1>0){
			String s=s1+s1; //Splice the strings. If s2 is the rotation of s1, it belongs to s.
			return isSubstring(s, s2);
		}
		else 
			return false;
	}
}

public boolean isSubstring(String s, String s2){
	if (s.indexOf(s2)>=0) //Judge whether the s2 is the substring of s.
		return true;
	else
		return false;
}
public static void main(String args[]){
	Scanner scanner = new Scanner(System.in);
	while(scanner.hasNextLine()){
		String inputStr1 = scanner.next();
		String inputStr2 = scanner.next();
		Solution09 obj = new Solution09();		
		System.out.print(obj.isRotation(inputStr1, inputStr2)?"TRUE\n":"FALSE\n");	
	}
	scanner.close();
}
}
