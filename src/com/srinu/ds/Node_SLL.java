package com.srinu.ds;

/*Linked list works on creating individual nodes unlike queues 
 * and stacks where we create the entire data-structure
 */
public class Node_SLL {
	Node_SLL next;
	int data;
	
	//constructor
	public Node_SLL(int data) {
		this.data = data;
		next = null;
	}
	
	/*given the current node (which may be at any point in the list),
	 * traverse till the end of the list where we see lastNode->null,
	 * there we get hold of that node and point the new_node to it as
	 * lastNode->new_node->null  using lastNode.next = new_node
	 */
	public void appendToTail(int d) {
		Node_SLL new_node = new Node_SLL(d);
		Node_SLL n = this;//point a temp to node to current node
		
		while(n.next!=null) { //traverse on temp node till we see null
			n=n.next;
		}
		n.next = new_node;
	}
	
	/*Delete a node with a given head node and 
	 * int value or a node reference of the node
	 * to be deleted...
	 * check if that node exist
	 */
	public Node_SLL deleteNode(Node_SLL head, int d) {
		Node_SLL n = head;
	
		//this is a special case where node to be deleted is the head node 
		if(n.data==d) {
			return head.next; //new head after deleting the old
		}
		
		//always check the next node data and stay one step behind the node to
		//be deleted, to keep the reference of the list before the deleted node
		while(n.next!=null) {
			if(n.next.data==d) {
				n.next = n.next.next;
				return head; //same old head
			}
			n=n.next;
		}
		return head;
	}
	
	/*Method to detect if there is a cycle in the linked list
	 * we chose two pointers-{slow,fast} and move until we either see a null 
	 * for a fast pointer or when slow==fast
	 */
	public boolean isThereACycle(){
		Node_SLL slow=this, fast=this;
		while(slow!=null && fast!=null){
			slow = slow.next;
			if(fast.next!=null) fast = fast.next.next;
			else break;
			if(slow==fast) return true;
		}
		return false;
	}
}
