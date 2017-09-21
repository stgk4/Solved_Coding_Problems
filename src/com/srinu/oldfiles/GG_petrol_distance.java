package com.srinu.oldfiles;

public class GG_petrol_distance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//35 11 97 70 85 16 25 97 66 83 17 52 44 62 88 38 
		int petrol[] = {35,97,85,25,66,17,44,88};
		int distance[] = {11,70,16,97,83,52,62,38};
		System.out.println(tour(petrol, distance));
	}
	
	public static int tour(int petrol[], int distance[])
    {
        if(petrol.length != distance.length){
            return -1;
        }
	  for(int i=0; i<distance.length; i++){
	      if(checkCondition(petrol, distance, 0, i, 0)) return i;
	  }
	  return -1;
    }
    
  public static boolean checkCondition(int petrol[], int distance[], int cur_pet, int index, int num_of_stops){
        if(num_of_stops>=petrol.length){
            return true;
        }
        index = index%petrol.length;
        cur_pet+=petrol[index];
        if(cur_pet>=distance[index]){
            cur_pet-=distance[index];
            return checkCondition(petrol, distance, cur_pet, ++index,++num_of_stops);
        }
        else{
            return false;
        }
    } 
}

