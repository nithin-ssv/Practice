package practice.code.queue;

//Linked List implementation of queue
public class LinkedQueue {

	public class Node{
		int data;
		Node next;
		public Node(int d) {
			data = d;
			next = null;
		}
	}

	Node front,rear;
	public LinkedQueue() {
		front = null;
		rear = null;
	}
	
	public void enQueue(int item) {
		
		Node newNode = new Node(item);
		if(rear == null) {
			rear = newNode;
			front = newNode;
			return;
		}
		
		rear.next = newNode;
		rear = newNode;
		
	}
	
	public int deQueue() {
		
		if(front == null) {
			System.out.println("\n Queue is Empty ...");
			return -1;
		}
		
		Node temp = front;
		front = front.next;
		temp.next = null;
		return temp.data;
		
	}
	
	public void printQueue() {
		
		Node temp = front;
		System.out.println("\nElements in the queue are :");
		
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		
	}
	
	public static void main(String[] args) {
		
//		LinkedQueue myQueue = new LinkedQueue();
//		
//		myQueue.enQueue(10);
//		myQueue.enQueue(20);
//		myQueue.enQueue(30);
//		myQueue.enQueue(40);
//		
//		myQueue.printQueue();
//		
//		System.out.print("\n The dequeued Element is :"+myQueue.deQueue());
//		System.out.print("\n The dequeued Element is :"+myQueue.deQueue());
//		System.out.print("\n The dequeued Element is :"+myQueue.deQueue());
//		
//		myQueue.enQueue(50);
//		myQueue.enQueue(60);
//		
//		myQueue.printQueue();
			
		
	}

}
