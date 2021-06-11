package practice.code;

import java.util.Arrays;
import java.util.Scanner;

import practice.code.BinaryTree.Node;

public class BinarySearchTree {

	public BinarySearchTree() {
		
	}

	public class Node{
		
		int data;
		Node left;
		Node right;
		
		public Node(int d) {
			data = d;
			left = null;
			right = null;
		}
		
	}
	
	public Node root;
	
	public void buildBinaryTree() {
		
		Node newNode = new Node(5);
		root = newNode;
		
		root.left = new Node(3);
		root.right = new Node(6);
		
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		
		root.left.right.left = new Node(15);
		root.left.right.right = new Node(16);
		
		root.right.right = new Node(8);
		
		root.left.left.left = new Node(10);
		root.left.left.right = new Node(2);
		
		root.left.left.left.left = new Node(11);
		root.left.left.left.right = new Node(12);
		
		root.left.left.right.left = new Node(13);
		root.left.left.right.right = new Node(14);
		
		root.right.right.left = new Node(7);
	}
	
	
	public Node insertNode(Node root,int item) {
		
		if(root == null) {
			Node newNode = new Node(item);
			root = newNode;
			return root;
		}
	
		if(item < root.data) {
			root.left = insertNode(root.left,item);
		}else {
			root.right = insertNode(root.right,item);
		}
		
		return root;
	}
	
	public void inOrder(Node root) {
		
		if(root!=null) {
			inOrder(root.left);
			System.out.print(" "+root.data);
			inOrder(root.right);
		}
		
	}
	
	public int minValue(Node root) {
		Node temp = root;
		while(temp.left != null) {
			temp = temp.left;
		}
		return temp.data;
	}
	
	public int maxValue(Node root) {
	
		while(root.right!=null) {
			root = root.right;
		}
		return root.data;
		
	}
	
	public Node minNode(Node root) {
		
		while(root.left!=null) {
			root = root.left;
		}
		return root;
		
	}
	
	public Node maxNode(Node root) {
	
		while(root.right!=null) {
			root = root.right;
		}
		return root;
		
	}
	
	public Node deleteNode(Node root,int item) {
		
		if(root == null) {
			return root; //item not found in the tree.
		}
		
		if(item < root.data) {
			root.left = deleteNode(root.left,item);
		}else if(item > root.data) {
			root.right = deleteNode(root.right,item);
		}else if(item == root.data) {
			
			if(root.left == null && root.right == null) { //if node is leaf..
				return null; 
			}else if(root.left !=null && root.right == null) {
				Node temp = root.left;
				root.left = null;
				return temp;
			}else if(root.left ==null && root.right != null) {
				Node temp = root.right;
				root.right = null;
				return temp;
			}else {
				root.data = maxValue(root.left); // copying the value of inorder predecessor to current node
				root.left = deleteNode(root.left,root.data);
			}
			
		}
		
		
		return root;
	}
	
	public Node leastCommonAncestor(Node root, int item1, int item2) {
		
		if(root == null) {
			return root;
		}
		
		if(item1 < root.data && item2 < root.data) {
			return leastCommonAncestor(root.left, item1, item2);
		}
		else if(item1 > root.data && item2 > root.data) {
			return leastCommonAncestor(root.right, item1, item2);
		}else {
			return root;
		}
		
	}
	
	
	public Node convertToBST(int arr[], int low, int high) {
		
		if(low > high) {
			return null;
		}
		
		int mid = (low+high)/2;
		
		Node root = new Node(arr[mid]); 
		root.left = convertToBST(arr, low, mid-1);
		root.right = convertToBST(arr, mid+1, high);
		
		return root;
	}
	
	public void convertSortedArrayToBalancedBST() {
		
		System.out.println("Enter the size of array:\n");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int arr[] = new int[n];
		System.out.println("\nEnter the elements of array :\n");
		for(int i=0;i<n;i++) {
			arr[i] = scanner.nextInt();
		}
		Node root = convertToBST(arr,0,n-1);
		System.out.println("\nThe preorder of obtained tree is: \n");
		preOrder(root);
		
		System.out.println("\nThe inorder of obtained tree is: \n");
		inOrder(root);
	}
	
	public void preOrder(Node root) {
		if(root == null) {
			return;
		}
		System.out.print(" "+root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public int binaryTreeKeys[];
	
	public int  fillBinaryTreeKeys(Node root,int index) {
		
		if(root == null) {
			return index;
		}
			
		index = index+1;
		binaryTreeKeys[index] = root.data;

		index = fillBinaryTreeKeys(root.left,index);
		return fillBinaryTreeKeys(root.right,index);
		
		
	}
	
	public void convertBinaryTreeToBalancedBST(Node root) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nEnter the no. of nodes :\n");
		
		int n = scanner.nextInt();
		binaryTreeKeys = new int[n];
		fillBinaryTreeKeys(root,-1);
		for(int i=0;i<n;i++) {
			System.out.print(" "+binaryTreeKeys[i]);
		}
		
		Arrays.sort(binaryTreeKeys);
		
		System.out.println();
		for(int i=0;i<n;i++) {
			System.out.print(" "+binaryTreeKeys[i]);
		}
		
		Node newroot = convertToBST(binaryTreeKeys,0,n-1);
		System.out.println("\nThe inorder of obtained tree is: \n");
		inOrder(newroot);
		
	}
	
		
	public static void main(String[] args) {
		
		BinarySearchTree tree = new BinarySearchTree();
		
//		System.out.println("Enter the no. of nodes :");
//		Scanner scanner = new Scanner(System.in);
//		int size = scanner.nextInt();
//		
//		System.out.println("Enter the elements :");
//		for(int i=0;i<size;i++) {
//			tree.root = tree.insertNode(tree.root, scanner.nextInt());
//		}
//
//		System.out.println("The inorder travesal of BST is :");
//		tree.inOrder(tree.root);
//		
//		System.out.println("\nThe min value in BST is : "+tree.minValue(tree.root));
//		System.out.println("The max value in BST is : "+tree.maxValue(tree.root));
//		
//		System.out.println("The min node in BST is : "+tree.minNode(tree.root).data);
//		System.out.println("The max node in BST is : "+tree.maxNode(tree.root).data);
		
//		tree.deleteNode(tree.root, 10);
		
//		System.out.println("The inorder travesal of BST is :");
//		tree.inOrder(tree.root);
		
//		int item1=2;
//		int item2=18;
//		System.out.println("The leastCommonAncestor of "+item1+" and "+item2+" is: "+tree.leastCommonAncestor(tree.root, item1, item2).data);
		
//		tree.convertSortedArrayToBalancedBST();
		
//		tree.buildBinaryTree();
//		tree.convertBinaryTreeToBalancedBST(tree.root);
		
 
	}

}
