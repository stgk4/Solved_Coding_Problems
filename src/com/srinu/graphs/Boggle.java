package com.srinu.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Boggle {
	
	public static final int word_size=5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BoggleBoard boggleBoard = new BoggleBoard(4);
		char[][] input = {
				{'j', 'y', 'k', 'e'},
				{'r', 'e', 'a', 'n'},
				{'t', 's', 'p', 'l'},
				{'e', 'o', 'u', 'o'}
		};
		boggleBoard.setBoard(input);
		boggleBoard.solveBoard();
		boggleBoard.printWords();
		//Random rand = new Random();
		//char c = (char) ('a' + rand.nextInt(26));
		//System.out.println(c);
	}

}

class BoggleBoard{

	 ArrayList<String> 	words = new ArrayList<String>();
	int size;
	char [][] board;
	//boolean [][] visited;
	public BoggleBoard(int size){
		this.size = size;
		board = new char[size][size];
	}

	public boolean setBoard(char[][] input){
		int inputLength = input.length;
		int inputWidth = input[0].length;
		if(inputLength!=size || inputWidth!=size){
			return false;
		}
		board = input;
		return true;
	}

	public void solveBoard(){
		boolean visited[][] = new boolean[size][size];
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				StringBuilder sb = new StringBuilder();
				dfsBoard(i, j, sb, visited, 0);
			}
		}
	}

	public void dfsBoard(int i, int j, StringBuilder sb, boolean[][] visited, int count){
			visited[i][j]=true;
			count = count+1;
			sb.append(board[i][j]);
			//System.out.println(sb.toString());
			 if(count==5) words.add(sb.toString());


			for(int m=-1; m<=1; m++){
				for(int n=-1; n<=1; n++){
					if(isVisitable(i+m, j+n, visited, count))
						dfsBoard(i+m, j+n, sb, visited, count);
				}
			}
			
			sb.setLength(sb.length()-1);
			visited[i][j] = false;
		
	}

	public boolean isVisitable(int i, int j, boolean[][] visited, int count){
		return i<size && i>=0 && j<size && j>=0 && count<5 &&  !visited[i][j];
	}


	public void createBoard(){

	}
	
	public void printWords(){
		Collections.sort(words);
		for(String s: words){
			System.out.println(s);
		}
	}


}
