package com.srinu.graphs;

public class CountIslands {
	
	public int[] row_inc =  {-1, -1, -1,  0, 0,  1, 1, 1};
	public int[] col_inc = {-1,  0,  1, -1, 1, -1, 0, 1};
	
	public int countIslands(int[][] M) {
		int ROW = M.length;
		int COL = M[0].length;
		
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
	
	public void DFS(int[][] M, int i, int j, boolean[][] visited) {
		visited[i][j] = true;
		for(int k=0; k<8; k++) 
			if(canVisit(M, i+row_inc[k], j+col_inc[k], visited))
				DFS(M, i+row_inc[k], j+col_inc[k], visited);
	}

	private boolean canVisit(int[][] m, int i, int j, boolean[][] visited) {
		// TODO Auto-generated method stub
		return (0<=i && i<visited.length && 
				0<=j && j<visited[0].length &&
				m[i][j]==1 && !visited[i][j]);
	}

	public static void main(String[] args) {
		int M[][] = new int[][]{{1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1}
           };
         CountIslands c = new CountIslands();
         System.out.println("No of islands: "+ c.countIslands(M));
	}
}
