package com.practice.trees;

public class LevelOrderTree {
	/**
	 * Node class
	 * @author stgk4
	 *
	 */
	public static class Node{
		int data;
		Node left, right;
		public Node(int value){
			data = value;
			left = right = null;
		}
	}


	public static Node root;
	public LevelOrderTree(){
		root = null;
	}

	public static void printLevelOrder(){
		//System.out.println(getHeightOfTree(root));
		int h = getHeightOfTree(root);
		for(int i=1; i<=h; i++){
			System.out.println("Level-"+i);
			printGivenLevel(root, i);
		}
	}

	public static void printGivenLevel(Node root, int level){
		if (root==null || level<1){
			return;
		}
		else if(level==1)
			System.out.println(root.data + " ");
		printGivenLevel(root.left, level-1);
		printGivenLevel(root.right, level-1);

	}

	public static int getHeightOfTree(Node root){
		if (root==null){
			return 0;
		}
		else{
			int lheight = getHeightOfTree(root.left);
			int rheight = getHeightOfTree(root.right);

			if(lheight>rheight){
				return lheight+1;
			}
			else{
				return rheight+1;
			}
		}


	}

	public static void main(String[] args){
		//LevelOrderTree lot = new LevelOrderTree();
		LevelOrderTree.root = new Node(1);
		LevelOrderTree.root.left = new Node(2);
		LevelOrderTree.root.right = new Node(3);
		LevelOrderTree.root.left.left = new Node(4);
		LevelOrderTree.root.left.right = new Node(5);
		LevelOrderTree.printLevelOrder();
	}
}

