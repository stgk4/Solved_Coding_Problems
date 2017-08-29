package com.srinu.oldfiles;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.Queue;


public class Concurrent_BL_Queue {

	public static void main(String args[]){
		Queue<Integer> q = new MRI_BL_Queue<Integer>(2);
		//q.offer(1);
		System.out.println(q.size());
		System.out.println(q.add(null));
		System.out.println(q.size());
		//System.out.println(q.remove(1));
		q.add(6);
		System.out.println(q.poll());
		System.out.println(q.size());

	}
}


class MRI_BL_Queue<E> extends AbstractQueue<E> implements Queue<E>{
	int size;
	int capacity;
	private Node<E> head;
	private Node<E> tail;
	
	public MRI_BL_Queue(int capacity){
		this.capacity=capacity;
		size =0;
		head = null;
		tail = null;
	}
	
	/**
	 * Node class
	 */
	public static class Node<E>{
		E data;
		Node<E> next;
		public Node(E data){
			this.data = data;
			next = null;
		}
	}
	/******/
	
	@Override
	public boolean offer(E e) {
		// TODO Auto-generated method stub
		Node<E> new_node = new Node<E>(e);
		
		if(size==0){
			tail = new_node;
			head = tail;
		}
		else if(size==capacity){
			tail.next = new_node;
			tail = new_node;
			head=head.next;
		}
		else{
			tail.next = new_node;
			tail = new_node;
		}
		size++;
		return true;
	}


	@Override
	public E poll() {
		// TODO Auto-generated method stub
		E polled_data = null;
		if(size>0){
			polled_data = head.data;
			head = head.next;
			size--;
		}
		return polled_data;
	}


	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return head.data;
	}


	@Override
	public Iterator<E> iterator() {
		Iterator<E> it = new Iterator<E>(){
			private int index =0;
			Node<E> n = head;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return index<size && head!=null;
			}

			@Override
			public E next() {
				// TODO Auto-generated method stub
				E data = n.data;
				n = n.next;
				index++;
				return data;
			}
		};

		return it;
	}


	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}	
}