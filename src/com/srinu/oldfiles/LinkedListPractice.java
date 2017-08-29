package com.srinu.oldfiles;

public class LinkedListPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node r = new Node(1);
		r.next = new Node(2);
		r.next.next= new Node(3);
		r.next.next.next = new Node(4);
		print(r);
		Node n = reverse(r);
		print(n);
		
	}
	
	public static Node reverse(Node current){
		Node previous = null;
		while(current!=null){
			Node next = current.next;
			current.next=previous;
			previous = current;
			current= next;
		}
		return previous;		
	}
	
	public static void print(Node n){
		while(n!=null){
			System.out.printf(n.data + "->");
			n = n.next;
		}
		System.out.printf("null\n");
	}
	
	public static class Node{
		int data;
		Node next;
		public Node(int d){
			data = d;
			next = null;
		}
	}

}
