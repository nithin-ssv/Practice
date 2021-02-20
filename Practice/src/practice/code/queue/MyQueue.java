package practice.code.queue;

import practice.code.stack.MyStack;

public class MyQueue {

	static final int MAX=5;
	
	int front,rear;
	int[] queue;
	public MyQueue() {
		queue = new int[MAX];
		front = 0;
		rear = 0;
	}

	public void enQueue(int item) {
		
		if( (rear+1) % MAX == front) {
			System.out.println(" Queue is Full.. ");
			return;
		}
		
		rear = (rear+1) % MAX;
		queue[rear] = item;
		
	}
	
	public int deQueue(){
		
		if(rear == front) {
			System.out.println("\nQueue is Empty.. ");
			return -1;
		}
		front = (front+1) % MAX;
		return queue[front];
		
	}
	
	public void printQueue() {
		
		System.out.println("\n The elements in queue are :");
		
		if(rear>front) {
			for(int i=front+1;i<=rear;i++) {
				System.out.print(queue[i]+" ");
			}
		}else {
			for(int i=front+1;i<MAX;i++) {
				System.out.print(queue[i]+" ");
			}
			for(int i=0;i<=rear;i++) {
				System.out.print(queue[i]+" ");
			}
			
		}
		
		
	}
	
	public boolean isEmpty() {
		
		if(front == rear) {
			return true;
		}else {
			return false;
		}
	}
	
	public void enqueueWithStacks(MyStack s1, MyStack s2, int item) {
		
		s1.push(item);
		
	}
	
	public int dequeueWithStacks(MyStack s1, MyStack s2) {
		
		if(s1.isEmpty() && s2.isEmpty()) {
			System.out.println("\n Queue is Empty ...");
			return -1;
		}
		
		if(!s2.isEmpty()) {
			return s2.pop();
		}
		
		while(!s1.isEmpty()) {
			int item = s1.pop();
			s2.push(item);
		}
		return s2.pop();
	}
	
	public static void main(String[] args) {
		
		MyQueue myQueue = new MyQueue();
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
//		
//		myQueue.enQueue(50);
//		myQueue.enQueue(60);
//		
//		myQueue.printQueue();
	
	/* Pop Operation is costly  */	
//		MyStack s1 = new MyStack();
//		MyStack s2 = new MyStack();
//		
//		myQueue.enqueueWithStacks(s1, s2, 10);
//		myQueue.enqueueWithStacks(s1, s2, 20);
//		myQueue.enqueueWithStacks(s1, s2, 30);
//		
//		System.out.print("\n The dequeued Element is :"+myQueue.dequeueWithStacks(s1,s2));
//		System.out.print("\n The dequeued Element is :"+myQueue.dequeueWithStacks(s1,s2));
//		
//		myQueue.enqueueWithStacks(s1, s2, 40);
//		myQueue.enqueueWithStacks(s1, s2, 50);
//		System.out.print("\n The dequeued Element is :"+myQueue.dequeueWithStacks(s1,s2));
//		myQueue.enqueueWithStacks(s1, s2, 60);
//		
//		System.out.print("\n The dequeued Element is :"+myQueue.dequeueWithStacks(s1,s2));
//		System.out.print("\n The dequeued Element is :"+myQueue.dequeueWithStacks(s1,s2));
//		System.out.print("\n The dequeued Element is :"+myQueue.dequeueWithStacks(s1,s2));
//		System.out.print("\n The dequeued Element is :"+myQueue.dequeueWithStacks(s1,s2));
		
	}

}
