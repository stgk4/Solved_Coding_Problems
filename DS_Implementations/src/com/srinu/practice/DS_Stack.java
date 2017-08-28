package com.srinu.practice;

public class DS_Stack {
	Node_SLL top = null;
	
	public void push(int data) {
		Node_SLL new_node = new Node_SLL(data);
		new_node.next = top;
		top = new_node;
	}
	
	public Object pop() {
		if(top==null) {
			return null;
		}
		int popped_item = top.data;
		top = top.next;
		return popped_item;
	}
	
	public int peek() {
		if(top==null) {
			return -1;
		}
		return top.data;
	}
	

}
