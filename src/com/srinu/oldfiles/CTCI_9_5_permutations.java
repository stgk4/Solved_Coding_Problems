package com.srinu.oldfiles;
import java.util.ArrayList;

public class CTCI_9_5_permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cnu";
		ArrayList<String> result = getPerms(s);
		int num_of_perms = result.size();
		System.out.println("num_of_perms:"+num_of_perms);
		System.out.println(result);
	}

	public static ArrayList<String> getPerms(String s){
		ArrayList<String> perms = new ArrayList<String>();
		if(s.length()==0){
			perms.add("");
			return perms;
		}
		char first_char = s.charAt(0);
		String remaining_string = s.substring(1);
		ArrayList<String> rem_perms = new ArrayList<String>();
		rem_perms = getPerms(remaining_string);
		for(String str: rem_perms){
			perms.addAll(getInsertedStrings(first_char, str));
		}
		return perms;
	}

	public static ArrayList<String> getInsertedStrings(char c, String s){
		ArrayList<String> inserted_perms = new ArrayList<String>();
		for(int i=0; i<=s.length(); i++){
			String front = s.substring(0,i);
			String  end = s.substring(i);
			inserted_perms.add(front+c+end);
		}
		return inserted_perms;
	}
}
