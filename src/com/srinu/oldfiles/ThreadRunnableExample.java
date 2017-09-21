package com.srinu.oldfiles;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadRunnableExample {
	private static final int NTHREADS = 10; 
	public static void main(String[] args) {

		//threadApproach();
		//executorApproach(NTHREADS);
		executorCallableApproach(NTHREADS);
	}

	public static void executorCallableApproach(int num_of_threads){
		ExecutorService executor = Executors.newFixedThreadPool(num_of_threads);
		List<Future<Long>> list = new ArrayList<Future<Long>>();
		for(int i=0; i<20000; i++){
			Callable<Long> worker = new MyCallable();
			Future<Long> submit = executor.submit(worker);
			list.add(submit);
		}
		long sum = 0;
		System.out.println(list.size());
		boolean await = false;
		for(Future<Long> future: list){
			try {
				sum+=future.get();
			System.out.println(sum);
			executor.shutdown();
			await = executor.awaitTermination(10, TimeUnit.SECONDS);
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				System.out.println(await);
			}
		}
		System.out.println("Finished executing all the callables along with getting future return gets");
	}
	public static void executorApproach(int num_of_threads){
		ExecutorService executor = Executors.newFixedThreadPool(num_of_threads);
		for(int i=0; i<500; i++){
			Runnable worker = new MyRunnable(10000000L +i);
			System.out.println("Created: Thread-"+i);
			executor.execute(worker);
		}
		executor.shutdown();
		try {
			boolean res = executor.awaitTermination(10, TimeUnit.SECONDS);
			System.out.println(res);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Finished executing all threads");
	}
	public static void threadApproach(){
		List<Thread> threads = new ArrayList<Thread>();
		for(int i=0; i<500; i++){
			Runnable task = new MyRunnable(10000000L + i);
			Thread worker = new Thread(task);
			worker.setName("Thread-"+i);
			System.out.println("Created: Thread-"+i);
			worker.start();
			threads.add(worker);
		}
		int running;
		do{
			running = 0;
			for(Thread thread: threads){
				if(thread.isAlive()){
					running++;
				}
			}
			System.out.println(running + " threads running");
		}while(running>0);
	}
}

class MyRunnable implements Runnable{
	private final long countUntil;
	public MyRunnable(long countUntil){
		this.countUntil = countUntil;
		System.out.println(this.countUntil + "-count");
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		long sum = 0;
		for(long i=1; i<countUntil; i++){
			sum+=i;
		}
		//System.out.println(sum);
	}

}

//callable object which will let the executor execute the object 
//and return the return type of the thread when completed
class MyCallable implements Callable<Long>{

	@Override
	public Long call() throws Exception {
		// TODO Auto-generated method stub
		long sum = 0;
		for(long i=0; i<=100; i++){
			sum+=i;
		}
		return sum;
	}
}
