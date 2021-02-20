package practice.code.stack;

public class LinkedStack {

	public class Node{
		int data;
		Node next;
		public Node(int d){
			data = d;
			next = null;
		}
	}
	
	Node head;
	
	public void push(int data) {
		
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			return;
		}
		
		newNode.next = head;
		head = newNode;	
	}
	
	public int pop() {
		
		if(head == null) {
			return -1;
		}
		
		Node temp = head;
		head = head.next;
		temp.next = null;
		return temp.data;
		
	}
	
	public void printStack() {
		System.out.println("\n The elements in the stack are:");
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		
		LinkedStack myStack = new LinkedStack();
		
		myStack.push(10);
		myStack.push(20);
		myStack.push(30);
		System.out.print("\n Popped element is :"+myStack.pop());
		myStack.push(40);
		myStack.push(50);
		System.out.print("\n Popped element is :"+myStack.pop());
		System.out.print("\n Popped element is :"+myStack.pop());
		System.out.print("\n Popped element is :"+myStack.pop());
		myStack.push(60);
		myStack.push(70);
		myStack.printStack();
		
		
	}

}
