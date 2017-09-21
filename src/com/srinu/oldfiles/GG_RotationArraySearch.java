package com.srinu.oldfiles;

public class GG_RotationArraySearch {

	public static void main (String[] args) {
		int[] array = {5,6,7,8,9,10,1,2,3};
		int size = array.length;
		int target = 5;
		/*Scanner scanner = new Scanner(System.in);
		 int T = scanner.nextInt();
		 for(int t=0; t<T; t++ ){
		    size = scanner.nextInt();
		    array = new int[size];
		    for(int i=0; i<size; i++){
		        array[i] = scanner.nextInt();
		    }
		     target = scanner.nextInt();
		}*/
		
		int pivot = findPivot(array,0, size-1);
	    int targetIndex = -1;
	    if(pivot==-1){
	        targetIndex = searchIndexBST(array, target, 0, size-1);
	    }
	    else if(target>=array[0]){
	        targetIndex = searchIndexBST(array, target, 0, pivot);
	    }
	    else{
	        targetIndex = searchIndexBST(array, target, pivot+1, size-1);
	    }
	    System.out.println(targetIndex);
	}
	
	public static int findPivot(int[] array, int low, int high){
	    if(low>high) return -1;
	    if(low==high) return low;
	    
	    int mid = low + (high-low)/2;
	    if(low<mid && array[mid]<array[mid-1]){
	        return mid-1;
	    }
	    if(mid<high && array[mid]>array[mid+1]){
	        return mid;
	    }
	    if(array[low]>=array[mid]){
	        return findPivot(array,low, mid-1);
	    }
	    else{
	        return findPivot(array, mid+1, high);
	    }
	}
	
	public static int searchIndexBST(int[] array, int target, int low, int high){
	    if(low>high)  return -1;
	    
	    int mid = low + (high-low)/2;
	    if(array[mid]<target){
	        return searchIndexBST(array, target, mid+1, high);
	    }
	    else if(array[mid]>target){
	        return searchIndexBST(array, target, low, mid-1);
	    }
	    else{
	        return mid;
	    }
	}
}