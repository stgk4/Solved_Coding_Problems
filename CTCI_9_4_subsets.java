package com.practice.ctci;
import java.util.ArrayList;

public class CTCI_9_4_subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] set = {0,1,2};//,3,4,5,6,7};
		ArrayList<ArrayList<Integer>> powerSet = new ArrayList<ArrayList<Integer>>();
		
		getSubsets_combi(set, powerSet);
		System.out.println("No of elements in powerSet: "+powerSet.size());
		System.out.println("powerSet:\n"+powerSet);
	}

	public static void getSubsets_combi(int[] set, ArrayList<ArrayList<Integer>> powerSet){
		int total_subsets = 1<<set.length;
		
		for(int i=0; i<total_subsets; i++){
			ArrayList<Integer> subset = covertNumToSet(set,i);
			powerSet.add(subset);
		}
	}
	
	public static ArrayList<Integer> covertNumToSet(int[] set, int num){
		ArrayList<Integer> subset = new ArrayList<Integer>();
		int set_length = set.length;
		for(int j=0; j<set_length; j++){
			if((num& 0X1) == 1){
				subset.add(set[j]);
			}
			num>>=1;
		}
		return subset;
	}
	
	public static void getSubsets(int[] set, ArrayList<ArrayList<Integer>> powerSet){
		ArrayList<Integer> empty = new ArrayList<Integer>();
		powerSet.add(empty);
		for(int element: set){
			ArrayList<ArrayList<Integer>> temp_powerSet = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> al: powerSet){
				ArrayList<Integer> subset = new ArrayList<Integer>();
				subset.addAll(al);
				subset.add(element);
				temp_powerSet.add(subset);
			}
			powerSet.addAll(temp_powerSet);
		}
		
	}
	
}
