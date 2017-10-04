package com.srinu.problems;
import java.util.Comparator;
public class OverlappingBarrier {
	public static void main(String[] args){
		
	}
}

class BarrierComparator_using_x1 implements Comparator<Barrier>{

	@Override
	public int compare(Barrier o1, Barrier o2) {
		// TODO Auto-generated method stub
		return o1.x1-o2.x1;
	}
	
}
class Barrier{
	int x1, x2;
}
