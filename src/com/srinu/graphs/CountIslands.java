package com.srinu.graphs;

public class CountIslands {
	
	//This is for deciding next neighbor from the current (i,j) position
	public int[] row_inc =  {-1, -1, -1,  0, 0,  1, 1, 1};
	public int[] col_inc = {-1,  0,  1, -1, 1, -1, 0, 1};
	
	//traversing element by element in the matrix
	public int countIslands(int[][] M) {
		int ROW = M.length;
		int COL = M[0].length;
		
		//a boolean array analogous to the given matrix for keeping track
		//of the visited elements
		boolean visited[][] = new boolean[ROW][COL];
		
		int count =0;
		for(int i=0; i<ROW; i++) {
			for(int j=0; j<COL; j++) {
				if(M[i][j]==1 && !visited[i][j]) {
					DFS(M, i, j, visited);
					++count;
				}
			}
		}
		return count;
	}
	
	//DFS Method to mark all the contiguous network forest of one's as visited
	public void DFS(int[][] M, int i, int j, boolean[][] visited) {
		visited[i][j] = true;
		for(int k=0; k<8; k++) //for each neighbor
			if(canVisit(M, i+row_inc[k], j+col_inc[k], visited)) //visit only if 'canBeVisited'
				DFS(M, i+row_inc[k], j+col_inc[k], visited);
	}

	//check if the node's (i,j) is valid and its value is '1' and not already visited
	private boolean canVisit(int[][] m, int i, int j, boolean[][] visited){
		// TODO Auto-generated method stub
		return (0<=i && i<visited.length && 
				0<=j && j<visited[0].length &&
				m[i][j]==1 && !visited[i][j]);
	}

	public static void main(String[] args) {
		int M[][] = new int[][]{
			{1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 1, 0, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1}
           };
         CountIslands c = new CountIslands();
         System.out.println("No of islands: "+ c.countIslands(M));
	}
}
