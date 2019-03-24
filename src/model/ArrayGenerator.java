package model;

import java.util.ArrayList;

public class ArrayGenerator {
	
	public static int numberOfSamples;
	public static ArrayList<Integer> toBeSorted;	
	public static ArrayList<Integer> copytoBeSorted;

	public ArrayGenerator(int numberOfSamples) {
		ArrayGenerator.numberOfSamples = numberOfSamples;
		toBeSorted = new ArrayList<Integer>(numberOfSamples);
		copytoBeSorted = new ArrayList<Integer>(numberOfSamples);
		randomizeArray();
	}
	
	
	private void randomizeArray() {
		for(int i = 0 ; i < numberOfSamples ; i++) {
			int random = (int)(Math.random() * numberOfSamples);
			toBeSorted.add(random);
			copytoBeSorted.add(toBeSorted.get(i));
		}
	}
	
	public static ArrayList<Integer> regenerateSameArray(ArrayList<Integer> arr,int start, int end) {
		for(int i = start; i < end; i++) {
			arr.set(i,copytoBeSorted.get(i));
		}
		return arr;
	}
		
	public void printArray() {
        for(int Integer: toBeSorted)
        	System.out.print(Integer + "    ");
	}
	

	public int getNumberOfSamples() {
		return numberOfSamples;
	}
	

}
