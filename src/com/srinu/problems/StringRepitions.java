package com.srinu.problems;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;


public class StringRepitions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//given a list of strings find the highest repeated string
		String sa[] = {"Alex", "bob", "james", "Alex", "bob", "Alex"};
		ArrayList<String> input = new ArrayList<String>(Arrays.asList(sa));
		Result res = getHighestRepeated(input);
		System.out.println(res.maxString + ":" + res.maxCount);
	}
	
	public static Result getHighestRepeated(ArrayList<String> input){
		if(input.size()==0) return null;
		Result res = new Result();
		res.maxCount = 0;
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for(String s: input){
			int val = 1;
			if(hm.containsKey(s)){
				 val+= hm.get(s);
			}
			hm.put(s,val);
			if(val>res.maxCount){
				res.maxCount = val;
				res.maxString = s;
			}
		}
		return res;
	}	
}

class Result{
	int maxCount;
	String maxString;
}
