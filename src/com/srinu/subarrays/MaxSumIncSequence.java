package com.srinu.subarrays;

public class MaxSumIncSequence {
	public static void main(String[] args){
		int[] array = {1,101,2,3,100,4,5};
		int n = array.length;
		System.out.println(getMaxSumIS(array, n));
	}
	
	/*
	 * get maximum sum increasing subsequence
	 */
	public static int getMaxSumIS(int[] array, int n){
		int max = array[0];
		int i, j;
		int msis[] = new int[n];
		
		//initialize msis values for all indexes same as the array vals
		for(i=0; i<n; i++) msis[i] = array[i];
		
		//compute maximum sum values in bottom up manner
		for(i=1; i<n; i++){
			for (j=0; j<i; j++){
				if(array[i]>array[j] && msis[i]<msis[j]+array[i]){
					msis[i] = msis[j]+array[i];
				}
			}		
			if (max<msis[i]) max = msis[i];
		}		
		
		return max;
	}

}
