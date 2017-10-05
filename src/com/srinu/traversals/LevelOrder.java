package com.srinu.traversals;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class LevelOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node = new Node(5);
		node.left = new Node(4);
		node.right = new Node(3);
		node.left.left = new Node(2);
		node.left.right = new Node(1);
		node.right.left = new Node(6);
		node.right.right = new Node(8);
		printReverseLevelOrder(node);
	}
	
	/*
	 * Printing level order using breadth first search
	 * This runs in O(n) time and takes O(n) space for recursion stack
	 */
	public static void printLevelOrder(Node root){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		visit(root);
		while(!queue.isEmpty()){
			Node n = queue.remove();
			if(n.left!=null){
				queue.add(n.left);
				visit(n.left);
			}
			if(n.right!=null){
				queue.add(n.right);
				visit(n.right);
			}
		}
	}
	
	public static void printReverseLevelOrder(Node root){
		Queue<Node> queue = new LinkedList<Node>();
		Stack<Node> stack = new Stack<Node>();
		queue.add(root); //do not visit, just add
		while(!queue.isEmpty()){
			Node n = queue.remove();
			stack.push(n);
			if(n.right!=null) queue.add(n.right);
			if(n.left!=null) queue.add(n.left);
		}
		
		while(!stack.isEmpty()) visit(stack.pop());
	}
	
	/*
	 * visit method to print the node visited
	 */
	public static void visit(Node n){
		System.out.print(n.data + " ");
	}

}

class Node{
	int data;
	Node left, right;
	Node(int data){
		this.data=data;
		left = null;
		right = null;
	}
}
