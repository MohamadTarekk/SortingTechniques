package model;

public class ArrayGenerator {
	
	private int numberOfSamples;
	private int step;
	private int[] toBeSorted;

	public ArrayGenerator(int numberOfSamples) {
		this.numberOfSamples = numberOfSamples;
		this.step = Math.round(numberOfSamples / 10);
		toBeSorted = new int[numberOfSamples];
		randomizeArray();
	}
	
	
	private void randomizeArray() {
		for(int i = 0 ; i < toBeSorted.length ; i++) {
			toBeSorted[i] = (int)(numberOfSamples*Math.random());
		}
	}
	
	public void printArray() {
		for(int i = 0 ; i < toBeSorted.length ; i++) {
			System.out.print(toBeSorted[i]);
		}
	}
	
	public int[] getToBeSorted() {
		return toBeSorted;
	}
	
	public int getStep() {
		return step;
	}
	

}
