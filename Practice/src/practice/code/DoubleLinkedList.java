package practice.code;

import java.util.Scanner;

public class DoubleLinkedList {

	public class Node{
		int data;
		Node prev,next;
		
		public Node(int d) {
			data = d;
			prev=null;
			next=null;
		}
	}

	public Node head;
	
	public void addToNode(int data) {
		
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			return;
		}
		Node temp = head;
		while(temp.next!=null) {
			temp = temp.next;
		}
		temp.next = newNode;
		newNode.prev = temp;
		
	}
	
	public void printList() {
		Node temp = head;
		System.out.println("The elements in the list are :");
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the no. of nodes :");
		int n = scanner.nextInt();
		
		DoubleLinkedList dll = new DoubleLinkedList();
		System.out.println("Enter the elements :");
		for(int i=0;i<n;i++) {
			dll.addToNode(scanner.nextInt());
		}
		
		dll.printList();
	}

}
