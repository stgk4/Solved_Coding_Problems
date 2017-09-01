package com.srinu.problems;

public class TreesGraphs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Nodee root = new Nodee(1);
		root.left= new Nodee(2);
		root.right= new Nodee(3);
		root.left.left= new Nodee(4);
		root.left.right= new Nodee(5);
		root.right.left = new Nodee(6);
		root.right.right= new Nodee(7);
		System.out.println("HeightOfTree:"+getHeight(root));
		printLevelOrder(root);
		
	}
	
	/*
	 * Method to print cousins at a level
	 */
	public static void printCousins(Nodee root, Nodee target, int level) {
		if(root==null || level<2) return;
		if(level==2) {
			if(root.left==target || root.right==target) {
				return;
			}
			if(root.left!=null) {
				System.out.println(root.left.data);
			}
			if(root.right!=null) {
				System.out.println(root.right.data);
			}
		}
		printCousins(root.left, target, level-1);
		printCousins(root.right, target, level-1);
	}
	
	/*
	 * method to find the level of a given node
	 */
	public static int getLevel(Nodee root, Nodee target, int level) {
		if(root==null) return 0;
		if(root==target) return level;
		
		int nextLevel = getLevel(root.left, target, level+1);
		if(nextLevel!=0) {
			return level;
		}
		return getLevel(root.right, target,level+1);
	}
	
	/*
	 * Method to find the height of the tree
	 */
	public static int getHeight(Nodee root) {
		if(root==null) return 0;
		return Math.max(getHeight(root.left), getHeight(root.right))+1;
	}
	/*
	 * print elements in the level order of tree
	 */
	public static void printLevelOrder(Nodee root) {
		if(root==null) return;
		int height = getHeight(root);
		for(int i=1; i<=height; i++) {
			System.out.println("Level-"+i);
			printAtLevel(root,i);
		}
	}
	
	/*
	 * prints elements at a given level
	 */
	public static void printAtLevel(Nodee root, int h) {
		if(root==null || h<1) return;
		
		if(h==1) {
			System.out.println(root.data);
		}else {
			printAtLevel(root.left, h-1);
			printAtLevel(root.right, h-1);
		}
	}
	
	/*
	 * Method to check if a binary tree is balanced. 
	 * Note: A balanced is defined to be a tree such that the heights of the two 
	 * subtrees of any Nodee never differ by more than one
	 */
	public static boolean isBalanced(Nodee root) {
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

class Nodee{
	Nodee left, right;
	int data;
	Nodee(int data){
		this.data = data;
	}
	
}
