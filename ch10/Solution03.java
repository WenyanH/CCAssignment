package Ch10;
/* Given a sorted array of n integers that has been rotated an unknown number of times, 
 * write code to find an element in the array.
 * You may assume that the array was originally sorted in increasing order.*/
public class Solution03 {
public static int search(int[]a,int first, int last, int x){
	int mid=(first+last)/2;
	if (x==a[mid]){
		return mid;
	}
	if (first>last){
		return -1;
	}
//All recursive.
	if(a[first]<a[mid]){ //Left part has a normal order.
		if(x>=a[last] && x<a[mid]){  
			return (search(a, first, mid-1, x));
		}else{
			return (search(a, mid+1, last, x));
		}
	}else if(a[first]>a[mid]){//Right part has a normal order.
		if (x>a[mid] && x<a[last]){
			return (search(a, mid+1, last, x));
		}else{
			return (search( a, first, mid-1, x));
		}		
	}else if(a[first]==a[mid]){
	   	if(a[last]!=a[mid]){ //Right part has a normal order.
	   		return (search(a, mid+1, last, x));
	   	}else{ //Both parts have the possiblity.
	   		int result=search(a, first, mid-1, x);
	   		if (result==-1){
	   			return (search(a, mid+1, last, x));
	   		}else{
	   			return result;
	   		}
	   	}
	}
	return -1;
}
public static int search(int[]a, int x){
	if(a==null){
		return -1;
	}
	return search(a, 0, a.length-1, x);
}
public static void main(String args[]){
	int []a={2,2,2,3,4,2};
	int []b={7,8,9,1,2,3,4,5,6};
	System.out.println(search(a,3));
	System.out.println(search(b,2));
	
}
}
