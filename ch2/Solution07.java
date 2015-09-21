package Ch2;

public class Solution07 {
	static class LinkedListNode<T> {
		public T data;
		public LinkedListNode<T> next;

		public LinkedListNode(T data) {
			this.data = data;
		}
	}
	public static LinkedListNode<String> findIntersection(LinkedListNode<String> n1, LinkedListNode<String> n2) {
		if (n1==null || n2==null)
			return null;
		Result result1=getTailAndSize(n1);//Get the tail and the sizes.
		Result result2=getTailAndSize(n2);
		if(result1.tail!=result2.tail){ //If the tail nodes are different,there is no intersection.
			return null;
		}
		LinkedListNode<String> shorter=result1.size<result2.size?n1:n2;
		LinkedListNode<String> longer=result1.size<result2.size?n2:n1;
		longer=getKthNode(longer, Math.abs(result1.size-result2.size));
		while(shorter!=longer){ //Find the collision
			shorter=shorter.next;
			longer=longer.next;
		}
		return longer;
	}
	
static	class Result{
		public LinkedListNode<String> tail;
		public int size;
		public Result(LinkedListNode<String> tail, int size){
			this.tail=tail;
			this.size=size;
		}
	}
	static Result getTailAndSize(LinkedListNode<String> list){
		if(list==null)
			return null;
		int size=1;
		LinkedListNode<String> current=list;
		while(current.next!=null){
			size++;
			current=current.next;		
		}
		return new Result(current,size);
			
	}
static	LinkedListNode<String> getKthNode(LinkedListNode<String> head, int k){
		LinkedListNode<String> current=head;
		while(k>0 && current!=null){
			current=current.next;
			k--;
		}
		return current;
	}
public static void main(String args[]) {
	String firstStr = "1";
	String secondStr = "2";
	String thirdStr = "3";
	String fourthStr = "4";
	String fifthStr = "5";

	LinkedListNode<String> node_1 = new LinkedListNode<String>(firstStr);
	LinkedListNode<String> node_2 = new LinkedListNode<String>(secondStr);
	node_1.next = node_2;
	LinkedListNode<String> node_3 = new LinkedListNode<String>(thirdStr);
	node_2.next = node_3;
	LinkedListNode<String> node_4 = new LinkedListNode<String>(fourthStr);
	node_3.next = node_4;
	LinkedListNode<String> node_5 = new LinkedListNode<String>(fifthStr);
	node_4.next=node_5;

	System.out.println("*** Print contents of linked list before findInsection");
	LinkedListNode<String> current1 = node_1;
	System.out.println("List1");
	System.out.println(current1.data);
		for(int i=0;i<2;i++){	
			current1 = current1.next;
			System.out.println(current1.data);
		}

	System.out.println("List2");
	LinkedListNode<String> current2 = node_5;
	for(int j=0;j<2;j++){			
		System.out.println(current2.data);
		current2=current1;
	}
	LinkedListNode<String> result = findIntersection(current1, current2);
	System.out.println("*** Print contents of linked list AFTER findInsection");
    System.out.println(result.data);
	}

}
