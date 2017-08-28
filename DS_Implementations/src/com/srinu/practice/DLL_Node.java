package com.srinu.practice;

public class DLL_Node {
	int data;
	DLL_Node prev, next;
	
	public DLL_Node(int data) {
		this.data = data;
		prev = null;
		next = null;
	}

	public void appendToTail(int d) {
		DLL_Node new_node = new DLL_Node(d);
		DLL_Node n = this;
		
		while(n.next!=null) {
			n=n.next;
		}
		n.next = new_node;
		n.next.prev = n; //alternatively new_node.prev = n;
	}
	
	public void appendToHead(int d) {
		DLL_Node new_node = new DLL_Node(d);
		DLL_Node n = this;
		while(n.prev!=null) {
			n=n.prev;
		}
		n.prev=new_node;
		n.prev.next = n; //alternatively new_node.next = n;
	}
	
	public DLL_Node deleteNode(DLL_Node head, int d) {
		DLL_Node n = head;
		
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
