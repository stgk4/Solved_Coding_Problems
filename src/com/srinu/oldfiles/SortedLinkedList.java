package com.srinu.oldfiles;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class SortedLinkedList {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.add(5);
		ll.add(7);
		ll.add(1);
		ll.add(9);
		ll.add(4);
		ll.print();
		System.gc();
	}
}

//LinkedList node
class Node_LL{
	int data;
	Node_LL next;
	public Node_LL(int value){
		data = value;
		next=null;
	} 
}

//LinkedList clas
class LinkedList{
	Node_LL head; 

	public Node_LL add(int val){
		Node_LL new_node = new Node_LL(val);
		if(head==null || head.data>=new_node.data){
			new_node.next = head;
			head = new_node;
		}
		else{
			Node_LL current = head;    
			while(current.next!=null && current.next.data<= new_node.data){
				current = current.next;
			}
			new_node.next=current.next;
			current.next=new_node;
		}
		return head;
	}

	public void print(){
		Node_LL n = head;
		while(n!=null){
			System.out.println(n.data);
			n = n.next;
		}

	}
}

