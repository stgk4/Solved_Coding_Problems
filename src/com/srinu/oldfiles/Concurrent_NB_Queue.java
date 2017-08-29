package com.srinu.oldfiles;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;


public class Concurrent_NB_Queue {

	public static void main(String args[]){
		/*Queue<Integer> q = new MRI_NB_Queue<Integer>(2);
		Integer o = new Integer(1);
		q.offer(o);
		System.out.println(q.size());
		//System.out.println(q.add(null));
		System.out.println(q.size());
		System.out.println(q.remove(o));
		q.add(6);
		System.out.println(q.poll());
		System.out.println(q.size());*/
		
		/*String s = "abcd";
		System.out.println(s.substring(1));
		System.out.println(s.substring(0,4));
		System.out.println(s.substring(4,4));*/
		
		/*HashMap<Integer,String> hm = new HashMap<Integer, String>();
		
		hm.put(null, null);
		hm.put(null, null);
		hm.put(1, "one");
		hm.put(1, "two");
		hm.put(2, null);
		System.out.println(hm.toString());*/
		
		/*Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
		ht.put(1, "one");
		ht.put(2, "two");
		ht.put(3, "hjkh");
		ht.put(4, "jhhl");
		ht.put(5, "uhuh");
		Enumeration<Integer> en = ht.keys();
		while(en.hasMoreElements()){
			System.out.println(en.nextElement() + "--"+ en.nextElement().hashCode());
		}*/
		
		String s1 = new String("abc");
		String s2 = new String("d");
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());

	}
}


class MRI_NB_Queue<E> extends AbstractQueue<E> implements Queue<E>{
	
	Node a,b;
	
	public void method1(){
		synchronized(a){
			System.out.println("method 1 acquired lock on a");
			synchronized(b){
				System.out.println("method 1 acquired lock on b");
			}
		}
	}
	public void method2(){
		synchronized(b){
			System.out.println("method 1 acquired lock on b");
			synchronized(a){
				System.out.println("method 1 acquired lock on a");
			}
		}
	}
	
	/**
	 * Node class
	 */
	private static class Node<E>{
		final E data;
		final AtomicReference<Node<E>> next;
		public Node(E data, Node<E> next){
			this.data = data;
			this.next = new AtomicReference<Node<E>>(next);
		}
	}
	/******/
	
	int size;
	int capacity;
	private AtomicReference<Node<E>> head;
	private AtomicReference<Node<E>> tail;
	
	public MRI_NB_Queue(int capacity){
		this.capacity=capacity;
		size =0;
		head = new AtomicReference<Node<E>>(new Node<E>(null, null));
		tail = head;
	}
	
	@Override
	public boolean offer(E e) {
		// TODO Auto-generated method stub
		Node<E> new_tail = new Node<E>(e,null);
		
		while(true){
			Node<E> current_tail = tail.get();
			Node<E> end_node = current_tail.next.get();
			if(current_tail == tail.get()){
				if(end_node == null){
					if(size==0){
						tail.compareAndSet(current_tail, new_tail);
						head = tail;
						size++;
						return true;
					}
					else if(size<capacity && current_tail.next.compareAndSet(null, new_tail)){
						tail.compareAndSet(current_tail, new_tail);
						size++;
						return true;
					}
					else{
						this.poll();
						this.offer(e);
					}
				}
				else{
					tail.compareAndSet(current_tail, end_node);
				}
			}
		}
	}

	@Override
	public E poll() {
		// TODO Auto-generated method stub
		Node<E> new_head ;
		Node<E> old_head;
		while(true){
			old_head = head.get();
			if(old_head==null){
				return null;
			}
			new_head = old_head.next.get();
			head.compareAndSet(old_head, new_head);
			size--;
			return old_head.data;
		}
	}


	@Override
	public E peek() {
		// TODO Auto-generated method stub	
		return head.get().data;
	}

	@Override
	public Iterator<E> iterator() {
		Iterator<E> it = new Iterator<E>(){
			private int index =0;
			Node<E> n = head.get();
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return index<size && head.get()!=null;
			}

			@Override
			public E next() {
				// TODO Auto-generated method stub
				E data = n.data;
				n = n.next.get();
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