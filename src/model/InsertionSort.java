package model;

import java.util.ArrayList;

import javafx.util.Pair;

public class InsertionSort {
	private ArrayList<Integer> arr;
	public static ArrayList<Pair<Integer,Long>> insertionNTime = new ArrayList<Pair<Integer,Long>>(20);
	private int numberOfArrays = 10;
	private int sortedLength = 0;
	
	public InsertionSort(ArrayList<Integer> array) {
    	this.arr = array;
	}

	public void sort() {
		int length = arr.size();
	    long start = System.nanoTime();
		for(int k = 0 ; k < numberOfArrays ; k++) {
			int lengthOfNewArray = (int)(length / numberOfArrays);
			int actualLength = lengthOfNewArray;
			lengthOfNewArray *= (k+1);
			arr = ArrayGenerator.regenerateSameArray(arr , 0, lengthOfNewArray);
			sortedLength += actualLength;
			
	        for (int firstUnsortedIndex = 1; firstUnsortedIndex < lengthOfNewArray ; firstUnsortedIndex++) {
	            int newElement = arr.get(firstUnsortedIndex);

	            int i;

	            for (i = firstUnsortedIndex; i > 0 && arr.get(i - 1) > newElement; i--) {
	                arr.set(i, arr.get(i - 1));
	            }
	            arr.set(i ,newElement);
	        }
	        
			long end = System.nanoTime();
			long time = end - start;
			Pair<Integer, Long> p = new Pair<Integer, Long>(sortedLength , time);
			insertionNTime.add(p);
		}
	}
	
	
	
	public void printArray() {
        for(int Integer: arr)
        	System.out.print(Integer + "    ");
        System.out.println();
	}

	
	
} 
