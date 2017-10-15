package com.srinu.ds;

/*
 * Similar to single linked list we add each
 * individual node and not total data structure.
 * If required, a full DoubleLinkedList data-structure
 * can be designed keeping track of count of nodes,
 * head node and other methods relevant to it
 */
public class Node_DLL {
	int data;
	Node_DLL prev, next;
	
	public Node_DLL(int data) {
		this.data = data;
		prev = null;
		next = null;
	}

	//This is similar to single linked list
	public void appendToTail(int d) {
		Node_DLL new_node = new Node_DLL(d);
		Node_DLL n = this;
		
		//traversing till the last node
		while(n.next!=null) {
			n=n.next;
		}
		
		n.next = new_node;
		n.next.prev = n; //alternatively new_node.prev = n;
	}
	
	//This appends the new node at the front
	public void appendToHead(int d) {
		Node_DLL new_node = new Node_DLL(d);
		Node_DLL n = this;
		
		//traversing towards the starting head node
		while(n.prev!=null) {
			n=n.prev;
		}
		n.prev=new_node;
		n.prev.next = n; //alternatively new_node.next = n;
	}
	
	
	public Node_DLL deleteNode(Node_DLL head, int d) {
		Node_DLL n = head;
		
		if(n.data==d) {
			n.next.prev = null;//removing the previous link of the new head
			return n.next;//head changed
		}
		
		while(n.next!=null) {
			if(n.next.data==d) {
				n.next.prev = null;//removing the previous link of the node to be deleted
				n.next = n.next.next;
				n.next.prev = n;
				return head;//head unchanged
			}
			n=n.next;
		}
		return head;
	}
}
