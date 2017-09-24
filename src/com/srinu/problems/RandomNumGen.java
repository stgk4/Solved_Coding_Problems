package com.srinu.problems;

public class RandomNumGen{
	
	public static int previous = (int)(System.currentTimeMillis()%5);
	public static int a = 31; //25214903917a constant value multiplied alway
	public static int c=11; //remainder to guarantee max randomness
	public static int Max_Number = 1000;
    public static void main(String args[]){
    	for(int i=0; i<10; i++){
    		System.out.println(generateRandomNum(6,19));
    	}
    }
    
    
    public static int generateRandomNum(){
    	//System.out.println("previous:"+previous);
    	int r = a*previous + c;
    	r = r%(Max_Number);
    	previous = r;
    	return r;
    }
    
    public static int generateRandomNum(int min, int max){
    	int a = generateRandomNum();
    	int num = min+ a%(max-min+1);
    	return num;
    }

}
