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
}
