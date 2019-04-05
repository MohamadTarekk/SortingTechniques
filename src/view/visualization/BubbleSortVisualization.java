package view.visualization;

import processing.core.*;

public class BubbleSortVisualization extends PApplet {
	private static final long serialVersionUID = 1L;

	int[] toBeSorted;
	int innerLoopCounter;
	int xLocation;
	int widthOfRect , lengthOfArray;
	
	public void setup() {
		size(600,500);
		toBeSorted = new int[20];
		
		for(int i = 0 ; i < toBeSorted.length ; i++) {
			toBeSorted[i] = (int)(Math.random() * height);
		}
		
		xLocation = width / toBeSorted.length;
		widthOfRect = xLocation - 1;
		lengthOfArray = toBeSorted.length - 1;
	}
	
	public void draw() {
		
		if(lengthOfArray == -2)
			return;
		background(0);
		//System.out.println("outer");
		
		for(int i = 0 ; i < toBeSorted.length ; i++) {
			fill(255);
		    if (i==innerLoopCounter)
		      fill(255,255,0);
		    if (i==innerLoopCounter + 1)
			      fill(0,255,0);
		    if (i>lengthOfArray)
			      fill(204,0,0);
		    rect(i*xLocation, height-toBeSorted[i], widthOfRect , toBeSorted[i]);
		    delay(70);
		}
		
		if(innerLoopCounter >= lengthOfArray) {
			innerLoopCounter = 0;
			lengthOfArray--;
		}
		
		if(toBeSorted[innerLoopCounter] > toBeSorted[innerLoopCounter+1]) {
			int temp = toBeSorted[innerLoopCounter];
			toBeSorted[innerLoopCounter] = toBeSorted[innerLoopCounter+1];
			toBeSorted[innerLoopCounter+1] = temp;
		}
		
		innerLoopCounter++;

	}
	
}
