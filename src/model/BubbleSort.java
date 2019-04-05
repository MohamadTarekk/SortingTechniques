package model;

import java.util.ArrayList;
import java.util.Collections;

import controller.ArrayGenerator;
import javafx.util.Pair;

public class BubbleSort extends Sort {

	public BubbleSort(ArrayList<Integer> array) {
    	sortingTechnique = "Bubble Sort";
		this.arr = array;
	}

	public void sort() {
		int length = arr.size();
	    long start = System.nanoTime();
		for(int k = 0 ; k < numberOfArrays ; k++) {
			int lengthOfNewArray = (length / numberOfArrays);
			int actualLength = lengthOfNewArray;
			lengthOfNewArray *= (k+1);
			arr = ArrayGenerator.regenerateSameArray(arr , 0, lengthOfNewArray);
			sortedLength += actualLength;
			
			boolean isSwapped;
			for(int i = 0 ; i < lengthOfNewArray - 1 ; i++) {
				isSwapped = false;
				for(int j = 0 ; j < lengthOfNewArray - i - 1 ; j++) {
					if(arr.get(j) > arr.get(j+1)) {
						swap(arr, j , j+1);
						isSwapped = true;
					}
				}
	            //check if any swapping occurred in last iteration
	            //if yes then break the loop, array is sorted at this point
				if(!isSwapped)
					break;
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
