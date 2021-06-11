package practice.code;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Stack;

public class Graph{
	 
	 private int v;
	 private LinkedList<Integer>[] adjList;
	 
	 Graph(int numVertices){
		 v = numVertices;
		 adjList = new LinkedList[v];
		 for(int i=0;i<v;i++) {
			 adjList[i] = new LinkedList<Integer>();
		 }
	 }
	 
	 public void addDirectedEdge(int s, int d) {
		 adjList[s].add(d);
	 }
	 
	 public void addUnDirectedEdge(int s, int d) {
		 adjList[s].add(d);
		 adjList[d].add(s);
	 }
	 
	 public void printGraph() {
		 
		 System.out.println("The graph is :\n");
		 for(int i=0;i<v;i++) {
			 
			 System.out.print(i+"--> ");
			 for(int j=0;j<adjList[i].size();j++) {
				 System.out.print(adjList[i].get(j)+"->");
			 }
			 System.out.println();
		 }
		 
	 }
	 
	 public void BFS(int startVertex) {
		 
		 boolean visited[] = new boolean[v];
		 
		 Queue<Integer> queue = new LinkedList<Integer>();
		 visited[startVertex] = true;
		 queue.add(startVertex);
		 
		 while(!queue.isEmpty()) {
			 
			 Integer vertex = queue.poll();
			 System.out.print(vertex+" ");
			 ListIterator iterator = adjList[vertex].listIterator();
			 
			 while(iterator.hasNext()) {
				 
				 int neighbour = (int) iterator.next();
				 if(!visited[neighbour]) {
					 queue.add(neighbour);
					 visited[neighbour]=true;
				 }
				 
			 }
			  
		 }
		
		 //Space Complexity = O(V)     => space required for the visited[] and the queue...
		 //Time complexity  = O(V + E) => for every edge present in the adj.list, constant time is done and the time taken for initializing the visited[]  
		 
	 }
	 
	 public void DFS(int vertex,boolean[] visited) {
		 
		System.out.print(vertex+" ");
		
		for(int i=0; i<adjList[vertex].size(); i++) {
			
			if(! visited[adjList[vertex].get(i)] ) {
				visited[adjList[vertex].get(i)] = true;
				DFS(adjList[vertex].get(i),visited);
			}
		}
		 
	 }
	 
	 public void callDFS(int startVertex) {
		 
		 boolean[] visited = new boolean[v];
		 visited[startVertex] = true;
		 DFS(startVertex, visited);
		 
	 }
	 
	 public void DFSWithoutRecursion( int vertex ) {
		 
		 boolean visited[] = new boolean[v];
		 Stack<Integer> stack = new Stack<Integer>();
		 stack.push(vertex);
		 visited[vertex] = true;
		 
		 while(!stack.isEmpty()) {
			 
			 int curNode = stack.pop();
			 System.out.print(curNode+" ");
			 
			 for(Integer neighbour : adjList[curNode]) {
				 
				 if(!visited[neighbour]) {
					 visited[neighbour] = true;
					 stack.push(neighbour);
				 }
			 }
			 
		 }
		 
	 }
	 
	 public boolean isCyclicUtil(int vertex,boolean[] visited, int parent) {
		 
		 visited[vertex] = true;
		 
		 for(int i=0; i< adjList[vertex].size(); i++) {
			 
			 int nextVertex = adjList[vertex].get(i);
			 
			 if(visited[nextVertex] != true) {
				 
				 if(isCyclicUtil(nextVertex, visited, vertex)) {
					 return true;
				 }
				 
			 }else if(nextVertex != parent){
				 // this implied that there is a back edge from the current vertex to the nextVertex
				 // if there comes a back edge while traversing DFS, it leads to a cycle
				 System.out.print("Backedge found between "+vertex+" and "+nextVertex);
				 return true;
			 }
			 
		 }
		 
		 return false;
	 }
	 
	 public boolean isCyclic() {
		 
		 boolean[] visited = new boolean[v];
		 return isCyclicUtil(0, visited, -1);
		 
	 }
	 
	 public void topologicalSort() {
		 
		 int[] inDegreeArr = new int[v];
		 
		 for(int i=0;i<adjList.length; i++) {
			 
			 for(int j=0; j< adjList[i].size(); j++) { 
				 inDegreeArr[adjList[i].get(j)]++;
			 }
			 
		 }
		 
		 Queue<Integer> queue = new LinkedList<Integer>();
		 for(int i=0;i<inDegreeArr.length; i++) {
			 if(inDegreeArr[i] ==0) {
				 queue.add(i);
			 }
		 }
		 
		 while(!queue.isEmpty()) {
			 
			 int vertex = queue.poll();
			 System.out.print(vertex+" ");
			 for(int edge: adjList[vertex]) {
				 inDegreeArr[edge]--;
				 if(inDegreeArr[edge] ==0) {
					 queue.add(edge);
				 }
			 }
			 
		 }
		 
		 //Time Complexity = O(V+E)
		 //Space Complexity = O()
	 }
	 
	 public boolean pathFinder(int fromVertex, int toVertex, boolean[] visited) {
		 
		 visited[fromVertex] = true;
		 
		 for(int i=0; i< adjList[fromVertex].size() ; i++) {
			 
			 int neighbour = adjList[fromVertex].get(i);
			 if(neighbour == toVertex) {
				 return true;
			 }
			 
			 if(!visited[neighbour]) {
				 if(pathFinder(neighbour,toVertex,visited)) {
					 return true;
				 }
			 }
			 
		 }	 
		 return false;
	 }
	 
	 public void isPathExists(int fromVertex, int toVertex) {
		 
		 boolean visited[] = new boolean[v];
		 
		 if(pathFinder(fromVertex,toVertex,visited)) {
			 System.out.println("Path found between "+fromVertex+" and "+toVertex);
		 }else {
			 System.out.println("No Path found between "+fromVertex+" and "+toVertex);
		 }
		 
	 }
	 
	 public static void main(String[] args) {
		  
		 Graph g = new Graph(6);
//		 g.addUnDirectedEdge(0, 1);
//		 g.addUnDirectedEdge(0, 2);
//		 g.addUnDirectedEdge(0, 3);
//		 
//		 g.addUnDirectedEdge(1, 4);
//		 g.addUnDirectedEdge(2, 4);
//		 
//		 g.addUnDirectedEdge(3, 5);
//		 g.addUnDirectedEdge(3, 6);
//		 
//		 g.addUnDirectedEdge(4, 7);
//		 
//		 g.addUnDirectedEdge(5, 7);
//		 g.addUnDirectedEdge(5, 8);
//		 
//		 g.addUnDirectedEdge(6, 8);
//		 
//		 g.addUnDirectedEdge(7, 9);
//		 g.addUnDirectedEdge(8, 9);
		 
//		 g.printGraph();
		 
//		 g.BFS(0);	 
//		 g.callDFS(0);
//		 g.DFSWithoutRecursion(0);
		 
//		 System.out.print("The given graph contains cycle :"+g.isCyclic());
		 
//		 g.addDirectedEdge(5, 0);
//		 g.addDirectedEdge(5, 2);
//		 g.addDirectedEdge(4, 0);
//		 g.addDirectedEdge(4, 1);
//		 g.addDirectedEdge(2, 3);
//		 g.addDirectedEdge(3, 1);
//		 
////		 g.printGraph();
//		 g.topologicalSort();
		 
		 g.addDirectedEdge(0, 1);
		 g.addDirectedEdge(0, 3);
		 g.addDirectedEdge(1, 2);
		 g.addDirectedEdge(2, 4);
		 g.addDirectedEdge(2, 5);
		 g.addDirectedEdge(3, 5);
		 g.addDirectedEdge(4, 1);
		 
		 g.printGraph();
		 
		 g.isPathExists(5, 4);
	 }
	 
}
