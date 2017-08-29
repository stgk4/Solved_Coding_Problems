package com.srinu.oldfiles;

import java.util.Arrays;

public class CTCI_9_1_countNumOfSteps {
	public static void main(String[] args){
		int n = 36;
		
		long start = System.currentTimeMillis();
		System.out.println(countWays_rec(n));
		System.out.println("RecursionTime:"+ (System.currentTimeMillis() - start)/1000.0 + " sec");


		System.out.println("-------------");
		start = System.currentTimeMillis();
		System.out.println(countWays_dp(n));
		System.out.println("DP_Time:"+ (System.currentTimeMillis() - start)/1000.0 + " sec");

	}

	public static int countWays_rec(int n){
		if(n<0){
			return 0;
		}
		else if(n==0){
			return 1;
		}
		else{
			return countWays_rec(n-1)+countWays_rec(n-2)+countWays_rec(n-3);
		}
	}

	public static int countWays_dp(int n){
		int[] ways = new int[n+1];
		Arrays.fill(ways, -1);
		return countWays_dp_util(n, ways);
	}

	public static int countWays_dp_util(int n, int[] ways){
		if(n<0){
			return 0;
		}
		else if(n==0){
			return 1;
		}
		else if(ways[n]>-1){
			return ways[n];
		}
		else{
			ways[n] = countWays_dp_util(n-1,ways) + countWays_dp_util(n-2, ways)+countWays_dp_util(n-3, ways);
			return ways[n];
		}
	}
}
