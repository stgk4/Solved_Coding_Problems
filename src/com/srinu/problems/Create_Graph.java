package com.srinu.problems;
import java.util.Hashtable;
import java.util.ArrayList;

public class Create_Graph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char [][] input = {{'\\', '/'}, {'\\', '\\'}}; 
		printCharArray(input);

	}
	
	public static void printCharArray(char[][] array) {
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public static void setNeighbours(Node n, ArrayList<Node> al) {
		for(Node n1: al) {
			n.adjacent.add(n1);
		}
	}
	
	public static Hashtable<Integer, Node> createGraph(char[][] input) {
		
		return null;
	}
	
	class Node{
		int node_num;
		ArrayList<Node> adjacent;
		
		 Node(int node_num){
			 this.node_num = node_num;
		 }
	}

}
