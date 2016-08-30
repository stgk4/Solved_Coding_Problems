package com.practice.threadsconcurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureCallback {
	public static void main(String[] args){
		long started = System.currentTimeMillis();
		
		//configure Completable Future
		CompletableFuture<String> data = createCompletableFuture().thenApply(
				(Integer count)->{
					int transformedValue = count*10;
					return transformedValue;
				}).thenApply(transformed->"Finally creates a string: " + transformed);
		
		//Continue to do other work
		System.out.println("Took " + (started-System.currentTimeMillis()) + " milliseconds");
		
		// now its time to get the result
		try{
			String count = data.get();
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
