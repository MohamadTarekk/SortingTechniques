package model;

import java.util.ArrayList;
import java.util.Collections;

import controller.ArrayGenerator;
import javafx.util.Pair;

public class SelectionSort extends Sort {

	public SelectionSort(ArrayList<Integer> array) {
		sortingTechnique = "Selection Sort";
		this.arr = array;
    }
	
	public void sort()
    {
		int length = arr.size();
	    long start = System.nanoTime();
		for(int k = 0 ; k < numberOfArrays ; k++) {
			int lengthOfNewArray = (length / numberOfArrays);
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
			Pair<Integer, Long> p = new Pair<>(sortedLength, time);
			NTime.add(p);
		}
    }
    
	private void swap(ArrayList<Integer> array , int i, int j) {
		Collections.swap(array, i, j);
	}
}