package com.srinu.oldfiles;

import java.util.Random;

public class practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = {{1,2,3,4}, {5,6,7,8},{9,10,11,12},{13,14,15,16}};
		printArrayMulti(input);
		//System.out.println(test());
		Random rand = new Random();
		//System.out.println(rand.nextInt(100));
	}
	
	public static Object test(){
		return test();
	}
	
	public static void printArrayMulti(int[][] input){
		int rows = input.length;
		int cols = input[0].length;
		for(int i=0; i<=Math.ceil(rows/2.0)-1; i++){
			for(int j=i; j<cols-i-1; j++){
				System.out.println(input[i][j]);
			}
			for(int k=i; k<rows-i-1; k++){
				System.out.println(input[k][cols-i-1]);
			}
			for(int l=cols-i-1; l>i; l--){
				System.out.println(input[rows-i-1][l]);
			}
			for(int m=rows-i-1; m>i; m--){
				System.out.println(input[m][i]);
			}
			
		}
	}

}
