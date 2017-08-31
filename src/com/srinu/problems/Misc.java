package com.srinu.problems;
import java.util.HashSet;
import java.util.Set;

public class Misc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,3, 5, 6, 8, 2, 9};
		System.out.println(findPair(a,10));
	}
	
	public static boolean findPair(int[] a, int val) {
		Set<Integer> foundValues = new HashSet<Integer>();
		for(int i: a) {
			if(foundValues.contains(val-i)) {
				return true;
			}
			foundValues.add(i);
		}
		return false;
	}

}
