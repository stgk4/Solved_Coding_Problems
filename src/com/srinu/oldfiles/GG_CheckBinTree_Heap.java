package com.srinu.oldfiles;

public class GG_CheckBinTree_Heap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root1 = new Node(97);
		root1.left = new Node(46);
		root1.right = new Node(37);
		root1.left.left = new Node(12);
		root1.left.right = new Node(3);
		root1.right.left = new Node(7);
		root1.right.right = new Node(31);
		root1.left.left.left = new Node(6);
		
		System.out.println(isHeap(root1));
		int n = countNodes(root1);
		System.out.println(n);
		System.out.println(isComplete(root1, 0, n));
		
		
		Node root2 = new Node(97);
		root2.left = new Node(46);
		root2.right = new Node(37);
		root2.left.left = new Node(12);
		root2.left.right = new Node(3);
		root2.left.right.left = new Node(2);
		root2.left.right.right = new Node(4);
		
		System.out.println(isHeap(root2));
		n = countNodes(root2);
		System.out.println(n);
		System.out.println(isComplete(root2, 0, n));
		
	}
	
	public static int countNodes(Node root){
		if(root==null){
			return 0;
		}
		return 1+countNodes(root.left)+countNodes(root.right);
	}
	
	public static boolean isComplete(Node root, int i, int n){
		if(root==null){
			return true;
		}
		if(i>=n){
			return false;
		}
		return isComplete(root.left, 2*i+1, n) && isComplete(root.right, 2*i+2, n);
	}
	
	public static boolean isHeap(Node root){
		if(root.left==null && root.right==null){
			return true;
		}
		if(root.right==null){//leftskewed
			return root.data>=root.left.data;
		}
		else{
			if(root.data>=root.left.data && root.data>=root.right.data){
				return isHeap(root.left) && isHeap(root.right);
			}
			else{
				return false;
			}
		}
	}
	
	public static class Node{
		int data;
		Node left, right;
		
		//favorable varialbes for dfs and bfs
		public Node adjacent[];
		public boolean visited;
		
		public Node(int data){
			this.data = data;
			left = null;
			right = null;
		}
	}

}


