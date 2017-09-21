package com.srinu.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.ArrayList;

public class Sorting {
	
	public static void main(String[] args) {
		/*//problem 10.1 
		int[] A = {2,4,5,7,8,11,-1,-1,-1,-1};
		int[] B = {3,6,8,13};
		mergeArrayInOther(A, B);
		printIntArray(A);*/
		
		/*//Problem 10.2 
		String[] sa = {"srin", "rain", "nirs", "narial", "abc", "ABc", "had", "adh"};
		Arrays.sort(sa, new AnagramComparator());
		printStrArray(sa);
		//printStrArray(sortByAnagrams(sa));
		*/
		
		/*//Problem 10.3
		int[] array = {10,15,20,0,5};
		System.out.println(search(array,0,4,5));*/
		
		//System.out.println("had".compareTo(""));
		String[] sa = {"srin", "rain", "nirs", "narial", "abc", "ABc", "had", "adh"};
		Arrays.sort(sa);
		printStrArray(sa);
		System.out.println(stringBinarySearch(sa,"abc",0,7));
	}
	
	public static int stringBinarySearch(String[] sa, String str, int low, int high) {
		if(low>high) return -1;
		int mid = (low+high)/2;
		
		if(sa[mid].isEmpty()) {
			int left = mid-1;
			int right =mid+1;
			
			while(true) {
				if(left<low && right>high) {
					return -1;
				}
				
				if(low<=left && !sa[left].isEmpty()) {
					mid = left;
					break;
				}else if(right<=high && !sa[right].isEmpty()) {
					mid = right;
					break;
				}
				left--;
				right++;
			}
		}
		
		if(str.compareTo(sa[mid])<0) {
			return stringBinarySearch(sa,str,low,mid-1);
		}else if(str.compareTo(sa[mid])>0) {
			return stringBinarySearch(sa,str,mid+1,high);
		}else {
			return mid;
		}
		
	}
	
	/*
	 * Problem 10.3 search an element in a rotated array 
	 * 
	 * Solution: use binary search and tweak it to also compare the mid, low, high elements while comparing
	 * in addition to just comparing element x with mid element
	 * 
	 */
	public static int search(int[] a, int left, int right, int x) {
		if(right<left) return -1;
		int mid = (left+right)/2;
		
		if(x==a[mid]) return mid;
		
		if(a[left]<a[mid]) {
			if(a[left]<=x && x<=a[mid]) {
				return search(a,left, mid,x);
			}else {
				return search(a,mid+1,right,x);
			}
		}else if(a[mid]<a[left]) {
			if(a[mid]<=x && x<a[right]) {
				return search(a,mid,right,x);
			}else {
				return search(a,left,mid-1,x);
			}
		}else if(a[mid]==a[left]) {//from left till middle all same values
			if(a[mid]!=a[right]) {
				return search(a,mid+1,right,x);
			}else {
				//search both sides
				int result = search(a,left,mid-1,x);
				if(result==-1) {
					return search(a,mid+1,right,x);
				}else {
					return result;
				}
			}
		}
		return -1;
	}
	
	public static int binarySearch(int[] a, int x, int low, int high) {
		if(low>high) return -1;
		int mid = (low+high)/2;
		
		if(x<a[mid]) {
			return binarySearch(a,x,low,mid-1);
		}else if(x>a[mid]) {
			return binarySearch(a,x,mid+1,high);
		}else {
			return mid;
		}
	}
	
	
	/*
	 * Problem 10.2: Write a method to sort an array of strings so that all the anagrams are next to each other
	 * 
	 * Algorithm: in nsquared complexity we can compare each string with every other string and if the sorting of 
	 * the strings resulted in the same string then we group them together
	 * 
	 * pseudo code: 
	 * 1) implement a comparator to compare anagrams
	 * 2) sort using this comarator with the sorting algorithm
	 */
	
	public static class AnagramComparator implements Comparator<String>{
		
		public String sortChars(String s) {
			char[] content = s.toCharArray();
			Arrays.sort(content);
			return new String(content);
		}
		
		public int compare(String s1, String s2) {
			return sortChars(s1).compareTo(sortChars(s2));
		}
	}
	/*
	 * use hashtable to map strings to their cousin permutations (anagrams)
	 */
	public static String[] sortByAnagrams(String[] array) {
		Hashtable<String, ArrayList<String>> stringMap = new Hashtable<String, ArrayList<String>>();
		for(String str: array){
			ArrayList<String> al = new ArrayList<String>();
			char[] content= str.toCharArray();
			Arrays.sort(content);
			String key = new String(content);
			System.out.println("key:"+key);
			if(!stringMap.containsKey(key)){
				al.add(str);
				stringMap.put(key, al);
			}else{
				al = stringMap.get(key);
				al.add(str);
				//stringMap.put(key, al);
			}
		}
		int index = 0;
		for(String key: stringMap.keySet()){
			ArrayList<String> al = stringMap.get(key);
			for(String s: al){
				array[index]=s;
				index++;
			}
		}
		return array;
	}
	
	/*
	 * Problem 10.1: Given two sorted arrays A and B, A has large enough buffer at the end to 
	 * hold B. Write a method to merge A and B in sorted order
	 * 
	 * Solution: Will use merge sort
	 * to merge the two arrays, this will take linear time
	 * 
	 * pseudo code: 
	 * 1) create pointers aPointer=A.size-1, bPointer=B.size-1 and insertion_index 'i' in 'A'
	 *    ; initialize i to A.size+B.size-1
	 * 2) compare A[aPointer] and B[bPointer] and the highest will go into A[i] and decrement the lowest side index 
	 * 3) if elements in A are left, then no need to worry, all are in place already, if elements in B are 
	 * left, then we copy them in the front of A
	 * 
	 */
	public static void mergeArrayInOther(int[] A, int[] B) {
		
		
		int aPointer = A.length-B.length-1;
		int bPointer = B.length-1;
		int ii = A.length-1;
		
		while(aPointer>=0 && bPointer>=0) {
			if(A[aPointer]>B[bPointer]){
				A[ii]=A[aPointer];
				aPointer--;
			}else {
				A[ii]=B[bPointer];
				bPointer--;
			}
			ii--;
		}
		while(bPointer>=0) {
			A[ii]=B[bPointer];
			ii--;
			bPointer--;
		}
	}
	
	public static void printIntArray(int [] array) {
		StringBuffer sb = new StringBuffer();
		for(int i: array) {
			sb.append(i + " ");
		}
		System.out.println(sb.toString().trim());
	}
	
	public static void printStrArray(String [] array) {
		StringBuffer sb = new StringBuffer();
		for(String i: array) {
			sb.append(i + " $ ");
		}
		System.out.println(sb.toString().trim());
	}
	
	

}
