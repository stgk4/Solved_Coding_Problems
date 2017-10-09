package com.srinu.traversals;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
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
		System.out.print(node.data + " ");
		
		printLeftBoundary(node.left);
		printLeafNodes(node);
		printRightBoundary(node.right);
	}
	
	public static void printLeftBoundary(Node node){
		if(node!=null){//ensure valid node
			if(node.left!=null){//ensure if left node exists
				System.out.print(node.data + " ");
				printLeftBoundary(node.left);
			}
			else if(node.right!=null){//ensure if at least right node exists
				System.out.print(node.data + " ");
				printLeftBoundary(node.right);
			}
			else{
				//this is the case where both left and right nodes are null
				//and we ignore this case to avoid duplicates
			}
		}
	}
	
	public static void printLeafNodes(Node node){
		if(node==null) return;
		
		printLeafNodes(node.left);
		
		if(node.left==null && node.right == null)
			System.out.print(node.data + " ");
		
		printLeafNodes(node.right);
	}
	
	public static void printRightBoundary(Node node){
		if(node!=null){
			if(node.right!=null){
				printRightBoundary(node.right);
				System.out.print(node.data + " ");
			}else if(node.left!=null){
				printRightBoundary(node.left);
				System.out.print(node.data + " ");
			}
		}
	}

}
