package com.srinu.oldfiles;

public class CTCI_9_7_paintFill {
	
	enum Color{
		B, W, R, Y, G;
	}
	
	public static void main(String[] args){
		Color b = Color.B;
		Color w = Color.W;
		Color r = Color.R;
		Color[][] screen = {{b,b,w,b,b}, {b,b,w,w,b}, {b,w,b,w,b},{b,b,w,w,w}};
		printScreen(screen);
		paintFill(screen, 2,1, r);
		printScreen(screen);
	}
	
	public static boolean paintFill(Color[][] screen, int x, int y, Color ncolor){
		return paintFill(screen, x, y, screen[y][x], ncolor);
	}
	
	public static boolean paintFill(Color[][] screen, int x, int y, Color ocolor, Color ncolor){
		if(x<0 || x>=screen[0].length || y<0 || y>=screen.length){
			return false;
		}
		if(screen[y][x] == ocolor){
			screen[y][x] = ncolor;
			paintFill(screen, x, y-1, ocolor, ncolor);//North
			paintFill(screen, x-1, y, ocolor, ncolor);//West
			paintFill(screen, x+1, y, ocolor, ncolor);//East
			paintFill(screen, x, y+1, ocolor, ncolor);//South
		}
		
		return true;
	}
	
	public static void printScreen(Color[][] screen){
		for(Color[] c_row : screen){
			for(Color c: c_row){
				System.out.print(c + " ");
			}
			System.out.print("\n");
		}
		System.out.println("-------------------");
	}

}
