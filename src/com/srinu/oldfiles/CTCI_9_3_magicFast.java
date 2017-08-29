package com.srinu.oldfiles;

public class CTCI_9_3_magicFast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = 
		{-10,-5,2,2,2,3,4,8,9,12,13};
		//{-40,-20,-1,1,2,3,5,7,9,12,13};
		System.out.println(magicFast(array));
		System.out.println(magicFast_nondistinct(array));
	}

	public static int magicFast(int[] array){
		return magicFast_util(array, 0, array.length-1);
	}

	private static int magicFast_util(int[] array, int start, int end){
		if(end<start || start<0 || end>=array.length){
			return -1;
		}
		int mid = (start+end)/2;
		if(array[mid]==mid){
			return mid;
		}
		else if(array[mid]<mid){
			return magicFast_util(array,mid+1,end);
		}
		else{
			return magicFast_util(array,start,mid-1);
		}
	}
	
	public static int magicFast_nondistinct(int[] array){
		return magicFast_nondistinct_util(array, 0, array.length-1);
	}

	private static int magicFast_nondistinct_util(int[] array, int start, int end) {
		// TODO Auto-generated method stub
		if(end<start || start<0 || end>=array.length){
			return -1;
		}
		
		int mid= (start+end)/2;
		if(array[mid] == mid){
			return mid;
		}
		
		//search left
		int leftIndex = Math.min(mid-1, array[mid]);
		int left = magicFast_nondistinct_util(array,start,leftIndex);
		if(left>-1){
			return left;
		}
		
		//search right
		int rightIndex = Math.max(mid+1, array[mid]);
		int right = magicFast_nondistinct_util(array,rightIndex, end);
		return right;
	}

}
