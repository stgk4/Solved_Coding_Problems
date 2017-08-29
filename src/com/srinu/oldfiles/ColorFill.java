package com.srinu.oldfiles;

public class ColorFill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int screen [][] = {{1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 3, 3, 3, 3, 0, 1, 0},
                {1, 1, 1, 3, 3, 0, 1, 0},
                {1, 1, 1, 3, 3, 3, 3, 0},
                {1, 1, 1, 1, 1, 3, 1, 1},
                {1, 1, 1, 1, 1, 3, 3, 1},
                };
		printScreen(screen);
		int x = 4;
		int y = 4;
		int new_col = 2;
		paint(screen,x, y, new_col);
		System.out.println("-------------After-------------");
		printScreen(screen);
		
	}
	public static void paint(int[][] screen, int x, int y, int new_col){
		int rows = screen.length;
		int cols = screen[0].length;
		int old_col = screen[x][y];
		paint_util(screen, rows, cols, x, y, old_col, new_col);
	}
	
	public static void paint_util(int[][] screen, int rows, int cols, int x, int y, int old_col, int new_col){
		if(x<0 || x>=rows || y<0 || y>=cols){
			return;
		}
		if(screen[x][y]!=old_col){
			return;
		}
		screen[x][y] = new_col;
		paint_util(screen, rows, cols, x-1, y, old_col, new_col);//North
		paint_util(screen, rows, cols, x, y+1, old_col, new_col);//East
		paint_util(screen, rows, cols, x, y-1, old_col, new_col);//west
		paint_util(screen, rows, cols, x+1, y, old_col, new_col);//south
	}
	
	public static void printScreen(int[][] s){
		//System.out.println(rows + ","+ cols);
		for(int[] row : s){
			for(int ele: row){
				System.out.print(ele + " ");
			}
			System.out.println("\n");
		}
	}

}
