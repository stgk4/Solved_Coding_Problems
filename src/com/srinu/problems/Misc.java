package com.srinu.problems;
import java.util.HashSet;
import java.util.Set;

public class Misc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] a = {1,3, 5, 6, 8, 2, 9};
		//System.out.println(findPair(a,10));
		
		Node n= new Node(1);
		n.next = new Node(2);
		n.next.next = new Node(3);
		
		//Node n_r = reverseLinkedList(n);
		
		printLinkedList(reverseLinkedList_rec(n,null));
	}
	
	public static Node reverseLinkedList(Node n) {
		if(n==null || n.next==null) return n;
		
		Node prev = null;
		while(n!=null) {
			Node next = n.next;
			n.next = prev;
			prev = n;
			n=next;
		}
		return prev;
	}
	
	public static Node reverseLinkedList_rec(Node current, Node prev) {
		if(current==null) return prev;
		Node next = current.next;
		current.next = prev;
		return reverseLinkedList_rec(next, current);
	}
	
	public static void printLinkedList(Node n) {
		//if(n==null) return;
		while (n!=null) {
			System.out.print(n.data + "->");
			n=n.next;
		}
		System.out.print("NULL");
	}
	
	/*
	 * return true if an array has pair of numbers whose sum is equal to value
	 */
	public static boolean findPair(int[] a, int val) {
		Set<Integer> foundValues = new HashSet<Integer>();
		for(int i: a) {
			if(foundValues.contains(val-i)) {
				return true;
			}
			foundValues.add(i);
		}
		return false;
	}
	
	public static boolean findPair2(int[] a, int val) {
		int left = 0;
		int right=a.length-1;
		int sum;
		for(;left<right;){//while(left<right)
			sum = a[left]+a[right];
			if(sum==val) return true;
			else if(sum>val) --right;
			else ++left;
		}
		return false;
	}

}

class Node{
	Node next;
	int data;
	Node(int data){
		this.data = data;
		next = null;
	}
}