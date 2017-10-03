package com.srinu.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
public class CheckDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sArray[] = {"one", "two", "one", "three"};
		int iArray[] = {1,2,3,1,4};
		System.out.println(checkDuplicate_int(iArray));
	}
	
	//String Array Version
	public static boolean checkDuplicateUsingSet(String[] input){
		if(input.length==0) return true;
		List<String> inputList = Arrays.asList(input);
		Set<String> inputSet = new HashSet<String>(inputList);
		if(inputList.size()>inputSet.size()){
			return false;
		}
		return true;
	}
	
	//Integer Array Version
	public static boolean checkDuplicate_int(int[] input){
		if(input.length==0) return true;
		//List<Integer> inputList = Arrays.asList(input);
		Set<Integer> inputSet = new HashSet<Integer>();
		for(int i: input){
			if(!inputSet.add(i)) return false;
		}
		return true;
	}

}
