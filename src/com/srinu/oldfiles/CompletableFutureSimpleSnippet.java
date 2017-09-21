package com.srinu.oldfiles;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

//Completable future to perform task asynchronously on the default
//thread pool
public class CompletableFutureSimpleSnippet {
	public static void main(String[] args){
		long started = System.currentTimeMillis();
		
		//configure Completable Future
		CompletableFuture<Integer> futureCount = createCompletableFuture();
		
		//Continue to do other work
		System.out.println("Took " + (started-System.currentTimeMillis()) + " milliseconds");
		
		// now its time to get the result
		try{
			int count = futureCount.get();
			System.out.println("CompletableFuture took " +(started-System.currentTimeMillis()) +" milliseconds");
			System.out.println("Result "+ count);
		}
		catch(InterruptedException|ExecutionException ex){
			//exceptions from future should be handled here
		}
	}

	private static CompletableFuture<Integer> createCompletableFuture(){
		CompletableFuture<Integer> futureCount = CompletableFuture.supplyAsync(
				()->{
					try{
						//simulate long running task
						Thread.sleep(5000);
					}
					catch(InterruptedException e){}
					return 20;
				});
		return futureCount;
	}
}
