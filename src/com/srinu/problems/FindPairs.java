package com.srinu.problems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FindPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(48,20,1,3,4,6,9,24));
		Collections.sort(array);
		int target_index=0;
		while(array.size()>0 && target_index<array.size()) {
			Pair output = getTwoPair(array,target_index);
			System.out.println(target_index + ":" + (output==null? "null":output.left+","+output.right));
			if(output!=null) {
				array.remove(target_index);
				array.remove(output.right);
				array.remove(output.left);
				target_index=0;
			}else {
				target_index++;
			}
			
		}
		
		for(int i: array) {
			System.out.println(i);
		}
		

	}
	
	public static Pair getTwoPair(ArrayList<Integer> array, int target_index) {
		int low =0;
		int high = array.size()-1;
		int num = array.get(target_index);
		
		while(low<=high) {
			int sum = array.get(low)+array.get(high);
			if(sum==num && target_index!=low && target_index!=high && low!=high) {
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
