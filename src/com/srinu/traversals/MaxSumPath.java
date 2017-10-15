package com.srinu.traversals;


public class MaxSumPath {
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
        tree.root = new Noode(-15);
        tree.root.left = new Noode(5);
        tree.root.right = new Noode(6);
        tree.root.left.left = new Noode(-8);
        tree.root.left.right = new Noode(1);
        tree.root.left.left.left = new Noode(2);
        tree.root.left.left.right = new Noode(6);
        tree.root.right.left = new Noode(3);
        tree.root.right.right = new Noode(9);
        tree.root.right.right.right = new Noode(0);
        tree.root.right.right.right.left = new Noode(4);
        tree.root.right.right.right.right = new Noode(-1);
        tree.root.right.right.right.right.left = new Noode(10);
        System.out.println("Max pathSum of the given binary tree is "
                + tree.maxPathSum_leaves());
	}

}

class Noode {
	 
    int data;
    Noode left, right;
 
    Noode(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree{
	 Noode root;
	static int max_2Leaves_sum;
	
	int maxPathSum_leaves(){
		max_2Leaves_sum = Integer.MIN_VALUE;
		maxPathSum_leaves_rec(this.root);
		return max_2Leaves_sum;
	}
	
	int maxPathSum_leaves_rec(Noode n) {
		if(n==null) return 0;
		
		//leaf Noode case;
		if(n.left==null && n.right==null) return n.data;
		
		int left = maxPathSum_leaves_rec(n.left);
		int right = maxPathSum_leaves_rec(n.right);
		
		if(n.left==null || n.right==null) {
			return (n.left==null)?n.data+right:n.data+left;
		}
		
		int max_current = n.data+Math.max(left, right); //one-side-reused
		int max_at_this_node = left+n.data+right;
		
		//update if the path from current Noode yields maximum
		max_2Leaves_sum = Math.max(max_2Leaves_sum, max_at_this_node);
		
		return max_current;
		
	}
	
	
}
