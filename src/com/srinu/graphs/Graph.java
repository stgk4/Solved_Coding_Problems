package com.srinu.graphs;

import java.util.Arrays;

public class Graph {
	
	int V, E; //V: no of vertices, E: no of edges
	Edge edge[];
	
	/*
	 * Constructor to initialize no of vertices and
	 * edges
	 */
	Graph(int v, int e){
		V = v;
		E = e;
		edge = new Edge[E];
		for(int i=0; i<e; ++i){
			edge[i] = new Edge();
		}
	}
	
	/*
	 * Edge class with parameters src, dest, weight
	 * each edge will have a source and destination, and a
	 * corresponding weight
	 */
	class Edge implements Comparable<Edge>{
		int src, dest, weight;
		
		public int compareTo(Edge compareEdge){
			return this.weight -compareEdge.weight;
		}
	};
	
	
	//The main function to construct MST using Kruskal's algorithm
	void KruskalMST() {
		Edge result[] = new Edge[V]; //this will store the resultant MST
		int e=0; //an index variable, used for result[]
		int i =0; //an index variable, used for sorted edges
		for(i=0; i<V; ++i)
			result[i] = new Edge();
		
		//step 1: sort all the edges in ascending order of weight.
		Arrays.sort(edge);
		
		//Allocate memory for creating V subsets
		Subset[] subsets = new Subset[V];
		for(i=0; i<V; i++) {
			subsets[i] = new Subset();
		}
		
		//initialize V subsets as individual elements
		for(int v=0; v<V; v++) {
			subsets[v].parent = v;
			subsets[v].rank = 0;
		}
		
		i =0; //Index used to pick next edge
		
		//no of edges to be taken is equal to V-1
		while(e < V-1) {
			//Step 2: Pick the smallest edge. And increment the index 
			//for next iteration
			Edge next_edge = new Edge();
			next_edge = edge[i++];
			
			int x = find(subsets, next_edge.src);
			int y = find(subsets, next_edge.dest);
			
			//if including this edge does not cause cycle, include it
			//in result and increment the index of result for next edge
			if(x!=y) {
				result[e++] = next_edge;
				Union(subsets, x, y);
			}
		}
		
		System.out.println("Edges constructed in constructed MST");
		for(i=0; i<e; i++) {
			System.out.println(result[i].src + "--" + result[i].dest + "=="+ result[i].weight);
		}
		
	}
	
	//A class to represent a subset for union-find
	class Subset{
		int parent, rank;
	}
	
	/*
	 * A function to find set of an element i
	 */
	int find(Subset subsets[], int i){
		//find root and make root as parent of i
		if(subsets[i].parent!=i)
			subsets[i].parent = find(subsets, subsets[i].parent);
		return subsets[i].parent;
	}
	
	/*
	 * A function that does union of two sets of x and y
	 */
	void Union(Subset[] subsets, int x, int y){
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);
		
		//attach smaller rank tree under root of 
		//high rank tree (union by rank)
		if(subsets[xroot].rank < subsets[yroot].rank)
			subsets[xroot].parent = yroot;
		else if(subsets[xroot].rank>subsets[yroot].rank)
			subsets[yroot].parent = xroot;
		
		//if ranks are same, then make one as root and increment
		//its rank by one
		else{
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}
	
	// Driver Program
    public static void main (String[] args)
    {
 
        /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */
        int V = 4;  // Number of vertices in graph
        int E = 5;  // Number of edges in graph
        Graph graph = new Graph(V, E);
 
        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;
 
        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;
 
        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;
 
        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;
 
        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;
 
        graph.KruskalMST();
    }
	
}
