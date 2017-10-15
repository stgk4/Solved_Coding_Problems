package com.srinu.ds;

public class DS_Stack {
	Node_SLL top = null;
	
	//push case is same for empty and non-empty stack
	public void push(int data) {
		Node_SLL new_node = new Node_SLL(data);
		new_node.next = top;
		top = new_node;
	}
	
	//check initially if top is null 
	public Object pop() {
		if(top==null) {
			return null;
		}
		int popped_item = top.data;
		top = top.next;
		return popped_item;
	}
	
	//check if top is null before returning
	public int peek() {
		if(top==null) {
			return -1; //or -infinity to indicate empty stack
		}
		return top.data;
	}
	

}
