package com.srinu.graphs;

import java.util.ArrayList;

public class BelmondFord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
	
		public static void addNode(int val){
			
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
