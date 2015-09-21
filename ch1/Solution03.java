package Ch1;

import java.util.Scanner;

public class Solution03 {
public String space(char[] s, int length1){ 
	int spaceCount=0;
	int length2;
	int i;
	for(i=0;i<length1;i++){
		if(s[i]==' '){
			spaceCount++;  //Calculate the number of spaces.
		}
	}
	length2=length1+spaceCount*2; //Get the new length of the new string.
	s[length2]='\0'; //Find the end.
	for(i=length1-1;i>=0;i--){
		if (s[i]==' '){        //Replace the space with "20%".
			s[length2-1]='0';
			s[length2-2]='2';
			s[length2-3]='%';
			length2=length2-3;
		}
		else{
			s[length2-1]=s[i];
			length2=length2-1;
		}
	}
	return String.copyValueOf(s);
}
public static void main(String args[]){
	Scanner scanner = new Scanner(System.in);
	while(scanner.hasNextLine()){
		String inputStr = scanner.nextLine(); //Get the original string.
		String inputNum = scanner.nextLine(); //Get the total length of the original string.
		int num = Integer.parseInt(inputNum); 
		Solution03 obj = new Solution03();
		char[] input = new char[inputStr.length()+100];//Create a new array, assume that the string has sufficient space at the end.
		System.arraycopy(inputStr.toCharArray(), 0, input, 0, inputStr.length());//Copy the original string into the array
		System.out.print(obj.space(input,num)+"\n");//Do the transformation
		
	}
	scanner.close();
}
}
