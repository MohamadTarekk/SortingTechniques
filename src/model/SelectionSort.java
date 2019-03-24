package model;

import java.util.ArrayList;
import java.util.Collections;

import javafx.util.Pair;

public class SelectionSort {
	public static ArrayList<Pair<Integer,Long>> selectionNTime = new ArrayList<Pair<Integer,Long>>(20);
	private ArrayList<Integer> arr;
	private int numberOfArrays = 10;
	private int sortedLength = 0;

	
	public SelectionSort(ArrayList<Integer> array) {
    	this.arr = array;
    }
	
	public void sort()
    {
		int length = arr.size();
	    long start = System.nanoTime();
		for(int k = 0 ; k < numberOfArrays ; k++) {
			int lengthOfNewArray = (int)(length / numberOfArrays);
			int actualLength = lengthOfNewArray;
			lengthOfNewArray *= (k+1);
			arr = ArrayGenerator.regenerateSameArray(arr , 0, lengthOfNewArray);
			sortedLength += actualLength;
		    // One by one move boundary of unsorted subarray 
		    for (int i = 0; i < lengthOfNewArray-1; i++) {
		        // Find the minimum element in unsorted array 
		        int min_idx = i; 
		        for (int j = i+1; j < lengthOfNewArray; j++) {
		            if (arr.get(j) < arr.get(min_idx)) 
		                min_idx = j; 
		        }
		        // Swap the found minimum element with the first element 
		        swap(arr,min_idx,i);
		    }
			long end = System.nanoTime();
			long time = end - start;
			Pair<Integer, Long> p = new Pair<Integer, Long>(sortedLength , time);
			selectionNTime.add(p);
		}
    }
    
	private void swap(ArrayList<Integer> array , int i, int j) {
		Collections.swap(array, i, j);
	}
	
	public void printArray() {
        for(int Integer: arr)
        	System.out.print(Integer + "    ");
        System.out.println();
	}
}