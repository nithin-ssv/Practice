package practice.code;

import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import practice.code.BinarySearchTree.Node;

public class BinaryTree {


	public BinaryTree() {
		hMin=0;
		hMax=0;
	}
	
	public class Node{
		int data;
		Node left;
		Node right;
		int hd;
		public Node(int d) {
			data = d;
			left = null;
			right = null;
		}
	}
	
	public Node root;
	public Node root2;
	public Node root3;
	public Node subtreeroot;

	
	public void buildTree() {
		
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
	
	public void buildSecondTree() {
		
		Node newNode = new Node(5);
		root2 = newNode;
		
		root2.left = new Node(3);
		root2.right = new Node(6);
		
		root2.left.left = new Node(1);
		root2.left.right = new Node(4);
		
		root2.right.right = new Node(8);
		
		root2.left.left.right = new Node(2);
		
		root2.right.right.left = new Node(7);
	}
	
	public void buildSumTree() {
		
		Node newNode = new Node(30);
		
		root3 = newNode;
		
		root3.left = new Node(5);
		root3.right = new Node(10);
		
		root3.left.left = new Node(2);
		root3.left.right = new Node(3);
		
		root3.right.left = new Node(6);
		root3.right.right = new Node(4);
		
	}
	
	public void buildSubTree() {
		
		subtreeroot = new Node(4);
		
		subtreeroot.left = new Node(15);
		subtreeroot.right = new Node(16);
		
	}
	
	public boolean areIdenticalTrees(Node root1, Node root2) {
		
		if(root1==null && root2==null) {
			return true;
		
		}else if(root1 !=null && root2 != null ) {
			if(root1.data != root2.data) {
				return false;
			}
			return areIdenticalTrees(root1.left,root2.left) && areIdenticalTrees(root1.right,root2.right);
		
		}else {
			return false;
		}
		
	}
	
	public int countTheNodes(Node root) {
		
		if(root!=null) {
			int l= countTheNodes(root.left);
			int r = countTheNodes(root.right);
			int sum = 1+l+r;
			return sum;
		}else {
			return 0;
		}
		
	}
	
	public void preOrder(Node root) {
		if(root!=null) {
			System.out.print(root.data+" ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public void inOrder(Node root) {
		if(root!=null) {
			inOrder(root.left);
			System.out.print(root.data+" ");
			inOrder(root.right);
		}
	}
	
	public void postOrder(Node root) {
		
		if(root!=null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data+" ");
		}
		
	}
	
	public int countLeaves(Node root) {
		
		if(root == null) {
			return 0;
		}
		else if(root.left == null && root.right == null) {
			return 1;
		}else {
			return countLeaves(root.left) + countLeaves(root.right);
		}
	}
	
	public int countNonLeafNodes(Node root) {
		
		if(root==null) {
			return 0;
		}else if(root.left !=null || root.right !=null) {
			return 1+ countNonLeafNodes(root.left) + countNonLeafNodes(root.right);
		}else {
			return 0;
		}
		
	}
	
	public int countFullNodes(Node root) {
		
		if(root!=null) {
			int sum = 0;
			if(root.left !=null && root.right !=null) {
				sum =  1+countFullNodes(root.left) + countFullNodes(root.right);
			}else if(root.left!=null) {
				sum = countFullNodes(root.left);
			}else if(root.right!=null){
				sum = countFullNodes(root.right);
			}
			return sum;
		}else {
			return 0;
		}
		
	}
	
	public int heightOfTree(Node root) {
		
		if(root == null || (root.left == null && root.right == null)) {
			return 0;
		}
		
		return 1+ max( heightOfTree(root.left), heightOfTree(root.right) );
	}
	
	public int max(int a ,int b) {
		int max =  (a>b)?  a:  b;
		return max;
	}
	
	public void mirrorTree(Node root) {
		
		if(root==null || (root.left == null && root.right == null)) {
			return;
		}
		
		Node temp;
		temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		mirrorTree(root.left);
		mirrorTree(root.right);
		
	}
	
	public void levelOrderTraversal(Node root) {
		
		Queue<Node> queue =  new LinkedList<Node>();
		
		queue.add(root);
		System.out.println("The level order traversal is :");
		while(!queue.isEmpty()) {
			Node item = queue.remove();
			if(item!=null) {
				System.out.print(" "+item.data);
				queue.add(item.left);
				queue.add(item.right);
			}
		}
		
	}
	
	public Node leastCommonAncestor(Node root, int item1, int item2) {
		
		if(root == null) {
			return root;
		}
		
		if(root.data == item1 || root.data == item2) {
			return root;
		}
		
		Node left = leastCommonAncestor(root.left,item1,item2);
		Node right = leastCommonAncestor(root.right,item1,item2);
		
		if(left == null) {
			return right;
		}else if(right == null) {
			return left;
		}else {
			return root;
		}
		
	}
	
	public Node convertToDLL(Node root) {
		
		if(root.left == null && root.right == null) {
			return root;
		}
		
		Node lNode = convertToDLL(root.left);
		Node rNode = convertToDLL(root.right);
		
		Node temp = lNode;
		while(temp.right != null) {
			temp = temp.right;
		}
		
		temp.right = root;
		root.left = temp;
		
		temp = rNode;
		while(temp.left != null) {
			temp = temp.left;
		}
		
		temp.left = root;
		root.right = temp;
		
		return root;
		
	}
	
	public int heightNode(Node root) {
		
		// height of the tree considering height of leaf as 1
		
		if(root == null) {
			return 0;
		}
		return 1+max(heightNode(root.left),heightNode(root.right));
	}
	
	public int diameter(Node root) {
		
		//Considering the maximum path (no. of edges) between any two nodes in a tree...
		if(root == null) {
			return 0;
		}
		
		int heightOfLST = heightNode(root.left);
		int heightOfRST = heightNode(root.right);
		
		int lDiameter = diameter(root.left);
		int rDiameter = diameter(root.right);
		
		return max(heightOfLST+heightOfRST, max(lDiameter,rDiameter));
		
		//Time complexity is O(n*2)
		//since every time while finding the diameter we need to find the height of the tree. 
		
	}
	
	public class Height{
		int height;
		Height() {
			height = 0;
		}
	}
	
	public int diameterOpt(Node root,Height h){
		
		Height lh = new Height();
		Height rh = new Height();
		
		if(root == null) {
			h.height = 0;
			return 0;
		}
		
		int lDiameter = diameterOpt(root.left,lh);
		int rDiameter = diameterOpt(root.right,rh);
		
		h.height = 1 + max(lh.height, rh.height);
		
		return max((lh.height+rh.height) , max(lDiameter,rDiameter) );
		
	}
	
	int diameterOpt(Node root)
    {
        Height height = new Height();
        return diameterOpt(root, height);
    }
	
	public int findLevelOfNode(Node root, int level ,int item) {
		
		if(root == null) {
			return -1;
		}
		
		if(root.data == item) {
			return level;
		}
		
		int level2 = findLevelOfNode(root.left,level+1,item);
		
		if(level2!=-1) {
			return level2;
		}
		
		return findLevelOfNode(root.right,level+1,item);
		
	}
	
	public void printNodesAtKdistanceFromRoot(Node root, int curDist, int givenDist) {
		
		if(root == null) {
			return;
		}
		
		if(curDist == givenDist) {
			System.out.print(root.data+" ");
		}else {
			
			printNodesAtKdistanceFromRoot(root.left,curDist+1,givenDist);
			printNodesAtKdistanceFromRoot(root.right,curDist+1,givenDist);
			
		}	
	}
	
	public int printNodesAtKDistanceFromKey(Node root,int k,int key) {
		
		if(root == null) {
			return -1;
		}
		if(root.data == key) {
			printNodesAtKdistanceFromRoot(root,0,k);
			return k-1;
		}
		
		int lDist = printNodesAtKDistanceFromKey(root.left,k,key);
		
		if(lDist != -1) {
			if(lDist == 0) {
				System.out.print(root.data+" ");
			}else {
				printNodesAtKdistanceFromRoot(root.right,0,lDist-1);
			}
			return lDist-1;
		}
		
		int rDist = printNodesAtKDistanceFromKey(root.right,k,key);
		if(rDist != -1) {
			if(rDist == 0) {
				System.out.print(root.data+" ");
			}else {
				printNodesAtKdistanceFromRoot(root.left,0,rDist-1);
			}
			return rDist-1;
		}
		
		return -1;
	}
	
	public int hMin;
	public int hMax;
	
	
	public void horizontalRange(Node root, int hDist) {
		
		if(root == null) {
			return;
		}
		
		if(hDist < hMin) {
			hMin = hDist;
		}
		if(hDist > hMax) {
			hMax = hDist;
		}
		
		horizontalRange(root.left,hDist-1);
		horizontalRange(root.right,hDist+1);
		
	}
	
	public void printVerticalOrder(Node root,int cur, int hDist) {
		
		if(root == null) {
			return;
		}
		
		if(cur == hDist) {
			System.out.print(root.data+" ");
		}
		
		printVerticalOrder(root.left, cur-1 , hDist);
		printVerticalOrder(root.right, cur+1, hDist);
		
		
	}
	
	public void verticalOrderTraversal(Node root) {
		
		horizontalRange(root, 0);
		for(int i=hMin; i<=hMax; i++) {
			printVerticalOrder(root,0,i);
		}
		
	}
	
	public Map<Integer,ArrayList<Integer>> treeMap;
	
	public void traverseVerticalOrderUsingTreeMap(Node root,int hDist) {
		
		if(root == null) {
			return;
		}
		
		ArrayList<Integer> nodeList = null;
		
		if( treeMap.get(hDist) != null ) {
			nodeList = treeMap.get(hDist);
		 }else {
			 nodeList = new ArrayList<Integer>();
		 }
		nodeList.add(root.data);
		treeMap.put(hDist, nodeList);
		
		traverseVerticalOrderUsingTreeMap(root.left, hDist-1);
		traverseVerticalOrderUsingTreeMap(root.right, hDist+1);
			
	}
	
	public void verticalOrderTraversalUsingMap(Node root) {
		
		treeMap = new TreeMap<Integer,ArrayList<Integer>>();
		//we use treemap because, the keys should be stored in a sorted order 
		traverseVerticalOrderUsingTreeMap(root,0);
		
		for(Entry<Integer, ArrayList<Integer>> map : treeMap.entrySet()) {
			
			ArrayList<Integer> itemList = map.getValue();	
			
//			System.out.println("\nNodes at horizontal distance : "+map.getKey());
			for(Integer item: itemList) {
				System.out.print(item+" ");
			}
			
		}
			
	}
	
	public Map<Integer,Integer> verticalSumMap; 
	
	public void computeVerticalSum(Node root, int hDist) {
		
		if(root == null) {
			return;
		}
		
		int curSum = 0;
		if(verticalSumMap.containsKey(hDist)) {
			curSum = verticalSumMap.get(hDist);
		}
		curSum = curSum + root.data;
		verticalSumMap.put(hDist, curSum);
		
		computeVerticalSum(root.left,hDist-1);
		computeVerticalSum(root.right,hDist+1);
		
	}
	
	public void verticalSumOfBinaryTree(Node root) {
		
		verticalSumMap = new TreeMap<Integer,Integer>();
		computeVerticalSum(root,0);
		
		System.out.println("The vertical sum of the tree is :");
		for(Entry<Integer,Integer> entry : verticalSumMap.entrySet()) {
			System.out.println("\n"+entry.getKey()+" = "+entry.getValue());
		}
		
	}
	
	public int isSumTree(Node root) {
		
		//sum of each node in the tree should be equal to sum of all the nodes in its LST and RST
		
		if(root == null) {
			return 0;
		}
		
		if( root.left == null && root.right==null ) {
			return root.data;
		}
		
		int lSum = isSumTree(root.left);
		int rSum = isSumTree(root.right);
		
		if(lSum == -1 || rSum == -1) {
			return -1;
		}
		
		if(root.data == lSum + rSum) {
			 return lSum + rSum + root.data;
		}
		
		return -1; 
	}

//we will get issue with this implementation.. so we have to go with level order traversal	
//	public void traverseTopView(Node root, int hDist) {
//		
//		if(root == null) {
//			return;
//		}
//		
//		if(!verticalSumMap.containsKey(hDist)) {
//			verticalSumMap.put(hDist, root.data);
//		}else {
//			return;
//		}
//		
//		traverseTopView(root.left,hDist-1);
//		traverseTopView(root.right,hDist+1);
//		
//		
//	}
//	
//	public void topView(Node root) {
//		
//		verticalSumMap = new TreeMap<Integer,Integer>();
//		
//		System.out.print("\nThe top view of the tree is :\n");
//		
//		traverseTopView(root,0);
//		
//		for(Entry<Integer,Integer> entry : verticalSumMap.entrySet()) {
//			
//			System.out.print(" "+entry.getValue());
//			
//		}
//		
//	}
	
	public void printVertcalOrderUsingLevelOrder(Node root) {
		
		treeMap = new TreeMap<Integer,ArrayList<Integer>>();
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.peek();
			queue.remove();
			
			ArrayList<Integer> nodeList = null; 
			if(treeMap.containsKey(temp.hd)) {
				nodeList = treeMap.get(temp.hd);
			}else {
				nodeList = new ArrayList<Integer>();
			}
			
			nodeList.add(temp.data);
			treeMap.put(temp.hd, nodeList);
			
			if(temp.left!=null) {
				temp.left.hd = temp.hd -1;
				queue.add(temp.left);
			}
			
			if(temp.right!=null) {
				temp.right.hd = temp.hd + 1;
				queue.add(temp.right);
			}
		}
		
		for(Entry<Integer,ArrayList<Integer>> entry : treeMap.entrySet()) {
			
			ArrayList<Integer> nodeList = entry.getValue();
			System.out.print("\nNodes at horizontal distance "+entry.getKey()+" :");
			for(Integer item : nodeList) {
				System.out.print(" "+item);
			}
			
		}
		
	}
	
	public void topView(Node root) {
		
		Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.peek();
			queue.remove();
			
			if(!map.containsKey(temp.hd)) {
				map.put(temp.hd, temp.data);
			}
			
			if(temp.left!=null) {
				temp.left.hd = temp.hd - 1;
				queue.add(temp.left);
			}
			
			if(temp.right!=null) {
				temp.right.hd = temp.hd + 1;
				queue.add(temp.right);
			}
			
		}
		
		System.out.println("\nThe top view of the tree is :\n");
		for(Entry<Integer,Integer> entry: map.entrySet()) {
			System.out.print(entry.getValue()+" ");
		}
		
	}
	
	public void bottomView(Node root) {
		
		Map<Integer,Integer> treeMap = new TreeMap<Integer,Integer>();
		Queue<Node> queue = new LinkedList<Node>();
		
		root.hd = 0;
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.remove();
			
			treeMap.put(temp.hd, temp.data);
			
			if(temp.left!=null) {
				temp.left.hd = temp.hd - 1;
				queue.add(temp.left);
			}
			
			if(temp.right!=null) {
				temp.right.hd = temp.hd + 1;
				queue.add(temp.right);
			}
			
			
		}
		
		System.out.println("\nThe bottom view of the tree is :\n");
		for(Entry<Integer,Integer> entry : treeMap.entrySet()) {
			System.out.print(" "+entry.getValue());
		}
		
	}
	
	int max_level;
	public void leftView(Node root,int level) {
		
		if(root == null) {
			return;
		}
		
		if(level > max_level) {
			System.out.print(root.data+" ");
			max_level = level;
		}
		
		leftView(root.left, level+1);
		leftView(root.right, level+1);
	}
	
	public void rightView(Node root,int level) {
		
		if(root == null) {
			return;
		}
		
		if(level > max_level) {
			System.out.print(root.data+" ");
			max_level = level;
		}
		
		rightView(root.right, level+1);
		rightView(root.left, level+1);
	}
	
	public void buildTestTree() {
		
		Node newNode = new Node(8);
		root = newNode;
		root.left = new Node(3);
		root.right = new Node(10);
		
		root.left.left = new Node(1);
		
		root.right.left = new Node(6);
		root.right.right = new Node(14);
		
		root.right.left.left = new Node(4);
		root.right.left.right = new Node(7);
		
//		root.right.right.left = new Node(13);
		
	}
	
	public void diagonalTraversalUsingQueues(Node root) {
		
		Queue<Node> q1 = new LinkedList<Node>();
		Queue<Node> q2 = new LinkedList<Node>();
		
		q1.add(root);
		
		while(!q1.isEmpty() || !q2.isEmpty() ) {
			
			Node temp = null;
			
			if(!q1.isEmpty()) {
				temp = q1.remove();
			}else {
				temp = q2.remove().left;
			}
			
			System.out.print(temp.data+" ");
			
			if(temp.right != null) {
				q1.add(temp.right);
			}
			if(temp.left!=null) {
				q2.add(temp);
			}
			
		}
		
	}
	
	public Map<Integer,ArrayList<Integer>> slopeMap;
	
	public void diagonalTraversal(Node root,Integer slope) {
		
		if(root == null) {
			return;
		}
		
		ArrayList<Integer> numList = new ArrayList<Integer>();
		
		if(slopeMap.containsKey(slope)) {
			numList = slopeMap.get(slope);
		}else {
			numList = new ArrayList<Integer>();
		}
		
		numList.add(root.data);
		slopeMap.put(slope, numList);
		
		diagonalTraversal(root.left,slope+1);
		diagonalTraversal(root.right,slope);
		
	}
	
	public void printDiagonalTraversal(Node root) {
		
		slopeMap = new TreeMap<Integer,ArrayList<Integer>>();
		diagonalTraversal(root,0);
		
		for(Entry<Integer,ArrayList<Integer>> entry: slopeMap.entrySet()) {
			
			ArrayList<Integer> nodeList = entry.getValue();
			System.out.println();
			for(Integer node : nodeList) {
				System.out.print(" "+node);
			}
		}
		
	}
	
	public Node traverseAndRemoveNodes(Node root, int curLen, int givenLen) {
		
		if(curLen == givenLen) {
			return root;
		}
		
		if(root == null) {
			return null;
		}
		
		root.left = traverseAndRemoveNodes(root.left,curLen + 1, givenLen);
		root.right = traverseAndRemoveNodes(root.right,curLen+1, givenLen);
		
		if(root.left == null && root.right == null && curLen < givenLen) {
			return null;
		}
		return root;
	}
	
	public void removeNodesOnPathLessThanK(Node root,int k) {
		
		traverseAndRemoveNodes(root,1,k);
	}
	
	boolean checkBST(Node root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        boolean leftCheck = checkBST(root.left);
        boolean rightCheck = checkBST(root.right);
        if(leftCheck && rightCheck){
            if(root.left != null){
                if(root.data <= root.left.data){
                    return false;
                }
            }
            if(root.right != null){
                if(root.data >= root.right.data){
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }
	
	public boolean isSubTree(Node root1, Node root2) {
		
		if(root2 == null) {
			return true;
		}
		
		if(root1 == null) {
			return false;
		}
		
		if(areIdenticalTrees(root1,root2)) {
			return true;
		}
		
		return isSubTree(root1.left,root2) || isSubTree(root1.right,root2);
		
	}
	
	public String preOrderString(Node root,String orderStr) {
		
		if(root == null) {
			return orderStr;
		}
		
		orderStr = orderStr + root.data +",";
		
		orderStr =  preOrderString(root.left,orderStr);
		orderStr = preOrderString(root.right,orderStr);
		
		return orderStr;
	}
	
	public String inOrderString(Node root,String orderStr) {
		
		if(root == null) {
			return orderStr;
		}
		
		orderStr =  inOrderString(root.left,orderStr);
		orderStr = orderStr + root.data +",";
		orderStr = inOrderString(root.right,orderStr);
		
		return orderStr;
	}
	
	public boolean isSubTreeSecondApproach(Node root1, Node root2) {
		
		String preOrderRoot1 =  preOrderString(root1,"");
		System.out.println("\nThe preorder string of tree1 :\n"+preOrderRoot1);
		
		String preOrderRoot2 =  preOrderString(root2,"");
		System.out.println("\nThe preorder string of tree2 :\n"+preOrderRoot2);
		
		String inOrderRoot1 = inOrderString(root1,"");
		System.out.println("\nThe inorder string of tree1 :\n"+inOrderRoot1);
		
		String inOrderRoot2 = inOrderString(root2,"");
		System.out.println("\nThe inorder string of tree2 :\n"+inOrderRoot2);
		
		if(preOrderRoot1.contains(preOrderRoot2) && inOrderRoot1.contains(inOrderRoot2)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean checkForCousin(Node root, int curLevel, int parentLevel, int key1, int key2) {
		
		if(root == null) {
			return false;
		}
		
		if(curLevel == parentLevel) {
			
			boolean foundKey1 = false;
			boolean foundKey2 = false;
			if((root.left != null && root.left.data == key1) || (root.right!=null && root.right.data == key1)) {
				foundKey1 = true;
			}
			if((root.left != null && root.left.data == key2) || (root.right!=null && root.right.data == key2)) {
				foundKey2 = true;
			}
			
			if(foundKey1 && foundKey2) {
				return false;
			}
			
			return (foundKey1 || foundKey2);
			
		}
		
		return checkForCousin(root.left, curLevel+1, parentLevel,key1, key2) || checkForCousin(root.right, curLevel+1, parentLevel,key1, key2);
		
	}
	
	public boolean areCousins(Node root, int key1, int key2) {
		
		int level1 = findLevelOfNode(root, 1, key1);
		int level2 = findLevelOfNode(root, 1, key2);
		
		System.out.println("\nLevel1 = "+level1+" Level2 = "+level2);
		
		if(level1 == level2) {
			return checkForCousin(root, 1, level1-1, key1, key2);
		}
		
		return false;
	}
	
	public void printLeafNodePaths(Node root, int path[], int len) {
		
		if(root == null) {
			return;
		}
		
		if(root.left == null && root.right == null) {
			
			for(int i=0;i<=len;i++) {
				System.out.print(path[i]+" ");
			}
			System.out.print(root.data+" \n");
			return;
		}
		
		len = len+1;
		path[len] = root.data;
		
		printLeafNodePaths(root.left,path,len);
		printLeafNodePaths(root.right,path,len);
		
		
	}
	
	public void printLevelOrderInSpiralOrder(Node root) {
		
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		
		s1.push(root);
		
		while( !s1.isEmpty() || !s2.isEmpty() ) {
			
			while(!s1.isEmpty()) {
				
				Node  item = s1.pop();
				System.out.print(" "+item.data);
				
				if(item.right!=null) {
					s2.push(item.right);
				}
				if(item.left!=null) {
					s2.push(item.left);
				}
				
			}
			
			while(!s2.isEmpty()) {
				
				Node item = s2.pop();
				System.out.print(" "+item.data);
				
				if(item.left!=null) {
					s1.push(item.left);
				}
				if(item.right!=null) {
					s1.push(item.right);
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		tree.buildTree();
//		tree.buildSecondTree();
//		tree.buildSumTree();
//		tree.buildTestTree();
//		tree.buildSubTree();
		
//		System.out.println("The no. of nodes in the tree are : "+tree.countTheNodes(tree.root));
		
//		System.out.println("\nThe preorder traversal of the tree is :");
//		tree.preOrder(tree.root);
		
//		System.out.println("\nThe inorder traversal of the tree is :");
//		tree.inOrder(tree.root);
		
//		System.out.println("\nThe postorder traversal of the tree is :");
//		tree.postOrder(tree.root);
		
//		System.out.println("\nThe no. of leaves in the tree are : "+tree.countLeaves(tree.root));
		
//		System.out.println("\nThe no. of non leaf nodes in the tree are: "+tree.countNonLeafNodes(tree.root));
		
//		System.out.println("\nThe no. of full nodes in the tree are:"+tree.countFullNodes(tree.root));
		
//		System.out.println("\nThe height of the tree is "+tree.heightOfTree(tree.root));
		
//		System.out.println("\nThe identity of the two trees is "+tree.areIdenticalTrees(tree.root, tree.root2));
		
//		tree.mirrorTree(tree.root);
//		System.out.println("\nThe inorder traversal of the tree is :");
//		tree.inOrder(tree.root);
		
//		tree.levelOrderTraversal(tree.root);
		
//		System.out.println("\nLCA of the given nodes is:"+tree.leastCommonAncestor(tree.root, 7, 2).data);
		
//		tree.root = tree.convertToDLL(tree.root);
//		Node temp = tree.root;
//		while(temp.left !=null) {
//			temp = temp.left;
//		}
		
//		System.out.println("\nThe diameter of the tree is "+tree.diameter(tree.root));
		
		
//		System.out.println("\nThe diameter of the tree is "+tree.diameterOpt(tree.root));
		
//		System.out.println("\nThe level of the given node is :"+tree.findLevelOfNode(tree.root, 1, 6));
		
//		System.out.print("\nThe nodes at given level are : ");
//		tree.printNodesAtKdistanceFromRoot(tree.root, 0, 1);
//		tree.printNodesAtKDistanceFromKey(tree.root, 3, 4);
		
//		System.out.println("\n The vertical order traversal is: \n");
//		tree.horizontalRange(tree.root, 0);
//		System.out.println("\n The horizontal range is ["+tree.hMin+" ,"+tree.hMax+"]");
//		tree.verticalOrderTraversal(tree.root);
		
//		tree.verticalOrderTraversalUsingMap(tree.root);
		
//		tree.verticalSumOfBinaryTree(tree.root);
		
//		System.out.print("\nThe given tree is sumTree is:");
//		if(tree.isSumTree(tree.root3) == tree.root3.data * 2) {
//			System.out.print(" true");
//		}else {
//			System.out.print(" false");
//		}
		
//		tree.printVertcalOrderUsingLevelOrder(tree.root);
		
//		tree.topView(tree.root);
//		tree.bottomView(tree.root);
//		
//		System.out.println("\nThe left view of the tree is:\n");
//		tree.max_level = -1;
//		tree.leftView(tree.root,0);
		
//		System.out.print("\n\nThe diagonal traversal of tree is:\n");
//		tree.printDiagonalTraversal(tree.root);
//		tree.removeNodesOnPathLessThanK(tree.root, 4);
//		System.out.print("\n\nThe diagonal traversal of tree is:\n");
//		tree.printDiagonalTraversal(tree.root);
		
//		System.out.println("The given tree is BST :"+tree.checkBST(tree.root));
		
//		System.out.println("The second is sub tree of given tree :"+tree.isSubTree(tree.root, tree.subtreeroot));
//		System.out.println("The second tree is sub tree of given tree :"+tree.isSubTreeSecondApproach(tree.root, tree.subtreeroot));
		
//		System.out.println("\nThe given two nodes are cousins : "+tree.areCousins(tree.root, 7, 16));
		
//		tree.printLeafNodePaths(tree.root, new int[tree.countTheNodes(tree.root)], -1);
		
		System.out.println("\nThe nodes printed in spiral form of level order:\n");
		tree.printLevelOrderInSpiralOrder(tree.root);
	}
	
}
