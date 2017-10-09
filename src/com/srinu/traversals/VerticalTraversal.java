package com.srinu.traversals;

import java.util.ArrayList;
import java.util.TreeMap;

public class VerticalTraversal {

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
		verticalTraversal(root);
	}
	private static void verticalTraversal(Node root) {
		// TODO Auto-generated method stub
		verticalTraversal(root, 0);
		
		//print
		for(int key: tm.keySet()){
			System.out.print("\nLevel-" + key + ">> ");
			for(int i: tm.get(key))
				System.out.print(i + " ");
		}
			
	}
	private static void verticalTraversal(Node root, int level) {
		// TODO Auto-generated method stub
		if(root==null) return;
		ArrayList<Integer> nodes_at_level = null;
		if(tm.containsKey(level)) nodes_at_level = tm.get(level);
		else nodes_at_level = new ArrayList<Integer>();
		
		nodes_at_level.add(root.data);
		tm.put(level, nodes_at_level);
		
		verticalTraversal(root.left, level-1);
		verticalTraversal(root.right, level+1);
		
	}
}
