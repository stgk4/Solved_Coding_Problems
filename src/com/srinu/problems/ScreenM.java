package com.srinu.problems;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class ScreenM {

	public static void main(String[] args) {
		/*DivResult res = divideNum(25,7);
		if(res==null){
			System.out.println("Cannot divide zero");
		}else{
			System.out.println("Quotient:"+res.quotient + "\n" + "Remainder:"+ res.remainder);
		}*/
		/*int a1[] = {1,2,3};
		int a2[] = {3,5,18,23};
		int a3[] = {2,12,24};

		int[] array = merge3Sorted(a1, a2, a3);
		for(int e: array){
			System.out.print(e + " ");
		}*/

		//System.out.println(isPalendromeConstantSpace(100));


		/*printInOrderTree(root);
		System.out.println("After");
		printInOrderTree(reverseTree(root));*/

		//printInOrderTree(root);
		//printLevelOrderTree(root);

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.left.left = new TreeNode(11);
		root.right.left.left.left = new TreeNode(12);
		root.right.left.left.left.left = new TreeNode(13);

		root.right.right = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		root.right.right.right = new TreeNode(9);

		//printVerticalOrder(root);

	}

	public static boolean isSymmetric_direct(TreeNode root){
		return isSymmetric_direct(root.left, root.right);
	}
	
	private static boolean isSymmetric_direct(TreeNode left, TreeNode right) {
		// TODO Auto-generated method stub
		if(left==null && right==null) return true;
		if(left==null || right==null) return false;
		
		return isSymmetric_direct(left.left,right.right) && isSymmetric_direct(left.right,right.left);
	}

	public static boolean isSymmetric(TreeNode root){
		//reverse one half of the tree (say left) and it should now equals to 
		//right
		return isEqual(root.left,root.right);
	}

	public static boolean isEqual(TreeNode t1, TreeNode t2){
		if(t1==null && t2==null) return true;
		if(t1==null || t2==null) return false;


		return isEqual(t1.left, t2.left) && isEqual(t1.right, t2.right);
	}
	

	public static TreeNode reverseTree(TreeNode root){
		if (root==null) return root;

		TreeNode left = reverseTree(root.left);
		TreeNode right = reverseTree(root.right);
		root.left = right;
		root.right = left;
		return root;
	}

	public static void printVerticalOrder(TreeNode root){
		HashMap<Integer, List<Integer>> hm_Vertical = new HashMap<Integer, List<Integer>>();

		printVerticalOrder_util(root, 0, hm_Vertical);


		for(int dist_key: hm_Vertical.keySet()){
			System.out.print("\nV-Level:"+dist_key + ">> ");
			for(int node_val:hm_Vertical.get(dist_key)){
				System.out.print(node_val + " ");
			}
		}
	}

	public static void printVerticalOrder_util(TreeNode root, int dist, HashMap<Integer, List<Integer>> hm_Vertical){
		if(root==null) return;

		if(!hm_Vertical.containsKey(dist)){
			List<Integer> list = new ArrayList<Integer>();
			list.add(root.data);
			hm_Vertical.put(dist,list);
		}else{
			hm_Vertical.get(dist).add(root.data);
		}

		printVerticalOrder_util(root.left, dist-1, hm_Vertical);
		printVerticalOrder_util(root.right, dist+1, hm_Vertical);
	}

	public static void printDiagonalOrder(TreeNode root){
		HashMap<Integer, List<Integer>> hm = new HashMap<Integer, List<Integer>>();
		printDiagonalOrder_util(root, 0, hm);

		for(int d: hm.keySet()){
			System.out.print("\nD:"+d + ">> ");
			for(int val: hm.get(d)){
				System.out.print(val + " ");
			}
		}
	}

	private static void printDiagonalOrder_util(TreeNode root, int d, HashMap<Integer, List<Integer>> hm) {
		// TODO Auto-generated method stub
		if(root==null) return;

		if(hm.containsKey(d)){
			hm.get(d).add(root.data);
		}else{
			List<Integer> list = new ArrayList<Integer>();
			list.add(root.data);
			hm.put(d,list);
		}

		printDiagonalOrder_util(root.left, d+1, hm);
		printDiagonalOrder_util(root.right, d, hm);
	}

	public static void printInOrderTree(TreeNode root){
		if(root==null) {System.out.print("NULL ");return;}
		printInOrderTree(root.left);
		System.out.print(root.data + " ");
		printInOrderTree(root.right);
	}

	public static void printPreOrderTree(TreeNode root){
		if(root==null){System.out.print("Null "); return;}
		System.out.print(root.data + " ");
		printPreOrderTree(root.left);
		printPreOrderTree(root.right);
	}

	public static void printPostOrderTree(TreeNode root){
		if(root==null){System.out.print("Null "); return;}
		printPostOrderTree(root.left);
		printPostOrderTree(root.right);
		System.out.println(root.data + " ");
	}

	public static void printLevelOrderTree(TreeNode root){
		if (root==null) return;
		int level=getHeight(root);
		System.out.println("Height:"+level);
		for(int i=1; i<=level; i++){
			System.out.print("Level-"+i+">> ");
			printAtLevel(root, i);
			System.out.println();
		}
	}

	public static void printAtLevel(TreeNode root, int level){
		if(root==null || level<1) return;
		if(level==1) System.out.print(root.data + " ");
		else{
			printAtLevel(root.left,level-1);
			printAtLevel(root.right,level-1);
		}
	}

	public static int getHeight(TreeNode root){
		if(root==null) return 0;
		return Math.max(getHeight(root.left), getHeight(root.right))+1;
	}

	static class TreeNode{
		int data;
		TreeNode left, right;
		TreeNode(int data){
			this.data = data;
		}
	}

	public static boolean isPalendromeConstantSpace(int x){
		if(x<0 || (x!=0 && x%10==0)) return false;

		int reversedNum =0;
		while(x>reversedNum){
			reversedNum = reversedNum*10+ (x%10);
			x/=10;
		}

		return x==reversedNum || x==reversedNum/10;
	}

	/*
	 * Method to merge 3 sorted arrays
	 */
	public static int[] merge3Sorted(int[] a1, int[] a2, int[] a3){

		boolean a1_empty=false,a2_empty=false, a3_empty=false;
		if (a1.length ==0) a1_empty=true;
		if (a2.length ==0) a2_empty=true;
		if (a3.length ==0) a3_empty=true;

		//if all the three arrays are empty
		if(a1_empty && a2_empty && a3_empty){
			return null;
		}

		//Case where two of three arrays are empty
		else if(a1_empty && a2_empty){
			return a3;
		}else if(a1_empty && a3_empty){
			return a2;
		}else if(a2_empty && a3_empty){
			return a1;
		}

		//Case when only one of the three arrays is empty
		else if(a1_empty){
			return merge2Sorted(a2,a3);
		}else if(a2_empty){
			return merge2Sorted(a1,a3);
		}else if(a3_empty){
			return merge2Sorted(a1,a2);
		}

		//This is the final else case where all the three are non-empty arrays
		int[] merge12 = merge2Sorted(a1,a2);
		int[] merge123 = merge2Sorted(merge12, a3);
		return merge123;
	}


	/*
	 * Merge two sorted arrays
	 *
	 */
	public static int[] merge2Sorted(int[] a, int[] b){
		//fixing reusable length variables 
		int a_length = a.length;
		int b_length = b.length;
		int c_length = a_length + b_length;

		//output array
		int c[] = new int[c_length];

		//state pointers while merge sorting
		int a_pointer = 0;
		int b_pointer = 0;
		int i=0;

		//loading array 'c' with lowest of two arrays in order
		while(a_pointer<a_length && b_pointer<b_length){
			if(a[a_pointer]<b[b_pointer]){
				c[i]=a[a_pointer];
				a_pointer++;
			}else{
				c[i]=b[b_pointer];
				b_pointer++;
			}
			i++;
		}

		//case when array 'a' is not maxed out
		while(a_pointer<a_length){
			c[i] = a[a_pointer];
			a_pointer++;
			i++;
		}

		//case when array 'b' is not maxed out
		while(b_pointer<b_length){
			c[i] = b[b_pointer];
			b_pointer++;
			i++;
		}
		return c;
	}



	/*
	 * Method to divide a number with another without using division operation
	 * 
	 * IMP NOTE: There are possibility that the parameters can also be negative
	 * If time permits I will also look into those edge cases.
	 */
	public static DivResult divideNum(int dividend, int divisor){
		DivResult result = null;
		//Cannot divide case
		if (divisor == 0) return result;

		result = new DivResult();
		while(dividend>=divisor){
			++result.quotient;
			dividend= dividend-divisor;
		}
		result.remainder = dividend;
		return result;
	}



}

/*
 * Datastructure for quotient and remainder answers from division operation
 */
class DivResult{
	int quotient;
	int remainder;
}



/*
 * 
 * This is short implementation of Linked List Node
 */
class LLNode{
	LLNode Next;
	int data;
	public LLNode(int data){
		this.data = data;
	}
}
