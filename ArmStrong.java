package com.fb.concepts;

public class ArmStrong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i<=999; i++){
			if(isArmstrong(i)){
				System.out.println(i);
			}
		}
	}
	
	public static boolean isArmstrong(int num){
		int result = 0;
		int orig = num;
		int rem = num%10;
		while(rem>0){
			result+=rem*rem*rem;
			num = num/10;
			rem = num%10;
		}
		if(result ==orig){
			return true;
		}
		return false;
	}

}
