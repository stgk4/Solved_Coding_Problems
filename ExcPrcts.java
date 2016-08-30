package com.fb.concepts;

public class ExcPrcts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getResult());
	}

	public static int getResult(){
		try{
			int a = 0;
			int b = 3;
			int c = b/a;
			return 1;
		}
		catch(Exception e){
			System.out.println(e.toString());
			return -2;
		}
		finally{
			return -1;
			
		}
	}
}
