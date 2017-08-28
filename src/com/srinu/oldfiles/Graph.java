package com.fb.concepts;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
private int V; //no of vertices
private LinkedList<Integer> adj[]; //array of linkedList
boolean visited_dfs[];
boolean cycle_status = false;
	public Graph(int no_of_vertices){
		V = no_of_vertices;
		adj = new LinkedList[no_of_vertices];
		for(int i=0; i<no_of_vertices; i++){
			adj[i] = new LinkedList<Integer>();
		}
		 visited_dfs = new boolean[V];
	}
	
	public void addEdges(int n, int w){
		adj[n].add(w);
	}
	
	public void BFS(int s){
		boolean visited[] = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		visited[s] = true;
		while(!queue.isEmpty()){
			s = queue.poll();
			System.out.println(s+"");
			Iterator<Integer> adj_node = adj[s].listIterator();
			while(adj_node.hasNext()){
				int n = adj_node.next();
				if(!visited[n]){
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
	
	public boolean DFS(int s){
		if(visited_dfs[s]){
			//break;
			//return true;
			
		}
		visited_dfs[s] = true;
		System.out.println(s+" ");
		Iterator<Integer> adj_node = adj[s].listIterator();
		while(adj_node.hasNext()){
			int node = adj_node.next();
			if(!visited_dfs[node]){
				DFS(node);
			}
			else{
				cycle_status = true;
				System.out.println("Cycle at:"+s);
			}
		}
		return cycle_status;
	}
	
	public static void main(String args[]){
		Graph g = new Graph(4);
		g.addEdges(0, 1);
		g.addEdges(0, 2);
		g.addEdges(1, 2);
		g.addEdges(2, 0);
		g.addEdges(2, 3);
		g.addEdges(3, 3);
		//g.BFS(2);
		System.out.println(g.DFS(2));
	}
	
}
