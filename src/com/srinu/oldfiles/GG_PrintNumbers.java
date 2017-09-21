package com.srinu.oldfiles;
import java.util.Scanner;
import java.util.Stack;

public class GG_PrintNumbers {
	
		public static void main (String[] args) {
			//code
			Scanner scanner = new Scanner(System.in);
			int t = scanner.nextInt();
			for(int i=0; i<t; i++){
			    int num = scanner.nextInt();
			    Stack<Integer> stack = new Stack<Integer>();
			    if(num>0){
			        printSequence(1, stack, num);
			    }
			    else{
			        printSequence(0, stack, num);
			    }
			    printStack(stack);
			    System.out.println();
			}
		}
		
		public static void printStack(Stack<Integer> stack){
			if(stack.isEmpty()){
				return;
			}
			System.out.print(stack.pop() + " ");
			printStack(stack);
		}
		
		public static void printSequence(int flag, Stack<Integer> stack,  int num){
		    System.out.print(num + " ");
		    if((flag==1 && num<=0) || (flag==0 && num>0)){
		        return;
		    }
		    stack.push(num);
		    if(flag==1){
		        num = num-5;
		    }
		    else{
		      num= num+5;
		    }
		    printSequence(flag, stack, num);
		}
	}