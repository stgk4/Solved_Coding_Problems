package com.srinu.algos;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

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
			if(n.visited==false){
				dfs(n);
			}
		}
	}
	
	public static void bfs(Node root) {
		Queue<Node> queue=new ArrayDeque<Node>();
		root.visited=true;
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node n = queue.remove();
			for(Node a: n.adjacent) {
				if(!a.visited) {
					a.visited=true;
					queue.add(a);
				}
			}
		}
		
		
	}
}
