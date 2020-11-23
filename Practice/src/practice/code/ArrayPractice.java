package practice.code;

import java.util.Scanner;

public class ArrayPractice {
	
	static void rotate(int arr[],int d,int n){
		
		int[] tempArr = new int[n];
		
		int i,k = 0;
		
		for(i=d;i<n;i++) {
			tempArr[k++] = arr[i]; 
		}
		for(i=0;i<d;i++) {
			tempArr[k++] = arr[i];
		}
		for(i=0;i<n;i++) {
			arr[i] = tempArr[i];
		}	
		
	}
	
	public static void juggleRotate(int arr[],int d, int n) {
		
		int gcdNum = MathUtil.gcd(n,d);
		
		int start = 0;
		for(int k=0; k<d; k++) {
			
			int temp = 0;
			temp = arr[start];
			int i=start;
			while(i+gcdNum < n) {
				arr[i] = arr[i+gcdNum];
				i = i+gcdNum;
			}
			arr[i]= temp;
			start = (start+1)%gcdNum;
		}
			
	}
	
	public static void reverse(int arr[],int p,int q) {
		int temp;
		int k=0;
		for(int i=p; i< (p+q)/2 ; i++,k++ ) {
			temp = arr[i];
			arr[i] = arr[q-1-k];
			arr[q-1-k] = temp;
		}
	}
	
	public static void reverseForRotate(int arr[],int d, int n) {
		reverse(arr,0,d);
		reverse(arr,d,n);
		reverse(arr,0,n);
	}
	
	public static void rotateClockWiseByOne(int arr[], int n) {
		
		int temp = arr[n-1];
		for(int i=n-2; i>=0; i--) {
			arr[i+1] = arr[i];
		}
		arr[0] = temp;
	}
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the array size");
		int n = sc.nextInt();
//		System.out.println("Enter the number to be rotated by");
//		int d = sc.nextInt();
		int[] arr = new int[n]; 
		System.out.println("Enter the array elements");
		for(int i=0; i<n ; i++) {
			arr[i] = sc.nextInt();
		}
		//Test
		//Left Rotate Array by some number {1,2,3,4,5,6} (d=2) => {3,4,5,6,1,2}
//		rotate(arr,d,n); //  Time complexity =  O(n) and Space complexity = O(n)
//		juggleRotate(arr,d,n); //  Time complexity =  O(n) and Space complexity = O(1)
//		reverseForRotate(arr,d,n); //  Time complexity =  O(n) and Space complexity = O(1) => Best approach 
		
		
		//Given an array, cyclically rotate the array clockwise by one.
		rotateClockWiseByOne(arr,n); 
		
		System.out.println("The output array is :");
		for(int i=0;i<n;i++) {
			System.out.print(" "+arr[i]);
		}
		
	}
	
}
