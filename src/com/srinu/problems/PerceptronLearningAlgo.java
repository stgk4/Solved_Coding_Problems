package com.srinu.problems;

public class PerceptronLearningAlgo {
	public static final int TOTAL_DATAPOINTS = 50;
	public static void main(String[] args)
	{
		//defining the training data of 50 points (index:1-50), considering the line equation as a*x1 + b*x2 + c = 0; 
		int trainingArray_x1[] = new int[51];
		int trainingArray_x2[] = new int[51];
		int testArray_x1[] = new int[31];
		int testArray_x2[] = new int[31];
		int classLabel[] = new int[51]; 

		//calling a function to create training,test and training data class
		dataCreation(trainingArray_x1,trainingArray_x2,testArray_x1,testArray_x2,classLabel);

		// defining initial weights and constants for the equation D = w0 + w1*x1 + w2*x2;
		double D;
		double w0 = 1;
		double w1 =1;
		double w2 = 1;
		double d = 0.5;
		int x1 ,x2;

		int sign = 0;
		int iteration=0;

		//Assuming that initially all data-points are wrongly classified
		int wrongly_classified = TOTAL_DATAPOINTS;
		while (wrongly_classified>0)
		{
			System.out.println("Iteration:"+ ++iteration);
			for (int i = 1;i <=TOTAL_DATAPOINTS;i++ ) {
				x1 = trainingArray_x1[i];
				x2 = trainingArray_x2[i];
				D = w0 + (w1 *x1) + (w2 * x2) ;

				//System.out.println("D:"+d + " classLabel[i]:"+classLabel[i]);
				// compare sign of D with sign of classLabel[i]
				if((D >0 && classLabel[i]>0) || (D<0 && classLabel[i] <0) ){
					wrongly_classified--;
					//System.out.println("if:"+i + "  wrongly_classified:"+wrongly_classified);
				}else{

					if (D>0 && classLabel[i] < 0 ) { // check if D > 
						sign = -1;

					}else if (D < 0 && classLabel[i]>0){
						sign = 1;
					}
					w0 =  w0 + (sign * d );
					w1 =  w1 + (sign * d * x1);
					w2 =  w2 + (sign * d * x2);

				}
			}

			System.out.println("Wrongly_Classified: " + wrongly_classified);
			if(wrongly_classified<1){
				break;
			}
			wrongly_classified = TOTAL_DATAPOINTS;//re-inititate back to the total datapoints
		}

		System.out.println("w0:" + w0 +"\nw1:" +  w1 +  "\nw2:"+ w2 + "\nnumber of times while loop runs  " + iteration);

		int k;
		for ( k = 1;k<=30;k++) {

			x1 = testArray_x1[k];
			x2 = testArray_x2[k];
			D = w0 + w1*x1 + w2*x2;
			if(D>0){
				classLabel[k] = 1;
			}else 
				classLabel[k] = -1;
			System.out.print(classLabel[k] + " ");
		}

	} 

	public static void dataCreation(int trainingArray_x1[],int trainingArray_x2[],int testArray_x1[],int testArray_x2[],int classLabel[]){

		// creating training data set for 50 points 
		for(int i =1;i<=25;i++) {
			trainingArray_x1[i] = i;
			trainingArray_x2[i] = i-1;
			classLabel[i] = 1;

		}
		for(int i = 26;i<=50;i++){

			trainingArray_x1[i] = i-1;
			trainingArray_x2[i] = i;
			classLabel[i] = -1;

		}
		// creating test data points such that 15 of them lie in one class and 15 lie in the other 
		for (int i = 1;i<= 30;i++) {
			testArray_x1[i] = i;
			testArray_x2[i] = -i;
		}
		for(int i = 15;i<=30;i++){
			testArray_x1[i] = -i;
			testArray_x2[i] = i;
		}
	}
}