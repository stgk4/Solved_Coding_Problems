package com.srinu.problems;

public class TreesGraphs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	 * Method to find the height of the tree
	 */
	public static int getHeight(TreeNode root) {
		if(root==null) return 0; //base case
		return Math.max(getHeight(root.left), getHeight(root.right))+1;
	}
	
	/*
	 * Method to check if a binary tree is balanced. 
	 * Note: A balanced is defined to be a tree such that the heights of the two 
	 * subtrees of any node never differ by more than one
	 */
	public static boolean isBalanced(TreeNode root) {
		if (root==null) return true; //base case
		
		int heightDiff = getHeight(root.left)-getHeight(root.right);
		if(Math.abs(heightDiff)>1) {
			return false;
		}else {
			//Recurse
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}
	
	
	
	

}

class TreeNode{
	TreeNode left, right;
	int data;
	
}
