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
		printLevelOrder(node);
	}
	
	/*
	 * Printing level order using breadth first search
	 * This runs in O(n) time and takes O(n) space for recursion stack
	 */
	public static void printLevelOrder(Node root){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node n = queue.remove();
			visit(n);
			if(n.left!=null){
				queue.add(n.left);
			}
			if(n.right!=null){
				queue.add(n.right);
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
	 * Prints the binary tree in a spiral pattern:
	 * meaning, the even level number rows will print
	 * from left to right, and odd number level will
	 * print from right to left
	 */
	public static void printSpiralLevelOrder(Node root){
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		s1.push(root);
		while(!s1.isEmpty() || !s2.isEmpty()){
			/*This while loop visits/prints from left to right 
			 * and adds numbers to other stack(s2) in reverse order
			 * so that other while loop prints in reverse order
			 */
			while(!s1.isEmpty()){
				Node n = s1.pop();
				visit(n);
				if(n.right!=null) s2.push(n.right);
				if(n.left!=null) s2.push(n.left);
			}
			
			/*
			 * This visits in reverse order and 
			 * adds in right order to the Stack(s1)
			 */
			while(!s2.isEmpty()){
				Node n = s2.pop();
				visit(n);
				if(n.left!=null) s1.push(n.left);
				if(n.right!=null) s1.push(n.right);
			}
		}
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
