package com.srinu.problems;

public class RandomNumGen{

    public static void main(String args[]){
        System.out.println(generateRandomNum());
    }
    
    public static int generateRandomNum(){
    	int num=3;
    	for(int i=0; i<=10; i++){
    		 
    	}
    	return num;
    }
    
    public static int generateRandomNum(int min, int max){
    	int a = generateRandomNum();
    	int b = generateRandomNum();
    	int num = max+min - (a+b);
    	return num;
    }

}
