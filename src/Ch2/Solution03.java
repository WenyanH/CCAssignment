package Ch2;

	import java.util.LinkedList;

	public class Solution03 {
		
	    public static void print(LinkedList<String> head){ //Input and get the output of the Linkedlist
	    	System.out.print(head.get(0));
	    	for(int i =1; i<head.size(); i++){ //int i=1 in LinkedList
	    		System.out.printf("->%s", head.get(i));
	    	}
	    	System.out.println();
	    }
	    
	    public static void main(String[] args){ //For test
			LinkedList<String> build = new LinkedList<String>();
			build.add("1");
			build.add("2");
			build.add("3");
			build.add("4");
			build.add("5");
			print(build);
			int n = build.size()/2;
			build.remove(n);
			print(build);
		}
	}
