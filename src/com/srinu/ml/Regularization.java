package com.srinu.ml;

import java.util.Random;

public class Regularization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total_size = 12;
		int[] x = new int[total_size];
		int[] y = new int[total_size];
		Random rand = new Random();
		for(int i=0; i<total_size; i++) {
			int num = -2 + rand.nextInt(12);
			x[i] = num;
			y[i] = x[i]*x[i]+10;
		}
		
		
		for(int i:x) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(int i:y) {
			System.out.print(i + " ");
		}
		
	}
	
	
}
