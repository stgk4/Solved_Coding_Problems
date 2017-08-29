package com.srinu.oldfiles;

import java.util.HashMap;
import java.util.Scanner;
public class TriePhonebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		scanner.nextLine();
		TriePhoneBook tpb = new TriePhoneBook();
		for(int t=0; t<T; t++){
			String input = scanner.nextLine();
			String[] inputs = input.split(" ");
			if(inputs[0].equals("add")){
				tpb.addName(inputs[1]);
			}
			else if(inputs[0].equals("find")){
				System.out.println(tpb.findPartial(inputs[1]));
			}
		}
	}

	public static class TrieNode{
		char c;
		boolean isEnd;
		int frequency;
		HashMap<Character, TrieNode> children;
		public TrieNode(char c){
			this.c = c;
			frequency =0;
			isEnd=false;
			children = new HashMap<Character, TrieNode>();
		}
	}
	
	public static class TriePhoneBook{
		TrieNode root;
		public TriePhoneBook(){
			root = new TrieNode((char)0);
		}
		
		public void addName(String s){
			TrieNode crawl = root;
			int length = s.length();
			for(int i=0; i<length; i++){
				char c = s.charAt(i);
				HashMap<Character, TrieNode> children = crawl.children;
				if(children.containsKey(c)){
					crawl = children.get(c);
				}
				else{
					TrieNode temp = new TrieNode(c);
					children.put(c,temp);
					crawl = temp;
				}
				crawl.frequency++;
			}
			crawl.isEnd = true;
		}
		
		public int findPartial(String partial){
			TrieNode crawl = root;
			int length=partial.length();
			for(int i=0; i<length; i++){
				char c = partial.charAt(i);
				HashMap<Character, TrieNode> children = crawl.children;
				if(children.containsKey(c)){
					crawl = children.get(c);
				}
				else{
					return 0;
				}
			}
			return crawl.frequency;	
		}
	}

}
