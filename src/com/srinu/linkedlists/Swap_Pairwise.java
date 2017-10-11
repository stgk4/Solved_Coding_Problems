package com.srinu.linkedlists;

public class Swap_Pairwise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		printLinkedList(head);
		head = pairWiseSwap(head);
		printLinkedList(head);
		
	}
	
	public static Node pairWiseSwap(Node head){
		Node prev=null, right = null;
		Node left = head;
		if(left.next!=null) head = left.next;
		while(left!=null){
			right = left.next;
			
			if(right==null) return head;
			left.next = right.next;
			right.next = left;
			if(prev!=null) prev.next = left;
			prev = left;
			
			left = left.next;
		}
		return head;  
	}
	
	public static void printLinkedList(Node head){
		
		while(head.next!=null){
			System.out.print(head.data + "->");
			head = head.next;
		}
		System.out.print(head.data + "->Null\n");
	}
	

}

class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		next = null;
	}
}
