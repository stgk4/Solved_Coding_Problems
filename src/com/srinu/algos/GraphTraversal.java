package com.srinu.algos;

import com.srinu.oldfiles.GG_CheckBinTree_Heap.Node;

public class GraphTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void dfs(Node root) {
		if (root==null) return;
		
		//visit(root);
		
		root.visited = true;
		for(Node n : root.adjacent) {
			if(n.visited==false) {
				dfs(n);
			}
		}
	}
	
	public static void bfs() {
		
	}
}
