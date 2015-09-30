package Ch10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*Write a method to sort an array of strings so that all the anagrams are next to the other.*/

public class Solution02 {// Sort the strings,Get the key words of the strings for anagram classification.
public static String unify(String s){
	char[] content=s.toCharArray();
	Arrays.sort(content);
	return new String(content);
}
public static void sort(String[] array){ //Use the HashMap to store the same anagrams in one group.
	HashMap<String, ArrayList<String>> map=new HashMap<String, ArrayList<String>>();
	for (int i=0;i<=array.length-1;i++){
		String key=unify(array[i]);
		if (!map.containsKey(key)){ //If the key has not exists, add the new key and create the new ArrayList.
			map.put(key, new ArrayList<String>());
		}
		map.get(key).add(array[i]);
	}
	int index=0;
	for(String key: map.keySet()){
		ArrayList<String> list=map.get(key);
		for(int j=0; j<=list.size()-1;j++){
			array[index]=list.get(j);
			System.out.print(array[index]+" ");
			index++;
		}
	}
}
public static void main(String args[]) {
	String[] test={"cat","ccc","tac","acct","act","tcca","tact"};
	sort(test);	
}
}
