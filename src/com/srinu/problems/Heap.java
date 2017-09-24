package com.srinu.problems;

public class Heap {
	
	public static void main(String[] args){
		int [] array= {2,3,5,1, 6, 8};
		
		buildMaxHeap(array);
		
		Node root = new Node(array[0]);
		//Build a heap with a root element equals first element
		buildTreeHeap(array, root, 0);
		
		int height = getHeight(root);
		System.out.println("Height:"+height);
		
		for(int i=0; i<height; i++){
			System.out.print("\nLevel-"+i + ">> ");
			printAtLevel(root, i);
		}
		
	}
	
	public static void buildMaxHeap(int[] array){
		for(int i=array.length/2; i>=0; i--){
			maxHeapify(array, i);
		}
	}
	
	public static void maxHeapify(int[] array, int i){
		int left = 2*i +1;
		int right = 2*i +2;
		int largest = i;
		
		if(left<array.length && array[left]>array[largest]){
			largest = left;
		}
		if(right<array.length && array[right]>array[largest]){
			largest = right;
		}
		
		if(largest!=i){
			int temp = array[i];
			array[i] = array[largest];
			array[largest] = temp;
			maxHeapify(array, largest);
		}
		
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

