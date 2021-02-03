package practice.code;

import java.util.Scanner;

public class CircularLinkedList {

	public class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}

	Node head = null;
	
	public void addToList(int data) {
		
		if(head == null) {
			head = new Node(data);
			head.next = head;
			return;
		}
		
		Node newNode = new Node(data);
		Node temp = head;
		while(temp.next!=head) {
			temp = temp.next;
		}
		newNode.next = temp.next;
		temp.next = newNode;
		
	}
	
	public void printList() {
		
		System.out.println("\nThe elements in the list are :");
		Node temp = head;
		do {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}while(temp!=head && temp.next!=null);
		System.out.print(temp.data+" ");
		
	}
	
	public void insertInSortedList(int data) {
		
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			return;
		}
		
		Node temp = head,prev=null;
		
		if(data<head.data) {
			prev = head;
			while(prev.next!=head) {
				prev = prev.next;
			}
			prev.next = newNode;
			newNode.next = head;
			head = newNode;
			return;
		}
		
		while(temp!=head || prev==null) {
			
			if(temp.data>data) {
				prev.next = newNode;
				newNode.next = temp;
				return;
			}
			prev = temp;
			temp = temp.next;
		}
		
		prev.next = newNode;
		newNode.next = head;
		return;
	}
	
	
	public void deleteNodeWithGivenData(int data) {
		
		Node temp = head;
		Node prev = null;
		while(temp!=head || prev==null) {
			if(temp.data == data) {
				if(temp == head) {
					prev = head;
					while(prev.next!=head) {
						prev = prev.next;
					}
					prev.next = head.next;
					head = prev.next;
					temp.next = null;
					
				}else {
					prev.next = temp.next;
					temp.next = null;
				}
				
				printList();
				return;
			}else {
				prev = temp;
				temp = temp.next;
			}
		}
		
		System.out.println("Element not found ...");
		
	}
	
	public boolean isCircular() {
		
		Node slow = head,fast = head;
		
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(fast == head || slow == head) {
				return true;
			}
			
			if(slow == fast) {
				if(slow == head) {
					return true;
				}
				return false;
			}
		}
		
		return false;
	}
	
	public void process() {
		Node prev = head;
		while(prev.next!= head) {
			prev = prev.next;
		}
		// prev.next = null;
		prev.next = head.next.next;
	}
	
	public void length() {
		
		Node temp = head;
		int length=1;
		while(temp.next!=head) {
			temp = temp.next;
			length++;
		}
		System.out.println("\n The length of the list is "+length);
	}
	
	public void splitNNodesToNewCLL(int k) {
		
		Node temp = head;
		for(int i=1;i<k;i++) {
			temp = temp.next;
		}
		
		Node newhead = temp.next;
		temp.next = head;
		
		Node sectemp = newhead;
		while(sectemp.next!=head) {
			sectemp = sectemp.next;
		}
		sectemp.next = newhead;
		
		printList();
		
		System.out.println("\nThe second list is :");
		temp = newhead;
		do{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}while(temp!=newhead);
		
		System.out.print(temp.data+" ");
		
	}
	
	public void deleteNodesAtOddPositionsInList() {
		
		Node temp = head,prevNext = head;
		while(prevNext.next!=head) {
			prevNext = prevNext.next;
		}
		prevNext.next = head.next;
		head = head.next;
		temp.next = null; // deleting old head
		
		Node curr = head;
		temp = curr.next;
		
		while(curr.next!=head && temp.next!=head) {
			curr.next = temp.next;
			temp.next = null;
			curr = curr.next;
			temp = curr.next;
		}
		
		if(curr.next!=head) {
			curr.next = temp.next;
			temp.next = null;
		}
		
		printList();
	}
	
	public void deleteAllNodesAtEvenPositionsInList() {
		
		Node prev = head, temp = head.next;
		
		do{
			prev.next = temp.next;
			temp.next = null;
			prev = prev.next;
			temp = prev.next;
		}while(prev!=head && temp!=head);
		
		printList();
		
	}
	
	public void search(int d) {
		
		Node temp = head;
		int count= 1;
		do {
			
			if(temp.data == d) {
				System.out.println("The given node is found at "+count);
				return;
			}
			temp = temp.next;
			count++;
			
		}while(temp!=head);
		
		System.out.print("Data not found..");
	}
	
	public void findLuckyNode() {
		
		Node curr = head, temp = curr.next;
		
		while(curr!=temp) {
			curr.next = curr.next.next;
			temp.next = null;
			curr = curr.next;
			temp = curr.next;
		}
		
		System.out.print("The lucky node is : "+curr.data);
		
	}
	
	public void findMinAndMaxElementsFromList() {
		
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		
		Node temp = head;
		
		do {
			int curData = temp.data;
			if(curData>max) {
				max = curData;
			}
			if(curData<min) {
				min = curData;
			}
			temp = temp.next;
		}while(temp!=head);
		
		System.out.print("\nThe min value is "+min+" and max value is "+max);
		
	}
	
	public void alternateFirstAndLastNodesInList() {
		
		Node temp = head,prev = null;
		
		while(temp.next!=head) {
			prev = temp;
			temp = temp.next;
		}
		Node oldhead = head;
		
		temp.next = head.next;
		head = temp;
		prev.next = oldhead;
		oldhead.next = temp;
		
		printList();
		
	}
	
	public static void main(String[] args) {
		
		System.out.println("Enter the no. of elements :");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		CircularLinkedList cll = new CircularLinkedList();
		
		System.out.println("Enter the elements :");
		
		for(int i=0;i<n;i++) {
			int d = scanner.nextInt();
			cll.addToList(d);
		}
		
		cll.printList();
		
//		cll.deleteNodeWithGivenData(5);

//		cll.insertInSortedList(5);
//		cll.printList();
		
		//for setting loop or converting to SLL.
//		cll.process();
//		cll.printList();
//		System.out.println("\nGiven linked list is circular : "+cll.isCircular());
		
//		cll.length();
//		cll.splitNNodesToNewCLL(3);
		
//		cll.deleteNodesAtOddPositionsInList();
		
//		cll.findLuckyNode();
//		cll.deleteAllNodesAtEvenPositionsInList();
		
//		cll.search(5);
		
//		cll.findMinAndMaxElementsFromList();
		
//		cll.alternateFirstAndLastNodesInList();
		
	}

}
