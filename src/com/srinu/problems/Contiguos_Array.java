package com.srinu.problems;

public class Contiguos_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {1,12, 4, 3, 2, 7, 3};
		subArrayEqualsSum(array, 9);
	}
	
	public static int getEquilibriumPoint(int[] array){
		
	}
	
	public static void subArrayEqualsSum(int[] array, int sum){
		int cur_sum = array[0];
		int start = 0;
		int size = array.length;
		for(int i=1; i<=size; i++){
			while(cur_sum>sum && start<i-1){
				cur_sum-=array[start];
				start++;
			}
			if(cur_sum==sum){
				System.out.println(start + "," + (i-1));
				return;
			}
			if(i<size){
				cur_sum+=array[i];
			}
		}
		System.out.println(-1);
		return;
	}

}
