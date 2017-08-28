package com.fb.concepts;

public class Fibonacci {
public static int a =0;
public static int b =1;
public static int c;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*System.out.println(findFibo(9));
		System.out.println(fibRecDynamic(9));
		System.out.println(memorySavingFib(9));
		
		*
		*Input:   str = "a,b$c"
		*Output:  str = "c,b$a"
		*
		*Input:   str = "Ab,c,de!$"
		*Output:  str = "ed,c,bA!$"
		*/
		//System.out.println(reverseStr("a,b$*)cy))"));
		
		
	}
	
	
	public static String reverseStr(String s){
		int len = s.length();
		char ca[] = s.toCharArray();
		int ptr1=0;
		int ptr2=len-1;
		while(ptr1<ptr2){
			while(!isAlpha(ptr1,ca)){
				ptr1++;
			}
			while(!isAlpha(ptr2,ca)){
				ptr2--;
			}
			if(ptr1<ptr2){
				char temp = ca[ptr1];
				ca[ptr1] = ca[ptr2];
				ca[ptr2] = temp;	
				ptr1++;
				ptr2--;
			}	
		}
		return new String(ca);
	}
	
	public static boolean isAlpha(int index, char charArray[]){
		char c = charArray[index];
		if((c>='A' && c<='Z') ||  (c>='a' && c<='z')){
			return true;
		}
		return false;
	}
	
	
	
	public static int findFibo(int n){
		int fib[] = new int[n+1];
		fib[0] = 0;
		fib[1] = 1;
		for(int i=2; i<=n; i++){
			fib[i] = fib[i-1]+fib[i-2];
		}
		return fib[n];
	}
	
	public static int fibRecDynamic(int n){
		int fib[] = new int[n+1];
		return fibUtil(fib, n);
	}

	public static int fibUtil(int[] fib, int n){
		if(n==0){
			return 0;
		}
		if(n==1){
			return 1;
		}
		if(fib[n]!=0){
			return fib[n];
		}
		fib[n] = fibUtil(fib, n-1)+ fibUtil(fib, n-2);
		return fib[n];
	}
	
	public static int memorySavingFib(int n){
		for(int i=2; i<=n; i++){
			c = a+b;
			a = b;
			b = c;
		}
		return c;
	}
}
