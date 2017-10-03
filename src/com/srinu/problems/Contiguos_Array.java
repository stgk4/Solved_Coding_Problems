package com.srinu.problems;

public class Contiguos_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {1,12, 4, 3, 2, 7, 1};
		//subArrayEqualsSum(array, 9);
		System.out.println(getEquilibriumPoint(array));
	}
	
	public static int getEquilibriumPoint(int[] array){
		int size = array.length;
		if(size==1) return 0;
		
		int sum_array[] = new int[size];
		sum_array[0] = array[0];
		for(int i=1;i<size;i++){
			sum_array[i]=sum_array[i-1]+array[i];
		}
		int array_sum=sum_array[size-1];
		
		for(int i=1;i<size-1;i++){
			if(sum_array[i-1]==(array_sum-sum_array[i-1]-array[i]))
				return i;
		}
		return -1;
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
