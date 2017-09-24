package com.srinu.problems;

public class Heap {

	public static void main(String[] args){
		int [] array= {2,3,5,1, 6, 8};

		//buildMaxHeap(array);
		//heapSort(array);
		//printArray(array);
		//levelOrderTraversal(array);
		
		int [][] input= {{2,4,5,7,19},{3,6,9,12,17},{1,8,13,18,22}, {1,12,16,21,44}};
		printArray(sortKArrays(input));
	}

	/*
	 * given k sorted arrays, merging them using a min heap built with k minimum elements of the arrays
	 * and storing the minimum element of the heap in the output array and then updating it with next minimum
	 * in the corresponding array (if no element left, replace with infinity or Integer.MAX_ELEMENT).
	 * Do this until all the arrays are maxed out
	 */
	public static int[] sortKArrays(int[][] input){
		int rows = input.length;
		int cols = input[0].length;
		int output_size = rows*cols;
		int[] output = new int[output_size];
		ArrayMin [] k_array = new ArrayMin[rows];
		
		//Using a linear algebra library in java, this could have been simplified
		//to one step by extracting the first column;
		for(int i=0; i<rows; i++){
			ArrayMin arrayMin = new ArrayMin(input[i][0],0, input[i]);
			k_array[i] = arrayMin;
		}
		
		for(int j=0; j<output_size; j++){
			buildMinHeap(k_array);
			output[j] = k_array[0].min; // copy the value in the output array
			
			int[] current_array = k_array[0].array;
			int current_array_min_index = k_array[0].min_index;
			k_array[0].min_index++;// move the index in the current array to the next element
			
			if(current_array_min_index<current_array.length-1){ //if the next element exists then update the min_element to it
				k_array[0].min = k_array[0].array[current_array_min_index+1];
			}else{//else update it to the maximum integer possible (theoretically infinite)
				k_array[0].min = Integer.MAX_VALUE;
			}
		}
		return output;
	}
	
	
	
	public static void buildMinHeap(ArrayMin[] array){
		for(int i=array.length/2; i>=0; i--){
			minHeapify(array, i, array.length);
		}
	}




	private static void minHeapify(ArrayMin[] array, int i, int length) {
		// TODO Auto-generated method stub
		int left = 2*i +1;
		int right = 2*i +2;
		int smallest = i;
		
		if(left<length && array[left].min<array[smallest].min){
			smallest = left;
		}
		if(right<length && array[right].min<array[smallest].min){
			smallest = right;
		}
		
		if(smallest!=i){
			swap(array, i, smallest);
			minHeapify(array,smallest,length);
		}
		
	}

	public static void printArray(int[] array){
		for(int e: array){
			System.out.print(e + " ");
		}
		System.out.println("----***---");
	}

	public static void heapSort(int[] array){
		buildMaxHeap(array); //Step-1 build max-heap
		heapSort(array, array.length); 
	}

	public static void heapSort(int[] array, int length){
		if(length==0) return;
		int largest = 0;
		int last = length-1;
		swap(array, largest, last); //Step-2 swap max element with the last element of the array
		maxHeapify(array, 0, length-1); //Step-3 max-heapify from the root element
		heapSort(array, length-1); // Step-4 recursively do Step-2 and Step-3
	}

	public static void buildMaxHeap(int[] array){
		for(int i=array.length/2; i>=0; i--){
			maxHeapify(array, i, array.length);
		}
	}

	public static void maxHeapify(int[] array, int i, int length){
		int left = 2*i +1;
		int right = 2*i +2;
		int largest = i;

		if(left<length && array[left]>array[largest]){
			largest = left;
		}
		if(right<length && array[right]>array[largest]){
			largest = right;
		}

		if(largest!=i){
			swap(array, largest, i);
			maxHeapify(array, largest, length);
		}

	}

	/*
	 * Function to swap the ith element and jth element in a given array
	 */
	public static void swap(int[] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void swap(ArrayMin[] array, int i, int j){
		ArrayMin temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void buildTreeHeap(int[] array, Node n, int index){
		int left = 2*index +1;
		int right = 2*index +2;
		if(left<array.length){
			n.left = new Node(array[left]);
		}else return;

		if(right<array.length){
			n.right = new Node(array[right]);
		}else return;

		buildTreeHeap(array, n.left, left);
		buildTreeHeap(array, n.right, right);
	}

	public static void levelOrderTraversal(int[] array){
		//Build a heap with a root element equals first element
		Node root = new Node(array[0]);
		buildTreeHeap(array, root, 0);

		//Level-order traversal of the tree
		int height = getHeight(root);
		System.out.println("Height:"+height);

		for(int i=0; i<height; i++){
			System.out.print("\nLevel-"+i + ">> ");
			printAtLevel(root, i);
		}
	}

	public static void printAtLevel(Node n, int level){
		if(n==null) return;
		if(level==0){
			System.out.print(n.data + " ");
		}else{
			printAtLevel(n.left, level-1);
			printAtLevel(n.right, level-1);
		}
	}

	public static int getHeight(Node n){
		if(n==null) return 0;
		return Math.max(getHeight(n.left), getHeight(n.right))+1;
	}

	static class Node{
		int data;
		Node left, right;
		Node(int data){
			this.data = data;
		}
	}


}

class ArrayMin{
	int min;
	int min_index;
	int[] array;
	ArrayMin(int min,int min_index, int[] array){
		this.min = min;
		this.min_index = min_index;
		this.array = array;
	}
	
}

