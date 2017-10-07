package com.srinu.problems;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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

		/*TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);

		root.right.left.left = new TreeNode(11);
		root.right.left.left.left = new TreeNode(12);
		root.right.left.left.left.left = new TreeNode(13);

		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		root.left.left.right = new TreeNode(9);*/

		//printLevelOrderTree(root);
		//if(isBinaryTreeHeap(root, 1)) System.out.println("Given binary tree is heap");
		//else System.out.println("Given binary tree is not a heap");

		/*LLNode n1 = new LLNode(1);
		n1.next = new LLNode(2);
		n1.next.next = new LLNode(3);

		printLL(n1);
		printLL(reverseLinkedList(n1));*/
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7); //change to 9 for check
		root.right = new TreeNode(11);
		root.right.left = new TreeNode(9); //change to 7 for check
		
		//System.out.println(isBST(root));
		//System.out.println(isBST_inorder(root,root.data));
		//System.out.println(inOrderSuccessor(root,11).data);
		
		Meeting[] array = {new Meeting(9,10),
				new Meeting(12,13), 
				new Meeting(10.5,11), 
				new Meeting(10,11)};
		//printMeetingArray(array);
		Arrays.sort(array,new meetingComparator());
		//printMeetingArray(array);
		
		/*sending previous meeting ending time as maximum possible hour, 
		theoretically infinite, so that one room is allocated first time
		assuming a meeting is going on for infinite time*/
		int rooms = getMaxMeetingRooms(array,25);
		System.out.println(rooms);
	}
	
	public static int getMaxMeetingRooms(Meeting[] array, double previous){
		int counter =0;
		//ArrayList<Meeting> al_endtimes = new ArrayList<Meeting>();
		for(Meeting m: array){
			if(m.start<previous) counter++;
			previous=m.end;
		}
		return counter;
	}
	/*
	 * al_endtimes.add(m);
			Collections.sort(al_endtimes, new meetingEndTimeComparator());
			
			if(m.start<al_endtimes.remove(0).end) counter++;
	 */
	
	static class MeetingHeap{
		Meeting root;
		Meeting last;
		
		void addMeeting(Meeting m){
			if(root==null) {
				root =m;
				last=m;
			}
			
		}
		
	}
	
	
	public static void printMeetingArray(Meeting[] arrays){
		for(Meeting m: arrays){
			System.out.println(m.start + "," +m.end);
		}
		System.out.println("---");
	}
	
	static class meetingComparator implements Comparator<Meeting>{

		@Override
		public int compare(Meeting m1, Meeting m2) {
			// TODO Auto-generated method stub
			return (int)(Math.ceil(m1.start)-Math.ceil(m2.start));
		}
		
	}
	
	static class meetingEndTimeComparator implements Comparator<Meeting>{

		@Override
		public int compare(Meeting m1, Meeting m2) {
			// TODO Auto-generated method stub
			return (int)(Math.ceil(m1.end)-Math.ceil(m2.end));
		}
		
	}
	
	static class Meeting{
		double start;
		double end;
		Meeting(double start, double end){
			this.start = start;
			this.end = end;
		}
	}
	
	/*
	 * Find inorder successor of a given target node
	 */
	public static TreeNode inOrderSuccessor(TreeNode root, int target){
		TreeNode target_Node = null;
		TreeNode n = root;
		//finding targetNode
		while(n!=null){
			if(n.data==target){
				target_Node = n;
				break;
			}else if(n.data>target){
				n=n.left;
			}else{
				n=n.right;
			}
		}
		
		//case-1: if rightSubtree of the node is not null
		if(target_Node.right!=null){
			return minValue(target_Node.right);
		}
		
		//case-2: start from the root and search the successor down the tree
		TreeNode succ = new TreeNode(-1);
		while(root!=null){
			if(target_Node.data<root.data){
				succ = root;
				root = root.left;
			}else if(target_Node.data>root.data){
				root = root.right;
			}else break;
		}
		return succ;
		
		
	}
	
	private static TreeNode minValue(TreeNode n) {
		// TODO Auto-generated method stub
		while(n.left!=null){
			n=n.left;
		}
		return n;
	}

	public static boolean isBST_inorder(TreeNode root, int prev){
		if(root==null) return true;
		isBST_inorder(root.left, root.data);
		if(root.data<prev) return false;
		isBST_inorder(root.right,root.data);
		return true;
	}
	
	
	public static boolean isBST(TreeNode root){
		return isBST_util(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	public static boolean isBST_util(TreeNode root, int min, int max){
		if(root==null) return true;
		
		if(root.data<min || root.data>max) return false;
		
		return isBST_util(root.left, min, root.data-1) &&
				isBST_util(root.right, root.data+1, max);
	}

	public static LLNode reverseLinkedList(LLNode node){
		LLNode previous = null;
		while(node!=null){
			LLNode next = node.next;
			node.next = previous;
			previous = node;
			node=next;
		}
		return previous;
	}
	public static void printLL(LLNode node){
		while(node!=null){
			System.out.print(node.data + "->");
			node=node.next;
		}
		System.out.print("NULL\n");
	}

	static class LLNode{
		int data;
		LLNode next;
		LLNode(int data){
			this.data = data;
			next = null;
		}
	}

	public static boolean isBinaryTreeHeap(TreeNode root, int minRmax){
		if (root==null) return true;

		//counting nodes and passing ito the property
		int node_count = countNodes(root);
		if(minRmax==0)
			return isComplete(root,0,node_count) && isMinHeap(root);
		else
			return isComplete(root,0,node_count) && isMaxHeap(root);
	}

	/*
	 * Method to count the number of nodes in a tree
	 */
	private static int countNodes(TreeNode root) {
		// TODO Auto-generated method stub
		if(root==null) return 0;
		return 1 + countNodes(root.left) + countNodes(root.right);
	}

	/*
	 * Method to check MaxHeap Property
	 */
	private static boolean isMaxHeap(TreeNode root) {
		//basecase: single isolated node satisfies the property
		if(root.left==null && root.right==null) return true;

		//if the node is the last-but-one level
		if(root.right==null) return root.data>=root.left.data;
		else{
			//so the node is some intermediary node
			//first check the heap property here and then recursively 
			//call on child nodes
			if(root.data>=root.left.data && root.data>=root.right.data){
				return isMaxHeap(root.left) && isMaxHeap(root.right);
			}else return false;
		}
	}

	/*
	 * Method to check MaxHeap Property
	 */
	private static boolean isMinHeap(TreeNode root) {
		if(root.left==null && root.right==null) return true;
		if(root.right==null) return root.data<=root.left.data;
		if(root.data<=root.left.data && root.data<=root.right.data)
			return isMinHeap(root.left) && isMinHeap(root.right);
		else return false;
	}
	private static boolean isComplete(TreeNode root, int index, int node_count) {
		if(root==null) return true;

		if(index>=node_count) return false;

		return isComplete(root.left, 2*index+1, node_count) && 
				isComplete(root.right, 2*index+2, node_count);
	}

	public static boolean isTreeSimilar(TreeNode t1, TreeNode t2){
		if(t1==null && t2==null) return true;
		if(t1==null || t2==null) return false;
		if(t1.data != t2.data) return false;

		return isTreeSimilar(t1.left,t2.left) && isTreeSimilar(t1.right, t2.right);
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
		return isEqual(reverseTree(root.left),root.right);
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
