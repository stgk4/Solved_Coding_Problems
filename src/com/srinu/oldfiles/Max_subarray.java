package com.srinu.oldfiles;

public class Max_subarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(maxSumSubarray(array));
		
		
		
	}
	
	public static int maxSumSubarray(int[] array){
		int max_here =0;
		int max_so_far = 0;
		
		for(int i=0; i<array.length; i++){
				max_here+=array[i];
			if(max_here<0){
				max_here =0;
			}
			if(max_here>max_so_far){
				max_so_far = max_here;
			}
		}
		return max_so_far;
	}
}
