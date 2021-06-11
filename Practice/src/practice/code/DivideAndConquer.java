package practice.code;

import java.util.Scanner;

public class DivideAndConquer {

	public static void findMajorityElementInSortedArray(int[] arr) {
		
		int length = arr.length;
		
		int elem = arr[length/2];
		//this elem is a candidate for the majority element. we need to confirm this.
		int firstOccurence = findFirstOccurence(arr, elem, 0, length/2-1);
		if(firstOccurence == -1) {
			firstOccurence = length/2;
		}
		if(arr[firstOccurence + length/2] == elem) {
			System.out.println("\nMajority element found : "+elem);
		}else {
			System.out.println("\nNo majority element.. ");
		}
	}
	
	public static int findFirstOccurence(int[] arr, int elem, int start, int end) {
		
		int mid = -1;
		
		while(start<=end) {
			
			mid = (start+end)/2;
			
			if(arr[mid] < elem) {
				start = mid + 1;
			}
			else if(arr[mid] == elem) {
				if(arr[mid-1] !=  elem) {
					return mid;
				}
				end = mid - 2;
				if(end<0) {
					return 0;
				}
			}
			
		}
		if(arr[mid] == elem) {
			return mid;
		}else {
			return -1;
		}

	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the no. of elements..");
		int n = scanner.nextInt();
		
		System.out.println("Enter array elements..");
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = scanner.nextInt();
		}
		
		findMajorityElementInSortedArray(arr);
		
	}
	
}
