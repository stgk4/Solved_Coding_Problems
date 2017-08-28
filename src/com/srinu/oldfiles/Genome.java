package com.fb.concepts;

public class Genome{

	public static void main(String args[]){
		System.out.println(gene_search("ACCATGCA", "CAT"));
	}

	public static boolean gene_search(String genome, String pattern){
		int g_len = genome.length();
		int p_len = pattern.length();

		//if genome or pattern is an empty string
		if(g_len==0 || p_len==0){
			return false;
		}
		char p_first = pattern.charAt(0);
		for(int i =0; i<g_len; i++){
			char c = genome.charAt(i);

			//matching the first character and then proceeding to check for remaining characters
			if(c == p_first){

				//if pattern has only one character
				if(p_len==1){
					return true;
				}

				//checking for 1 till p_len-1 characters
				for(int j=1; j<p_len && (i+j)<g_len; j++){
					if(genome.charAt(i+j) != pattern.charAt(j)){
						//stop searching if we do not see a matching
						break;
					}
					if(j==p_len-1){
						return true;
					}
				}  
			} 
		}
		//completed one linear search of the input genome string
		return false;
	}
}