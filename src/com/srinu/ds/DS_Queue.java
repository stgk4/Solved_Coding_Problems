package com.srinu.ds;

public class DS_Queue {
	Node_SLL first, last;
	
	public void enqueue(int d) {
		Node_SLL new_node = new Node_SLL(d);
		//case when the queue is empty
		if(last==null){
			last = new_node;
			first = last;
		}
		//case when the queue is non-empty
		else{
			last.next = new_node;
			last = new_node;
		}
	}
	
	public Node_SLL dequeue(int d) {
		if(first==null) { //case when the node is empty
			return null;
		}
	
		//getting hold of the removed node
		Node_SLL removed_node = first;
		
		first=first.next;
		
		if(first==null) last = first;//if the queue become empty after dequeueing the only element that was present
		
		return removed_node;
	}
}
