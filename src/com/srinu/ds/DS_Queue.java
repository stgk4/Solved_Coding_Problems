package com.srinu.ds;

public class DS_Queue {
	Node_SLL first, last;
	
	public void enqueue(int d) {
		Node_SLL new_node = new Node_SLL(d);
		last.next = new_node;
		last = new_node;
		if(first==null) {
			first = last;
		}
	}
	
	public Node_SLL dequeue(int d) {
		if(first==null) {
			return null;
		}
		Node_SLL removed_node = first;
		first=first.next;
		return removed_node;
	}
}
