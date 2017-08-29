package com.srinu.oldfiles;
import java.util.HashMap;

public class Trie_practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie dict = new Trie();
		//System.out.println((char)0);
		dict.insert("are");
		dict.insert("area");
		dict.insert("base");
		dict.insert("cat");
		dict.insert("cater");
		dict.insert("basement");
		
		String input = "caterer";
		System.out.print(input + ": ");
		System.out.println(dict.getMatchingPrefix(input));
		
		input = "basement";
		System.out.print(input + ": ");
		System.out.println(dict.getMatchingPrefix(input));
		
		
		input = "are";
		System.out.print(input + ": ");
		System.out.println(dict.getMatchingPrefix(input));
		
		input = "arex";
		System.out.print(input + ": ");
		System.out.println(dict.getMatchingPrefix(input));
		
		input = "basementz";
		System.out.print(input + ": ");
		System.out.println(dict.getMatchingPrefix(input));
		
		input = "xyz";
		System.out.print(input + ": ");
		System.out.println(dict.getMatchingPrefix(input));
	}

}

class TrieNode{
	private char value;
	private HashMap<Character, TrieNode> children;
	private boolean bIsEnd;
	
	public TrieNode(char ch){
		value = ch;
		children = new HashMap<Character, TrieNode>();
		bIsEnd = false;
	}
	
	public HashMap<Character, TrieNode> getChildern(){
		return children;
	}
	public char getValue(){
		return value;
	}
	public void setIsEnd(boolean val){
		bIsEnd = val;
	}
	public boolean isEnd(){
		return bIsEnd;
	}
}

class Trie{
	public TrieNode root;
	public Trie(){
		root = new TrieNode((char)0);
	}
	
	public void insert(String word){
		int length = word.length();
		TrieNode crawl = root;
		
		for(int level=0; level<length; level++){
			HashMap<Character, TrieNode> child = crawl.getChildern();
			char ch = word.charAt(level);
			if(child.containsKey(ch)){
				crawl = child.get(ch);
			}
			else{
				TrieNode temp = new TrieNode(ch);
				child.put(ch, temp);
				crawl=temp;
			}
		}
		crawl.setIsEnd(true);
	}
	
	public String getMatchingPrefix(String input){
		String result = "";
		int length = input.length();
		TrieNode crawl = root;
		int level, prevMatch = 0;
		for(level=0; level<length; level++){
			char ch = input.charAt(level);
			HashMap<Character, TrieNode> child = crawl.getChildern();
			if(child.containsKey(ch)){
				result +=ch;
				crawl = child.get(ch);
				
				if(crawl.isEnd()){
					prevMatch = level +1;
				}
				
			}
			else{
				break;
			}
		}
		
		if(!crawl.isEnd()){
			return result.substring(0,prevMatch);
		}
		return result;
	}
}