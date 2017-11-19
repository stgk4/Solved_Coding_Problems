package com.srinu.traversals;

public class LeftView {
	
	public static int max_level = 0;
	
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
        leftView(root, 1);
        System.out.println();
	}
	
	public static void leftView(Node root, int level){
		if(root==null) return;
		
		if(max_level<level){
			System.out.print(root.data + " ");
			max_level= level;
		}
		
		leftView(root.left, level+1);
		leftView(root.right, level+1);
	}

}
