package com.srinu.oldfiles;

import java.util.concurrent.atomic.AtomicReference;

public class NonBlockingLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}

//Non-blocking linkedList queue
class LinkedQueue<E>{
	//Node class
	static class Node<E>{
		final E data;
		final AtomicReference<Node<E>> next;
		Node(E data, Node<E> next){
			this.data = data;
			this.next = new AtomicReference<Node<E>>(next);
		}
	}
	
	private AtomicReference<Node<E>> head = new AtomicReference<Node<E>>(new Node<E>(null, null));
	private AtomicReference<Node<E>> tail = head;
	
	public boolean put(E item){
		Node<E> newNode = new Node<E>(item,null);
		while(true){
			Node<E> curTail = tail.get();
			Node<E> residue = curTail.next.get();
			if(curTail == tail.get()){
				if(residue == null)/*A*/{
					if(curTail.next.compareAndSet(null,newNode))/*C*/{
						tail.compareAndSet(curTail, newNode)/*D*/;
						return true;
					}
				}else{
					tail.compareAndSet(curTail, residue)/*B*/;
				}
			}
		}
	}
}