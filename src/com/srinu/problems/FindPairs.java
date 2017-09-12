package com.srinu.problems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(1,3,4,5,6,8,9));
		
		Pair output = getTwoPair(array,9);
		System.out.println(output.left + "," + output.right);

	}
	
	public static Pair getTwoPair(ArrayList<Integer> array, int num) {
		int low =0;
		int high = array.size()-1;
		
		while(low<=high) {
			int sum = array.get(low)+array.get(high);
			if(sum==num) {
				return new Pair(low,high);
			}
			if(sum<num) {
				low++;
			}else {
				high--;
			}
		}
		return null;
	}
	
 

}

class Pair{
	int left, right;
	Pair(int left, int right){
		this.left = left;
		this.right = right;
	}
}
