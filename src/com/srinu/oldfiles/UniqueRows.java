package com.srinu.oldfiles;

import java.util.HashMap;

public class UniqueRows {

	public static void main(String[] args) {
		
		char[][] input = {{'1','1','0','1'}, {'1','0','0','1'},{'1','1','0','1'}};
		System.out.println(getUnique(input, input.length));

	}
	
	public static String getUnique(char[][] array, int m){
		ArrayTrie at = new ArrayTrie();
		for(int i=0; i<m; i++){
			char[] row = array[i];
			at.addRow(row);
		}
		System.out.println("Added rows");
		//System.out.println(at.printTrie());
		//return null;
		return at.getUnique();
	}
	
	public static class TriNode{
		char c;
		HashMap<Character, TriNode> neighbor;
		boolean isLeaf;
		int count=0;
		public TriNode(char c){
			this.c=c;
			neighbor = new HashMap<Character, TriNode>();
		}
	}
	
	public static class ArrayTrie{
		TriNode root;
		public ArrayTrie(){
			root = new TriNode(' ');
		}
		
		public void addRow(char[] row){
			//System.out.println(row[0] + " " + row [1] + " " + row[2]);
			TriNode crawl = root;
			for(int i=0; i<row.length; i++){
				HashMap<Character, TriNode> hm = crawl.neighbor;
				char c = row[i];
				if(hm.containsKey(c)){
					crawl = hm.get(c);
				}
				else{
					//System.out.println("NewNode:" + c);
					TriNode new_node = new TriNode(c);
					hm.put(c,new_node);
					crawl = new_node;
				}
				crawl.count++;
			}
			crawl.isLeaf = true;
		}
		
		public String getUnique(){
			StringBuffer sb = new StringBuffer();
			getUnique_util(root, sb);
			return sb.toString();
		}
		
		public void getUnique_util(TriNode n, StringBuffer res){
			String prev = n.c + "";
			if(n.isLeaf){
				//if(root.count==1){
					res.append("$");
					//first.setLength(0);
					//first = new StringBuffer();
					//System.out.println(res.toString());
				//}	
				return;
			}
			HashMap<Character, TriNode> hm = n.neighbor;
			for(char key: hm.keySet()){
				TriNode t = hm.get(key);
				res.append(key);
				getUnique_util(t, res);
			}
		}
		
		public String printTrie(){
			StringBuffer print = new StringBuffer();
			printTrie_util(root, print);
			return print.toString();
		}
		
		public void printTrie_util(TriNode t, StringBuffer print){
			if(t.isLeaf){
				print.append(t.c);
				print.append("$");
				return;
			}
			HashMap<Character, TriNode> hm = t.neighbor;
			for(char key: hm.keySet()){
				print.append(key);
				printTrie_util(hm.get(key), print);
			}
		}
	}	

}
