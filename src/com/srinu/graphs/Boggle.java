package com.srinu.graphs;

public class Boggle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoggleBoard boggleBoard = new BoggleBoard(4);
		char[][] input = {
				{'w', 'i', 'n', 'm'},
				{'l', 'o', 'r', 'a'},
				{'f', 'l', 'b', 'd'},
				{'e', 'p', 's', 'i'}
		};
		boggleBoard.setBoard(input);
		boggleBoard.solveBoard();
	}

}

class BoggleBoard{
	int size;
	char [][] board;
	boolean [][] visited;
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
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				visited = new boolean[size][size];
				StringBuilder sb = new StringBuilder();
				dfsBoard(i, j, sb, 0);
			}
		}
	}

	public void dfsBoard(int i, int j, StringBuilder sb, int count){
		if(isVisitable(i, j, count)){
			visited[i][j]=true;
			count = count+1;
			sb.append(board[i][j]);
			System.out.println(sb.toString());


			for(int m=-1; m<=1; m++){
				for(int n=-1; n<=1; n++){
					dfsBoard(i+m, j+n, sb, count);
				}
			}
			visited[i][j] = false;
		}
		
	}

	public boolean isVisitable(int i, int j, int count){
		return i<size && i>=0 && j<size && j>=0 && count<7 &&  !visited[i][j];
	}


	public void createBoard(){

	}


}
