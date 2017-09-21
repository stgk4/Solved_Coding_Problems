package com.srinu.oldfiles;

public class CTCI_9_8_denomination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int denom=25;
		System.out.println(makeChange(100, denom));
	}
	
	public static int makeChange(int n, int denom){
		int next_denom = 0;
		switch(denom){
		case 25:
			next_denom = 10;
			break;
		case 10:
			next_denom = 5;
			break;
		case 5:
			next_denom = 1;
			break;
		case 1:
			return 1;
		}
		
		int ways = 0;
		
		for(int i=0; i*denom<=n; i++){
			ways+=makeChange(n-i*denom, next_denom);
		}
		return ways;
	}

}
