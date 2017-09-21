package com.srinu.oldfiles;

import java.util.ArrayList;

public class GG_serialize_deserialize {

	public static int index = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		//printLevelOrder(root);
		
		 
		 ////////Serialization	 
		System.out.print("[ ");
		inOrder(root);
		System.out.print("]\n");
		ArrayList<Integer> tree_array = new ArrayList<Integer>();
		serialize(root,tree_array);
		System.out.println(tree_array);*/
		
		////////De-serialization
		 int[] des_array = {20, 8, 4, 12, 10,14, 22};
		 /*Node root1= null;
		root1 = deserialize(des_array, root1, 0);*/
		 Node n = constructTree(des_array, des_array.length);
		System.out.print("[ ");
		inOrder(n);
		System.out.print("]\n");
		 
	}
	
	public static Node constructTree(int[] array, int size){
		//int preIndex = 0;
		return constructTree_util(array, array[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static Node constructTree_util(int[] array, int value, int min, int max){
		if (index>=array.length){
			return null;
		}
		Node root = null;
		if(value>min && value<max){
			root = new Node(value);
			index = index+1;
			//System.out.println(index + " " + size);
			if(index<array.length){
				root.left = constructTree_util(array, array[index], min, value);
				root.right = constructTree_util(array, array[index], value, max);
			}
		}
		return root;
	}
	
	public static Node deserialize(int[] array, Node root1, int i){
		//System.out.println(i + " " + array.length);
		if(i>=array.length || array[i] == -1){
			return null;
		}
		root1 = new Node(array[i]);
		deserialize(array,root1.left,++i);
		deserialize(array,root1.right,++i);
		System.out.println(getHeightOfTree(root1));
		return root1;
	}
	
	public static void serialize(Node root, ArrayList<Integer> al){
		if(root==null){
			al.add(-1);
			return;
		}
		al.add(root.data);
		serialize(root.left,al);
		serialize(root.right,al);
	}
	
	public static void inOrder(Node root){
		if(root!=null){
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}
	
	
	public static void printLevelOrder(Node root){
		//System.out.println(getHeightOfTree(root));
		int h = getHeightOfTree(root);
		for(int i=1; i<=h; i++){
			//System.out.println("Level-"+i);
			printGivenLevel(root, i);
			System.out.println();
		}
	}
	
	public static void printGivenLevel(Node root, int level){
		if (root==null){
			return;
		}
		else if(level==1)
			System.out.print(root.data + " ");
		else if(level>1){
			printGivenLevel(root.left, level-1);
			printGivenLevel(root.right, level-1);
		}
	}
	
	public static int getHeightOfTree(Node root){
		if(root == null) return 0;
		return 1+Math.max(getHeightOfTree(root.left), getHeightOfTree(root.right));
	}

}

class Node{
	int data;
	Node left, right;
	public Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}