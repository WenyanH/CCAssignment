package Ch1;

import java.util.Scanner;

public class Solution05 {
	public boolean oneEditArray(String s1, String s2){ //Define three situations.
		if (s1.length()==s2.length()){
			return oneEditReplace(s1, s2);
		}else if (s1.length()+1==s2.length()){
			return oneEditInsert(s1, s2);
		}else if (s1.length()-1==s2.length()){
			return oneEditRemove(s1, s2);
		}else{
			return false;
		}
	}
	
	public boolean oneEditReplace(String s1, String s2){
		 boolean difference=false;
		 for (int i=0;i<s1.length();i++){
			 if(s1.charAt(i)!=s2.charAt(i)){
				 if(difference){// More than one time of edits.
					 return false;
				 }
				difference=true;
			 }
		 }
		return true; 
	}	
	
	public boolean oneEditInsert(String s1, String s2){
		int index1=0;
		int index2=0;
		while(index2<s2.length()&&index1<s1.length()){
			if (s1.charAt(index1)!=s2.charAt(index2)){
				if(index1!=index2){//More than one time of edits.
					return false;
				}
				index2++;
			}else{
			index1++;
			index2++;
			}
		}
		return true;
	}
    public boolean oneEditRemove(String s1, String s2){
		return oneEditInsert(s2,s1);
	}
    public static void main(String args[]){
    	Scanner scanner = new Scanner(System.in);
    	while(scanner.hasNextLine()){
    		String inputStr1 = scanner.next();
    		String inputStr2 = scanner.next();
    		Solution05 obj = new Solution05();		
    		System.out.print(obj.oneEditArray(inputStr1, inputStr2)?"TRUE\n":"FALSE\n");	
    	}
    	scanner.close();
    }
} 
