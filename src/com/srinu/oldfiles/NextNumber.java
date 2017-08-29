package com.srinu.oldfiles;

public class NextNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,4,2,3,4,5};
				//{1,3,5,4,2,1};
		printArray(nums);
		nextLowest(nums);
		printArray(nums);
	}
	
	public static void nextLowest(int[] nums){
		int i = nums.length-2;
		while(i>=0 && nums[i]<=nums[i+1]){
			i--;
		}
		if(i>=0){
			int j = nums.length-1;
			while(j>=0 && nums[i]<=nums[j]){
				j--;
			}
			swap(nums,i,j);
			reverseArray(nums,i+1,nums.length-1);
		}
	}

	public static void nextBiggest(int[] nums){
		int i = nums.length-2;
		while(i>=0 && nums[i]>=nums[i+1]){
			i--;
		}
		if(i>=0){
			int j=nums.length-1;
			while(j>=0 && nums[i]>=nums[j]){
				j--;
			}
			swap(nums, i, j);
		}
		else{
			reverseArray(nums,0, nums.length-1);
		}	
	}

	public static void swap(int[] nums, int i, int j){
		nums[i] = nums[i] + nums[j];
		nums[j] = nums[i] - nums[j];
		nums[i] = nums[i] - nums[j];
	}

	public static void reverseArray(int[] nums, int start, int end){
		int i=start;
		int j=end;
		while(i<j){
			swap(nums,i,j);
			i++;
			j--;
		}
	}

	public static void printArray(int[] arr){
		int arr_len = arr.length;
		for(int i=0;i<arr_len; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n-----");
	}

}
