package com.srinu.traversals;

import java.util.TreeMap;
import java.util.ArrayList;

public class DiagonalTraversal {

	public static TreeMap<Integer, ArrayList<Integer>> tm = new TreeMap<Integer, ArrayList<Integer>>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(20);
		root.left = new Node(8);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		root.right = new Node(22);
		root.right.left = new Node(11);
		root.right.right = new Node(25);
		diagonalTraversal(root);
	}

	public static void diagonalTraversal(Node root){
		diagonalTraversal(root,0);

		for(int key: tm.keySet())
			for(int i: tm.get(key)) 
				System.out.print(i + " ");
	}


	private static void diagonalTraversal(Node root, int level) {
		// TODO Auto-generated method stub
		if(root==null) return;
		ArrayList<Integer> nodes_at_level = null;
		if(tm.containsKey(level)) nodes_at_level = tm.get(level);
		else nodes_at_level = new ArrayList<Integer>();

		nodes_at_level.add(root.data);
		tm.put(level, nodes_at_level);

		diagonalTraversal(root.left, level+1);
		diagonalTraversal(root.right, level);

	}

}
