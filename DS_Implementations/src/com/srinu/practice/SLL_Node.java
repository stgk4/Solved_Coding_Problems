package com.srinu.practice;

public class SLL_Node {
	SLL_Node next;
	int data;
	
	public SLL_Node(int data) {
		this.data = data;
		next = null;
	}
	
	public void appendToTail(int d) {
		SLL_Node new_node = new SLL_Node(d);
		SLL_Node n = this;
		
		while(n.next!=null) {
			n=n.next;
		}
		n.next = new_node;
	}
	
	public SLL_Node deleteNode(SLL_Node head, int d) {
		SLL_Node n = head;
	
		if(n.data==d) {
			return head.next; //new head after deleting the old
		}
		
		while(n.next!=null) {
			if(n.next.data==d) {
				n.next = n.next.next;
				return head; //same old head
			}
			n=n.next;
		}
		return head;
	}
}
