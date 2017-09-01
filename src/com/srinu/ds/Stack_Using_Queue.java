package com.srinu.ds;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Stack_Using_Queue {
	Queue<Integer> queue1 = new ArrayDeque<Integer>(); 
	Queue<Integer> queue2 = new ArrayDeque<Integer>();
	
	public boolean isEmpty(){
		return (queue1.size()+queue2.size() == 0);
	}
	
	public int pop() throws Exception{
		if(isEmpty()){
			throw new Exception("Stack is empty");
		}
		return queue1.remove();
	}
	
	public void push(int a){
		if(queue1.isEmpty()){
			queue1.add(a);
		}else{
			queue2.add(a);
			while(!queue1.isEmpty()){
				queue2.add(queue1.remove());
			}
			queue1 = queue2;
			queue2.clear();
		}
	}
}
