package view.visualization;

import processing.core.*;

public class BubbleSortVisualization extends PApplet {
	private static final long serialVersionUID = 1L;

	private int[] toBeSorted;
	private int innerLoopCounter;
	private int xLocation;
	private int widthOfRect , lengthOfArray;
	
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
		background(57, 56, 102);
		//System.out.println("outer");
		
		for(int i = 0 ; i < toBeSorted.length ; i++) {
			fill(135, 206, 250);
		    if (i==innerLoopCounter)
		      fill(255, 255, 66);
		    if (i==innerLoopCounter + 1)
			      fill(245, 255, 250);
		    if (i>lengthOfArray)
			      fill(85, 82, 239);
		    rect(i*xLocation, height-toBeSorted[i], widthOfRect , toBeSorted[i]);
		    delay(25);
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
