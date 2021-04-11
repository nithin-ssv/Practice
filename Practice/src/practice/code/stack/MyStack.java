package practice.code.stack;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

import com.sun.xml.internal.ws.util.StringUtils;

import practice.code.MathUtil;
import practice.code.queue.MyQueue;

public class MyStack {

	final static int MAX = 5;
	
	int[] stack = new int[MAX];
	int top;
	int min;
	MyQueue q1 = new MyQueue();
	MyQueue q2 = new MyQueue();
	
	public class Interval implements Comparable<Interval>{
		
		Integer start;
		Integer end;
		public Interval(int s, int e) {
			start = s;
			end = e;
		}
		
		public int compareTo(Interval interval) {
			
			if(start > interval.start) {
				return 1;
			}else if(start < interval.start){
				return -1;
			}else {
				return 0;
			}
			
		}
	}
	
	public MyStack() {
		top = -1;
		min = Integer.MAX_VALUE;
	}
	
	public void push(int item) {
		
		if(top == MAX-1) {
			System.out.println("\n Stack Overflow...");
			return;
		}
		
		stack[++top]= item;
		
		if(item < min) {
			min = item;
		}
		
	}
	
	public int pop() {
		
		if(top == -1) {
			System.out.println("\n Stack Underflow...");
			return -1;
		}
		
		return stack[top--];
	}
	
	public void printStack() {
		
		System.out.println("\n Elements in the stack are : ");
		for(int i=top;i>=0;i--) {
			System.out.print(stack[i]+" ");
		}
		
	}
	
	public boolean isEmpty() {
		
		if(top == -1) {
			return true;
		}else {
			return false;
		}
	}
	
	public int getMinimum() {
		
		if(top == -1) {
			System.out.println("\n Stack Underflow...");
			return -1;
		}
		
		return min;
	}
	
	
	public void pushWithTwoQueues( int item) {
		
		q2.enQueue(item);
		int temp;
		while(!q1.isEmpty()) {
			temp = q1.deQueue();
			q2.enQueue(temp);
		}
		MyQueue t = q2;
		q2 = q1;
		q1 = t;
		
	}
	
	public int popWithTwoQueues() {
		return q1.deQueue();
	}
	
	public void findTheNextGreaterElement(int arr[],int n) {
		
		//Time complexity - O(n) Space Complexity O(n)
		
		Stack<Integer> stack = new Stack<Integer>();
		int outArr[] = new int[n];
		int item;
		stack.push(0);
		
		for(int i=1;i<n;i++) {
			
			while(!stack.isEmpty()) {
				item = stack.peek();
				if(arr[i] < arr[item]) {
					break;
				}else {
					outArr[item]=arr[i];
					stack.pop();
				}
			}
			
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			item = stack.pop();
			outArr[item] = Integer.MIN_VALUE;
		}
		
		System.out.println("\n The output is ");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" "+outArr[i]);
		}
		
	}
	
	public void mergeIntervals() {
		
		System.out.println("Enter the no. of intervals..");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		Interval[] arr = new Interval[n];
 		System.out.println("Enter the intervals..");
		for(int i=0;i<n;i++) {
			arr[i] = new Interval(scanner.nextInt(),scanner.nextInt());
		}
		
		//Sorting should take place here.........
		Arrays.sort(arr);
		
		Stack<Interval> stack = new Stack<Interval>();
		stack.push(arr[0]);
		
		for(int i=1;i<n;i++) {
			
			Interval interval = stack.pop();
			
			if(arr[i].start < interval.end) {
				
				if(arr[i].end > interval.end) {
					interval.end = arr[i].end;
				}
				stack.push(interval);
			}else {
				stack.push(interval);
				stack.push(arr[i]);
			}
			
		}
		
		System.out.println("The merged intervals are ::");
		while(!stack.isEmpty()) {
			Interval interval = stack.pop();
			System.out.print("["+interval.start+","+interval.end+"]");
		}
		
	}
	
	public void stockSpanProblem(int arr[],int n) {
		
		//Given a list of stock prices.. we have to find the span 
		//(how many consecutive prices before the current price that are less than the current price)
		
		int outArr[] = new int[n];
		outArr[0]=0;
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		
		
		for(int i=1;i<n;i++) {
			
			int item = stack.peek();
			if(arr[item] < arr[i]) {
				
				while( (arr[item] < arr[i]) && !stack.isEmpty() ) {
					stack.pop();
					if(!stack.isEmpty()) {
						item = stack.peek();
					}
				}
				
				if(stack.isEmpty()) {
					outArr[i] = i;
				}else {
					outArr[i] = i - stack.peek() - 1;
				}
				stack.push(i);
			
			}else {
				outArr[i] = 0;
				stack.push(i);
			}
			
		}
		
		System.out.println("The output array is :: ");
		for(int i=0;i<n;i++) {
			System.out.print(outArr[i]+" ");
		}
		
	}
	
	public boolean balanceParanthesis(char[] arr, int n) {
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0;i<n;i++) {
			
			if(arr[i]=='(' || arr[i] == '{' || arr[i] == '[' ) {
				stack.push(arr[i]);
			}
			else if(arr[i] == ')') {
				
				if(!stack.isEmpty() && '(' == stack.peek()) {
					stack.pop();
				}else {
					return false;
				}
				
			}else if (arr[i] == '}') {
				
				if(!stack.isEmpty() && '{' == stack.peek()) {
					stack.pop();
				}else {
					return false;
				}
				
			}else if (arr[i] == ']') {
				
				if(!stack.isEmpty() && '[' == stack.peek()) {
					stack.pop();
				}else {
					return false;
				}
				
			}
			
		}
		
		if(stack.isEmpty()) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public void minNoOfReversalsRequiredToBalance(char arr[],int size) {
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0;i<size;i++) {
			
			if(arr[i] == '{') {
				stack.push(arr[i]);
			}
			else if(arr[i] == '}') {
				if( !stack.isEmpty() && stack.peek() == '{') {
					stack.pop();
				}else {
					stack.push(arr[i]);
				}
			}
			
		}
		
		int m=0,n=0;
		while(!stack.isEmpty()) {
			
			char cur = stack.pop();
			if('{' ==  cur) {
				m++;
			}else if('}' == cur) {
				n++;
			}
			
		}
		int sum=0;
		if((m+n)%2 != 0) {
			System.out.println("Cannot be balanced... ");
			return;
		}else {
			sum = (int) (Math.ceil(m/2) + Math.ceil(n/2));
		}
		System.out.println("The min. no. of reversals required is "+sum);
		System.out.println("The max no. of reversals required is "+(m+n));
	}
	
	public void findIfExpressionHasRedundantParanthesis(char arr[],int size) {
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0;i<size;i++) {
			
			if( arr[i] == ')') {
				
				if(stack.isEmpty()) {
					System.out.println("Given string is unbalanced ..");
					return;
				}
				
				char test = stack.peek();
				if(test == '(') {
					System.out.println("Given string has redundant paranthesis");
					return;
				}
				
				while(!stack.isEmpty() && '(' != stack.peek()) {
					stack.pop();
				}
				stack.pop();
				
			}else {
				stack.push(arr[i]);
			}
			
		}
		
		if(!stack.isEmpty()) {
			System.out.println("Given string is unbalanced ..");
		}else {
			System.out.println("Given string doesn't have redundant paranthesis");
		}
		
	}
	
	public static void main(String[] args) {
		
		MyStack myStack = new MyStack();
		
//		myStack.push(10);
//		myStack.push(20);
//		myStack.push(30);
//		System.out.print("\n Popped element is :"+myStack.pop());
//		myStack.push(40);
//		myStack.push(50);
//		System.out.print("\n Popped element is :"+myStack.pop());
//		System.out.print("\n Popped element is :"+myStack.pop());
//		System.out.print("\n Popped element is :"+myStack.pop());
//		myStack.push(60);
//		myStack.push(70);
//		myStack.printStack();
		
		
//		myStack.pushWithTwoQueues(10);
//		myStack.pushWithTwoQueues(20);
//		myStack.pushWithTwoQueues(30);
//		
//		System.out.print("\n Popped element is :"+myStack.popWithTwoQueues());
//		System.out.print("\n Popped element is :"+myStack.popWithTwoQueues());
//		
//		myStack.pushWithTwoQueues(40);
//		myStack.pushWithTwoQueues(50);
//		
//		System.out.print("\n Popped element is :"+myStack.popWithTwoQueues());
//		System.out.print("\n Popped element is :"+myStack.popWithTwoQueues());
//		System.out.print("\n Popped element is :"+myStack.popWithTwoQueues());
		
//		System.out.println("Enter no. of elements:");
		Scanner scanner = new Scanner(System.in);
//		int n = scanner.nextInt();
//		int arr[] = new int[n]; 
//		System.out.println("Enter elements of the array:");
//		for(int i=0;i<n;i++) {
//			arr[i] = scanner.nextInt();
//		}
		
//		myStack.findTheNextGreaterElement(arr, n);	
//		myStack.stockSpanProblem(arr, n);
		
		System.out.println("Enter the paranthesis string:");
		String paranthesisStr = scanner.next();

//		myStack.minNoOfReversalsRequiredToBalance(paranthesisStr.toCharArray(),paranthesisStr.length());
		
		myStack.findIfExpressionHasRedundantParanthesis(paranthesisStr.toCharArray(),paranthesisStr.length());
		
//		System.out.println(" The balance of given string is "+myStack.balanceParanthesis(paranthesisStr.toCharArray(), paranthesisStr.length()));
		
		
		
//		myStack.mergeIntervals();
		
		
		
	}

}
