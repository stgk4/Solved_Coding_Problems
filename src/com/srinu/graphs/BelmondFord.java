package com.srinu.graphs;

import java.util.ArrayList;

public class BelmondFord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static class Graph{
		int V;
		int E;
		ArrayList<GraphNode> adjacencyList[] = null;
		public Graph(int v){
			this.V = v;
			adjacencyList = new ArrayList[V];
		}
	
	}
	
	public static class GraphNode{
		int val;
		public GraphNode(int val){
			this.val = val;
		}
	}

}
