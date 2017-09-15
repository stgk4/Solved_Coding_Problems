package com.srinu.problems;

public class PerceptronLearningAlgo {
	public static final int TOTAL_DATAPOINTS = 50;
	
	public static void main(String[] args)
	{
		
		//defining the training data of 50 points (index:1-50), considering the line equation as a*x1 + b*x2 + c = 0; 
		Point[] points = new Point[TOTAL_DATAPOINTS+1];
		Point[] testPoints = new Point[31];

		//calling a function to create training,test and training data class
		dataCreation(points, testPoints);

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
				x1 = points[i].x1;
				x2 = points[i].x2;
				D = w0 + (w1 *x1) + (w2 * x2) ;

				//System.out.println("D:"+d + " classLabel[i]:"+classLabel[i]);
				// compare sign of D with sign of classLabel[i]
				if((D >0 && points[i].sign>0) || (D<0 && points[i].sign <0) ){
					wrongly_classified--;
					//System.out.println("if:"+i + "  wrongly_classified:"+wrongly_classified);
				}else{

					if (D>0 && points[i].sign < 0 ) { // check if D > 
						sign = -1;

					}else if (D < 0 && points[i].sign>0){
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

			x1 = testPoints[k].x1;
			x2 = testPoints[k].x2;
			D = w0 + w1*x1 + w2*x2;
			if(D>0){
				testPoints[k].sign = 1;
			}else 
				testPoints[k].sign = -1;
			System.out.print(testPoints[k].sign + " ");
		}

	} 

	public static void dataCreation(Point[] points, Point[] testPoints){

		// creating training data set for 50 points 
		for(int i =1;i<=25;i++) {
			Point point = new Point();
			point.x1 = i;
			point.x2 = i-1;
			point.sign = 1;
			points[i] = point;
		}
		for(int i = 26;i<=50;i++){
			Point point = new Point();
			point.x1 = i-1;
			point.x2 = i;
			point.sign = 1;
			points[i] = point;
		}
		
		// creating test data points such that 15 of them lie in one class and 15 lie in the other 
		for (int i = 1;i<= 30;i++) {
			Point testPoint = new Point();
			testPoint.x1 = i;
			testPoint.x2 = -i;
			testPoints[i] = testPoint;
		}
		for(int i = 15;i<=30;i++){
			Point testPoint = new Point();
			testPoint.x1 = -i;
			testPoint.x2 = i;
			testPoints[i] = testPoint;
		}
	}
}

//DataStructure for point with x and y coordinates along with classlabel as sign
class Point{
	int x1;
	int x2;
	int sign;
}