package com.srinu.problems;

public class Heap {
	
	public static void main(String[] args){
		int [] a= {2,3,5,1, 6, 8};
		Node root = new Node(a[0]);
		//Build a heap with a root element equals first element
		buildHeap(a, root, 0);
		
		int height = getHeight(root);
		System.out.println("Height:"+height);
		
		for(int i=0; i<height; i++){
			System.out.print("\nLevel-"+i + ">> ");
			printAtLevel(root, i);
		}
		
	}
	
	public static void buildHeap(int[] array, Node n, int index){
		int left = 2*index +1;
		int right = 2*index +2;
		if(left<array.length){
			n.left = new Node(array[left]);
		}else return;
		
		if(right<array.length){
			n.right = new Node(array[right]);
		}else return;
		
		buildHeap(array, n.left, left);
		buildHeap(array, n.right, right);
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

