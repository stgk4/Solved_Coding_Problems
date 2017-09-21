package com.srinu.oldfiles;

public class GG_minheapTomaxheap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {3,5,9,6,8,20,10,12,18,9};
		int heap_size = array.length;
		printArray(array);
		convertHeaps(array, heap_size);
		printArray(array);
	}
	
	public static void convertHeaps(int[] array, int heap_size){
		for(int i= (heap_size-2)/2; i>=0; --i){
			MaxHeapify(array, heap_size, i);
		}
	}
	
	public static void MaxHeapify(int[] array, int n, int i){
		int left = 2*i+1;
		int right = 2*i +2;
		int largest = i;
		if(left<n && array[left]>array[i]){
			largest = left;
		}
		if(right<n && array[right]>array[largest]){
			largest = right;
		}
		if(largest!=i){
			swap(array,i, largest);
			MaxHeapify(array, n, largest);
		}
	}
	
	public static void swap(int[] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	
	public static int getLeft(int[] array, int index){
		if(2*(index+1) <= array.length){
			return 2*(index+1) - 1;
		}
		return -1;
	}
	
	public static int getRight(int[] array, int index){
		if(2*(index+1) +1 <=array.length){
			return 2*(index + 1);
		}
		return -1;
	}
	
	public static void printArray(int[] array){
		System.out.print("[ ");
		for(int a: array){
			System.out.print(a + " ");
		}
		System.out.println(" ]");
	}

}
