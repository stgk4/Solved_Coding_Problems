package com.srinu.traversals;

public class BoundaryTraversal_Btree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.right = new Node(25);
        printBoundary(root);

	}
	
	public static void printBoundary(Node node){
		
	}

}
