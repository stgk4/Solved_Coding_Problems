package com.fb.concepts;
import java.util.Stack;


public class Paranthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//“{“,”}”,”(“,”)”,”[“,”]” 
		// true:    “[()]{}{[()()]()}” 
		// false: “[(])”
		String s1 = "[()]{}{[()()]()}";
		String s2 = "[(]";
		String s3 = "";
		System.out.println(s1 + ":" + isStringParan_balanced(s1));
		System.out.println(s2 + ":" + isStringParan_balanced(s2));
		System.out.println(s3 + ":" + isStringParan_balanced(s3));

	}

	public static boolean isStringParan_balanced(String s){
		char ch_array[] = s.toCharArray();
		Stack<Character> st_paran = new Stack<Character>();
		for(char c: ch_array){
			if(c == '(' || c== '[' || c == '{'){
				st_paran.push(c);
			}
			else{
				switch (c){
				case ')':
					if (st_paran.isEmpty() || st_paran.peek() != '(') return false;
					st_paran.pop();
					break;
				case ']':
					if(st_paran.isEmpty() || st_paran.peek() != '[') return false;
					st_paran.pop();
					break;

				case '}':
					if(st_paran.isEmpty() || st_paran.peek() != '{') return false;
					st_paran.pop();
					break;

				default:
					break;
				}
			}
		}
		if(st_paran.isEmpty()) return true;
		return false;
	}

}
