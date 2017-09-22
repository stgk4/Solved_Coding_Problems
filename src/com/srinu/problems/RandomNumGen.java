package com.srinu.problems;

public class RandomNumGen{
	
	public static int previous = 0;
	public static int a = 252; //25214903917
	public static int c=11;
    public static void main(String args[]){
    	for(int i=0; i<100; i++){
    		System.out.println(generateRandomNum());
    	}
    }
    
    
    public static int generateRandomNum(){
    	int r = a*previous + c;
    	previous = r;
    	return r;
    }
    
    public static int generateRandomNum(int min, int max){
    	int a = generateRandomNum();
    	int b = generateRandomNum();
    	int num = min+ Math.abs((a%min)+(b%max));
    	return num;
    }

}
