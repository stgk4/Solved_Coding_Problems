package com.srinu.graphs;

import java.util.ArrayList;

public class BelmondFord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creating a graph
		int V = 5;
		int E = 8;
		Graph graph = new Graph(V, E);

        // add edges 0-1 (or A-B in above figure)
        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;
        graph.edges[0].weight = -1;
 
        // add edges 0-2 (or A-C in above figure)
        graph.edges[1].src = 0;
        graph.edges[1].dest = 2;
        graph.edges[1].weight = 4;
 
        // add edges 1-2 (or B-C in above figure)
        graph.edges[2].src = 1;
        graph.edges[2].dest = 2;
        graph.edges[2].weight = 3;
 
        // add edges 1-3 (or B-D in above figure)
        graph.edges[3].src = 1;
        graph.edges[3].dest = 3;
        graph.edges[3].weight = 2;
 
        // add edges 1-4 (or A-E in above figure)
        graph.edges[4].src = 1;
        graph.edges[4].dest = 4;
        graph.edges[4].weight = 2;
 
        // add edges 3-2 (or D-C in above figure)
        graph.edges[5].src = 3;
        graph.edges[5].dest = 2;
        graph.edges[5].weight = 5;
 
        // add edges 3-1 (or D-B in above figure)
        graph.edges[6].src = 3;
        graph.edges[6].dest = 1;
        graph.edges[6].weight = 1;
 
        // add edges 4-3 (or E-D in above figure)
        graph.edges[7].src = 4;
        graph.edges[7].dest = 3;
        graph.edges[7].weight = -3;
 
        graph.BellmanFord(graph, 0);
	}
	
	public static class Graph{
		int V;
		int E;
		Edge edges[];
		public Graph(int v, int e){
			this.V = v;
			this.E = e;
			edges = new Edge[e];
			for (int i=0; i<e; i++){
				edges[i] = new Edge();
			}
		}
	
		public void BellmanFord(Graph graph, int src){
			int V = graph.V, E=graph.E;
			int dist[] = new int[V];
			
			//step1: initialize distances from src to all other
			//vertices as infinite
			for(int i=0; i<V; i++){
				dist[i] = Integer.MAX_VALUE;
			}
			dist[src] = 0;
			
			//Step2: Relax all edges |V|-1 times. A simple
			//shortest path from src to any other vertex can have
			//at-most |V|-1 edges		
			for(int i=1; i<V; ++i){
				for(int j=0; j<E; ++j){
					int u = graph.edges[j].src;
					int v = graph.edges[j].dest;
					int weight = graph.edges[j].weight;
					if(dist[u]!=Integer.MAX_VALUE && 
							dist[u]+weight<dist[v])
						dist[v] = dist[u]+weight;
				}
			}
			
			//Step3: important - to check for negative weight cycles
			for(int j=0; j<E; ++j){
				int u = graph.edges[j].src;
				int v = graph.edges[j].dest;
				int weight = graph.edges[j].weight;
				if(dist[u]!=Integer.MAX_VALUE && 
						dist[u]+weight<dist[v])
					System.out.println("NegativeWeightCycle present in the graph");
			}
			printDist(dist, V);
		}
		
		public void printDist(int []dist, int V){
			System.out.println("Vertex      Distance from Source");
			for(int i=0; i<V; i++){
				System.out.println(i + "\t\t" + dist[i]);
			}
		}
	}
	
	public static class GraphNode{
		int val;
		public GraphNode(int val){
			this.val = val;
		}
	}
	
	public static class Edge{
		int src, dest, weight;
		public Edge(){
			src = dest = weight =0;
		}
	}

}
