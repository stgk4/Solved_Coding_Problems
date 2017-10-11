package com.srinu.graphs;

public class Graph {
	
	/*
	 * Edge class with parameters src, dest, weight
	 */
	class Edge implements Comparable<Edge>{
		int src, dest, weight;
		public int compareTo(Edge compareEdge){
			return this.weight -compareEdge.weight;
		}
	};
	
	//A class to represent a subset for union-find
	class Subset{
		int parent, rank;
	}
	
	int V, E; //V: no of vertices, E: no of edges
	Edge edge[];
	
	Graph(int v, int e){
		V = v;
		E = e;
		edge = new Edge[E];
		for(int i=0; i<e; ++i){
			edge[i] = new Edge();
		}
	}
	
	int find(Subset subsets[], int i){
		if(subsets[i].parent!=i)
			subsets[i].parent = find(subsets, subsets[i].parent);
		return subsets[i].parent;
	}
	
	void Union(Subset[] subsets, int x, int y){
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);
		
		if(subsets[xroot].rank < subsets[yroot].rank)
			subsets[xroot].parent = yroot;
		else if(subsets[xroot].rank>subsets[yroot].rank)
			subsets[yroot].parent = xroot;
		else{
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}
	
	
	
}
