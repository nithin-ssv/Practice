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
		
		list.printMiddleNode();
		
		
		
	}

}
