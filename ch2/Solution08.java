package Ch2;


public class Solution08 {
	static class LinkedListNode<T> {
		public T data;
		public LinkedListNode<T> next;

		public LinkedListNode(T data) {
			this.data = data;
		}
	}
static LinkedListNode<String> FindBeginning(LinkedListNode<String> head){
	LinkedListNode<String> slow=head;
	LinkedListNode<String> fast=head;
	while(fast!=null&&fast.next!=null){
		slow=slow.next;
		fast=fast.next.next;
		if(slow==fast){
			break;
		}
	}
	if(fast==null || fast.next==null){
		return null;
	}
	slow=head;
	while(slow!=fast){
		slow=slow.next;
		fast=fast.next;
	}
	return fast;
}
public static void main(String args[]) {
	String firstStr = "a";
	String secondStr = "b";
	String thirdStr = "c";
	String fourthStr = "d";

	LinkedListNode<String> node_1 = new LinkedListNode<String>(firstStr);
	LinkedListNode<String> node_2 = new LinkedListNode<String>(secondStr);
	node_1.next = node_2;
	LinkedListNode<String> node_3 = new LinkedListNode<String>(thirdStr);
	node_2.next = node_3;
	LinkedListNode<String> node_4 = new LinkedListNode<String>(fourthStr);
	node_3.next = node_4;
	node_4.next = node_2;
	

	System.out.println("*** Print contents of linked list before findBeginning");
	LinkedListNode<String> current = node_1;

		for(int i=0;i<5;i++){
			System.out.println(current.data);
			current = current.next;
		}
		
	LinkedListNode<String> result = FindBeginning(node_1);
	System.out.println("*** Print contents of linked list AFTER findBeginning");
    System.out.println(result.data);

}
}
