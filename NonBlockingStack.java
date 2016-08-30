package com.practice.threadsconcurrency;

import java.util.concurrent.atomic.*;

public class NonBlockingStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConcurrentStack<Integer> cStack = new ConcurrentStack<Integer>();
		/*System.out.println("pop(): " + cStack.pop());
		System.out.println("peek(): " + cStack.peek());
		cStack.push(1);
		cStack.push(2);
		cStack.push(3);
		System.out.println("pop(): " + cStack.pop());
		System.out.println("peek(): " + cStack.peek());*/
		Thread thread_producer = new Thread(new Producer_stack(cStack));
		Thread thread_consumer = new Thread(new Consumer_stack(cStack));
		thread_producer.start();
		thread_consumer.start();
	}
}

class Producer_stack implements Runnable{
	ConcurrentStack<Integer> c_stack;
	public Producer_stack(ConcurrentStack<Integer> stack){
		this.c_stack = stack;
	}
	public void run(){
		for(int i=0; i<100; i++){
			c_stack.push(i);
			System.out.println("pushed-"+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Consumer_stack implements Runnable{
	ConcurrentStack<Integer> c_stack;
	public Consumer_stack(ConcurrentStack<Integer> stack){
		this.c_stack = stack;
	}
	public void run(){
		/*for(int i=0; i<100; i++){
			System.out.println("Pop(): " + c_stack.pop());
		}*/
		while(true){
			if(!c_stack.isEmpty()){
				System.out.println("Pop(): " + c_stack.pop());
			}	
		}
	}
}

class ConcurrentStack<E>{
	AtomicReference<Node<E>> top;
	public ConcurrentStack(){
		top = new AtomicReference<Node<E>>();
	}
	
	public void push(E item){
		Node<E> new_top = new Node<E>(item);
		Node<E> old_top;
		do{
			old_top = top.get();
			new_top.next = old_top;
		}while(!top.compareAndSet(old_top, new_top));
		print();
	}
	
	public E pop(){
		Node<E> new_top;
		Node<E> old_top;
		do{
			 old_top = top.get();
			 //Check if stack is empty
			 if(old_top == null){
				 return null;
			 }
			 new_top = old_top.next;
		}while(!top.compareAndSet(old_top, new_top));
		print();
		return old_top.data;
	}
	
	public E peek(){
		if(top.get()==null){
			return null;
		}
		print();
		return top.get().data;
	}
	
	public void print(){
		StringBuffer sb = new StringBuffer();
		Node<E> n = top.get();
		while(n!=null){
			sb.append(n.data);
			sb.append("->");
			n=n.next;
		}
		sb.append("null");
		System.out.println(sb.toString());
	}
	
	public boolean isEmpty(){
		return top.get()==null;
	}
	
	static class Node<E>{
		final E data;
		Node<E> next;
		public Node(E data){
			this.data = data;
		}
	}
}