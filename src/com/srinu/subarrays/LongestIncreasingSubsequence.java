package com.srinu.subarrays;

public class LongestIncreasingSubsequence {

	public static int maxLis;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {10,22,9,33,21,50,41,60,80};
		getLis(array);
	}
	
	public static void getLis(int array[]){
		maxLis =1;
		int length = array.length;
		int Lis[] = new int[length];
		getLis_rec(array, length, Lis);
		System.out.println(maxLis);
	}
	
	//Recursive program to get Longest increasing subsequence of the 
	//sub-array ending at the current index (here)
	public static int getLis_rec(int array[], int n, int[] Lis){
		int here = n-1;
		if(n==1) return 1;
		Lis[here] = 1;
		int res = 1;
		for(int i=1; i<n; i++){
			res = getLis_rec(array,i,Lis);
			if(array[i-1]<array[here] && 1+res>Lis[here])
				Lis[here] = 1+res;
		}
		if (maxLis<Lis[here]) maxLis = Lis[here];
		return Lis[here];
	}

}
