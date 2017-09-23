package com.srinu.problems;

public class ScreenM {

	public static void main(String[] args) {
		/*DivResult res = divideNum(25,7);
		if(res==null){
			System.out.println("Cannot divide zero");
		}else{
			System.out.println("Quotient:"+res.quotient + "\n" + "Remainder:"+ res.remainder);
		}*/
		int a1[] = {1,2,3};
		int a2[] = {3,5,18,23};
		int a3[] = {2,12,24};
		
		int[] array = merge3Sorted(a1, a2, a3);
		for(int e: array){
			System.out.print(e + " ");
		}
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
