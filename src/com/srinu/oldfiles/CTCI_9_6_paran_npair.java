package com.srinu.oldfiles;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CTCI_9_6_paran_npair {

	public static void main(String[] args){

		method_1("dfd");
		int j = method_1(3);
		
		
		//method-1 using set
		//System.out.println(getParans(4));
		
		// method-2 using count
		//System.out.println(addParen(4));
	}
	
	public static void method_1(String s){
		System.out.println(s);
	}
	public static int method_1(int s){
		System.out.println(s);
		return 0;
	}
	
	public static ArrayList<String> addParen(int n){
		ArrayList<String> list = new ArrayList<String>();
		char[] str = new char[2*n];
		int left_rem = n;
		int right_rem = n;
		int index =0;
		addParen(list, str, left_rem, right_rem, index);
		return list;
	}
	
	public static void addParen(ArrayList<String> list, char[] str, int left_rem, int right_rem, int index){
		if(left_rem<0 || right_rem<left_rem) return;
		if(left_rem==0 && right_rem==0) list.add(String.copyValueOf(str));
		else{
			if(left_rem>0){
				str[index] = '(';
				addParen(list, str, left_rem-1, right_rem, index+1);
			}
			if(right_rem>left_rem){
				str[index] = ')';
				addParen(list, str, left_rem, right_rem-1, index+1);
			}
		}
		
	}
	
	public static Set<String> getParans(int n){
		Set<String> set = new HashSet<String>();
		if(n==1){
			set.add("()");
			return set;
		}
		Set<String> set_lower = new HashSet<String>();
		set_lower = getParans(n-1);
		for(String s: set_lower){
			set.addAll(insertParans(s));
		}
		return set;
	}
	
	public static Set<String> insertParans(String s){
		Set<String> inserted_set = new HashSet<String>();
		inserted_set.add("()"+s);
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			if(c=='('){
				String left = s.substring(0,i+1);
				String right = s.substring(i+1);
				inserted_set.add(left + "()" + right);
			}
		}
		return inserted_set;
	}
}
