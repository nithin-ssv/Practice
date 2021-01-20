package practice.code;

import java.util.Arrays;
import java.util.HashSet;
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
	
	private static void binarySearch(int[] arr,int n) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the key to be searched:");
		int key = scanner.nextInt();
		boolean found=false;
		int low=0,high=n-1,mid=-1;
		while(low<=high) {
			mid = (low + high)/2;
			if(key > arr[mid]) {
				low = mid+1;
			}else if(key < arr[mid]) {
				high = mid-1;
			}else if(arr[mid] == key) {
				found = true;
				break;
			}
		}
		
		if(found) {
			System.out.print("Element found at "+mid);
		}else {
			System.out.print("Element not found");
		}
	}
	
	private static int pivotFindingInRotatedSortedArray(int[] arr, int n) {
		//Sample Input : 3 4 5 6 7 1 2
		//Sample Inut  : 6 7 1 2 3 4 5
		int mid = -1;
		int start=0,end=n-1;
		if(arr[start] < arr[end]) {
//			System.out.println("Pivot is found at "+mid);
			return mid;
		}
		
		while(start<=end) {
			mid = (start+end)/2;
			if(arr[mid+1]<arr[mid]) {
				System.out.println("Pivot is found at "+mid);
				return mid;
			}
			if(arr[mid]>arr[n-1]) {
				start = mid+1;
			}else if(arr[mid] < arr[n-1]) {
				end = mid-1;
			}
		}
		System.out.println("Some error occured..");
		return mid;
	}
	
	private static void findingPairWithGivenSumInSortedArray(int[] arr, int n) {
		
		//Two pointer technique
		System.out.println("Enter the sum to be found :");
		Scanner scanner = new Scanner(System.in);
		int givenSum = scanner.nextInt();
		boolean found = false;
		
		int start=0,end=n-1,curSum=0;
		while(start<end) {
			curSum = arr[start] + arr[end];
			if(curSum > givenSum) {
				end = end - 1;
			}else if(curSum < givenSum) {
				start = start + 1;
			}else {
				found = true;
				break;
			}
		}
		
		if(found) {
			System.out.println("The elements which form the given sum are :"+arr[start]+" and "+arr[end]);
		}else {
			System.out.println("The pair is not found .. ");
		}
	}
	
	private static void findingPairsWithGivenSumInUnSortedArray(int[] arr, int n) {
		
		//Using the approach of hashing...
		System.out.println("Enter the sum to be matched ..");
		Scanner scanner = new Scanner(System.in);
		int givenSum = scanner.nextInt();
		boolean found = false;
		HashSet<Integer> numSet = new HashSet<Integer>();
		
		for(int i=0;i<n;i++) {
			int partner = givenSum - arr[i];
			if(numSet.contains(partner)) {
				System.out.println("The elements which form the given sum are "+ arr[i]+ " and "+partner);
				found = true;
			}else {
				numSet.add(arr[i]);
			}
		}
		if(!found) {
			System.out.println("The pair is not found ..");
		}
	}
	
	public static void findingMajorityElementInSortedArray(int arr[],int n) {

		// Own approach -- O(n)
//		int start = 0,count=1,i;
//		boolean found = false;
//		while(start<n) {
//			
//			for( i=start+1;i<n;i++) {
//				if(arr[i]==arr[start]) {
//					count++;
//					if(count>n/2) {
//						System.out.println("Majority element found = "+arr[i]);
//						return;
//					}
//				}else {
//					break;
//				}
//			}
//			start = i;
//		}
//		
//		if(!found) {
//			System.out.println("Majority element not found");
//		}
		
		for(int i=0;i<=n/2;i++) {
			if(arr[i]==arr[i+n/2]) {
				System.out.println("Majority element found = "+arr[i]);
				return;
			}
		}
		System.out.println("Majority element not found");
	}
	
	public static void findingMajorityElementInUnSortedArray(int arr[],int n) {
		
		//Moore Voting method... Time complexity- O(n)
		
		int voter=0,votes=1;
		
		for(int i=1;i<n;i++) {
			if(arr[i] != arr[voter]) {
				votes--;
			}else {
				votes++;
			}
			if(votes==0) {
				votes=1;
				voter=i;
			}
		}
		
			int count=0;
			for(int i=0;i<n;i++) {
				if(arr[i]==arr[voter]) {
					count++;
				}
			}
			if(count>n/2) {
				System.out.println("Majority element is "+arr[voter]);
			}else {
				System.out.println("No Majority element...");
			}
			
	}
	
	public static void maximumSumSubArrayBruteForce(int arr[],int n) {
		//Time Complexity  - O(n^3)
		//Space Complexity - O(1)
		int maxSum=-99999;
		int curSum,start=0,end=n-1;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				curSum=0;
				for(int k=i;k<=j;k++) {
					curSum= curSum+arr[k];
				}
				if(curSum>maxSum) {
					maxSum=curSum;
					start=i;
					end=j;
				}
			}
		}
		System.out.print("The maximum sum "+ maxSum +" is found between "+start+" and "+end);
	}
	
	public static void maximumSumSubarrayWithCumulativeSum(int arr[],int n) {
		
		//Time Complexity  - O(n^2)
		//Space Complexity - O(n)
		int cumArr[]= new int[n];
		int cumSum=0;
		for(int i=0;i<n;i++) {
			cumSum=cumSum+arr[i];
			cumArr[i]=cumSum;
		}
		int maxSum=-9999,curSum=0,start=0,end=n-1;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++){
				if(i==0) {
					curSum=cumArr[j];
				}else {
					curSum = cumArr[j]-cumArr[i-1];
				}
				if(curSum>maxSum) {
					maxSum=curSum;
					start=i;
					end=j;
				}
			}
		}
		System.out.print("The maximum sum "+ maxSum +" is found between "+start+" and "+end);
	}
	public static void maximumSumSubArrayWithKadane(int arr[],int n) {
		
		//Time Complexity =  O(n) 
		//Space Complexity = O(1)
		int max_sum_so_far=0,cur_sum=0,max_index=-1,start_index=-1;
		
		for(int i=0;i<n;i++) {
			cur_sum = cur_sum + arr[i];
			if(cur_sum<0) {
				cur_sum=0;
			}
			if(cur_sum>max_sum_so_far) {
				max_sum_so_far=cur_sum;
				max_index=i;
			}
		}
		cur_sum=0;
		for(int k=max_index;k>-1;k--) {
			cur_sum = cur_sum + arr[k];
			if(cur_sum==max_sum_so_far) {
				start_index=k;
				break;
			}
		}
		System.out.print("The maximum sum "+ max_sum_so_far +" is found between "+start_index+" and "+max_index);
	}
	
	public static void maximumDiffInArrayWithLargerElementAfterSmallerElementBruteForce(int arr[],int n) {
		
		//Find the maximum difference between two elements in an Array such that the larger element is on to the right side of the smaller element
		// Sample Array [4 3 10 2 9 1 6]
		//If we just find max and min and find the diff. , that is wrong.The larger elem must be present after the smaller element in the array.
		
		int max_sum=0,max_start=-1,max_end=-1,cur_sum=0;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				cur_sum = arr[j] - arr[i];
				if(cur_sum > max_sum) {
					max_sum = cur_sum;
					max_start = i;
					max_end = j;
				}
			}
		}
		
		System.out.println("The start elem is "+ max_start +" and ending elem is "+max_end);
		
		//Time Complexity - O(n^2)
		//Space Complexity - O(1)
		
	}
	
	public static void maximumDiffInArrayWithLargerElementAfterSmallerElementEfficient(int arr[],int n) {
		
		int min_so_far=arr[0];
		int max_diff=arr[1]-arr[0];
		int start=-1,end=-1,cur_diff=0;
		
		for(int i=2;i<n;i++) {
			if(arr[i-1]<min_so_far) {
				min_so_far=arr[i-1];
			}
			cur_diff = arr[i] - min_so_far;
			if(cur_diff>max_diff) {
				max_diff = cur_diff;
				start = min_so_far;
				end = arr[i];
			}
		}
		
		System.out.println("The max diff is present between "+start+" and "+end);
		
		
	}
	
	public static void findNumberOccuringOddNumberOfTimes(int arr[],int n) {
		//find the number which occurs odd number of times, given that only one number in the input occurs like that..
		
		HashSet<Integer> mySet = new HashSet<Integer>();
		
		for(int i=0;i<n;i++) {
			if(mySet.contains(arr[i])) {
				mySet.remove(arr[i]);
			}else {
				mySet.add(arr[i]);
			}
		}
		
		if(mySet.isEmpty()) {
			System.out.println("There is no such element...");
		}else {
			for(Integer elem:mySet) {
				System.out.println("The element is "+elem);
			}
		}
		
	}
	
	public static void findNumberOccuringOddNumberOfTimesEffcient(int arr[],int n) {
		
		int sum=0;
		for(int i=0;i<n;i++) {
			sum = sum ^ arr[i];
		}
		if(sum == 0) {
			System.out.println("There is no such element...");
		}else {
			System.out.println("The element is "+sum);
		}
	}
	
	public static void seperateZerosAndOnes(int arr[],int n) {
		
		//Counting Approach
		int zeroCount = 0;
		for(int i=0;i<n;i++) {
			if(arr[i]==0) {
				zeroCount++;
			}
		}
		for(int i=0;i<zeroCount;i++) {
			arr[i]=0;
		}
		for(int i=zeroCount;i<n;i++) {
			arr[i]=1;
		}
		
		System.out.println("The output array is ");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
	
	public static void seperateZerosAndOnesEfficient(int arr[],int n) {
		
		int left=0,right=n-1;
		
		while(left<right) {
			if(arr[right]==1) {
				right--;
			}else if(arr[right]==0){
				if(arr[left]==0) {
					left++;
				}else if(arr[left]==1) {
					arr[left]=0;
					arr[right]=1;
				}
			}
		}
		
		System.out.println("The output array is ");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}	
	}
	
	public static void seperateEvenAndOddNumbers(int arr[],int n) {
		
		int left=0,right=n-1,temp;
		while(left<right) {
			
			while( (arr[left]%2 == 0) &&  (left<right)) {
				left++;
			}
			while( (arr[right]%2 == 1) &&  (left<right)) {
				right--;
			}
			if(left<right) {
				temp=arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
			}
		}
		
		System.out.println("The output array is ");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
	
	public static void findPairWhoseSumIsClosestToZero(int arr[],int n) {
		
		int left=0,right=n-1;
		Arrays.sort(arr);
		int start=0,end=n-1;
		int minSum = MathUtil.abs(arr[0]+arr[n-1]),curSum=0;
		while(left<right) {
			curSum = arr[left]+arr[right];
			if(curSum == 0) {
				start=left;
				end=right;
				minSum=curSum;
				break;
			}
			else if(curSum>0) {
				if(curSum<minSum) {
					start = left;
					end= right;
					minSum=curSum;
				}
				right--;
			}else if(curSum<0){
				if(MathUtil.abs(curSum)<minSum) {
					minSum=MathUtil.abs(curSum);
					start = left;
					end= right;
				}
				left++;
			}
		}
		System.out.println("The elements are "+arr[start]+" and "+arr[end]+" and the sum is "+minSum);
		
	}
	
	public static void findingTripletWithGivenSum(int arr[],int n) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the target sum :");
		int target = scanner.nextInt();
		Arrays.sort(arr);
		int left=0,right=n-1,curSum=0;
		
		for(int i=0;i<n-2;i++) {
			
			left=i+1;
			right=n-1;
			curSum=0;
			while(left<right) {
				
				curSum = arr[i]+arr[left]+arr[right];
				if(curSum==target) {
					System.out.println("The triplet is found as :"+arr[i]+" , "+arr[left]+" , "+arr[right]);
					return;
				}
				else if(curSum < target) {
					left++;
				}else {
					right--;
				}
			}
			
			
		}
		
		System.out.println("Triplet is not found...");
		
	}
	
	public static void findEquilibruimIndexInGivenArray(int arr[],int n) {
		
		//Sum of the elements from index 0 to that index = sum of the elements from that index (excluding it) till end of the array
		
		int leftSum=0,totalSum=0,rightSum=0;
		for(int i=0;i<n;i++) {
			totalSum = totalSum + arr[i];
		}
		
		for(int i=0;i<n;i++) {
			leftSum=leftSum+arr[i];
			rightSum = totalSum - leftSum;
			if(leftSum == rightSum) {
				System.out.println("The equilibruim index is :"+i);
				return;
			}
		}
		System.out.println("Equilibruim index is not found.. ");
	}
	
	public static void findIndexOfFirstOneInInfiniteArray(int arr[]) {
		//Since we consider it as an infinite array, we don't pass the size and consider it as unknown
		
		int l=0,h=1;
		while(arr[h]==0) {
			l=h;
			h=2*h;
		}
		
		//when arr[h] ==1, if seen, we consider that as upper index  and apply binary search
		
		int low=l,high=h,mid=0;
		
		while(low<=high) {
			
			mid=(low+high)/2;
			if(arr[mid]==1 && arr[mid-1]==0) {
				break;
			}
			else if(arr[mid]==0) {
				low=mid+1;
			}else if(arr[mid]==1){
				high=mid-1;
			}
			
		}
		
		System.out.println("First 1 is found at index : "+mid);
		
	}
	
	public static void printMaximumOfEachSlidingWindowBruteForce(int arr[],int n) {

		/** Time Complexity = O(nK) Space Complexity = O(1) **/
		
		System.out.println("Enter the window size:");
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		int windowMax=0;
		
		System.out.println("The values of window Max are : ");
		
		for(int i=0;i<=n-k;i++) {
			windowMax=Integer.MIN_VALUE;
			for(int j=i;j<i+k;j++) {
				if(arr[j]>windowMax) {
					windowMax=arr[j];
				}
			}
			System.out.print(windowMax+" ");
		}
		
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

		//Left Rotate Array by some number {1,2,3,4,5,6} (d=2) => {3,4,5,6,1,2}
//		rotate(arr,d,n); //  Time complexity =  O(n) and Space complexity = O(n)
//		juggleRotate(arr,d,n); //  Time complexity =  O(n) and Space complexity = O(1)
		
		//Reversal algorithm for array rotation
//		reverseForRotate(arr,d,n); //  Time complexity =  O(n) and Space complexity = O(1) => Best approach 
		
		
		//Given an array, cyclically rotate the array clockwise by one.
		//rotateClockWiseByOne(arr,n); 
		
		//Binary Search
//		binarySearch(arr,n);
		
		//Finding pivot in rotated sorted array
//		pivotFindingInRotatedSortedArray(arr,n);
		
//		findingPairWithGivenSumInSortedArray(arr,n);
//		findingPairsWithGivenSumInUnSortedArray(arr,n);
		
//		findingMajorityElementInSortedArray(arr,n);
//		findingMajorityElementInUnSortedArray(arr,n);
		
//		maximumSumSubArrayBruteForce(arr,n);
//		maximumSumSubarrayWithCumulativeSum(arr,n);
//		maximumSumSubArrayWithKadane(arr,n);
		
//		maximumDiffInArrayWithLargerElementAfterSmallerElementBruteForce(arr,n);
//		maximumDiffInArrayWithLargerElementAfterSmallerElementEfficient(arr,n);
		
//		findNumberOccuringOddNumberOfTimes(arr,n);
//		findNumberOccuringOddNumberOfTimesEffcient(arr,n);
		
//		seperateZerosAndOnes(arr,n);
//		seperateZerosAndOnesEfficient(arr,n);
//		seperateEvenAndOddNumbers(arr,n);
		
//		findPairWhoseSumIsClosestToZero(arr,n);
		
//		findingTripletWithGivenSum(arr,n);
		
//		findEquilibruimIndexInGivenArray(arr,n);
		
//		findIndexOfFirstOneInInfiniteArray(arr);
		
		printMaximumOfEachSlidingWindowBruteForce(arr,n);
		
//		System.out.println("The output array is :");
//		for(int i=0;i<n;i++) {
//			System.out.print(" "+arr[i]);
//		}
		
	}


}