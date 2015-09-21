package Ch2;

import java.util.LinkedList;

public class Solution05_1 {
	public static int reverseAddList(LinkedList<Integer> head) {
		int sum = 0;
		for (int i = 0; i < head.size(); i++) {
			sum += (int) (head.get(i) * Math.pow(10, i));
														
		}
		return sum;
	}// return a reversing number
	
	public static void print(int num) {
		int count=0;
		int i=0;
		int n=num;
		while(n!=0){			
			n=(n-n%10)/10;
			count++;
		}
		int[]n1 = new int[count];
		while (num != 0) {							
			n1[i]=num%10;
			num=num/10;
			i++;			
			}			
				int []n2=new int[count];
				for(int j=count-1;j>=1;j--){
					n2[j]=n1[j];
				System.out.printf(n2[j]+"->");
			}
				System.out.print(n1[0]);
			System.out.println();
		}			
			
	
	public static void main(String[] args) {
		LinkedList<Integer> build1 = new LinkedList<Integer>();
		build1.add(1);
		build1.add(3);
		build1.add(5);
		//Print(addList(build1));
		LinkedList<Integer> build2 = new LinkedList<Integer>();
		build2.add(7);
		build2.add(6);
		build2.add(2);
		//Print(addList(build2));
		int sum = reverseAddList(build1) + reverseAddList(build2);
		System.out.println(sum);
		print(sum);
	}
	
}

