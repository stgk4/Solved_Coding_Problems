package com.srinu.ds;

public class Node_SLL {
	Node_SLL next;
	int data;
	
	public Node_SLL(int data) {
		this.data = data;
		next = null;
	}
	
	public void appendToTail(int d) {
		Node_SLL new_node = new Node_SLL(d);
		Node_SLL n = this;
		
		while(n.next!=null) {
			n=n.next;
		}
		n.next = new_node;
	}
	
	public Node_SLL deleteNode(Node_SLL head, int d) {
		Node_SLL n = head;
	
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
