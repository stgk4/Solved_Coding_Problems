package com.srinu.oldfiles;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class NonBlockingAlgo {
	private static final int NTHREADS = 10;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Counter counter = new Counter();
		List<Future<Integer>> list = new ArrayList<Future<Integer>>();
		ExecutorService executor = Executors.newFixedThreadPool(NTHREADS);
		for(int i=0; i<500; i++){
			Callable<Integer> worker = new Callable<Integer>(){

				@Override
				public Integer call() throws Exception {
					// TODO Auto-generated method stub
					int number = counter.increment();
					System.out.println(number);
					return number;
				}
				
			};
			Future<Integer> submit = executor.submit(worker);
			list.add(submit);
		}
		//this will make the executor accept no new threads
		//and finish all existing threads
		executor.shutdown();
		//wait until all threads are finished
		while(!executor.isTerminated()){
		}
		Set<Integer> set = new HashSet<Integer>();
		for(Future<Integer> future: list){
			try{
				set.add(future.get());
			}
			catch(InterruptedException|ExecutionException e){
				e.printStackTrace();
			}
		}
		if(list.size()!=set.size()){
			throw new RuntimeException("Double-entries!!!");
		}
	}
}

//Non-blocking counter which always increases
class Counter{
	private AtomicInteger value = new AtomicInteger();
	public int getValue(){
		return value.get();
	}
	public int increment(){
		return value.incrementAndGet();
	}
	
	//implementation explicit
	public int incrementLongVersion(){
		int oldValue = value.get();
		while(!value.compareAndSet(oldValue, oldValue+1)){
			oldValue = value.get();
		}
		return oldValue+1;
	}
}
