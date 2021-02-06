package practice.code;

import java.util.Scanner;

class Node{
	
	int data;
	Node next;
	Node(int d){
		data = d;
		next = null;
	}
	
}

public class LinkedList {

	Node head;
	
	public static Node addNodeToList(int data, Node head) {
		// Insertion at the end //
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
		}else {
			Node temp = head;
			while(temp.next!=null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
		return head;
	}
	
	public  void printList() {
		
		Node temp = head;
		System.out.println("The elements in the list are :");
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		
	}
	
	public void insertAtBeginning() {
		
		System.out.println("Enter the element to insert :");
		Scanner scanner = new Scanner(System.in);
		int elem = scanner.nextInt();
		
		Node newNode = new Node(elem);
		newNode.next=head;
		head = newNode;
		
		printList();
	}
	
	public  void deleteElement() {
		
		System.out.println("Enter the element to delete :");
		Scanner scanner = new Scanner(System.in);
		int elem = scanner.nextInt();
		
		Node prev=null,temp=head;
		
		while(temp!=null) {
			if(temp.data==elem) {
				if(prev==null) {
					//if prev=null and elem is found, then it must be in head
					head=temp.next;
					temp.next=null;
				}else {
					prev.next=temp.next;
					temp.next=null;
				}
				System.out.println("Element is deleted :"+elem);
				printList();
				return;
			}
			prev = temp;
			temp = temp.next;
		}
		System.out.println("Element is not found..");
		return;
	}
	
	public void deleteAtGivenPos() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the position of Node to delete :");
		int pos = scanner.nextInt();
		//Considering the positions starting from zero
		
		Node temp = head;
		Node curr;
		boolean isDeleted = false;
		
		if(pos==0) {
			head = temp.next;
			temp.next=null;
			isDeleted = true;
		}
		
		for(int i=0;i<pos && temp!=null; i++) {
			
			if(i==pos-1 && temp.next!= null) {
				curr = temp.next;
				temp.next = curr.next;
				curr.next = null;
				isDeleted = true;
			}else {
				temp = temp.next;
			}
			
		}
		
		if(isDeleted) {
			System.out.println("The element is deleted at given pos ..");
		}else {
			System.out.println("Element could not be found... ");
		}
		
		printList();
	}
	
	public void pairWiseSwapElementsOfLinkedList() {
		
		if(head == null) {
			System.out.println("Linked List is empty ...");
			return;
		}
		
		Node temp = head;
		int t;
		while(temp!=null && temp.next!=null) {
			t = temp.data;
			temp.data = temp.next.data;
			temp.next.data = t;
			temp = temp.next.next;
		}
		
		printList();
	}
	
	public void pairWiseSwapNodesofLinkedList() {
		
		if(head == null) {
			System.out.println("Linked List is Empty ...");
			return;
		}
		
		Node curr=head,temp=head.next,prev=null;
		
		while(curr!=null && curr.next!=null) {
			
			temp = curr.next;
			
			curr.next = temp.next;
			temp.next = curr;
			if(prev!=null) {
				prev.next = temp;
			}
			if(curr == head) {
				head = temp;
			}
			prev = curr;
			curr = curr.next;
			
		}
		
		printList();
		
	}
	
	public void reverse() {
		
		if(head == null) {
			System.out.println("Linked List is empty...");
		}
		
		Node prev=null,curr=head,next=null;
		
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		printList();
	}
	
	public void loopExists() {
		
		Node slow=head,fast=head;
		
		while(slow.next!=null && fast.next!=null && fast.next.next!=null) {
			
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				System.out.println("Loop Found at.."+slow.data);
				
				//fnding the length of the loop
				Node temp = slow.next;
				int length =1;
				while(temp!=slow) {
					temp = temp.next;
					length++;
				}
				System.out.println("Length of the loop is "+length);
				temp = head;
				Node prev = null;
				while(slow!=temp) {
					prev=slow;
					slow = slow.next;
					temp = temp.next;
				}
				System.out.println("Loop is starting at :"+slow.data);
				//remving the loop
				prev.next=null;
				printList();
				return;
			}
			
		}
		
		System.out.println("Loop not found... ");
		
	}
	
	public static void deleteNodeWithOutHead(Node temp) {
		
		if(temp.next!=null) {
			Node toDel = temp.next;
			temp.data = temp.next.data;
			temp.next = temp.next.next;
			toDel.next = null;
		}else {
			System.out.println("We cannot do this... We need head..");
		}	
		
	}
	
	public void printMiddleNode() {
		
		Node slow=head, fast=head; 
		while( fast.next!=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println("The middle element is :"+slow.data);
		
	}
	
	public void printNthNodeFromLast(int pos) {
		
		Node slow=head,fast=head;
		int i=0;
		for( i=1; i<pos && fast!=null ; i++) {
			fast = fast.next;
		}
		if(fast==null) {	
			System.out.println(" Given list is small");
			return;
		}
		while(fast.next!=null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		System.out.println("The data of the node at position "+pos+" from end is "+slow.data);
		
	}
	
	public void swapNodes(int from, int to) {
		
		Node start = head,end= head,preStart = null,preEnd = null;
		for(int i=1;i<from && start!=null;i++) {
			preStart = start;
			start = start.next;
		}
		for(int i=1;i<to && end!=null;i++) {
			preEnd = end;
			end = end.next;
		}
		
		if(start==null || end==null) {
			System.out.println("Invalid Input");
			return;
		}
		
		Node temp = start.next;
		if(preStart!=null) {
			preStart.next = end;
		}
		
		start.next = end.next;
		preEnd.next = start;
		end.next = temp;
		
		if(start == head) {
			head = end;
		}
		
		printList();
		
	}
	
	public void deleteDuplicatesInSortedLinkedList() {
		
		Node slow=head,fast=slow.next;
		boolean duplicate = false;
		
		while(fast!=null) {
			if(slow.data == fast.data) {
				fast = fast.next;
				duplicate = true;
			}else if(duplicate) {
				slow.next = fast;
				duplicate = false;
			}else {
				fast = fast.next;
				slow = slow.next;
			}	
		}
		
		if(duplicate) {
			slow.next = fast;
		}
		
		printList();
	}
	
	public void moveLastNodeToFirst() {
		
		Node curr=head;
		
		while(curr.next.next != null) {
			curr = curr.next;
		}
			
		curr.next.next = head;
		head = curr.next;
		curr.next = null;
		
		printList();
		
	}
	
	public void isPalindrome() {
		
		Node first=head,second=head;
	// finding the midpoint	
		while(second.next!=null && second.next.next!=null) {
			
			first = first.next;
			second = second.next.next;
		}
	
	//reversing the second half
		Node curr = first.next;
		Node prev = reverseTheList(curr);
		first.next = prev;
		
		printList();
		
	//checking the values	
		Node temp = head;
		first = first.next;
		boolean isPalindrome = true;
		while(first != null) {
			if(temp.data != first.data) {
				isPalindrome = false;
				break;
			}
			first = first.next;
			temp = temp.next;
		}
		
		if(isPalindrome) {
			System.out.println("\n\nGiven input is palindrome ..");
		}else {
			System.out.println("\n\nNot a palindrome ..");
		}
		
		first=head;
		second=head;
		while(second.next!=null && second.next.next!=null) {
			
			first = first.next;
			second = second.next.next;
		}
	//reversing back the second half
		curr = first.next;
		prev = reverseTheList(curr);
		first.next = prev;
		
		printList();
			
	}
	
	public Node reverseTheList(Node curr) {
		
		Node prev=null;
		Node temp = null;
		
		while(curr!=null) {
			
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		
		return prev;
	}
	
	public void intersectionPointOfTwoLists(Node head2) {
	
//		Using Two loops....
		
//		Node temp = head, sectemp = null;
//		
//		while(temp!=null) {
//			
//			sectemp = head2;
//			while(sectemp !=null) {
//				if(temp == sectemp) {
//					System.out.println("Intersection point is found at "+temp.data);
//					return;
//				}
//				sectemp = sectemp.next;
//			}
//			
//			temp = temp.next;
//		}
//		
//		System.out.println("No Intersection point.. ");
//		Time Complexity = O(mn)
		
		Node temp = head, sectemp = head2;
		int c1=0,c2=0;
		
		while(temp!=null) {
			c1++;
			temp = temp.next;
		}
		
		while(sectemp !=null) {
			c2++;
			sectemp = sectemp.next;
		}
		
		if(c1>c2) {
			temp = head;
			sectemp = head2;
		}else {
			temp = head2;
			sectemp = head;
		}
		
		int diff = MathUtil.abs(c1-c2);
		
		for(int i=0;i<diff;i++) {
			temp = temp.next;
		}
		
		while(temp!=null && sectemp!=null) {
			
			if(temp == sectemp) {
				System.out.println("Intersection point is found at "+temp.data);
				return;			
			}
			temp = temp.next;
			sectemp = sectemp.next;
		}
		
		System.out.println("No Intersection point.. ");

		//		Time Complexity = O(m+n)	
		
	}
	
	public void segeregateOddAndEvenNodes() {
		
		// All Even nodes at the beginning and order among the even and odd numbers should be preserved
		
		Node lastNode = head,temp= head,prev = null;
		
		while(lastNode.next!=null) {
			lastNode = lastNode.next;
		}
		
		Node oddtemp = lastNode;
		
		while(temp!= lastNode) {
			
			if(temp.data % 2 != 0 ) {
				
				if(temp == head) {
					oddtemp.next = temp;
					oddtemp = temp;
					temp = temp.next;
					head = temp;
				}else {
					prev.next = temp.next;
					oddtemp.next = temp;
					oddtemp = temp;
					temp = prev.next;
				}
				
			}else {
				prev = temp;
				temp = temp.next;
			}
			
		}
		
		if(lastNode.data %2 !=0 && lastNode.next!=null ) {
			
			if(prev!=null) {
				prev.next = lastNode.next;
			}else {
				head = lastNode.next;
			}
			
			oddtemp.next = lastNode;
			oddtemp = lastNode;
		}
		
		oddtemp.next = null;
		
		printList();
		
	}
	
	public void multiplyTwoNumbersRepresentedByLL(Node head2) {
		
		Node first = head, second= head2;
		int firstNum=0,secondNum=0;
		
		while(first!=null) {
			firstNum = firstNum*10 + first.data;
			first = first.next;
		}
		
		while(second!=null) {
			secondNum = secondNum*10 + second.data;
			second = second.next;
		}
		
		System.out.println("The product is :"+ (firstNum*secondNum));
		
	}
	
	public void segregateOs1s2s() {
		
		Node temp = head;
		int c0=0,c1=0,c2=0;
		
		while(temp!=null) {
			if(temp.data == 0) {
				c0++;
			}else if(temp.data == 1) {
				c1++;
			}else if(temp.data == 2) {
				c2++;
			}
			temp = temp.next;
		}
		
		temp = head;
		for(int i=0;i<c0;i++) {
			temp.data = 0;
			temp = temp.next;
		}
		for(int i=0;i<c1;i++) {
			temp.data = 1;
			temp = temp.next;
		}
		for(int i=0;i<c2;i++) {
			temp.data = 2;
			temp = temp.next;
		}
		
		printList();
	}
	
	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		System.out.println("Enter the size of the list : ");
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		System.out.println("Enter the elements :");
		
		for(int i=0;i<size;i++) {
			int data = scanner.nextInt();
			list.head = addNodeToList(data,list.head);
		}
		
		list.printList();
		
//		list.deleteElement();		
//		list.insertAtBeginning();
//		list.deleteAtGivenPos();
//		list.pairWiseSwapElementsOfLinkedList();
//		list.pairWiseSwapNodesofLinkedList(t);
//		list.reverse();
//		list.head.next.next.next.next.next.next.next.next.next.next.next = list.head.next.next.next.next.next.next;
//		list.loopExists();

//		deleteNodeWithOutHead(list.head.next.next.next);
//		list.printList();
		
//		list.printMiddleNode();
//		list.printNthNodeFromLast(4);		
//		list.swapNodes(1, 4);
//		list.deleteDuplicatesInSortedLinkedList();
		
//		list.moveLastNodeToFirst();
//		list.isPalindrome();

/*		
// 		Linked List intersection problem

		Node head2=null;
		System.out.println("\n\nEnter the size of the second list : ");
		scanner = new Scanner(System.in);
		size = scanner.nextInt();
		System.out.println("\n\nEnter the elements of second List :");
		
		for(int i=0;i<size;i++) {
			int data = scanner.nextInt();
			head2 = addNodeToList(data,head2);
		}
		
		Node temp = head2;
		System.out.println("\n\nThe elements in the second list are :");
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		
//		list.head.next.next.next.next = head2.next.next.next.next.next;		
//		list.intersectionPointOfTwoLists(head2);	
*/
		
//		list.segeregateOddAndEvenNodes();
//		list.multiplyTwoNumbersRepresentedByLL(head2);
		
		list.segregateOs1s2s();
		
	}

}
