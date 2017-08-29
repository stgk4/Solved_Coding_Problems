package com.srinu.oldfiles;

public class NB_Counter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class CAS_Counter{
	private AtomicVar_CAS value;
	
	public int getValue(){
		return value.getValue();
	}
	
	public int increment(){
		int oldValue = value.getValue();
		while(value.CompareAndSwap(oldValue, oldValue+1) != oldValue){
			oldValue = value.getValue();
		}
		return oldValue+1;
	}
}

class AtomicVar_CAS{
	private int value;
	
	public synchronized int getValue(){
		return value;
	}
	
	public synchronized int CompareAndSwap(int expectedValue, int newValue){
		int oldValue = value;
		if(value==expectedValue){
			value = newValue;
		}
		return oldValue;
	}
}