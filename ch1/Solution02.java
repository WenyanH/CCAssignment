package Ch1;

import java.util.Scanner;

public class Solution02 {
    String sort(String s){
	char[] sentence = s.toCharArray();//Transfer String into a char array
	java.util.Arrays.sort(sentence); //Sort the chars in an increasing number.
	return new String(sentence);
	}
    boolean permutation(String s, String t){
    	int lengths=s.length();
    	int lengtht=t.length();
    	if (lengths!=lengtht)
    		return false;
    	return sort(s).equals(sort(t));
    }
    public static void main(String args[]){
    	Scanner scanner = new Scanner(System.in);
    	while(scanner.hasNextLine()){
    		String inputStr1 = scanner.next();
    		String inputStr2 = scanner.next();
    		Solution02 obj = new Solution02();
    		System.out.print(obj.permutation(inputStr1, inputStr2)?"TRUE\n":"FALSE\n");	
    	}
    	scanner.close();
    }
}
