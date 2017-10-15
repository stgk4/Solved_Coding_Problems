package com.srinu.ds;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Stack_Using_Queue {
	Queue<Integer> queue1 = new ArrayDeque<Integer>(); 
	Queue<Integer> queue2 = new ArrayDeque<Integer>();
	
	public boolean isEmpty(){
		return (queue1.size()+queue2.size() == 0); //ideally the size is always the size of queue, but just in case of synchronous queue
	}
	
	//This queue implementation prioritizes the the pop(), i.e O(1) popping time 
	// and O(N) pushing time; alternatively the other way out can also be implemented
	public int pop() throws Exception{
		if(isEmpty()){
			throw new Exception("Stack is empty");
		}
		return queue1.remove();
	}
	
	//we add all the old elements of queue1 to queue2 only after
	// adding new element into queue2 and then swap the queues
	public void push(int a){
		if(queue1.isEmpty()){
			queue1.add(a);
		}else{
			queue2.add(a);
			while(!queue1.isEmpty()){
				queue2.add(queue1.remove());
			}
			swapQueues(queue1,queue2);
		}
	}
	
	//method to swap queues using references, rather than adding element by element or copying  and clearing to
	//save a linear pass
	public void swapQueues(Queue<Integer> q1, Queue<Integer> q2){
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
		
	}
}
