package controller;

import java.util.ArrayList;

public class ArrayGenerator {
	
	private int numberOfSamples;
	private ArrayList<Integer> toBeSorted;
	private static ArrayList<Integer> copyToBeSorted;

	public ArrayList<Integer> getToBeSorted() {
		return toBeSorted;
	}

	public ArrayGenerator(int numberOfSamples) {
		this.numberOfSamples = numberOfSamples;
		toBeSorted = new ArrayList<>(numberOfSamples);
		copyToBeSorted = new ArrayList<>(numberOfSamples);
		randomizeArray();
	}
	
	
	private void randomizeArray() {
		for(int i = 0 ; i < numberOfSamples ; i++) {
			int random = (int)(Math.random() * numberOfSamples);
			toBeSorted.add(random);
			copyToBeSorted.add(toBeSorted.get(i));
		}
	}
	
	public static ArrayList<Integer> regenerateSameArray(ArrayList<Integer> arr,int start, int end) {
		for(int i = start; i < end; i++) {
			arr.set(i,copyToBeSorted.get(i));
		}
		return arr;
	}
		
	void printArray() {
        for(int Integer: toBeSorted)
        	System.out.print(Integer + "    ");
	}
}