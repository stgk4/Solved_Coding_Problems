package com.srinu.traversals;
import java.util.Queue;
import java.util.LinkedList;

public class MaxTreeWidth {

	public static void main(String[] args){
		Node node = new Node(5);
		node.left = new Node(4);
		node.right = new Node(3);
		node.left.left = new Node(2);
		node.left.right = new Node(1);
		node.right.left = new Node(6);
		node.right.right = new Node(8);
		System.out.print(getMaxTreeWidth(node));
	}
	
	/*
	 * Get maximum width of tree (may be at any level). So we 
	 * use level order traversal and count the nodes at each
	 * level, we will be done in O(N) complexity
	 */
	public static int getMaxTreeWidth(Node root){
		Queue<Node> queue = new LinkedList<Node>(); //bfs
		queue.add(root);
		int max_width = 0;
		while(!queue.isEmpty()){
			int count = queue.size();
			max_width = Math.max(max_width, count);
			while(--count>=0){
				Node n = queue.remove();
				if(n.left!=null) queue.add(n.left);
				if(n.right!=null) queue.add(n.right);
			}
		}
		
		return max_width;
	}
}
