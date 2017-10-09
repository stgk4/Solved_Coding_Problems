package com.srinu.trees;


public class ConstructBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] parent = {-1,0,0,1,1,3,5};
	}
	
	public static Node constructTree(int[] parent, int i){
		//if(i>parent.length) return root;
		return null;
	}
	
	

}

class Node{
	int data;
	Node left, right;
	Node(int data){
		this.data = data;
		left =null;
		right = null;
	}
}