package com.srinu.problems;

public class ScreenM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DivResult res = divideNum(25,7);
		if(res==null){
			System.out.println("Cannot divide zero");
		}else{
			System.out.println("Quotient:"+res.quotient + "\n" + "Remainder:"+ res.remainder);
		}
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
