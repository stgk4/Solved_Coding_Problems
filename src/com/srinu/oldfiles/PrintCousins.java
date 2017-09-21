package com.srinu.oldfiles;


public class PrintCousins {

	public static void main(String[] args) {

		//Create Tree
		Node r = new Node(1);
		r.left = new Node(2);
		r.right = new Node(3);
		r.left.left = new Node(4);
		r.left.right = new Node(5);
		r.right.left = new Node(6);
		//r.right.right = new Node(7);
		Node root = r;
		System.out.println("HeightOfTree: " + getHeight(r));
		System.out.println("--------------------------------");
		for(int i=1; i<=3; i++){
			printAtLevel(i, r);
			System.out.println();
		}
		System.out.println("--------------------------------");
		/*for(int i=0; i<=8; i++){
			int level = getLevel(r,i,1);
			if(level!=0){
				System.out.println("level of " + i + " is " + level);
			}
			else{
				System.out.println(i + " not found in tree");
			}
		}*/
		System.out.println("--------------------------------");
		Node target = r.left.left;
		int level = getLevel(root,target,1);
		System.out.println("level:" + level);
		printCousinsOfNode(root, level, target);

	}

	public static void printCousinsOfNode(Node root, int level, Node target){
		if(root==null || level<2){
			return;
		}
		if(level==2){
			if(root.left==target || root.right==target){
				return;
			}
			if(root.left!=null){
				System.out.print(root.left.data);
			}
			if(root.right!=null){
				System.out.print(root.right.data);
			}
		}
		printCousinsOfNode(root.left, level-1, target);
		printCousinsOfNode(root.right, level-1, target);
	}

	public static void printAtLevel(int level, Node root){
		if(root == null){
			return;
		}
		if(level==1){
			System.out.print(root.data);
		}
		printAtLevel(level-1, root.left);
		printAtLevel(level-1, root.right);
	}
	
	public static int getLevel(Node n, Node target, int level){
		if(n==null){
			return 0;
		}
		if(n == target){
			return level;
		}
		int nextLevel= getLevel(n.left,target, level+1);
		if(nextLevel!=0){
			return nextLevel;
		}
		nextLevel = getLevel(n.right, target, level+1);
		return nextLevel;
	}

	public static int getHeight(Node r){
		if(r==null){
			return 0;
		}
		return 1+ Math.max(getHeight(r.left), getHeight(r.right));
	}

	public static class Node{
		Node left, right;
		int data;
		public Node(int data){
			this.data = data;
			left = null;
			right = null;
		}
	}
}
