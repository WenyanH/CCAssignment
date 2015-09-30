package Ch10;
/* Given a sorted array of strings that is interspersed with empty strings, 
 * write a method to find the location of a given string.*/
public class Solution05 {
public static int search(String[] s, String givenString, int first, int last){
	if(first>last){
		return -1;
	}
	int mid=(first+last)/2;
/*Find the closest non-empty string if mid is empty*/
	if(s[mid].isEmpty()){
		int left=mid-1;
		int right=mid+1;
		while(true){
			if(left<first && right>last){
				return -1;
			}else if (left>=first && !s[left].isEmpty()){
				mid=left;
				break;
			}else if (right<=last && !s[right].isEmpty()){
				mid=right;
				break;
			}
			left--;
			right++;
		}
	}
/*recursive for dichotomy*/
	if (givenString==s[mid]){
		return mid;
	}else if(s[mid].compareTo(givenString)>0){//Search right
		return search(s, givenString, first, mid-1);
	}else{
		return search(s, givenString, mid+1, last);
	}
}
public static int search(String [] s, String givenString){
	if(s==null || givenString==null || givenString==""){
		return -1;
	}
	return search(s, givenString, 0, s.length-1);
}
public static void main(String args[]){
	String[] test={"a","","","b","c","","d"};
	System.out.println(search(test, "a"));
	System.out.println(search(test, "b"));
	System.out.println(search(test, "c"));
	System.out.println(search(test, "d"));
}
}
