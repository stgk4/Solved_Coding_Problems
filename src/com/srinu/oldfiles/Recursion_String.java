package com.srinu.oldfiles;

public class Recursion_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "I am a student";
		System.out.println(reverseString(str));
		String sr = new StringBuffer(str).reverse().toString();
		System.out.println("sr:"+ sr);
	}
	
	public static String reverseString_rec(String str){
		if(str.length()<2){
			return str;
		}
		return reverseString_rec(str.substring(1)) + str.charAt(0);
	}
	
	public static String reverseString(String str){
		StringBuilder sb = new StringBuilder();
		char c[] = str.toCharArray();
		int c_len = str.length();
		for(int i=c_len-1; i>=0; i--){
			sb.append(c[i]);
		}
		return sb.toString();
	}
	
	

}
