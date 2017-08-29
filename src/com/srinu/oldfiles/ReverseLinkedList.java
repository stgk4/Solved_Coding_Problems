package com.srinu.oldfiles;

public class ReverseLinkedList{
	public static void main(String args[]){
		LNode head = new LNode(1);
		head.next = new LNode(2);
		head.next.next = new LNode(3);
		printLinkedList(head);
		printLinkedList(reverseLinkedList(head));
	}

	public static LNode reverseLinkedList(LNode head){
		LNode prev = null;// we make the head point to null
		LNode current = head;
		while(current!=null){
			LNode next = current.next;
			current.next = prev;
			prev = current;
			if(next==null){
				break;
			}
			current = next;
		}
		return prev;
	}
	public static void printLinkedList(LNode n){
		while(n!=null){
			System.out.print(n.data + "->");
			n=n.next;
		}
		System.out.print("null\n");
	}

	public static class LNode{
		int data;
		LNode next;
		public LNode(int data){
			this.data = data;
			next = null;
		}
	}
}
