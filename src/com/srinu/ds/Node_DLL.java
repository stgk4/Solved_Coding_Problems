package com.srinu.ds;

public class Node_DLL {
	int data;
	Node_DLL prev, next;
	
	public Node_DLL(int data) {
		this.data = data;
		prev = null;
		next = null;
	}

	public void appendToTail(int d) {
		Node_DLL new_node = new Node_DLL(d);
		Node_DLL n = this;
		
		while(n.next!=null) {
			n=n.next;
		}
		n.next = new_node;
		n.next.prev = n; //alternatively new_node.prev = n;
	}
	
	public void appendToHead(int d) {
		Node_DLL new_node = new Node_DLL(d);
		Node_DLL n = this;
		while(n.prev!=null) {
			n=n.prev;
		}
		n.prev=new_node;
		n.prev.next = n; //alternatively new_node.next = n;
	}
	
	public Node_DLL deleteNode(Node_DLL head, int d) {
		Node_DLL n = head;
		
		if(n.data==d) {
			n.next.prev = null;
			return n.next;//head changed
		}
		
		while(n.next!=null) {
			if(n.next.data==d) {
				n.next = n.next.next;
				n.next.prev = n;
				return head;//head unchanged
			}
			n=n.next;
		}
		return head;
	}
}
