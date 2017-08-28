package com.practice.trees;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumPair {
	static int arr[] = {1,2,3,3,8,6,5,1,2,4};
	static int sum = 6;
	public static void main(String[] args){
		//printPairs(arr, sum);
		findSumPairs(arr,sum);
	}
	
	public static void findSumPairs(int[] arr, int sum){
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int arr_len = arr.length;
		for(int i=0; i<arr_len; i++){
			hm.put(arr[i], 0);
		}
		for(int i=0; i<arr_len; i++){
			int val = sum - arr[i];
			hm.put(arr[i],1);
			if(hm.containsKey(val) && hm.get(val)!=1){
				hm.put(val,1);
				System.out.println(arr[i] + "," + val);
			}
		}
	}
	
	public static void printPairs(int[] arr, int sum){
		for(int i=0; i<arr.length-1; i++){
			for(int j=i+1; j<arr.length; j++){
				if(arr[i]+arr[j] == sum){
					System.out.println(arr[i] + "," + arr[j]);
				}
			}
		}
	}
}
