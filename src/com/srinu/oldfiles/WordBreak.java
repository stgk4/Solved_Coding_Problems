package com.fb.concepts;
import java.util.Set;
import java.util.HashSet;

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		dict.add("co");
		dict.add("de");
		dict.add("aaaa");
		dict.add("aaa");
		dict.add("go");
		dict.add("goal");
		dict.add("goals");
		dict.add("special");
		String test = "leetdecocode";
		System.out.println(wordBreak_rec("goalspecial", dict));
	}

	public static boolean wordBreak(String s, Set<String> wordDict) {
		int str_len = s.length();
		if(str_len==0){
			return false;
		}
		for(int i=1; i<=str_len; i++){
			String left = s.substring(0,i);
			String right = s.substring(i);
			System.out.println("left:" + left + " Right:"+ right);
			if(wordDict.contains(left) && wordDict.contains(right)){
				return true;
			}
		}
		return false;
	}


	public static boolean wordBreak_rec(String s, Set<String> wordDict){
		int str_len = s.length();
		if(str_len==0){
			return false;
		}
		for(int i=1; i<=str_len; i++){
			String left = s.substring(0,i);
			String right = s.substring(i);
			System.out.println("left:" + left + " Right:"+ right);
			if(wordDict.contains(left)){
				if(right.equals("") || wordDict.contains(right)|| wordBreak_rec(right, wordDict)){
					return true;
				}
			}
		}
		return false;
	}
}

