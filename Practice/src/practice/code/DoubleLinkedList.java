package practice.code;

import java.util.HashSet;
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
		Node temp = head,prev=null;
		System.out.println("The elements in the list are :");
		while(temp!=null) {
			System.out.print(temp.data+" ");
			prev = temp;
			temp = temp.next;
		}
		System.out.println("\n Travel backwards ..");
		while(prev!=null) {
			System.out.print(prev.data+" ");
			prev = prev.prev;
		}
		
	}
	
	public void addAfterGivenNode(int d,int key) {
		Node temp = head;
		while(temp!=null) {
			if(temp.data == key) {
				Node newNode = new Node(d);
				newNode.next = temp.next;
				newNode.prev = temp;
				temp.next = newNode;
				if(newNode.next!=null) {
					newNode.next.prev = newNode;
				}
				printList();
				return;
			}
			temp = temp.next;
		}
		System.out.println("\nKey not found..");
	}
	
	public void addBeforeGivenNode(int d,int key) {
		
		Node temp = head;
		while(temp!=null) {
			if(temp.data == key) {
				Node newNode = new Node(d);
				newNode.next = temp;
				newNode.prev = temp.prev;
				temp.prev = newNode;
				if(newNode.prev!=null) {
					newNode.prev.next = newNode;
				}else {
					head = newNode;
				}
				printList();
				return;
			}
			temp = temp.next;
		}
		System.out.println("\nKey not found ..");
		
	}
	
	public void delete(int key) {
		Node temp = head;
		while(temp!=null) {
			if(temp.data == key) {
				if(temp.next!=null) {
					temp.next.prev = temp.prev;
				}
				if(temp.prev!=null) {
					temp.prev.next = temp.next;
				}else {
					head = temp.next;
				}
				temp.next = null;
				printList();
				return;
			}
			temp = temp.next;
		}
		System.out.println("\nKey not found ...");
	}
	
	public void reverse() {
		
		Node curr = head,temp = null,prev=null;
		while(curr!=null) {
			prev = temp;
			temp = curr.next;
			curr.next = curr.prev;
			curr.prev = temp;
			curr = temp;
		}
		head = prev;
		printList();
	}
	
	/*********************************   https://www.geeksforgeeks.org/remove-duplicates-unsorted-doubly-linked-list/  *************/
	
	public void removeDuplicates() {
		
		Node outer = head;
		while(outer!=null) {
			Node inner = outer.next;
			while(inner!=null) {
				Node temp = inner.next;
				if(inner.data == outer.data) {
					if(inner.next !=null) {
						inner.next.prev = inner.prev;
					}
					inner.prev.next = inner.next;
					inner.next = null;
					inner.prev = null;
				}
				inner = temp;
			}
			outer = outer.next;
		}
		printList();
	}
	
	public void removeDuplicatesUsingHashing() {
		
		Node temp = null, curr=head;
		HashSet dataSet = new HashSet();
		while(curr!=null) {
			temp = curr.next;
			if(dataSet.contains(curr.data)) {
				if(curr.next!=null) {
					curr.next.prev = curr.prev;
				}
				curr.prev.next = curr.next;
				curr.prev = null;
				curr.next = null;
			}else {
				dataSet.add(curr.data);
			}
			curr = temp;
		}
		printList();
	}
	
	/**********************   https://www.geeksforgeeks.org/find-pairs-given-sum-doubly-linked-list/    ********************/
	public void findPairsWithGivenSumInSortedDLL(int givenSum) {
		
		Node front = head,back = head;
		while(back.next!=null) {
			back = back.next;
		}
		
		int curSum=0;
		boolean found = false;
		while(front!=back) {
			curSum = front.data + back.data;
			if(curSum > givenSum) {
				back = back.prev;
			}else if(curSum < givenSum){
				front = front.next;
			}else {
				System.out.println("\n Pair  is : ( "+front.data+" , "+back.data+" )");
				back = back.prev;
				found = true;
			}
		}
		
		if(!found) {
			System.out.println("\nNo Pair found ... ");
		}
	}
	
	/************************ https://www.geeksforgeeks.org/count-triplets-sorted-doubly-linked-list-whose-sum-equal-given-value-x/  ************/
	
	public void findTripletsWithGivenSum(int givenSum) {
		
		Node first = head;
		boolean found = false;
		while(first.next.next!=null) {
			
			Node second = first.next;
			Node third = first.next.next;
			while(third.next!=null) {
				third = third.next;
			}
			int curSum = 0;
			
			while(second!=third) {
				curSum = first.data + second.data + third.data;
				if(curSum > givenSum) {
					third = third.prev;
				}else if(curSum < givenSum) {
					second = second.next;
				}
				else {
					System.out.println("\nTriplet found ( "+first.data+" , "+second.data+" , "+third.data+" )");
					found = true;
					second = second.next;
				}
			}
			first = first.next;
		}
		
		if(!found) {
			System.out.println("Triplet could not be found... ");
		}
		
	}
	
	public void rotateCounterClockWise(int key) {
		
		Node temp = head;
		for(int i=1;i<key;i++) {
			temp = temp.next;
		}
		
		Node lastNode = head;
		while(lastNode.next!=null) {
			lastNode = lastNode.next;
		}
		
		lastNode.next = head;
		head.prev = lastNode;
		head = temp.next;
		head.prev = null;
		temp.next = null;
		
		printList();
		
	}
	
	public void isPalindrome() {
		
		Node front=head,back=head;
		while(back.next!=null) {
			back = back.next;
		}
		while(front!=back && back.next!=front) {
			if(front.data != back.data) {
				System.out.println("\nNot a palindrome... ");
				return;
			}
			front = front.next;
			back = back.prev;
		}
		System.out.println("\nGiven DLL is a palindrome ... ");
	}
	
	public void largestNode() {
		
		Node temp = head;
		int max = Integer.MIN_VALUE;
		
		while(temp!=null) {
			if(temp.data>max) {
				max = temp.data;
			}
			temp = temp.next;
		}
		
		System.out.println("The largest node is "+max);
	}
	
	
	public void reverseInGroups(int size) {
		
		//Unsolved ... 
	}
	
	public void swapKthNodeFromLastAndFirst(int k) {
		
		Node first=head, second=head;
		
		for(int i=1;i<k && first!=null;i++) {
			first = first.next;
		}
		
		if(first == null) {
			System.out.println("\nValue of k is more than the no. of nodes ...");
			return;
		}
		
		while(second.next!=null) {
			second = second.next;
		}
		
		for(int i=1;i<k;i++) {
			second = second.prev;
		}
		
		if(first == second) {
			printList();
			return;
		}
		Node temp = null;
		
		temp = first.next;
		
		if(second.next == first) {
			first.next = second;
		}else {
			first.next = second.next;
		}
		
		if(temp == second) {
			second.next = first;
		}else {
			second.next = temp;
		}
		
		
		temp = first.prev;
		if(second.prev == first) {
			first.prev = second;
		}else {
			first.prev = second.prev;
		}
		if(temp == second) {
			second.prev = first;
		}else {
			second.prev = temp;
		}
		
		
		second.prev.next = second;
		
		if(second.next!=null) {
			second.next.prev = second;
		}
		
		first.next.prev = first;
		if(first.prev!=null) {
			first.prev.next = first;
		}
		
		
		if(second == head) {
			head = first;
		}
		
		printList();
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
//		dll.addAfterGivenNode(4, 5);
//		dll.addBeforeGivenNode(4, 5);
//		dll.delete(3);
		
//		dll.reverse();
		
//		dll.removeDuplicates();
//		dll.removeDuplicatesUsingHashing();
		
//		dll.findPairsWithGivenSumInSortedDLL(7);
//		dll.findTripletsWithGivenSum(15);
		
//		dll.rotateCounterClockWise(2);
		
//		dll.isPalindrome();
		
//		dll.largestNode();
		
//		dll.reverseInGroups(3);
		
		dll.swapKthNodeFromLastAndFirst(7);
		
	}

}
