package practice.code;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class StringPractice{
		
	public void maximumOccuringCharInGivenString(String input) {
		
		input = input.toLowerCase();
		int count[] = new int[256];
		char[] charArr = input.toCharArray();
		
		for(char ch: charArr) {
			count[ch]++;
		}
		int max_count=0;
		char max_char=' ';
		for(char ch: charArr) {
			if(count[ch]>max_count) {
				max_count = count[ch];
				max_char = ch;
			}
		}
		
		System.out.println("\nThe character "+max_char+" has occured a max of "+max_count+" times ..");
		//Time Complexity - O(n)
		//Space Complexity - O(1), since the count Array is of fixed size and independent of the input size 
	}
	
	public void removeDuplicatesInGivenString(String input) {
		
		int  count[] = new int[256];
		
		char charArr[] = input.toCharArray();
		int seq=0;
		
		for(int i=0; i<charArr.length; i++) {
			
			if(count[charArr[i]] == 1) {
				continue;
			}
			
			charArr[seq++] = charArr[i];
			count[charArr[i]] = 1;
			
		}
		
		for(int i=seq; i<charArr.length; i++) {
			charArr[i] = ' ';
		}
		
		System.out.println("The output string is:\n");
		for(int i=0;i<charArr.length && charArr[i]!=' ';i++) {
			System.out.print(charArr[i]);
		}
		
		//Time complexity - O(n)
		//Space complexity - O(1)
	}
	
	public void checkIfStringIsRotationOfGivenString(String input,String check) {
		
		boolean isRotation = false; 
		
		if(input.length() == check.length()) {
			String test = input + input;
			if(test.contains(check)) {
				isRotation = true;
			}else {
				isRotation = false;
			}
		}
		if(isRotation) {
			System.out.println("Given string is rotation of input");
		}else {
			System.out.println("Given string is not a rotation of input");
		}
	}
	
	public String reverseString(String input) {
		
		char[] charArr = input.toCharArray();
		int len = charArr.length;
		char temp;
		for(int i=0;i<(len/2);i++) {
			temp = charArr[i];
			charArr[i] = charArr[len-i-1];
			charArr[len-i-1] = temp;
		}
		
		return new String(charArr);
	}
	
//	public String reverseWordsInSentence(String input) {
//		
//		char[] charArr = input.toCharArray();
//		int start=0,end=0;
//		for(int i=0;i<charArr.length;i++) {
//			
//			if(charArr[i]==' ') {
//				
//				
//				
//			}
//			
//		}
//		
//	}
	
	public void charPractice() {
		
		char x = ' ';
		System.out.print("The ASCII value table is :\n");
		for(int i=0;i<256;i++) {
			x=(char)i;
			System.out.println(x+" = "+i);
		}
	}
	
	public static void main(String[] args) {
		
		StringPractice practice = new StringPractice();
		
		practice.charPractice();
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("\nEnter the input string :\n");
//		String inputStr = scanner.nextLine();
		
		//practice.maximumOccuringCharInGivenString(inputStr);
		//practice.removeDuplicatesInGivenString(inputStr);
		//practice.checkIfStringIsRotationOfGivenString("ravi", "irav");
		
		//System.out.println("The reverse of the given string "+practice.reverseString(inputStr));
	}
	
	
}